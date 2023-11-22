package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.EnseignantDao;
import dao.EtudiantDao;
import dao.ResponsableDao;
import model.Enseignant;
import model.Etudiant;
import model.Responsable;

import java.awt.event.ActionEvent;

public class Login {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel erreurMsg;
	private ButtonGroup G;
	public static Enseignant ens = new Enseignant();
	public static Etudiant etd = new Etudiant();
	public static Responsable resp = new Responsable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 543, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		textField = new JTextField();
		textField.setBounds(49, 74, 291, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Enseignant");
		rdbtnNewRadioButton.setBounds(49, 177, 105, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Etudiant");
		rdbtnNewRadioButton_1.setBounds(158, 177, 85, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnResponsable = new JRadioButton("Responsable");
		rdbtnResponsable.setBounds(247, 177, 124, 23);
		frame.getContentPane().add(rdbtnResponsable);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected() == false && rdbtnNewRadioButton_1.isSelected() == false
						&& rdbtnResponsable.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Sélectionner un utilisateur");
				} else {
					String login = textField.getText();
					String pass = passwordField.getText();
					login(login, pass);
				}

			}
		});
		btnNewButton.setBounds(187, 244, 117, 25);
		frame.getContentPane().add(btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(49, 142, 291, 19);
		frame.getContentPane().add(passwordField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 115, 70, 15);
		frame.getContentPane().add(lblPassword);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(49, 47, 70, 15);
		frame.getContentPane().add(lblLogin);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Users.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(385, 26, 117, 203);
		frame.getContentPane().add(lblNewLabel);

		G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setActionCommand("1");
		G.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setActionCommand("2");
		G.add(rdbtnResponsable);
		rdbtnResponsable.setActionCommand("3");

		erreurMsg = new JLabel("");
		erreurMsg.setBounds(59, 208, 265, 15);
		frame.getContentPane().add(erreurMsg);
		erreurMsg.setVisible(false);
	}

	private void login(String login, String pass) {
		switch (G.getSelection().getActionCommand()) {
		case "1":
			Enseignant e = enseignantAuthentification(login, pass);
			if (e != null) {
				ens = e;
				DashboardEnseignant dashboardEns = new DashboardEnseignant();
				dashboardEns.frame.setVisible(true);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "vérifier vos données");
			}
			break;
		case "2":
			Etudiant et = etudiantAuthentification(login, pass);
			if (et != null) {
				etd = et;
				DashboardEtudiant dashboardEtud = new DashboardEtudiant();
				dashboardEtud.frame.setVisible(true);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "vérifier vos données");
			}
			break;
		case "3":
				Responsable res = responsableAuthentification(login, pass);
			if (res!=null) {
				resp = res;	
				DashboardResponsable dashboardResp = new DashboardResponsable();
				dashboardResp.frame.setVisible(true);
				frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "vérifier vos données");
			}
			break;
		}
	}

	private Enseignant enseignantAuthentification(String login, String pass) {
		Enseignant enseignant = EnseignantDao.chercherEnseignant(login, pass);
		return enseignant;
	}

	private Responsable responsableAuthentification(String login, String pass) {
		Responsable responsable = ResponsableDao.chercherResponsable(login, pass);
		return responsable;
	}

	private Etudiant etudiantAuthentification(String login, String pass) {
		Etudiant etudiant = EtudiantDao.chercherEtudiant(login, pass);
		return etudiant;
	}
}
