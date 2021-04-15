import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

public class HueClient extends JFrame implements KeyListener{

	//Init model stuff
	private  HueBridge    hueBridge;
	private  int 		  selectedLamp;
	
	//Init GUI stuff
	private  JFrame 	  frame				 = new JFrame("Hue Client");
    private  JLabel       baseUrlLabel       = new JLabel (" Base URL: ");
    private  JLabel       actualUrlLabel     = new JLabel (" Actual URL: ");
    private  JTextField   baseUrlField       = new JTextField ();		
    private  JTextField   actualUrlField     = new JTextField ();		
    private  JButton      connectButton      = new JButton("Connect");  //startet bridge Thread
    private  JTextArea    bridgeResponseArea = new JTextArea ();
    
    //Messages
    //private  JTextArea    messagesText       = new JTextArea ();
    //private  JScrollPane  messagesScrollPane = new JScrollPane (messagesText);
    
    //Color stuff
    private  JLabel       			brightnessLabel    = new JLabel (" Brightness: ");
    private  JLabel       			saturationLabel    = new JLabel (" Saturation: ");
    private  JLabel       			hueLabel		   = new JLabel (" Hue: ");
    private  JFormattedTextField   	brightnessField    = new JFormattedTextField ();		
    private  JFormattedTextField   	saturationField    = new JFormattedTextField ();		
    private  JFormattedTextField   	hueField		   = new JFormattedTextField ();		
    private  JButton				setColorButton	   = new JButton();	
    
    //Choose lamp, ON & OFF
    private  JLabel       			lampSelectedLabel  = new JLabel (" Selected lamp: ");
    private  JFormattedTextField   	lampSelectedField  = new JFormattedTextField ();
    private  JButton	  			lampOnButton	   = new JButton("ON");
    private  JButton	  			lampOffButton	   = new JButton("OFF");
    
    //Choose mode
    private JButton 	  			colorWheelButton   = new JButton("Colorwheel");
    private JButton 	  			policeModeButton   = new JButton("Policemode");
    private JButton 	  			idleModeButton     = new JButton("Idle");
    private JFormattedTextField	  	selectedModeField  = new JFormattedTextField("Idle");
    
