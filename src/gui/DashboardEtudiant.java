package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Enseignant;

import java.awt.Font;

public class DashboardEtudiant {

	public static JFrame frame;
	private final JPanel panel = new JPanel();
	private EtudiantHome etudiantHome;
	private EtudiantConsulterAbsence etudiantConsulterAbsence;
	private EtudiantMails etudiantMails;
	public  JLabel ensId = new JLabel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardEtudiant window = new DashboardEtudiant();
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
	public DashboardEtudiant() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(47,79,79));
		panel.setBounds(0, 0, 193, 523);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(33, 12, 119, 164);
		Image img = new ImageIcon(this.getClass().getResource("/Users.png")).getImage();
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(img));

		JPanel home = new JPanel();
		home.addMouseListener(new panelButtonMouseAdapter(home) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(etudiantHome);
			}
		});
		home.setBackground(new Color(47,79,79));
		home.setBounds(0, 198, 193, 38);
		panel.add(home);
		home.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Acceuil");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(65, 11, 91, 14);
		home.add(lblNewLabel_1);

		JPanel ConsulterAbsence = new JPanel();
		ConsulterAbsence.addMouseListener(new panelButtonMouseAdapter(ConsulterAbsence) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(etudiantConsulterAbsence);
			}
		});
		ConsulterAbsence.setBackground(new Color(47,79,79));
		ConsulterAbsence.setBounds(0, 237, 193, 38);
		panel.add(ConsulterAbsence);
		ConsulterAbsence.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Consulter Absence");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(29, 11, 142, 14);
		ConsulterAbsence.add(lblNewLabel_1_1);
		
		JPanel Mails = new JPanel();
		Mails.addMouseListener(new panelButtonMouseAdapter(Mails) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(etudiantMails);
			}
		});
		Mails.setLayout(null);
		Mails.setBackground(new Color(47, 79, 79));
		Mails.setBounds(0, 275, 193, 38);
		panel.add(Mails);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mail");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(79, 11, 91, 14);
		Mails.add(lblNewLabel_1_2);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(192, 0, 645, 499);
		frame.getContentPane().add(MainPanel);
		frame.setBounds(100, 100, 853, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 etudiantHome = new EtudiantHome();
		 etudiantHome.setBounds(10, 0, 627, 491);
		 etudiantConsulterAbsence = new EtudiantConsulterAbsence();
		 etudiantConsulterAbsence.setBounds(10, 0, 627, 491);
		 etudiantMails = new EtudiantMails();
		 etudiantMails.setBounds(10, 0, 627, 491);
		 MainPanel.setLayout(null);
		
		 MainPanel.add(etudiantHome);
		 MainPanel.add(etudiantConsulterAbsence);
		 MainPanel.add(etudiantMails);
		 menuClicked(etudiantHome);
		
	}
	
	public void menuClicked(JPanel panel) {
		etudiantHome.setVisible(false);
		etudiantConsulterAbsence.setVisible(false);
		etudiantMails.setVisible(false);
		panel.setVisible(true);
	}

	private class panelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		
		public panelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(122,128,144));
		}

		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47,79,79));
		}

		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60,179,113));
		}

		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(122,128,144));
		}
	}
}
