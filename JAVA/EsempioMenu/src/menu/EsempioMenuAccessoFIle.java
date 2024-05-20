package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EsempioMenuAccessoFIle {
	public static void main(final String args[]) {
		JFrame frame = new JFrame("Esempio Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem apriMenuItem = new JMenuItem("Apri");
		apriMenuItem.addActionListener((ActionEvent e) -> {
			JFileChooser fc = new JFileChooser();
			int val = fc.showOpenDialog(frame);

			if (val == JFileChooser.APPROVE_OPTION)
				System.out.println("File scelto" + fc.getSelectedFile());
			else
				System.out.println("Nessun file scelto");
			;

		});
		fileMenu.add(apriMenuItem);

		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}