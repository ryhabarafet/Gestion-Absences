package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtudiantHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public EtudiantHome() {
		setBounds(0, 0, 627, 491);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Accueil Etudiant");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(218, 0, 284, 88);
		add(lblNewLabel);
		
		JLabel bnv = new JLabel("New label");
		bnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		bnv.setBounds(34, 117, 552, 31);
		add(bnv);
		bnv.setText("Bienvenue "+Login.etd.getNomEtudiant()+" "+Login.etd.getPrenomEtudiant());
		
		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				DashboardEtudiant.frame.dispose();
			}
		});
		btnNewButton.setBounds(480, 11, 137, 23);
		add(btnNewButton);
	}

}
