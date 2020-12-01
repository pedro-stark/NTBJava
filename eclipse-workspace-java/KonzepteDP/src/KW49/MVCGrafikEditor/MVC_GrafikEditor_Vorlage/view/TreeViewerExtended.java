package KW49.MVCGrafikEditor.MVC_GrafikEditor_Vorlage.view;

import java.awt.*;
import javax.swing.*;

import MVC_GrafikEditor_Vorlage.model.*;

public class TreeViewerExtended extends JFrame {
	private JTree tree;
	private JTable table;
	
	private Group root;
	
	public TreeViewerExtended(Group root) {
		super("Tree and Table");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.root = root;
		
		add(createToolbar(), BorderLayout.NORTH);

		tree = new JTree(root);		
		JComponent c = new JScrollPane(tree); c.setPreferredSize(new Dimension(700, 400)); 
		add(c, BorderLayout.CENTER);
		
		table = new JTable(root);
		table.setFillsViewportHeight(false); 
		c = new JScrollPane(table); c.setPreferredSize(new Dimension(700, 100)); 
		add(c, BorderLayout.SOUTH);
		
		tree.addTreeSelectionListener(e -> { table.setModel((Figure)e.getPath().getLastPathComponent()); });

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