	public HueClient() {
		
		super ("Hue Client");
		hueBridge = new HueBridge ("http://192.168.0.10/api/P7j4vPm-NyIgIZuXfxqF00yevzCptd1pTKknrdZu/");
		hueBridge.start();
		
		//Value init
		baseUrlField.setText (hueBridge.getBaseURL());
		actualUrlField.setText (hueBridge.getActualURL());

		// Number Formatter: Only allow numbers in JTextFields
		// Define the number factory.
		NumberFormat numberFormat = NumberFormat.getIntegerInstance(); // Specify specific format here.
		NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		numberFormatter.setValueClass(Integer.class);
		//numberFormatter.setMinimum(0);
		numberFormatter.setMaximum(Integer.MAX_VALUE);
		numberFormatter.setAllowsInvalid(false);
		DefaultFormatterFactory factory = new DefaultFormatterFactory(numberFormatter);

		// Define the decimal factory.
		//DecimalFormat df = new DecimalFormat(); // And here..
		//NumberFormatter dnff = new NumberFormatter(df);
		//DefaultFormatterFactory factory2 = new DefaultFormatterFactory(dnff); 

		// Then you set which factory to use.
		brightnessField.setFormatterFactory(factory);
		saturationField.setFormatterFactory(factory);
		hueField.setFormatterFactory(factory);
		lampSelectedField.setFormatterFactory(factory);

        // create configuration panel
        JPanel configPanel = new JPanel (new BorderLayout ());
        configPanel.setBorder (new TitledBorder (" Configuration "));
		
        // create baseURL panel
        JPanel baseUrlPanel = new JPanel (new BorderLayout ());
        baseUrlLabel.setPreferredSize (new Dimension (100, 28));
        baseUrlField.setPreferredSize (new Dimension (400, 28));
        baseUrlPanel.add (baseUrlLabel, BorderLayout.WEST);
        baseUrlPanel.add (baseUrlField, BorderLayout.CENTER);
        baseUrlPanel.add (connectButton, BorderLayout.EAST);
        baseUrlPanel.setBorder (new EmptyBorder (2, 2, 2, 2));
        
        // create actualURL panel
        JPanel actualUrlPanel = new JPanel (new BorderLayout ());
        actualUrlLabel.setPreferredSize (new Dimension (100, 28));
        actualUrlField.setPreferredSize (new Dimension (400, 28));
        actualUrlPanel.add (actualUrlLabel, BorderLayout.WEST);
        actualUrlPanel.add (actualUrlField, BorderLayout.CENTER);
        actualUrlPanel.setBorder (new EmptyBorder (2, 2, 2, 2));
        
        // fill configuration panel
        configPanel.add (baseUrlPanel, BorderLayout.NORTH); 
        configPanel.add (actualUrlPanel, BorderLayout.SOUTH);
        
        // create selected lamp panel
        JPanel selectedLampPanel = new JPanel (new BorderLayout ());
        lampSelectedLabel.setPreferredSize (new Dimension (100, 28));
        lampSelectedField.setPreferredSize (new Dimension (400, 28));
        selectedLampPanel.add (lampSelectedLabel, BorderLayout.WEST);
        selectedLampPanel.add (lampSelectedField, BorderLayout.CENTER);
        selectedLampPanel.setBorder (new EmptyBorder (2, 2, 2, 2));
        
        // create ON/OFF lamp panel
        JPanel onOffPanel = new JPanel (new BorderLayout ());
        GridLayout lampImmGrid = new GridLayout (1,2);
        lampImmGrid.setHgap(4);
        lampImmGrid.setVgap(4);
        JPanel lampImmPanel = new JPanel (lampImmGrid);
        lampImmPanel.add(lampOnButton);
        lampImmPanel.add(lampOffButton);
        onOffPanel.add (lampImmPanel, BorderLayout.CENTER);
        onOffPanel.setBorder (new EmptyBorder (2, 2, 2, 2));
        
        // create lamp panel
        JPanel lampPanel = new JPanel (new BorderLayout());
        lampPanel.setBorder (new TitledBorder (" Lamp "));
        lampPanel.add (selectedLampPanel, BorderLayout.NORTH);
        lampPanel.add (onOffPanel, BorderLayout.SOUTH);
        
        // create messages panel
        //JPanel messagesPanel = new JPanel (new BorderLayout ());
        //messagesPanel.add (messagesScrollPane, BorderLayout.CENTER);
        //messagesPanel.setBorder (new TitledBorder (" Messages "));
 
        // create color panel
        JPanel colorPanel = new JPanel ();
        GridLayout colorGrid = new GridLayout(3,1);
        colorGrid.setHgap(4);
        colorGrid.setVgap(4);
        colorPanel.setLayout(colorGrid);
        brightnessLabel.setPreferredSize (new Dimension (100, 28));
        brightnessField.setPreferredSize (new Dimension (400, 28));
        saturationLabel.setPreferredSize (new Dimension (100, 28));
        saturationField.setPreferredSize (new Dimension (400, 28));
        hueLabel.setPreferredSize (new Dimension (100, 28));
        hueField.setPreferredSize (new Dimension (400, 28));
        
        JPanel colorBriPanel = new JPanel (new BorderLayout());
        JPanel colorSatPanel = new JPanel (new BorderLayout());
        JPanel colorHuePanel = new JPanel (new BorderLayout());
        colorBriPanel.add (brightnessLabel, BorderLayout.WEST);
        colorBriPanel.add (brightnessField, BorderLayout.CENTER);
        colorSatPanel.add (saturationLabel, BorderLayout.WEST);
        colorSatPanel.add (saturationField, BorderLayout.CENTER);
        colorHuePanel.add (hueLabel, BorderLayout.WEST);
        colorHuePanel.add (hueField, BorderLayout.CENTER);
        colorPanel.add(colorBriPanel);
        colorPanel.add(colorSatPanel);
        colorPanel.add(colorHuePanel);
        colorPanel.setBorder (new TitledBorder (" Light Settings "));
        
        // create lamp color panel  
        JPanel lampColorPanel = new JPanel (new BorderLayout ());
        lampColorPanel.add (colorPanel, BorderLayout.CENTER);
        lampColorPanel.add (lampPanel, BorderLayout.NORTH);
        
        // create action panel
        JPanel actionPanel = new JPanel ();
        GridLayout actionGrid = new GridLayout (1,3);
        actionGrid.setHgap(4);
        actionGrid.setVgap(4);
        actionPanel.setLayout(actionGrid);
        actionPanel.setBorder (new TitledBorder (" Modes "));
        actionPanel.add (colorWheelButton);
        actionPanel.add (policeModeButton);
        actionPanel.add (idleModeButton);
        
        // create panel with Config, Messages, Lamps and Actions
        JPanel panel1 = new JPanel (new BorderLayout ());
        panel1.add (configPanel, BorderLayout.NORTH);
        panel1.add (lampColorPanel, BorderLayout.CENTER);
        panel1.add (actionPanel, BorderLayout.SOUTH);
        
        // create panel to hold all other panels
        JPanel contentPanel = new JPanel (new BorderLayout ());
        contentPanel.setBorder (new EmptyBorder (10, 10, 10, 10));
        contentPanel.add (panel1, BorderLayout.CENTER);

        // add content panel to the window
        frame.setContentPane (contentPanel);
        frame.setMinimumSize (new Dimension (400, 300));
        frame.setPreferredSize (new Dimension (660, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack ();
        frame.setVisible (true);
        
        
		// Buttonlisteners
		
		lampOnButton.addActionListener(e -> {
			selectedLamp = Integer.parseInt(lampSelectedField.getText());
			hueBridge.setLampOn(selectedLamp, true);
		});
		
		lampOffButton.addActionListener(e -> {
			hueBridge.setLampOn(selectedLamp, false);
		});
		
		policeModeButton.addActionListener(e -> {
			hueBridge.setPoliceMode(selectedLamp);
		});
		
		colorWheelButton.addActionListener(e -> {
			hueBridge.setColorWheel(selectedLamp);
		});
		
		idleModeButton.addActionListener(e -> {
			hueBridge.setIdle(selectedLamp);
		});
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("KeyTyped: ");
		/*
		 * if(e.getKeyChar() == KeyEvent.CHAR_UNDEFINED){
		 * System.out.println("Kein Unicode-Character gedr\u00FCckt!"); }else{
		 * System.out.println(e.getKeyChar() + " gedr\u00FCckt!"); }
		 */
		System.out.println("---");
	}

	public void keyPressed(KeyEvent e) {
		/*
		 * if (e.getKeyCode() == 39 || e.getKeyCode() == 37 && spielGestartet){
		 * sf.schlaegerBewegen(e.getKeyCode()); }
		 * 
		 * if (e.getKeyCode() == 38){ sf.winMode(e.getKeyCode()); }
		 */
		System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
		System.out.println("Tastenposition: " + e.getKeyLocation());
		System.out.println("---");
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("KeyReleased: ");
		// if(e.getKeyCode() == KeyEvent.VK_SPACE){
		// System.out.println("Programmabbruch!");
		// System.exit(0);
		// }
		System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
		System.out.println("---");
	}

	public static void main(String args[]) {
		HueClient client = new HueClient();
	}
}
