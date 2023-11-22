package gui;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dao.EtudiantDao;
import model.Mails;
import javax.swing.JLabel;
import java.awt.Font;

public class EtudiantMails extends JPanel {

	/**
	 * Create the panel.
	 */
	public EtudiantMails() {
		setBounds(0, 0, 627, 491);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 103, 596, 354);
		add(scrollPane);
		
		
		
		JLabel lblNewLabel = new JLabel("Etudiant Emails");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 36, 162, 37);
		add(lblNewLabel);
		
		ArrayList<Mails> arr = EtudiantDao.getMailsByEtudiant(Login.etd.getIdEtudiant());
		DefaultListModel demoList = new DefaultListModel();
		for(int i=0;i<arr.size();i++) {
			demoList.add(0,"Email "+(i+1)+"  "+arr.get(i).getContenu());
		}
		JList list = new JList(demoList);
		scrollPane.setViewportView(list);
	}
}
