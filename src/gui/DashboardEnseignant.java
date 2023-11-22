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

public class DashboardEnseignant {

	public static JFrame frame;
	private final JPanel panel = new JPanel();
	private EnseignantHomePanel enseignantHomePanel;
	private EnseignantRemplirAbsence enseignantRemplirAbsence;
	private EnseignantConsultAbsence enseignantConsultAbsence;
	public  JLabel ensId = new JLabel();
	JPanel MainPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardEnseignant window = new DashboardEnseignant();
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
	public DashboardEnseignant() {
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
				menuClicked(enseignantHomePanel);
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

		JPanel rempAbsence = new JPanel();
		rempAbsence.addMouseListener(new panelButtonMouseAdapter(rempAbsence) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(enseignantRemplirAbsence);
			}
		});
		rempAbsence.setBackground(new Color(47,79,79));
		rempAbsence.setBounds(0, 237, 193, 38);
		panel.add(rempAbsence);
		rempAbsence.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Remplir Absence");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(29, 11, 142, 14);
		rempAbsence.add(lblNewLabel_1_1);

		JPanel consultAbsence = new JPanel();
		consultAbsence.addMouseListener(new panelButtonMouseAdapter(consultAbsence) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(enseignantConsultAbsence);
			}
		});
		consultAbsence.setBackground(new Color(47,79,79));
		consultAbsence.setBounds(0, 276, 193, 38);
		panel.add(consultAbsence);
		consultAbsence.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Consulter Absence");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(27, 11, 142, 14);
		consultAbsence.add(lblNewLabel_1_1_1);
		
		MainPanel = new JPanel();
		MainPanel.setBounds(192, 0, 645, 499);
		frame.getContentPane().add(MainPanel);
		frame.setBounds(100, 100, 853, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		enseignantHomePanel = new EnseignantHomePanel();
		enseignantHomePanel.setBounds(10, 0, 627, 491);
		enseignantRemplirAbsence = new EnseignantRemplirAbsence();
		enseignantRemplirAbsence.setBounds(10, 0, 627, 491);
		enseignantConsultAbsence = new EnseignantConsultAbsence();
		enseignantConsultAbsence.setBounds(10, 0, 627, 491);

		 MainPanel.setLayout(null);
		 MainPanel.add(enseignantHomePanel);
		 MainPanel.add(enseignantRemplirAbsence);
		 MainPanel.add(enseignantConsultAbsence);
		 
		 menuClicked(enseignantHomePanel);
		
	}
	
	public void menuClicked(JPanel panel) {
		
		enseignantHomePanel.setVisible(false);
		enseignantRemplirAbsence.setVisible(false);
		enseignantConsultAbsence.setVisible(false);
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
