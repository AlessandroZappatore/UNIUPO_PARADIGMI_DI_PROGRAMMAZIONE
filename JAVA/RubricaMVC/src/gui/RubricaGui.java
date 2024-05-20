package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.vista.RubricaPanel;
import modello.Rubrica;

@SuppressWarnings("serial")
public class RubricaGui extends JFrame{
	
	public RubricaGui(Rubrica model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Rubrica " + model.getNome());

		JPanel rubricaPanel= new RubricaPanel(model);
		setContentPane(rubricaPanel);
		
		setVisible(true);
		
	}

}
