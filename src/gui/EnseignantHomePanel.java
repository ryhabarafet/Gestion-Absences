package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnseignantHomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EnseignantHomePanel() {
		setBounds(0, 0, 627, 491);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Accueil Enseignant");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(189, 0, 247, 101);
		add(lblNewLabel);
		
		JLabel bnv = new JLabel("New label");
		bnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		bnv.setBounds(36, 116, 531, 34);
		add(bnv);
		bnv.setText("Bienvenue "+Login.ens.getNomEnseignant()+" "+Login.ens.getPrenomEnseignant());
		
		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				DashboardEnseignant.frame.dispose();
			}
		});
		btnNewButton.setBounds(503, 11, 114, 23);
		add(btnNewButton);
	}

}
