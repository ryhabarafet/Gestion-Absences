package gui;

import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistique extends JPanel {

	/**
	 * Create the panel.
	 */
	public Statistique() {
			setBounds(0, 0, 627, 491);
			setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Statistiques");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
			lblNewLabel.setBounds(239, 26, 181, 33);
			add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Statistique par classe");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 BarChartExample example=new BarChartExample("Par Classe");  
				      example.setSize(800, 400);  
				      example.setLocationRelativeTo(null);  
				      example.setVisible(true);   
				}
			});
			btnNewButton.setBounds(185, 95, 282, 42);
			add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Statistique par Niveau");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 BarChartNiveau example=new BarChartNiveau("Par Niveau");  
				      example.setSize(800, 400);  
				      example.setLocationRelativeTo(null);  
				      example.setVisible(true);   
				}
			});
			btnNewButton_1.setBounds(185, 170, 282, 42);
			add(btnNewButton_1);
			
			JButton btnNewButton_1_1 = new JButton("Statistique par Filiére");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BarChartFiliere example=new BarChartFiliere("Par Filiére");  
				      example.setSize(800, 400);  
				      example.setLocationRelativeTo(null);  
				      example.setVisible(true);
				}
			});
			btnNewButton_1_1.setBounds(185, 241, 282, 42);
			add(btnNewButton_1_1);
			 
	    
	}
}
