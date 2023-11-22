package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.AbsenceDao;
import dao.ClasseDao;
import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.MatiereDao;
import gui.EnseignantRemplirAbsence.Item;
import model.Absence;
import model.Classe;
import model.Enseignant;
import model.Etudiant;
import model.Matiere;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ResponsableGestionAbsence extends JPanel {
	
	private JTable table;
	private JTextField seance;
	private DefaultTableModel model;
	final JComboBox<Item> matiere;
	private JButton modifBtn;
	private final JComboBox enseignant;

	/**
	 * Create the panel.
	 */
	public ResponsableGestionAbsence() {

		final Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);

		setBounds(0, 0, 627, 491);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Gestion Absence");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(190, 26, 255, 33);
		add(lblNewLabel);

		
		enseignant = new JComboBox();
		
		enseignant.removeAllItems();
		ArrayList<Enseignant> enseignants = EnseignantDao.getEnseignant();
		enseignant.addItem(new Item(0, "sélectionner enseignant"));
		for (Enseignant e : enseignants) {
			enseignant.addItem(new Item(e.getIdEnseignant(), e.getNomEnseignant()+" "+e.getPrenomEnseignant()));
		}
		
		enseignant.setBounds(49, 109, 157, 33);
		add(enseignant);

		JLabel lblNewLabel_1_1 = new JLabel("Enseignant");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(49, 80, 114, 14);
		add(lblNewLabel_1_1);

		final JComboBox<Item> classe = new JComboBox();
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
				Item ens = (Item) enseignant.getSelectedItem();
				int seancet = Integer.parseInt(seance.getText());
				ArrayList<String> abs = AbsenceDao.getAbsence(ens.id, mat.id, seancet,clas.id);
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
					model.addRow(new Object[] {strArray[0],strArray[1], strArray[2], strArray[3], strArray[4],Boolean.parseBoolean(strArray[5])});
				}
				table.setModel(model);
				table.removeColumn(table.getColumnModel().getColumn(0));
				modifBtn.setEnabled(true);
			}
		});
		
		btnNewButton.setBounds(237, 153, 89, 33);
		add(btnNewButton);

		matiere = new JComboBox(new Object[] {});
		matiere.setEnabled(false);
		matiere.setBounds(237, 109, 157, 33);
		add(matiere);

		JLabel lblNewLabel_1_1_1 = new JLabel("Matiére");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(237, 80, 69, 14);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Séance");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(49, 168, 69, 14);
		add(lblNewLabel_1_1_1_1);

		seance = new JTextField();
		seance.setBounds(108, 167, 86, 20);
		add(seance);
		seance.setColumns(10);

		/**** current date ***/

		JLabel lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setBounds(519, 11, 98, 14);
		add(lblNewLabel_2);
		setVisible(true);
		lblNewLabel_2.setText("Date: " + strDate);
		
		modifBtn = new JButton("Modifier");
		modifBtn.setEnabled(false);
		modifBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableModel dtm = table.getModel();
			    int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
			    Object[][] tableData = new Object[nRow][nCol];
			    for (int i = 0 ; i < nRow ; i++)
			        for (int j = 0 ; j < nCol ; j++)
			            tableData[i][j] = dtm.getValueAt(i,j);
			    ArrayList<String> arr = new ArrayList<>();
			    String ch="";
			    for (int i = 0 ; i < nRow ; i++) {
			        for (int j = 0 ; j < nCol ; j++) {
			        	ch+=tableData[i][j]+",";
			        }
			        ch = ch.substring(0, ch.length() - 1);
			        arr.add(ch);
			        ch="";
			    }
			    Item mat = (Item) matiere.getSelectedItem();
				Item ens = (Item) enseignant.getSelectedItem();
				int seancet = Integer.parseInt(seance.getText());
			    for(int i=0;i<arr.size();i++) {
			    	int id_etd = Character.getNumericValue(arr.get(i).charAt(0));
			    	AbsenceDao.removeAbs(ens.id, mat.id, seancet, id_etd);
			    }
			    for(int i=0;i<arr.size();i++) {
			    	int id_etd = Character.getNumericValue(arr.get(i).charAt(0));
			    	String[] data = arr.get(i).split(",");
			    	SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
			    	Date date = null;
					try {
						date = formatter2.parse(data[4]);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
			    	Absence a = new Absence(id_etd, ens.id,mat.id, seancet, date, data[5]);
			    	AbsenceDao.addNbAbs(a);
			    }
			}
		});
		modifBtn.setBounds(528, 460, 89, 20);
		add(modifBtn);
		
		JButton btnNewButton_1 = new JButton("Imprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MessageFormat header = new MessageFormat("Liste des absences"); 
					MessageFormat footer = new MessageFormat("Page {0,number,integer}");// add footer
				    table.print(JTable.PrintMode.FIT_WIDTH, header, footer); 
				} catch (java.awt.print.PrinterException s) {
				     System.err.format("Cannot print %s%n", s.getMessage()); 
				}
			}
		});
		btnNewButton_1.setBounds(10, 459, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Initialiser");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignant.setSelectedIndex(0);
				matiere.removeAllItems();
				matiere.setEnabled(false);
				classe.removeAllItems();
				classe.setEnabled(false);
				seance.setText("");
				if(model!=null) {
					model.setColumnCount(0);
				}
				modifBtn.setEnabled(false);
			}
		});
		btnNewButton_2.setBounds(108, 459, 89, 23);
		add(btnNewButton_2);
		enseignant.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Item selectedItem = (Item) e.getItem();
					if (!selectedItem.description.equals("sélectionner enseignant")) {
						matiere.removeAllItems();
						ArrayList<Matiere> matiere_enseignant = MatiereDao.getMatiereByEnseignant(selectedItem.id);
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
						classe.removeAllItems();
						Item ens = (Item) enseignant.getSelectedItem();
						ArrayList<Classe> classes = ClasseDao.getClasseByEnsignantAndMatiere(ens.id, selectedItem.id);
						classe.addItem(new Item(0, "sélectionner classe"));
						for (Classe c : classes) {
							classe.addItem(new Item(c.getIdClasse(), c.getLibelleClasse()));
						}
						classe.setEnabled(true);
					}

				}
			}
		});

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
