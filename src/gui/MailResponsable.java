package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.EtudiantDao;
import dao.MailDao;
import model.Etudiant;
import model.Mails;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MailResponsable extends JPanel {
	private JTextField receiver;

	/**
	 * Create the panel.
	 */
	public MailResponsable() {
		setBounds(0, 0, 627, 491);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Envoyer Mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(224, 25, 197, 33);
		add(lblNewLabel);
		
		receiver = new JTextField();
		receiver.setBounds(127, 80, 440, 20);
		add(receiver);
		receiver.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 83, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contenu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(31, 140, 63, 14);
		add(lblNewLabel_2);
		
		final JTextArea contenu = new JTextArea();
		contenu.setBounds(127, 135, 440, 272);
		add(contenu);
		
		JButton sendBtn = new JButton("Envoyer");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rec = receiver.getText();
				String cont = contenu.getText();
				if(!rec.equals("") && !cont.equals("")) {
					Etudiant et = EtudiantDao.getEtudiantByEmail(rec);
					Mails m = new Mails(Login.resp.getIdResponsable(),et.getIdEtudiant(),cont);
					int res = MailDao.envoyerMail(m);
					if(res!=0) {
						JOptionPane.showMessageDialog(null, "mail envoyé");
						receiver.setText("");
						contenu.setText("");
					}
					
				}
			}
		});
		sendBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		sendBtn.setBounds(442, 429, 125, 38);
		add(sendBtn);
	}
}
