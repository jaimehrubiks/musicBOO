/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.BooManager;
import com.alee.laf.filechooser.WebFileChooser;
import com.alee.laf.progressbar.WebProgressBar;
import com.io.UserSettings;
import com.util.AudioPlayer;
import com.util.Functions;
import com.util.PlayListDownloader;
import com.util.VideoDownloader;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Jaime
 */
public class BooGui extends javax.swing.JFrame {

    /**
     * Creates new form BooGui
     */
    public BooGui() {
        
        File configFolder = new File("./config");
        if(!configFolder.exists()) configFolder.mkdir();
        File downFolder = new File("./downloads");
        if(!downFolder.exists()) downFolder.mkdir();
        
        this.setIconImage(icon.getImage());
        
        
        startAPP();
        initComponents();
        initColumns();
        
        
        //SELECT ON FOCUS
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(searchField.getText().equalsIgnoreCase("Input Song Title"))
                            searchField.setText("");
                        searchField.selectAll();
                    }
                });
            }
        });
        //
        //this.getRootPane().setDefaultButton(searchButton);
       
        
        //progressBar.set
        paneLog.setVisible(false);
        progressBar.setValue(0);
        UserSettings.loadProperties();
        loadSettingsToForm();
        
        (( WebProgressBar) progressBar).setProgressTopColor(Color.CYAN);
        (( WebProgressBar) progressBar).setProgressBottomColor(Color.darkGray);
                
        (( WebProgressBar) urlParserBar).setProgressTopColor(Color.GREEN);
        (( WebProgressBar) urlParserBar).setProgressBottomColor(Color.darkGray);
        //(( WebProgressBar) urlParserBar).setString("0%");
        (( WebProgressBar) urlParserBar).setStringPainted(true);
        //progressBar).
        
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton.doClick();
            }
        });
        
        playListField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startPlayList.doClick();
            }
        });
        
          //videoTable.setRowSorter(new TableRowSorter(model));
          progressBar.setValue(0);
          progressBar.setMaximum(1000);
        
          //DefaultCaret caret = (DefaultCaret) jTextArea1.getCaret();
          // caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
          jTextArea1.setCaretPosition(0);
          
          setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
          
          videoTable.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // Left mouse click
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Do something
                } // Right mouse click
                else if (SwingUtilities.isRightMouseButton(e) )
		 {
                    // get the coordinates of the mouse click
                    Point p = e.getPoint();

                    // get the row index that contains that coordinate
                    int rowNumber = videoTable.rowAtPoint(p);

                    // Get the ListSelectionModel of the JTable
                    ListSelectionModel model = videoTable.getSelectionModel();

			// set the selected interval of rows. Using the "rowNumber"
                    // variable for the beginning and end selects only that one row.
                    model.setSelectionInterval(rowNumber, rowNumber);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        rightClickAudio = new javax.swing.JMenuItem();
        rightClickVideo = new javax.swing.JMenuItem();
        paneLog = new javax.swing.JPanel();
        scrollLog = new javax.swing.JScrollPane();
        outputLogger = new javax.swing.JTextArea();
        scrollLog1 = new javax.swing.JScrollPane();
        outputLogger1 = new javax.swing.JTextArea();
        progressBar = new WebProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        searchTab = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        videoTable = new javax.swing.JTable();
        urlTab = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        urlsPanel = new javax.swing.JTextArea();
        urlParseButton = new javax.swing.JButton();
        urlParserBar = new WebProgressBar();
        jLabel14 = new javax.swing.JLabel();
        playlistTab = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        startPlayList = new javax.swing.JButton();
        playListField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        downTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        downloadsTable = new javax.swing.JTable();
        openFolderButton = new javax.swing.JButton();
        settingsTab = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        confDownFolder = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        confAudioFormat = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        confAudioQuality = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        confKeepOriginalVideo = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        confOriginalVideoFormat = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        confPostVideoConvert = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        confVideoOnly = new javax.swing.JToggleButton();
        jSeparator7 = new javax.swing.JSeparator();
        configSaveButton = new javax.swing.JButton();
        confDiscardButton = new javax.swing.JButton();
        confDefaults = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        confParallelSlider = new javax.swing.JSlider();
        confParallelValue = new javax.swing.JLabel();
        aboutTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        logButton = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        rightClickAudio.setText("Download Audio");
        rightClickAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickAudioActionPerformed(evt);
            }
        });
        rightClickMenu.add(rightClickAudio);

        rightClickVideo.setText("Download Video");
        rightClickVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickVideoActionPerformed(evt);
            }
        });
        rightClickMenu.add(rightClickVideo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onWindowsClose(evt);
            }
        });

        paneLog.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Output Log"));
        paneLog.setToolTipText("");

        scrollLog.setAutoscrolls(true);

        outputLogger.setBackground(new java.awt.Color(0, 0, 0));
        outputLogger.setColumns(20);
        outputLogger.setForeground(new java.awt.Color(255, 255, 255));
        outputLogger.setRows(5);
        outputLogger.setFocusable(false);
        scrollLog.setViewportView(outputLogger);

        scrollLog1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollLog1.setAutoscrolls(true);

        outputLogger1.setBackground(new java.awt.Color(0, 0, 0));
        outputLogger1.setColumns(20);
        outputLogger1.setForeground(new java.awt.Color(255, 255, 255));
        outputLogger1.setRows(5);
        outputLogger1.setFocusable(false);
        scrollLog1.setViewportView(outputLogger1);

        javax.swing.GroupLayout paneLogLayout = new javax.swing.GroupLayout(paneLog);
        paneLog.setLayout(paneLogLayout);
        paneLogLayout.setHorizontalGroup(
            paneLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollLog, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(scrollLog1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        paneLogLayout.setVerticalGroup(
            paneLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneLogLayout.createSequentialGroup()
                .addComponent(scrollLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(scrollLog1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        progressBar.setStringPainted(true);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(0, 115));

        searchField.setText("Input Song Title");
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        videoTable.setModel(model);
        videoTable.setRowHeight(50);
        videoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        videoTable.setShowHorizontalLines(false);
        videoTable.setShowVerticalLines(false);
        videoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(videoTable);

        javax.swing.GroupLayout searchTabLayout = new javax.swing.GroupLayout(searchTab);
        searchTab.setLayout(searchTabLayout);
        searchTabLayout.setHorizontalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addGroup(searchTabLayout.createSequentialGroup()
                        .addComponent(searchField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        searchTabLayout.setVerticalGroup(
            searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", searchTab);

        jLabel13.setText("Paste Youtube videos URLs to download them all. Put one URL on each Line.");

        urlsPanel.setColumns(20);
        urlsPanel.setRows(5);
        jScrollPane4.setViewportView(urlsPanel);

        urlParseButton.setText("Start Downloads");
        urlParseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlParseButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Parsing status:");

        javax.swing.GroupLayout urlTabLayout = new javax.swing.GroupLayout(urlTab);
        urlTab.setLayout(urlTabLayout);
        urlTabLayout.setHorizontalGroup(
            urlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(urlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(urlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(urlTabLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 594, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, urlTabLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urlParserBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(urlParseButton)))
                .addContainerGap())
        );
        urlTabLayout.setVerticalGroup(
            urlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, urlTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(urlTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(urlParseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urlParserBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        urlTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {urlParseButton, urlParserBar});

        jTabbedPane1.addTab("URL Parser", urlTab);

        jLabel18.setText("Paste a youtube URL. It may be a Playlist, Channel or Video... musicBOO will attempt to download it using your user Settings.");

        startPlayList.setText("Start Downloads");
        startPlayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPlayListActionPerformed(evt);
            }
        });

        playListField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playListFieldKeyPressed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Some Examples:\n\nVideo\nhttps://www.youtube.com/watch?v=VIDEO_ID\n[You can see \"watch?v=ID\" as part of the URL]\n\nPlaylist\nhttps://www.youtube.com/playlist?list=PLAYLIST_ID\n[You can see \"?list=ID\" as part of the URL]\n\nChannel\nhttps://www.youtube.com/user/USER_NAME/videos\n[You can see \"/user/USERNAME/videos\" as part of the URL]");
        jTextArea2.setFocusable(false);
        jScrollPane5.setViewportView(jTextArea2);

        javax.swing.GroupLayout playlistTabLayout = new javax.swing.GroupLayout(playlistTab);
        playlistTab.setLayout(playlistTabLayout);
        playlistTabLayout.setHorizontalGroup(
            playlistTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playlistTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playlistTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playListField)
                    .addComponent(jScrollPane5)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startPlayList)
                .addContainerGap())
        );
        playlistTabLayout.setVerticalGroup(
            playlistTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playlistTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playlistTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playListField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startPlayList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        playlistTabLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {playListField, startPlayList});

        jTabbedPane1.addTab("Playlists...", playlistTab);

        downloadsTable.setModel(downModel);
        downloadsTable.setRowHeight(50);
        jScrollPane3.setViewportView(downloadsTable);

        openFolderButton.setText("Open Downloads Folder");
        openFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout downTabLayout = new javax.swing.GroupLayout(downTab);
        downTab.setLayout(downTabLayout);
        downTabLayout.setHorizontalGroup(
            downTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(downTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, downTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(openFolderButton)))
                .addContainerGap())
        );
        downTabLayout.setVerticalGroup(
            downTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openFolderButton)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Downloads", downTab);

        jLabel1.setText("Downloads Folder");

        confDownFolder.setText("jTextField1");
        confDownFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        confDownFolder.setFocusable(false);

        jButton2.setText("Change Folder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Audio Format");

        confAudioFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "best", "aac", "vorbis", "mp3", "m4a", "opus", "wav" }));

        jLabel3.setText("Audio Quality");

        confAudioQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "32K", "96K", "128K", "160K", "192K", "320K" }));
        confAudioQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confAudioQualityActionPerformed(evt);
            }
        });

        jLabel4.setText("Audio conversion: [0 BEST - 9 WORST] or Desired BIT RATE");

        jLabel6.setText("Keep original video");

        confKeepOriginalVideo.setText("No");
        confKeepOriginalVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confKeepOriginalVideoActionPerformed(evt);
            }
        });

        jLabel5.setText("Select BEST or BESTVIDEO or (other video formats) for video downloading mode. ");

        confOriginalVideoFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "best", "bestvideo", "bestaudio", "worst", "bestvideo+bestaudio", "aac", "m4a", "mp3", "mp4", "ogg", "wav", "webm" }));

        jLabel7.setText("Original video Format");

        jLabel8.setText("(!) Lower parallel Downloads to 1 [and restart] not to overload CPU");

        confPostVideoConvert.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "no", "mp4", "flv", "ogg", "webm", "mkv" }));

        jLabel9.setText("Post video convert");

        jLabel10.setText("Only videos (no music)");

        confVideoOnly.setText("No");
        confVideoOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confVideoOnlyActionPerformed(evt);
            }
        });

        configSaveButton.setText("Save Changes");
        configSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configSaveButtonActionPerformed(evt);
            }
        });

        confDiscardButton.setText("Discard Changes");
        confDiscardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confDiscardButtonActionPerformed(evt);
            }
        });

        confDefaults.setText("Load Defaults");
        confDefaults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confDefaultsActionPerformed(evt);
            }
        });

        jLabel15.setText("Parallel Downloads*");

        jLabel16.setText("* Restart is required to have effect.");

        confParallelSlider.setMaximum(30);
        confParallelSlider.setMinimum(1);
        confParallelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                confParallelSliderStateChanged(evt);
            }
        });

        confParallelValue.setText("5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confDownFolder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(confAudioFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confKeepOriginalVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(confVideoOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(confAudioQuality, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(confOriginalVideoFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(confPostVideoConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(confParallelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(confParallelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 388, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(confDefaults, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confDiscardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(configSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator8))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {confAudioFormat, confAudioQuality, confKeepOriginalVideo, confOriginalVideoFormat, confPostVideoConvert, confVideoOnly});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {confDefaults, confDiscardButton, configSaveButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confDownFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confAudioFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confAudioQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confOriginalVideoFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confKeepOriginalVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(confVideoOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(confPostVideoConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(confParallelSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confParallelValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confDefaults)
                    .addComponent(configSaveButton)
                    .addComponent(confDiscardButton))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {confAudioFormat, confAudioQuality, confDownFolder, confKeepOriginalVideo, confOriginalVideoFormat, confPostVideoConvert, confVideoOnly});

        settingsTab.setViewportView(jPanel1);

        jTabbedPane1.addTab("Settings", settingsTab);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(8, 6, 6));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 255, 0));
        jTextArea1.setRows(5);
        jTextArea1.setText("\n © MUSICBOO v1.3.0.0 FINAL\n \n Developed and designed by Jaime Hidalgo García - @jaimehrubiks\n \n Author:\n -Jaime Hidalgo garcía\n \n Special Thanks to:\n -\"youtube-dl\" \t\thttps://rg3.github.io/youtube-dl/\n -\"FFmpeg\" \t        https://www.ffmpeg.org/\n -\"netbeans IDE\" \thttps://netbeans.org/\n -\"youtube.com\"\t\thttps://www.youtube.com/\n \n App description:\n -\"MUSICBOO\" can be considered as a Windows GUI for youtube api v3, youtube-dl and FFmpeg, and allows the user to search,\n download, and convert online videos easily.\n \n **DO NOT USE THIS PROGRAM TO DOWNLOAD COPYRIGHT PROTECTED MATERIAL WITHOUT OWNER PERMISSION**\n This program should not be used to download content you are not allowed to. This program may be used\n to download copyright-free content, personally uploaded data, or material you are given explicit permission.\n \n APPLICATION DISCLAIMER\n \n This app is provided “as is” without any representations or warranties, express or implied. \n \"© MUSICBOO\" makes no representations or warranties in relation to this app or the information and\n materials provided on it. The content displayed belong to their respective authors.\n \n Your use of this software constitutes acceptance of the Terms mentioned before.");
        jTextArea1.setFocusable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel17.setText("Make a donation to support the server, the development of new proyects and me");

        jButton1.setText("Donate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutTabLayout = new javax.swing.GroupLayout(aboutTab);
        aboutTab.setLayout(aboutTabLayout);
        aboutTabLayout.setHorizontalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
                    .addGroup(aboutTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        aboutTabLayout.setVerticalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("About", aboutTab);

        logButton.setText("Show Log");
        logButton.setFocusable(false);
        logButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButtonActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/header1.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/image1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
                    .addComponent(paneLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(paneLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {logButton, progressBar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        while(  model.getRowCount()!=0  ) model.removeRow(0);
        
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // code in here
                boo.newSearch( searchField.getText() );
            }
        });
        
        //reloadAllColumns();
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void logButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButtonActionPerformed
        // TODO add your handling code here:
        if(logButton.isSelected()) paneLog.setVisible(true);
        else paneLog.setVisible(false);
    }//GEN-LAST:event_logButtonActionPerformed

    private void urlParseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlParseButtonActionPerformed
        // TODO add your handling code here:
        //boo.newVideoGet("KCBelQF7JeY,Uxw2VoaQBQk");


        String matcher = "youtube";
        final StringBuilder sb = new StringBuilder();
        
        String[] urls = urlsPanel.getText().split("\n");
        
        
        if (urls.length>0 && urls[0].contains(matcher)) sb.append(Functions.getID(urls[0]));
        for(int i = 1 ; i < urls.length ; i++)
            if( urls[i].contains(matcher) ) sb.append(",").append(Functions.getID(urls[i]));
        
        if(sb.length()==0) return;
        
        urlParserBar.setMaximum(urls.length+1);
        urlParserBar.setValue(1);
        urlParseButton.setEnabled(false);
        
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                // code in here
                boo.newVideoGet(sb.toString());
            }
        });
        
       

        
    }//GEN-LAST:event_urlParseButtonActionPerformed

    private void openFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonActionPerformed

        File folder = new File( UserSettings.configProps.getProperty("DownloadsFolder") );
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(folder);
        } catch (IOException ex) {
            //Logger.getLogger(BooGui.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }//GEN-LAST:event_openFolderButtonActionPerformed

    private void onWindowsClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowsClose
        // TODO add your handling code here:
        if(progressBar.getValue()!=progressBar.getMaximum()  && !(progressBar.getMaximum()==1000)){
            if(exitForm == null) exitForm = new OnExitForm();
            exitForm.setVisible(true);
        }
        else
            System.exit(0);
    }//GEN-LAST:event_onWindowsClose

    private void confParallelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_confParallelSliderStateChanged
        // TODO add your handling code here:
        confParallelValue.setText(String.valueOf(confParallelSlider.getValue()));
    }//GEN-LAST:event_confParallelSliderStateChanged

    private void confDefaultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confDefaultsActionPerformed
        // TODO add your handling code here:
        UserSettings.loadDefaults();
        loadSettingsToForm();
    }//GEN-LAST:event_confDefaultsActionPerformed

    private void confDiscardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confDiscardButtonActionPerformed
        // TODO add your handling code here:
        UserSettings.loadProperties();
        loadSettingsToForm();
    }//GEN-LAST:event_confDiscardButtonActionPerformed

    private void configSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configSaveButtonActionPerformed
        // TODO add your handling code here:
        parseSettingsFromForm();
        UserSettings.saveProperties();
    }//GEN-LAST:event_configSaveButtonActionPerformed

    private void confVideoOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confVideoOnlyActionPerformed
        // TODO add your handling code here:
        if(confVideoOnly.isSelected()) {
            confVideoOnly.setText("Yes");
            String test = (String)  confOriginalVideoFormat.getSelectedItem();
            if( !test.equalsIgnoreCase("best") && !test.equalsIgnoreCase("bestvideo") )
                confOriginalVideoFormat.setSelectedItem("best");
        }
        else confVideoOnly.setText("No");
    }//GEN-LAST:event_confVideoOnlyActionPerformed

    private void confKeepOriginalVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confKeepOriginalVideoActionPerformed
        // TODO add your handling code here:
        if(confKeepOriginalVideo.isSelected()) {
            confKeepOriginalVideo.setText("Yes");
            String test = (String)  confOriginalVideoFormat.getSelectedItem();
            if( !test.equalsIgnoreCase("best") && !test.equalsIgnoreCase("bestvideo") )
                confOriginalVideoFormat.setSelectedItem("best");
        }
        else confKeepOriginalVideo.setText("No");
    }//GEN-LAST:event_confKeepOriginalVideoActionPerformed

    private void confAudioQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confAudioQualityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confAudioQualityActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //if(downloadFolderForm==null) downloadFolderForm= new SelectFolder(this);
        //downloadFolderForm.setVisible(true);

        File open = WebFileChooser.showOpenDialog ();
        if(open.isDirectory()){
            String path = open.getAbsolutePath();
            UserSettings.configProps.setProperty("DownloadsFolder", path);
            confDownFolder.setText(open.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Functions.loadLink("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=LHEC57GMVE5QA&lc=ES&item_name=Jaime%20Hidalgo%20Proyects&currency_code=EUR&bn=PP%2dDonationsBF%3abtn_donate_SM%2egif%3aNonHosted");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void videoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videoTableMouseClicked
        // TODO add your handling code here:
        if ( evt.getButton() == 3 )
            rightClickMenu.show(videoTable, evt.getX(), evt.getY());
    }//GEN-LAST:event_videoTableMouseClicked

    private void rightClickAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightClickAudioActionPerformed
        // TODO add your handling code here:
        Thread t = new Thread(new VideoDownloader(boo.currentVideos.get(videoTable.getSelectedRow()).getID(), BooGui.this, downModel.getRowCount() , 1));
        t.start();

        //model.setValueAt( "", modelRow, 6 );
        model.setValueAt(downloadOkImage, videoTable.getSelectedRow(), 6);
        Object[] data = {model.getValueAt(videoTable.getSelectedRow(), 0), model.getValueAt(videoTable.getSelectedRow(), 1), model.getValueAt(videoTable.getSelectedRow(), 2), "0%"};
        downModel.addRow(data);
        updateBar();
    }//GEN-LAST:event_rightClickAudioActionPerformed

    private void rightClickVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightClickVideoActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Thread t = new Thread(new VideoDownloader(boo.currentVideos.get(videoTable.getSelectedRow()).getID(), BooGui.this, downModel.getRowCount() , 2));
        t.start();

        //model.setValueAt( "", modelRow, 6 );
        model.setValueAt(downloadOkImage, videoTable.getSelectedRow(), 6);
        Object[] data = {model.getValueAt(videoTable.getSelectedRow(), 0), model.getValueAt(videoTable.getSelectedRow(), 1), model.getValueAt(videoTable.getSelectedRow(), 2), "0%"};
        downModel.addRow(data);
        updateBar();
    }//GEN-LAST:event_rightClickVideoActionPerformed

    private void startPlayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPlayListActionPerformed
        // TODO add your handling code here:
        Thread t = new Thread(new PlayListDownloader(playListField.getText(), BooGui.this, downModel.getRowCount() ));
        t.start();
        Object[] data = {icon, playListField.getText(), "", "0%"};
        downModel.addRow(data);
        updateBar();
    }//GEN-LAST:event_startPlayListActionPerformed

    private void playListFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playListFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_playListFieldKeyPressed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            
            UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BooGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new BooGui().setVisible(true);
            }
        });
    }
    
    public void startAPP(){
        boo = new BooManager();
        boo.setGuiRef(this);
        
        String[] columnNames = new String[]{ "Image" , "Title" , "Duration" , "Uploader", "Hits", "Preview" , "Download" };
        model = new TableModel(columnNames,0);
        columnNames = new String[]{ "Image" , "Title" , "Duration" , "Progress" };
        downModel = new DownTableModel(columnNames,0);
        
        
    }
    
    private void initColumns() {
        //SEARCH TABLE
        TableColumn column = null;
        videoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        videoTable.getColumnModel().getColumn(0).setMinWidth(90);
        videoTable.getColumnModel().getColumn(0).setMaxWidth(90);
        videoTable.getColumnModel().getColumn(1).setPreferredWidth(27);
        videoTable.getColumnModel().getColumn(2).setMinWidth(75);
        videoTable.getColumnModel().getColumn(2).setMaxWidth(75);
        videoTable.getColumnModel().getColumn(3).setMinWidth(90);
        videoTable.getColumnModel().getColumn(3).setMaxWidth(90);
        videoTable.getColumnModel().getColumn(4).setMinWidth(90);
        videoTable.getColumnModel().getColumn(4).setMaxWidth(90);
        videoTable.getColumnModel().getColumn(5).setMinWidth(90);
        videoTable.getColumnModel().getColumn(5).setMaxWidth(90);
        videoTable.getColumnModel().getColumn(6).setMinWidth(90);
        videoTable.getColumnModel().getColumn(6).setMaxWidth(90);
        //videoTable.setModel(model);
        ButtonColumn playButton          = new ButtonColumn(videoTable, playAction , 5);
        ButtonColumn downloadButton      = new ButtonColumn(videoTable, downloadAction , 6);
        //ButtonColumn downloadOkButton    = new ButtonColumn(videoTable, downloadAction , 6);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        videoTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        videoTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        videoTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
                
        //DOWNLOADS TABLE
        downloadsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        downloadsTable.getColumnModel().getColumn(0).setMinWidth(90);
        downloadsTable.getColumnModel().getColumn(0).setMaxWidth(90);
        downloadsTable.getColumnModel().getColumn(1).setPreferredWidth(27);
        downloadsTable.getColumnModel().getColumn(2).setMinWidth(90);
        downloadsTable.getColumnModel().getColumn(2).setMaxWidth(90);
        downloadsTable.getColumnModel().getColumn(3).setMinWidth(200);
        downloadsTable.getColumnModel().getColumn(3).setMaxWidth(200);
        
        TableColumn myCol = downloadsTable.getColumnModel().getColumn(3);
        myCol.setCellRenderer(new ProgressCellRenderer());
        
        downloadsTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        
    }
    
        //Función para Youtube
    Action playAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JTable mytable = (JTable)e.getSource();
            int modelRow = Integer.valueOf( e.getActionCommand() );
