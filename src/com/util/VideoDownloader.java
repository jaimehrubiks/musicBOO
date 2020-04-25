/*
 * JAIME HIDALGO.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import com.gui.BooGui;
import com.io.ErrorLogger;
import com.io.UserSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Jaime Hidalgo García
 */
public class VideoDownloader implements Runnable {

	private static final int parallelThreads;
	private static int totalThreads;
	private volatile static List<Boolean> okThreads;
	private static int okThread;

	private int audio_video_only = 0; // 0 Default , 1 Audio , 2 Video

	static {
		parallelThreads = Integer.parseInt(UserSettings.configProps.getProperty("ParallelDownloads"));
		totalThreads = 0;
		okThreads = new ArrayList<>();
		for (int i = 0; i < parallelThreads; i++) {
			okThreads.add(Boolean.TRUE);
		}
		okThread = Integer.parseInt(UserSettings.configProps.getProperty("ParallelDownloads"));
	}

	private String id;
	private BooGui guiRef;
	private int downRef;

	List<String> command;

	public VideoDownloader(String id, BooGui guiRef, int downref) {
		this.id = id;
		this.guiRef = guiRef;
		downRef = downref;
		totalThreads++;
		okThreads.add(Boolean.FALSE);
	}

	public VideoDownloader(String id, BooGui guiRef, int downref, int auvidon) {
		this.id = id;
		this.guiRef = guiRef;
		downRef = downref;
		totalThreads++;
		okThreads.add(Boolean.FALSE);
		audio_video_only = auvidon;
	}

	private void loadCommandParams() {

		command = new ArrayList<>();

		//PATH TO YOUTUBE-DL
		if (platformtools.isWindows()) {
			command.add(new java.io.File("").getAbsolutePath() + "/tools/youtube-dl.exe");
		} else if (platformtools.isMac()) {
			command.add(new java.io.File("").getAbsolutePath() + "/osxtools/youtube-dl");
		} else if (platformtools.isUnix()) {
			command.add(new java.io.File("").getAbsolutePath() + "/linuxtools/youtube-dl");
		}

		if (Boolean.parseBoolean(UserSettings.configProps.getProperty("disableSSL"))) {
			command.add("--no-check-certificate");
		}

		if (Boolean.parseBoolean(UserSettings.configProps.getProperty("ONLYVIDEOS")) && audio_video_only == 0
			|| audio_video_only == 2) {

			command.add("--format");
			String format = UserSettings.configProps.getProperty("VideoFormat");
			if (!format.equals("best") && !format.equals("bestvideo") && !format.equals("bestvideo+bestaudio") && !format.equals("mp4")) {
				command.add("best");
			} else {
				command.add(format);
			}
			//Re encode video after download
			if (!UserSettings.configProps.getProperty("PostVideoConvert").equals("no")) {
				command.add("--recode-video");
				command.add(UserSettings.configProps.getProperty("PostVideoConvert"));
			}

			// Download Subtitles
			if (UserSettings.configProps.getProperty("DownloadSubs").equals("true")) {
				command.add("--write-sub");
				command.add("--all-subs");
			}
			if (UserSettings.configProps.getProperty("IncludeAllAutoSubs").equals("true")) {
				command.add("--write-auto-sub");
			}

			//YOUTUBE LINKS OR IDS
			command.add("--");
			command.add(id);
			return;
		}

		//Video Format
		command.add("--format");
		command.add(UserSettings.configProps.getProperty("VideoFormat"));

		//Extract Audio
		command.add("--extract-audio");

		//Set Audio Format
		command.add("--audio-format");
		command.add(UserSettings.configProps.getProperty("AudioFormat"));

		//Set Audio Quality
		command.add("--audio-quality");
		command.add(UserSettings.configProps.getProperty("AudioQuality"));

		//Keep Original video after obtaining audio
		if (Boolean.parseBoolean(UserSettings.configProps.getProperty("KeepVideo")) && audio_video_only == 0) {
			command.add("-k");
		}

		//Re encode video after download
		if (!UserSettings.configProps.getProperty("PostVideoConvert").equals("no") && audio_video_only == 0) {
			command.add("--recode-video");
			command.add(UserSettings.configProps.getProperty("PostVideoConvert"));
			System.out.println(UserSettings.configProps.getProperty("PostVideoConvert"));
		}

		//Output File Name
		command.add("-o");
		command.add(UserSettings.configProps.getProperty("DefaultFilename"));

		// Add metadata
		command.add("--add-metadata");

		//YOUTUBE LINKS OR IDS
		command.add("--");
		command.add(id);
	}

	private static synchronized void downloadCompleted() {

		okThreads.set(okThread, Boolean.TRUE);
		okThread++;

	}

	@Override
	public void run() {
		//System.out.println("downref->"+downRef);
		loadCommandParams();
		JTextArea logger = guiRef.getLogOutput();
		guiRef.setDownStatus(downRef, 0);
		guiRef.setDownStatus(downRef, "Waiting");
		while (!okThreads.get(downRef)) {
			waitfor(1000);
		}

		try {
			ProcessBuilder builder = new ProcessBuilder(command);

			if (platformtools.isMac()) {
				Map<String, String> env = builder.environment();
				env.put("PATH", env.get("PATH") + ":" + new java.io.File("").getAbsolutePath() + "/osxtools/");
			} else if (platformtools.isUnix()) {
				Map<String, String> env = builder.environment();
				env.put("PATH", env.get("PATH") + ":" + new java.io.File("").getAbsolutePath() + "/linuxtools/");
			}

			builder.directory(new File(UserSettings.configProps.getProperty("DownloadsFolder")));
			builder.redirectErrorStream(true);

			Process p = builder.start();
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			String lines[];

			while ((line = r.readLine()) != null) {
				lines = line.replaceAll("\\s+", " ").replaceAll("%", "").split(" ");
				if (lines[0].equalsIgnoreCase("[download]")) {
					try {
						guiRef.setDownStatus(downRef, (int) Float.parseFloat(lines[1]));
					} catch (NumberFormatException e) {
					}
				} else if (lines[0].equalsIgnoreCase("[ffmpeg]")) {
					guiRef.setDownStatus(downRef, 100);
					guiRef.setDownStatus(downRef, "converting...");
				}

				logger.append(line + "\n");
				logger.setCaretPosition(logger.getDocument().getLength());
			}

			logger.append("Done." + "\n");
			logger.setCaretPosition(logger.getDocument().getLength());
			guiRef.setDownStatus(downRef, 100);
			guiRef.setBarComplete();

		} catch (IOException ex) {
			Logger.getLogger(VideoDownloader.class.getName()).log(Level.SEVERE, null, ex);
			ErrorLogger.toFile("ProcessError", ex.toString());
		}
		downloadCompleted();

	}

	public static void main(String[] args) {

		VideoDownloader down = new VideoDownloader("PQtRXqBQETA", new BooGui(), 5);
		down.run();
		System.out.println("end1");

	}

	private void waitfor(int miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException ex) {
			Logger.getLogger(VideoDownloader.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
