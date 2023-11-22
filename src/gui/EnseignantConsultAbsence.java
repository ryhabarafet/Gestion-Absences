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
import gui.EnseignantRemplirAbsence.Item;
import model.Classe;
import model.Etudiant;
import model.Matiere;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EnseignantConsultAbsence extends JPanel {
	private JTable table;
	private JTextField seanceText;
	private JComboBox classe;
	private JComboBox matiere;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public EnseignantConsultAbsence() {
		
		setBounds(0, 0, 627, 491);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulter Absence");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(190, 38, 261, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Classe");
		lblNewLabel_1.setBounds(23, 85, 55, 14);
		add(lblNewLabel_1);
		
		classe = new JComboBox();
		classe.setBounds(23, 114, 130, 22);
		add(classe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 147, 594, 314);
		add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Matiére");
		lblNewLabel_2.setBounds(180, 85, 46, 14);
		add(lblNewLabel_2);
		
		matiere = new JComboBox();
		matiere.setBounds(180, 114, 174, 22);
		add(matiere);
		
		JLabel lblNewLabel_3 = new JLabel("Séance");
		lblNewLabel_3.setBounds(383, 85, 46, 14);
		add(lblNewLabel_3);
		
		seanceText = new JTextField();
		seanceText.setBounds(384, 115, 86, 20);
		add(seanceText);
		seanceText.setColumns(10);
		
		JButton affAbsence = new JButton("Consulter");
		affAbsence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherAbsence();
			}
		});
		affAbsence.setBounds(496, 114, 89, 23);
		add(affAbsence);
		
		JButton btnNewButton = new JButton("Initialiser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classe.setSelectedIndex(0);
				matiere.removeAllItems();
				matiere.setEnabled(false);
				seanceText.setText("");
				if(model!=null)
				model.setColumnCount(0);
			}
		});
		btnNewButton.setBounds(23, 468, 89, 23);
		add(btnNewButton);
		remplireCalsse();
		remplireMatiere();
	}
	
	public void remplireCalsse() {
		classe.removeAllItems();
		ArrayList<Classe> classe_enseignant = ClasseDao.getClasseByEnsignant(Login.ens.getIdEnseignant());
		classe.addItem(new Item(0, "sélectionner classe"));
		for (Classe c : classe_enseignant) {
			classe.addItem(new Item(c.getIdClasse(), c.getLibelleClasse()));
		}
		classe.setEnabled(true);
	}
	
	public void remplireMatiere(){
		classe.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Item selectedItem = (Item) e.getItem();
					if (!selectedItem.description.equals("sélectionner classe")) {
						matiere.removeAllItems();
						ArrayList<Matiere> matiere_enseignant = ClasseDao.getMatiere(Login.ens.getIdEnseignant(),
								selectedItem.id);
						matiere.addItem(new Item(0, "sélectionner matiére"));
						for (Matiere m : matiere_enseignant) {
							matiere.addItem(new Item(m.getIdMatiere(), m.getLibelleMatiere()));
						}
						matiere.setEnabled(true);
					}

				}
			}
		});
	}
	
	public void afficherAbsence() {
		Item mat = (Item) matiere.getSelectedItem();
		Item clas = (Item) classe.getSelectedItem();
		int id_ens = Login.ens.getIdEnseignant();
		int seance = Integer.parseInt(seanceText.getText());
		ArrayList<String> abs = AbsenceDao.getAbsence(id_ens, mat.id, seance,clas.id);
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
