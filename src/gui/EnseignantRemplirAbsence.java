package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AbsenceDao;
import dao.ClasseDao;
import dao.EtudiantDao;
import gui.EnseignantRemplirAbsence.Item;
import model.Absence;
import model.Classe;
import model.Etudiant;
import model.Matiere;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EnseignantRemplirAbsence extends JPanel {
	private JTable table;
	private JComboBox filiere;
	private JTextField seance;
	private DefaultTableModel model;
	final JComboBox<Item> matiere;
	private JButton validateBtn;
	final JComboBox niveau;
	final JComboBox<Item> classe;

	/**
	 * Create the panel.
	 */
	
	
	
	public EnseignantRemplirAbsence() {
		
		final Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);

		setBounds(0, 0, 627, 491);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Remplire Absence");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(190, 26, 255, 33);
		add(lblNewLabel);

		ArrayList<String> niveau_enseignant = ClasseDao.getNiveauByEnseignant(Login.ens.getIdEnseignant());
		niveau_enseignant.add(0, "sélectionner niveau");
		niveau = new JComboBox(niveau_enseignant.toArray());
		niveau.setBounds(49, 109, 157, 33);
		add(niveau);

		JLabel lblNewLabel_1 = new JLabel("Filiére:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(239, 84, 69, 14);
		add(lblNewLabel_1);
		filiere = new JComboBox();
		filiere.setEnabled(false);
		filiere.setBounds(239, 109, 157, 33);
		add(filiere);

		JLabel lblNewLabel_1_1 = new JLabel("Niveau:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(49, 80, 69, 14);
		add(lblNewLabel_1_1);

		classe = new JComboBox();
		classe.setEnabled(false);
		classe.setBounds(425, 109, 157, 33);
		add(classe);

		JLabel lblNewLabel_1_2 = new JLabel("Classe:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(429, 86, 69, 14);
		add(lblNewLabel_1_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 205, 607, 252);
		add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		table = new JTable() {
			public Class getColumnClass(int column) {
				// return Boolean.class
				return getValueAt(0, column).getClass();
			}
		};
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Vérifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item mat = (Item) matiere.getSelectedItem();
				Item clas = (Item) classe.getSelectedItem();
				int res = AbsenceDao.verfiAbsenceBySeanceAndClasse(clas.id, mat.id, Integer.parseInt(seance.getText()));
				if (res == 0) {
					table.setEnabled(true);
					validateBtn.setEnabled(true);
				}else {
					table.setEnabled(false);
					validateBtn.setEnabled(false);
					
				}
				
				ArrayList<Etudiant> arrEtd = EtudiantDao.getEtudiantByClasse(clas.id);
				ArrayList<Integer> arrEtdAbs = AbsenceDao.getEtudiantAbsent(clas.id, mat.id, Integer.parseInt(seance.getText()));
				table.removeAll();
				model = new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("Nom");
				model.addColumn("Prénom");
				model.addColumn("Absence");
				for(Etudiant et : arrEtd) {
					if(arrEtdAbs.contains(et.getIdEtudiant())) {
						model.addRow(new Object[] { et.getIdEtudiant(), et.getNomEtudiant(), et.getPrenomEtudiant(),
								true });
					}else {
						model.addRow(new Object[] { et.getIdEtudiant(), et.getNomEtudiant(), et.getPrenomEtudiant(),
								false });
					}
				}
				table.setModel(model);
				table.removeColumn(table.getColumnModel().getColumn(0));

			}
		});
		btnNewButton.setBounds(445, 161, 89, 33);
		add(btnNewButton);

		matiere = new JComboBox(new Object[] {});
		matiere.setBounds(110, 161, 157, 33);
		add(matiere);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Matiére");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(49, 168, 69, 14);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Séance");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(277, 168, 69, 14);
		add(lblNewLabel_1_1_1_1);

		seance = new JTextField();
		seance.setEnabled(false);
		seance.setBounds(344, 167, 86, 20);
		add(seance);
		seance.setColumns(10);
		/**** current date ***/

		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(519, 11, 98, 14);
		add(lblNewLabel_2);
		setVisible(true);
		lblNewLabel_2.setText("Date: " + strDate);
		
		validateBtn = new JButton("Valider");
		validateBtn.setEnabled(false);
		validateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item mat = (Item) matiere.getSelectedItem();
				Item clas = (Item) classe.getSelectedItem();
				int res = AbsenceDao.verfiAbsenceBySeanceAndClasse(clas.id, mat.id, Integer.parseInt(seance.getText()));
				if (res == 0) {
					ArrayList<Absence> absences = new ArrayList<Absence>();
					for (int count = 0; count < model.getRowCount(); count++) {
							Absence a = new Absence();
							a.setIdEnseignant(Login.ens.getIdEnseignant());
							a.setIdEtudiant(Integer.parseInt(model.getValueAt(count, 0).toString()));
							a.setIdMatiere(mat.id);
							a.setNumSeance(Integer.parseInt(seance.getText()));
							a.setDateAbsence(date);
							if (model.getValueAt(count, 3).toString().equals("true")) {
								a.setEtat("true");
							}
							else {
								a.setEtat("false");
							}
							absences.add(a);
						

					}
					for (Absence a : absences) {
						AbsenceDao.addNbAbs(a);
					}
				}
			}
		});
		validateBtn.setBounds(528, 460, 89, 20);
		add(validateBtn);
		
		JButton btnNewButton_1 = new JButton("Initialiser");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init();
			}
		});
		btnNewButton_1.setBounds(10, 459, 89, 23);
		add(btnNewButton_1);
		niveau.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedItem = (String) e.getItem();
					if (!selectedItem.equals("sélectionner niveau")) {
						ArrayList<String> filiere_enseignant = ClasseDao
								.getFiliereByEnseignantAndNiveau(Login.ens.getIdEnseignant(), selectedItem);
						filiere_enseignant.add(0, "sélectionner filiere");
						filiere.removeAllItems();
						for (String s : filiere_enseignant) {
							filiere.addItem(s);
						}
						filiere.setEnabled(true);
					}

				}
			}
		});

		filiere.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String selectedItem = (String) e.getItem();
					if (!selectedItem.equals("sélectionner filiere")) {
						classe.removeAllItems();
						ArrayList<Classe> classe_enseignant = ClasseDao.getClasse(Login.ens.getIdEnseignant(),
								niveau.getSelectedItem().toString(), selectedItem);
						classe.addItem(new Item(0, "sélectionner classe"));
						for (Classe c : classe_enseignant) {
							classe.addItem(new Item(c.getIdClasse(), c.getLibelleClasse()));
						}
						classe.setEnabled(true);
					}

				}
			}
		});

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

		matiere.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Item selectedItem = (Item) e.getItem();
					if (!selectedItem.description.equals("sélectionner matiére")) {
						seance.setEnabled(true);
					}

				}
			}
		});
		
	}
	
	public void init() {
		niveau.setSelectedIndex(0);
		matiere.removeAllItems();
		matiere.setEnabled(false);
		classe.removeAllItems();
		classe.setEnabled(false);
		seance.setText("");
		seance.setEnabled(false);
		filiere.removeAllItems();
		filiere.setEnabled(false);
		if(model!= null)
		model.setRowCount(0);
		validateBtn.setEnabled(false);
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
