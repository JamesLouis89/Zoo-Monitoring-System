
//***The penguin menu class allows a user to record the time the habitat was checked at and the temperature of the habitat***///

package zoo;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class penguinMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					penguinMenu frame = new penguinMenu();
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
	public penguinMenu() {
		setTitle("Penguin Habitat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("<html>The habitat needs to be checked 3x daily<br/>Check times are: 8AM 12PM 6PM please check time below<br/>The temperature needs to be between 40 and 50 degrees. Record temperature reading below<html>");
		label.setBounds(12, 13, 390, 109);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 111, 147, 129);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTimeCheck = new JLabel("Time Check");
		lblTimeCheck.setBounds(33, 13, 80, 16);
		panel.add(lblTimeCheck);
		
		JCheckBox chckbxAm = new JCheckBox("8 Am");
		chckbxAm.setBounds(0, 38, 64, 25);
		panel.add(chckbxAm);
		
		JCheckBox chckbxPm = new JCheckBox("12 Pm");
		chckbxPm.setBounds(0, 68, 64, 25);
		panel.add(chckbxPm);
		
		JCheckBox chckbxPm_1 = new JCheckBox("6 Pm");
		chckbxPm_1.setBounds(0, 98, 57, 25);
		panel.add(chckbxPm_1);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Please Enter Time and initials");
			}
		});
		btnOK.setBounds(71, 58, 64, 33);
		panel.add(btnOK);
		
		//***The code block below allows the user to enter a temperature and record that temperature. It then enters an if else statement to make sure the entered temperature
		//** is within normal range. If it isn't a warning is displayed. If the temperature is within in the limits a message is displayed stating so***///
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(206, 111, 196, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPleaseEnterTemperature = new JLabel("Please enter temperature below");
		lblPleaseEnterTemperature.setBounds(0, 13, 184, 16);
		panel_1.add(lblPleaseEnterTemperature);
		
		JFormattedTextField tempInput = new JFormattedTextField();
		tempInput.setBounds(34, 43, 102, 22);
		panel_1.add(tempInput);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp;
				temp = Integer.parseInt(tempInput.getText());
				if(temp < 40) {
					JOptionPane.showMessageDialog(null,
		                    "WARNING!! TEMPERATURE TOO COLD!");
					}
				else if (temp > 50) {
					JOptionPane.showMessageDialog(null,
		                    "Warning!! TEMPERATURE TOO HOT!");

				}
				else {
					JOptionPane.showMessageDialog(null,
		                    "Temperature within normal limits!");

				}
				};
			
		});
		btnCheck.setBounds(39, 78, 97, 25);
		panel_1.add(btnCheck);
		
		
	}
}
