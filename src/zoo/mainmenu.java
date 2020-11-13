///**** The following program is a zoo monitoring system. 
//**	It allows employees to monitor both animals and habitats within the zoo. 
//***	The program supports object oriented programming by calling classes when a button is pressed, once pressed the class is called and the user can interact with the GUI******//////////





package zoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public mainmenu() {
		setTitle("Glendale Zoo Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToGlendale = new JLabel("Welcome to Glendale Zoo Monitoring System");
		lblWelcomeToGlendale.setBounds(66, 32, 312, 16);
		contentPane.add(lblWelcomeToGlendale);
		
		JLabel lblMainMenu = new JLabel("Main Menu");
		lblMainMenu.setBounds(24, 67, 98, 16);
		contentPane.add(lblMainMenu);
		
		JButton btnMonitorAnimals = new JButton("Monitor Animals");
		btnMonitorAnimals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//**Creating a class for a new window then calling it so it opens a window**//
				animalmonitor nw = new animalmonitor();
				nw.NewScreen();

			}
		});
		btnMonitorAnimals.setBounds(24, 96, 182, 25);
		contentPane.add(btnMonitorAnimals);
		
		JButton btnMonitorHabitats = new JButton("Monitor Habitats");
		btnMonitorHabitats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habitatMenu nw = new habitatMenu();
				nw.newScreen();
			}
		});
		btnMonitorHabitats.setBounds(24, 139, 182, 25);
		contentPane.add(btnMonitorHabitats);
	}
}
