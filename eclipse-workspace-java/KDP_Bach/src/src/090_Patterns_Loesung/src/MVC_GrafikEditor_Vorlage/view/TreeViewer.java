package MVC_GrafikEditor_Vorlage.view;

import java.awt.*;
import javax.swing.*;

import MVC_GrafikEditor_Vorlage.model.*;

public class TreeViewer extends JFrame {
	private JTree tree;
	
	private Group root;
	
	public TreeViewer(Group root) {
		super("Tree");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.root = root;
		
		add(createToolbar(), BorderLayout.NORTH);

		tree = new JTree(root);		
		JComponent c = new JScrollPane(tree); c.setPreferredSize(new Dimension(700, 400)); 
		add(c, BorderLayout.CENTER);

		setSize(700,500);
        setVisible(true);
	}

	protected JComponent createToolbar() {
		JToolBar tb = new JToolBar();
		
		JButton b = new JButton("Refresh");
		b.addActionListener(e -> { tree.setModel(null); tree.setModel(root); }); //brute force!
		tb.add(b);
		
		return tb;
	}

}
