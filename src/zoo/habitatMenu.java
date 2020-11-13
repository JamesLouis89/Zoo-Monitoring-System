
///*** habitat menu is a menu the employee opens, it allows the employee to click any listed habitat which calls that class***///

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

public class habitatMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					habitatMenu frame = new habitatMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public habitatMenu() {
		setTitle("Habitat Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an option below to monitor a habitat");
		lblPleaseSelectAn.setBounds(73, 41, 310, 16);
		contentPane.add(lblPleaseSelectAn);
		
		JButton btnPeguinHabitat = new JButton("Peguin Habitat");
		btnPeguinHabitat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				penguinMenu nw = new penguinMenu();
				nw.newScreen();
			}
		});
		btnPeguinHabitat.setBounds(158, 89, 115, 25);
		contentPane.add(btnPeguinHabitat);
		
		JButton btnBirdHouse = new JButton("Bird House");
		btnBirdHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				birdHouseMenu dialog = new birdHouseMenu();
				dialog.setVisible(true);
			}
		});
		btnBirdHouse.setBounds(158, 137, 115, 25);
		contentPane.add(btnBirdHouse);
		
		JButton btnAqurium = new JButton("Aqurium");
		btnAqurium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aqaurium dialog = new aqaurium();
				dialog.setVisible(true);
				
			}
		});
		btnAqurium.setBounds(158, 190, 115, 25);
		contentPane.add(btnAqurium);
	}
}
