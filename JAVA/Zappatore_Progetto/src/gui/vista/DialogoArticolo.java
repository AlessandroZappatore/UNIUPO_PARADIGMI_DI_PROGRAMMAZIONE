package gui.vista;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class DialogoArticolo {
	private JTextField nome, qty, costo, categoria;
	private JComponent[] inputs;
	public DialogoArticolo() {
		nome = new JTextField(20);
		qty = new JTextField(10);
		costo = new JTextField(10);
		categoria = new JTextField(30);
		inputs = new JComponent[] {
				new JLabel("Nome"), nome, new JLabel("Quantita'"), qty, new JLabel("Costo"), costo, new JLabel("Categoria"), categoria,
		};
	}
	
	public String[] getInputs(String msg) {
		String[] res = new String[4];
		int result = JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			res[0]=nome.getText();
			res[1]=qty.getText();
			res[2]=costo.getText();
			res[3]=categoria.getText();
			return res;
		}else {return null;}
	}
}