//            //System.out.println("HENGA");
//            String url = Functions.genLink( boo.currentVideos.get(modelRow).getID() );
//            Functions.loadLink(url);
            model.setValueAt(playOkImage, modelRow, 5);
            if(aPlay==null) aPlay = new AudioPlayer(BooGui.this);
            aPlay.setID(boo.currentVideos.get(modelRow).getID());
            aPlay.play();
            
            
        }
    };
    
            //Función para Download
    Action downloadAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            updateBar();
//            JTable mytable = (JTable)e.getSource();
//            int modelRow = Integer.valueOf( e.getActionCommand() );
//            VideoDownloader down = new VideoDownloader( boo.currentVideos.get(modelRow).getID() , BooGui.this );
//            down.run();
            JTable mytable = (JTable) e.getSource();
            int modelRow = Integer.valueOf(e.getActionCommand());
            
            //final VideoDownloader down = new VideoDownloader(boo.currentVideos.get(modelRow).getID(), BooGui.this);
            
            
            Thread t = new Thread( new VideoDownloader(boo.currentVideos.get(modelRow).getID(), BooGui.this , downModel.getRowCount() )  ); 
            t.start();
            
            //model.setValueAt( "", modelRow, 6 );
            model.setCellEditable(modelRow, 6, false);
            model.setValueAt(downloadOkImage, modelRow, 6);
            Object[] data = { model.getValueAt(modelRow, 0) , model.getValueAt(modelRow, 1) , model.getValueAt(modelRow, 2) , "0%" };
            downModel.addRow(data);
            updateBar();
                
                
        }
    };
    
    public void reloadAllColumns(){
        
        while(  model.getRowCount()!=0  )
            model.removeRow(0);
        model.reset_editables();
        Object[] entry = new Object [7];
        
        for( int i = 0 ; i < boo.currentVideos.size() ; i++ ){
            URL link = null;
            try {
                link = new URL(boo.currentVideos.get(i).getImg());
                //BufferedImage img = ImageIO.read(link);
            } catch (MalformedURLException ex) {
                Logger.getLogger(BooGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            entry[0] = new ImageIcon( link );
            entry[1] = boo.currentVideos.get(i).getTitle();
            entry[2] = boo.currentVideos.get(i).getDuration();
            entry[3] = boo.currentVideos.get(i).getUploader();
            entry[4] = boo.currentVideos.get(i).getHits();
            entry[5] = playImage;
            entry[6] = downloadImage;
            model.addRow(entry);
        }
        
    }
    
    public void partialReloadInsert(int index){
        
        if(index==0){
            model.reset_editables();
        }
        
        Object[] entry = new Object [7];
        
            URL link = null;
            try {
                link = new URL(boo.currentVideos.get(index).getImg());
                //BufferedImage img = ImageIO.read(link);
            } catch (MalformedURLException ex) {
                Logger.getLogger(BooGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            entry[0] = new ImageIcon( link );
            entry[1] = boo.currentVideos.get(index).getTitle();
            entry[2] = boo.currentVideos.get(index).getDuration();
            entry[3] = boo.currentVideos.get(index).getUploader();
            entry[4] = boo.currentVideos.get(index).getHits();
            entry[5] = playImage;
            entry[6] = downloadImage;
            model.addRow(entry);
        
    }
    
    public JTextArea getLogOutput(){
        return outputLogger;
    }
    
    public JTextArea getLog1Output(){
        return outputLogger1;
    }
    
    public void setBar(int val, int max){
        progressBar.setMaximum(max);
        progressBar.setValue( val );
    }
    
    public void setDownStatus(int ref, int perc){
        String pert = perc+"%";
        downModel.setValueAt(pert, ref, 3);
    }
    
    public void setDownStatus(int ref, String str){
        downModel.setValueAt(str, ref, 3);
    }
    
    public void setBarComplete(){
        //progressBar.setb
        
        downloadsCount++;
        
        updateBar();
    }
    
    public void updateBar(){
                
        progressBar.setValue(downloadsCount+1);
        progressBar.setMaximum(downModel.getRowCount()+1);
        
        if(progressBar.getValue()==progressBar.getMaximum())
            (( WebProgressBar) progressBar).setProgressTopColor(Color.GREEN);
        else
            (( WebProgressBar) progressBar).setProgressTopColor(Color.CYAN);
        

        
        
    }
    
    public void updateParseBar(){

        urlParserBar.setValue( urlParserBar.getValue() + 1 );

        if(urlParserBar.getValue() == urlParserBar.getMaximum()){
            urlParseButton.setEnabled(true);
            urlsPanel.setText("");
        }
        
    }
    
    public void updateParseVarMax(int max){
        urlParserBar.setMaximum(max);
    }
    
    public void startURLvideos(){
        
        
        
        for(int i = 0 ; i < boo.urlVideos.size() ; i++){

            URL link = null;
            try {
                link = new URL(boo.urlVideos.get(i).getImg());
            } catch (MalformedURLException ex) {
                Logger.getLogger(BooGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int rowcounter = downModel.getRowCount();
            
            Object[] data = { new ImageIcon( link ) , boo.urlVideos.get(i).getTitle() , boo.urlVideos.get(i).getDuration() , "0%"};
            downModel.addRow(data);
            updateBar();
            
            
            Thread t = new Thread(new VideoDownloader(boo.urlVideos.get(i).getID(), this , rowcounter ));
            t.start();

        }
        
    }
    
    
    private BooManager boo;
    private TableModel     model;
    private DownTableModel downModel;
    ImageIcon    playImage       = new ImageIcon( getClass().getResource("/img/youtube1.png") );
    ImageIcon    playOkImage     = new ImageIcon( getClass().getResource("/img/youtube1ok.png") );
    ImageIcon    downloadImage   = new ImageIcon( getClass().getResource("/img/download1.png") );
    ImageIcon    downloadOkImage = new ImageIcon( getClass().getResource("/img/downloadok1.png") );
    ImageIcon    icon =            new ImageIcon( getClass().getResource("/img/icon.png") );
    private int downloadsCount = 0;
    private OnExitForm exitForm;
    private AudioPlayer aPlay;
    //private SelectFolder downloadFolderForm;
    
    
    
    private void loadSettingsToForm(){
        confDownFolder.setText(UserSettings.configProps.getProperty("DownloadsFolder"));
        confAudioFormat.setSelectedItem( UserSettings.configProps.getProperty("AudioFormat") );
        confAudioQuality.setSelectedItem(UserSettings.configProps.getProperty("AudioQuality"));
        confOriginalVideoFormat.setSelectedItem( UserSettings.configProps.getProperty("VideoFormat"));
        confKeepOriginalVideo.setSelected(Boolean.parseBoolean(UserSettings.configProps.getProperty("KeepVideo")));
        confVideoOnly.setSelected(Boolean.parseBoolean(UserSettings.configProps.getProperty("ONLYVIDEOS")));
        confPostVideoConvert.setSelectedItem(UserSettings.configProps.getProperty("PostVideoConvert"));
        confParallelValue.setText( UserSettings.configProps.getProperty("ParallelDownloads") );
        confParallelSlider.setValue( Integer.parseInt(UserSettings.configProps.getProperty("ParallelDownloads")));
        
        if( !Boolean.parseBoolean(UserSettings.configProps.getProperty("TermsAccepted","false")) )
            new Disclaimer().setVisible(true);
    }
    
    private void parseSettingsFromForm(){
        UserSettings.configProps.setProperty("DownloadsFolder", confDownFolder.getText());
        UserSettings.configProps.setProperty("AudioFormat",  (String) confAudioFormat.getSelectedItem() );
        UserSettings.configProps.setProperty("AudioQuality", (String) confAudioQuality.getSelectedItem());
        UserSettings.configProps.setProperty("VideoFormat", (String)  confOriginalVideoFormat.getSelectedItem() );
        UserSettings.configProps.setProperty("KeepVideo", String.valueOf(confKeepOriginalVideo.isSelected()));
        UserSettings.configProps.setProperty("ONLYVIDEOS",String.valueOf(confVideoOnly.isSelected()));
        UserSettings.configProps.setProperty("PostVideoConvert",(String) confPostVideoConvert.getSelectedItem());
        UserSettings.configProps.setProperty("ParallelDownloads", confParallelValue.getText());
    }
    
    public void triggerFolderUpdated(){
        confDownFolder.setText(UserSettings.configProps.getProperty("DownloadsFolder"));
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutTab;
    private javax.swing.JComboBox confAudioFormat;
    private javax.swing.JComboBox confAudioQuality;
    private javax.swing.JButton confDefaults;
    private javax.swing.JButton confDiscardButton;
    private javax.swing.JTextField confDownFolder;
    private javax.swing.JToggleButton confKeepOriginalVideo;
    private javax.swing.JComboBox confOriginalVideoFormat;
    private javax.swing.JSlider confParallelSlider;
    private javax.swing.JLabel confParallelValue;
    private javax.swing.JComboBox confPostVideoConvert;
    private javax.swing.JToggleButton confVideoOnly;
    private javax.swing.JButton configSaveButton;
    private javax.swing.JPanel downTab;
    private javax.swing.JTable downloadsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToggleButton logButton;
    private javax.swing.JButton openFolderButton;
    private javax.swing.JTextArea outputLogger;
    private javax.swing.JTextArea outputLogger1;
    private javax.swing.JPanel paneLog;
    private javax.swing.JTextField playListField;
    private javax.swing.JPanel playlistTab;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem rightClickAudio;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JMenuItem rightClickVideo;
    private javax.swing.JScrollPane scrollLog;
    private javax.swing.JScrollPane scrollLog1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JPanel searchTab;
    private javax.swing.JScrollPane settingsTab;
    private javax.swing.JButton startPlayList;
    private javax.swing.JButton urlParseButton;
    private javax.swing.JProgressBar urlParserBar;
    private javax.swing.JPanel urlTab;
    private javax.swing.JTextArea urlsPanel;
    private javax.swing.JTable videoTable;
    // End of variables declaration//GEN-END:variables
}
