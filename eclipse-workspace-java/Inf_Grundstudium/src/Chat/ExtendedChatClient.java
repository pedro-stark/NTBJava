package Chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class ExtendedChatClient {

    private static final  int     SERVER_PORT     = 5555;
    private static final  String  SERVER_HOST     = "localhost";
    private static final  int     MAX_ICON_HEIGHT = 58;           // pixel

    private  JLabel       nameLabel          = new JLabel (" Name: ");
    private  JLabel       serverLabel        = new JLabel (" Server: ");
    private  JButton      sendButton         = new JButton ("Send");
    private  JButton      registerButton     = new JButton ("Register");
    private  JButton      unregisterButton   = new JButton ("Unregister");
    private  JTextArea    messagesText       = new JTextArea ();
    private  JTextField   nameField          = new JTextField ();
    private  JButton      imageButton        = new JButton("Bild");
    private  JTextField   serverField        = new JTextField ();
    private  JTextField   messageField       = new JTextField ();
    private  JScrollPane  messagesScrollPane = new JScrollPane (messagesText);
    
    private  JPanel       userListPanel;
    private  JScrollPane  userListScrollPane;
    private  JFrame       frame              = new JFrame("NTB ExtendedChatClient");

    private Thread receiver;

    private  Communication  communication = new Communication (); 

    public ExtendedChatClient () {

        receiver = new Thread() {
            public void run () { 
                while (true) {
                    try {
                        // Wait to receive a datagram, blocking call
                        communication.waitForMessage ();
                        // datagram was received
                        Message message = communication.getMessage ();
                        // check message type
                        if (message instanceof PostingMessage) {
                            // it is a posting message
                            final PostingMessage p = (PostingMessage) message;
                            // add the message text to the messages textarea
                            Runnable appendText = new Runnable () {
                                    public void run () {
                                        System.out.println ("PostingMessage");
                                        User user = p.getUser ();
                                        String text = p.getText ();
                                        messagesText.append (user + ": " + text);
                                        messagesText.append ("\n"); 
                                    } 
                                };
                            SwingUtilities.invokeLater (appendText);
                        } else if (message instanceof UserSetMessage) {
                            final UserSetMessage ul = (UserSetMessage) message;
                            // add the message text to the messages textarea
                            Runnable displayPosting = new Runnable () {
                                    public void run () {
                                        System.out.println ("UserSetMessage");
                                        userListPanel.setVisible (false);
                                        userListPanel.removeAll();
                                        messagesText.append("-> current users: " + ul.getUserSet());
                                        messagesText.append ("\n"); 
                                        for (User u: ul.getUserSet()){
                                            JButton but = new JButton(u.getName());
                                            if (u.getIcon() != null) {
                                                but.setIcon(u.getIcon());
                                            }
                                            userListPanel.add(but);
                                        }
                                        userListPanel.setVisible(true);
                                    } 
                                };
                            SwingUtilities.invokeLater (displayPosting);
                        }
                    } catch (Exception e) {
                        // it is a posting message
                    } 
                } 
            }   
        };

        // setup communication
        setupCommunication ();

        // setup ActionListeners for buttons
        sendButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendPosting();
                }
            });

        registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendRegisterMessage();
                }
            });

        unregisterButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendUnRegisterMessage();
                }
            });

        imageButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadUserImage();
                }
            });

        // implementation of KeyListener interface 
        messageField.addKeyListener(new KeyAdapter() {
                public void keyPressed (KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        sendPosting();
                    }
                }
            });

        // create server panel
        JPanel serverPanel = new JPanel (new BorderLayout ());
        serverLabel.setPreferredSize (new Dimension (50, 28));
        serverField.setPreferredSize (new Dimension (400, 28));
        serverField.setText (SERVER_HOST);
        serverPanel.add (serverLabel, BorderLayout.WEST);
        serverPanel.add (serverField, BorderLayout.CENTER);
        serverPanel.setBorder (new EmptyBorder (2, 2, 2, 2));

        // create button panel
        JPanel buttonPanel = new JPanel (new BorderLayout ());
        buttonPanel.add (registerButton, BorderLayout.WEST);
        buttonPanel.add (unregisterButton, BorderLayout.EAST);

        // create name panel
        JPanel namePanel = new JPanel (new BorderLayout ());
        nameLabel.setPreferredSize (new Dimension (50, 28));
        nameField.setPreferredSize (new Dimension (400, 28));
        namePanel.add (nameLabel, BorderLayout.WEST);
        namePanel.add (nameField, BorderLayout.CENTER);
        namePanel.add (buttonPanel, BorderLayout.EAST);
        namePanel.setBorder (new EmptyBorder (2, 2, 2, 2));

        // create configuration panel
        JPanel configPanel = new JPanel (new BorderLayout ());
        configPanel.setBorder (new TitledBorder (" Configuration "));

        JPanel immediatePanel = new JPanel (new GridLayout (2, 1));
        immediatePanel.add (serverPanel);
        immediatePanel.add (namePanel);
        configPanel.add(immediatePanel, BorderLayout.CENTER);
        configPanel.add(imageButton, BorderLayout.EAST);
        imageButton.setPreferredSize(new Dimension(70,56));

        // create messages panel
        JPanel messagesPanel = new JPanel (new BorderLayout ());
        messagesPanel.add (messagesScrollPane, BorderLayout.CENTER);
        messagesPanel.setBorder (new TitledBorder (" Received Messages "));

        // create message panel
        JPanel messagePanel = new JPanel (new BorderLayout ());
        messagePanel.add (messageField, BorderLayout.CENTER);
        messagePanel.add (sendButton, BorderLayout.EAST);
        messagePanel.setBorder (new TitledBorder (" Send Message "));
        
        // create user list panel
        userListPanel = new JPanel(new FlowLayout());
        userListScrollPane = new JScrollPane (userListPanel);
        userListScrollPane.setPreferredSize(new Dimension(0,MAX_ICON_HEIGHT * 2));
        userListScrollPane.setBorder (new TitledBorder (" Active Users "));
        
        // create south panel
        JPanel southPanel = new JPanel (new BorderLayout ());
        southPanel.add(messagePanel, BorderLayout.NORTH);
        southPanel.add(userListScrollPane, BorderLayout.CENTER);       

        // create panel with name, messages and message panel
        JPanel panel1 = new JPanel (new BorderLayout ());
        panel1.add (configPanel, BorderLayout.NORTH);
        panel1.add (messagesPanel, BorderLayout.CENTER);
        panel1.add (southPanel, BorderLayout.SOUTH);

        // create panel to hold all other panels
        JPanel contentPanel = new JPanel (new BorderLayout ());
        contentPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
        contentPanel.add (panel1, BorderLayout.CENTER);

        // add content panel to the window
        frame.setContentPane (contentPanel);
        frame.setMinimumSize (new Dimension (400, 300));
        frame.setPreferredSize (new Dimension (600, 400));

        frame.pack ();
        frame.setVisible (true);
    } 

    private void setupCommunication () {
        System.out.println ("Setup Chat Client");
        // open the communication channel
        communication.open();
        // start a background thread to receive messages from the server
        receiver.start ();
    } 

    private void sendPosting () {
        // send the user message
        if (!(nameField.getText().equals(""))) {
            User user = new User(nameField.getText());  // the user image is not needed in each posting
            String text = messageField.getText ();
            String serverHost = serverField.getText ();
            System.out.println (user + ": " + text);
            communication.sendMessage (serverHost, SERVER_PORT, new PostingMessage (user, text));
            messageField.setText ("");
        }
    } 

    private void sendRegisterMessage () {
        // register the user
        if (!(nameField.getText().equals(""))) {
            User user = new User(nameField.getText(), imageButton.getIcon());
            //User user = new User(nameField.getText());
            String serverHost = serverField.getText ();
            System.out.println ("Register " + user);
            communication.sendMessage (serverHost, SERVER_PORT, new RegisterMessage (user));
        }
    } 

    private void sendUnRegisterMessage () {
        // unregister the user
        if (!(nameField.getText().equals(""))) {
            User user = new User(nameField.getText(), imageButton.getIcon());
            //User user = new User(nameField.getText());
            String serverHost = serverField.getText ();
            System.out.println ("Unregister " + user);
            communication.sendMessage (serverHost, SERVER_PORT, new UnregisterMessage (user));
            // clean panels
            nameField.setText("");
            imageButton.setIcon(null);
            imageButton.setText("Bild");
            messagesText.setText("");
            userListPanel.removeAll();
            userListPanel.repaint();
        }
    } 

    private void loadUserImage() {
        File file = null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF & PNG Images", "jpg", "jpeg", "gif", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            System.out.println("You opened this image file: " + file.getName());
            try {
                BufferedImage img = ImageIO.read(file);
                if (img != null) {
                    Icon myIcon = new ImageIcon(img.getScaledInstance(MAX_ICON_HEIGHT, -1, Image.SCALE_SMOOTH));
                    imageButton.setIcon(myIcon);
                    imageButton.setText("");
                } else {
                    imageButton.setIcon(null);
                    imageButton.setText("Bild");
                } 
            } catch (IOException e) {
            }
        }

    }

    public static void main (String argv[]) {
        new ExtendedChatClient ();
    } 

} 