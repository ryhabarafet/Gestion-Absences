package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.AbsenceDao;
import dao.ClasseDao;
import dao.EtudiantDao;
import dao.MatiereDao;
import gui.EnseignantRemplirAbsence.Item;
import model.Classe;
import model.Etudiant;
import model.Matiere;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EtudiantConsulterAbsence extends JPanel {
	private JTable table;
	private JComboBox matiere;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public EtudiantConsulterAbsence() {
		
		setBounds(0, 0, 627, 491);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulter Absence");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(190, 38, 261, 33);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 147, 594, 333);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Matiére");
		lblNewLabel_2.setBounds(23, 118, 46, 14);
		add(lblNewLabel_2);
		
		matiere = new JComboBox();
		matiere.setBounds(79, 114, 174, 22);
		add(matiere);
		
		JButton affAbsence = new JButton("Consulter");
		affAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherAbsence();
			}
		});
		affAbsence.setBounds(263, 114, 89, 23);
		add(affAbsence);
		remplireMatiere();
	}
	
	
	
	public void remplireMatiere(){
		matiere.removeAllItems();
		ArrayList<Matiere> matiere_etudiant = MatiereDao.getMatiere(Login.etd.getIdEtudiant());
		matiere.addItem(new Item(0, "sélectionner Matiere"));
		for (Matiere m : matiere_etudiant) {
			matiere.addItem(new Item(m.getIdMatiere(), m.getLibelleMatiere()));
		}
		matiere.setEnabled(true);
	}
	
	public void afficherAbsence() {
		Item mat = (Item) matiere.getSelectedItem();
		int id_etd = Login.etd.getIdEtudiant();
		ArrayList<String> abs = AbsenceDao.getAbsenceByEtudiant(id_etd, mat.id);
		table.removeAll();
		model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("Nom");
		model.addColumn("Prénom");
		model.addColumn("Seance");
		model.addColumn("Date");
		model.addColumn("Etat");
		for(int i=0;i<abs.size();i++) {
			String[] strArray = abs.get(i).split(",");  
			model.addRow(new Object[] {strArray[0],strArray[1], strArray[2], strArray[3], strArray[4],getAbs(strArray[5]) });
		}
		table.setModel(model);
		table.removeColumn(table.getColumnModel().getColumn(0));
	}
	
	public String getAbs(String s) {
		if(s.equals("true")) {
			return "Absent";
		}
		return "Présent";
	}
	
	
	class Item {

		private int id;
		private String description;

		public Item(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return description;
		}
	}
}
