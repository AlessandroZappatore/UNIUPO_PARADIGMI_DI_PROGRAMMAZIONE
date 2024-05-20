package gui.vista;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
public class DialogoFile {
	private JTextField nome, file;
	private JComponent[] inputs;
	public DialogoFile() {
		nome=new JTextField(20);
		file=new JTextField(20);
		inputs=new JComponent[] {
				new JLabel("Nome lista"), nome, new JLabel("File"), file,
		};
	}
	
	public String[] getInputs(String msg) {
		String[] res=new String[2];
		int result=JOptionPane.showConfirmDialog(null, inputs, msg, JOptionPane.CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			res[0]=nome.getText();
			res[1]=file.getText();
			return res;
		}else {
			return null;
		}
	}
}
