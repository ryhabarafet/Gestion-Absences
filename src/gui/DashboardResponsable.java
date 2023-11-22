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

public class DashboardResponsable {

	public static JFrame frame;
	private final JPanel panel = new JPanel();
	private ResponsableHome responsableHome;
	private ResponsableGestionAbsence responsableGestionAbsence;
	private MailResponsable mailResponsable;
	private Statistique statistique;
	public  JLabel ensId = new JLabel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardResponsable window = new DashboardResponsable();
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
	public DashboardResponsable() {
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
				menuClicked(responsableHome);
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

		JPanel gestAbsence = new JPanel();
		gestAbsence.addMouseListener(new panelButtonMouseAdapter(gestAbsence) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(responsableGestionAbsence);
			}
		});
		gestAbsence.setBackground(new Color(47,79,79));
		gestAbsence.setBounds(0, 237, 193, 38);
		panel.add(gestAbsence);
		gestAbsence.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Gestion Absence");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(29, 11, 142, 14);
		gestAbsence.add(lblNewLabel_1_1);

		JPanel stat = new JPanel();
		stat.addMouseListener(new panelButtonMouseAdapter(stat) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(statistique);
			}
		});
		stat.setBackground(new Color(47,79,79));
		stat.setBounds(0, 276, 193, 38);
		panel.add(stat);
		stat.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Statistique");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(50, 11, 96, 14);
		stat.add(lblNewLabel_1_1_1);
		
		JPanel mail = new JPanel();
		mail.addMouseListener(new panelButtonMouseAdapter(mail) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(mailResponsable);
			}
		});
		mail.setLayout(null);
		mail.setBackground(new Color(47, 79, 79));
		mail.setBounds(0, 316, 193, 38);
		panel.add(mail);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mail");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(73, 11, 42, 14);
		mail.add(lblNewLabel_1_1_1_1);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(192, 0, 645, 499);
		frame.getContentPane().add(MainPanel);
		frame.setBounds(100, 100, 853, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		responsableHome = new ResponsableHome();
		responsableHome.setBounds(10, 0, 627, 491);
		 responsableGestionAbsence = new ResponsableGestionAbsence();
		 responsableGestionAbsence.setBounds(10, 0, 627, 491);
		 mailResponsable = new MailResponsable();
		 mailResponsable.setBounds(10, 0, 627, 491);
		 statistique = new Statistique();
		 statistique.setBounds(10, 0, 627, 491);
		 MainPanel.setLayout(null);
		
		 MainPanel.add(responsableHome);
		 MainPanel.add(responsableGestionAbsence);
		 MainPanel.add(mailResponsable);
		 MainPanel.add(statistique);
		 menuClicked(responsableHome);
		
	}
	
	public void menuClicked(JPanel panel) {
		responsableHome.setVisible(false);
		responsableGestionAbsence.setVisible(false);
		mailResponsable.setVisible(false);
		statistique.setVisible(false);
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
