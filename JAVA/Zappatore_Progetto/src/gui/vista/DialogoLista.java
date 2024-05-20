package gui.vista;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class DialogoLista {
	private JTextField nome;
	private JComponent[] inputs;
	public DialogoLista() {
		nome=new JTextField(20);
		inputs=new JComponent[] {
				new JLabel("Nome"), nome,
		};
	}
	
	public String[] getInputs(String msg) {
		String[] res=new String[1];
		int result=JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			res[0]=nome.getText();
			return res;
		}else {
			return null;
		}
	}
}
