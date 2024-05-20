package gui.vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.controllo.ControlloLista;
/**
 * @author Alessandro Zappatore matricola:20050889
 */
@SuppressWarnings("serial")
public class OpsPanel extends JPanel{
	public OpsPanel(ControlloLista controllo) {
		setLayout(new FlowLayout());
		JButton addList = new JButton("Aggiungi lista");
		JButton delList = new JButton("Elimina lista");
		JButton addCat = new JButton("Aggiungi categoria");
		JButton delCat = new JButton("Elimina categoria");
		JButton saveFile = new JButton("Salva lista su file");
		JButton readFile = new JButton("Leggi lista da file");
		JButton accList = new JButton("Accedi lista");
		addList.addActionListener(controllo);
		add(addList);
		delList.addActionListener(controllo);
		add(delList);
		addCat.addActionListener(controllo);
		add(addCat);
		delCat.addActionListener(controllo);
		add(delCat);
		saveFile.addActionListener(controllo);
		add(saveFile);
		readFile.addActionListener(controllo);
		add(readFile);
		accList.addActionListener(controllo);
		add(accList);
		
	}
}
