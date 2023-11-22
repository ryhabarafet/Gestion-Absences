package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResponsableHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResponsableHome() {
		setBounds(0, 0, 627, 491);
		setLayout(null);
		setVisible(true);
		JLabel lblNewLabel = new JLabel("Accueil Responsable");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(196, 0, 284, 114);
		add(lblNewLabel);
		
		JLabel bnv = new JLabel("New label");
		bnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		bnv.setBounds(36, 127, 536, 30);
		add(bnv);
		bnv.setText("Bienvenue "+Login.resp.getNomResponsable()+" "+Login.resp.getPrenomResponsable());
		
		JButton btnNewButton = new JButton("Déconnexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.frame.setVisible(true);
				DashboardResponsable.frame.dispose();
			}
		});
		btnNewButton.setBounds(503, 11, 114, 23);
		add(btnNewButton);
	}

}
