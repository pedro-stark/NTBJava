package Visitor.Loesung;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Visitor_Werkstattleiter extends JFrame implements Visitor {

	public JTextField laufzeitDrehMaschine;
	public JTextField laufzeitStanzMaschine;
	public JTextField laufzeitSchweissen;
	public JTextField gesamtlaufzeitAllerMaschinen;
	public int gesamtLaufzeit = 0;

	public Visitor_Werkstattleiter() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setTitle("Überwachung Laufzeiten");
		Container cont = this.getContentPane();
		cont.setLayout(new GridLayout(4, 1));
		cont.add(createPanelDrehen());
		cont.add(createPanelStanzen());
		cont.add(createPanelSchweissen());
		cont.add(createPanelGes());
		this.setVisible(true);
		
		

	}

	@Override
	public void visit(Drehbank dreh) {
		int Laufzeit = dreh.Laufzeit;
		laufzeitDrehMaschine.setText("" + Laufzeit);
		gesamtLaufzeit += Laufzeit;
		gesamtlaufzeitAllerMaschinen.setText("" + gesamtLaufzeit);

	}

	@Override
	public void visit(Stanzmaschine stan) {
		int Laufzeit = stan.Laufzeit;
		laufzeitStanzMaschine.setText("" + Laufzeit);
		gesamtLaufzeit += Laufzeit;
		gesamtlaufzeitAllerMaschinen.setText("" + gesamtLaufzeit);

	}

	@Override
	public void visit(SchweissRoboter s) {
		int Laufzeit = s.Laufzeit;
		laufzeitSchweissen.setText("" + Laufzeit);
		gesamtLaufzeit += Laufzeit;
		gesamtlaufzeitAllerMaschinen.setText("" + gesamtLaufzeit);

	}

	public JPanel createPanelDrehen() {
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Abteilung Drehen"));
		pan.setSize(500, 160);
		pan.setLayout(new BorderLayout());
		JPanel params = new JPanel();
		params.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbl1 = new JLabel("Maschine: ");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl1, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		JLabel lbl2 = new JLabel("CTX Beta TC1250");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl2, c);

		JLabel lbl = new JLabel("Laufzeit: ");
		lbl.setSize(30, 50);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbl, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		laufzeitDrehMaschine = new JTextField("aktuelle Laufzeit");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(laufzeitDrehMaschine, c);
		
		JLabel lbltime = new JLabel("[min]");
		lbltime.setSize(30, 50);
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbltime, c);


		pan.add(params, BorderLayout.WEST);

		//Get package name of current Class
		Class cl = this.getClass();
		String s = ""+cl.getPackage();
		s = s.substring(8);
		System.out.println(s);
		pan.add(new JLabel(new ImageIcon("src\\"+s+"\\images\\DrehbankBetaTC1250.jpg")),
				BorderLayout.EAST);

		return pan;
	}

	public JPanel createPanelStanzen() {
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Abteilung Stanzen"));
		pan.setSize(500, 160);
		pan.setLayout(new BorderLayout());
		JPanel params = new JPanel();
		params.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbl1 = new JLabel("Maschine: ");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl1, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		JLabel lbl2 = new JLabel("Boschert Ecoline");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl2, c);

		JLabel lbl = new JLabel("Laufzeit: ");
		lbl.setSize(30, 50);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbl, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		laufzeitStanzMaschine = new JTextField("aktuelle Laufzeit");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(laufzeitStanzMaschine, c);
		
		JLabel lbltime = new JLabel("[min]");
		lbltime.setSize(30, 50);
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbltime, c);

		pan.add(params, BorderLayout.WEST);

		//Get package name of current Class
		Class cl = this.getClass();
		String s = ""+cl.getPackage();
		s = s.substring(8);
		pan.add(new JLabel(
				new ImageIcon("src\\"+s+"\\images\\Stanzmaschine_Boschert_Ecoline.jpg")),
				BorderLayout.EAST);

		return pan;
	}

	public JPanel createPanelSchweissen() {
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Abteilung Schweissen"));
		pan.setSize(500, 300);
		pan.setLayout(new BorderLayout());
		JPanel params = new JPanel();
		params.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbl1 = new JLabel("Maschine: ");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl1, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		JLabel lbl2 = new JLabel("Kuka KR XY");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 0;
		params.add(lbl2, c);

		JLabel lbl = new JLabel("Laufzeit: ");
		lbl.setSize(30, 50);
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbl, c);

		c.gridx = 1;
		params.add(Box.createHorizontalStrut(50), c);

		laufzeitSchweissen = new JTextField("aktuelle Laufzeit");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(laufzeitSchweissen, c);
		
		JLabel lbltime = new JLabel("[min]");
		lbltime.setSize(30, 50);
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = 1;
		params.add(lbltime, c);


		pan.add(params, BorderLayout.WEST);

		//Get package name of current Class
		Class cl = this.getClass();
		String s = ""+cl.getPackage();
		s = s.substring(8);
		pan.add(new JLabel(new ImageIcon("src\\"+s+"\\images\\Kuka.jpg")), BorderLayout.EAST);

		return pan;
	}

	public JPanel createPanelGes() {
		JPanel pan = new JPanel();
		pan.setBorder(BorderFactory.createTitledBorder("Alle Abteilungen"));
		pan.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel lbl1 = new JLabel("Gesamtlaufzeit: ");
		c.gridx = 0;
		c.gridwidth = 1;
		c.gridy = 0;
		pan.add(lbl1, c);

		c.gridx = 1;
		pan.add(Box.createHorizontalStrut(50), c);

		gesamtlaufzeitAllerMaschinen = new JTextField("gesamte Laufzeit");
		c.gridx = 2;
		c.gridwidth = 1;
		c.gridy = 0;
		pan.add(gesamtlaufzeitAllerMaschinen, c);
		
		JLabel lbltime = new JLabel("[min]");
		lbltime.setSize(30, 50);
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = 0;
		pan.add(lbltime, c);


		return pan;

	}
}
