//****This is the bird house habitat menu. The user can select the time, am or pm and select when the power washing of the habitat was done.***///
//*** The design utilizes panels to group content on the screen**//

package zoo;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class birdHouseMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					birdHouseMenu frame = new birdHouseMenu();
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
	public birdHouseMenu() {
		setTitle("Bird House Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 13, 432, 51);
		contentPane.add(panel);
		
		JLabel lblCheckTheBird = new JLabel("<html> Check the bird house 2x a day <br/> Power wash the floor once in the morning and at night");
		panel.add(lblCheckTheBird);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 96, 169, 144);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		//****The following section sets up the label to enter time, radio buttons used to select am or pm. the user utilizes a spinner to select the time they checked at and a button to record time check****////
		JLabel lblEnterTimeCheck = new JLabel("Enter Time Check");
		lblEnterTimeCheck.setBounds(32, 13, 106, 16);
		panel_1.add(lblEnterTimeCheck);
		
		JRadioButton Am = new JRadioButton("AM");
		Am.setBounds(94, 38, 53, 31);
		panel_1.add(Am);
		
		JRadioButton Pm = new JRadioButton("PM");
		Pm.setBounds(94, 74, 57, 25);
		panel_1.add(Pm);
		
		JButton btnRecordTime = new JButton("New Record Time");
		btnRecordTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					
		            
			}
		});
		btnRecordTime.setBounds(32, 106, 97, 25);
		panel_1.add(btnRecordTime);
		
		JSpinner spinner = new JSpinner(); //***time selection spinner//
		spinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner.setBounds(32, 56, 44, 37);
		panel_1.add(spinner);
		
		
		
		
		//****The design is grouped together by panels. Below is panel 2, above is panel 1***//
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(181, 96, 251, 144);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnMorningPowerWash = new JRadioButton("Morning Power Wash");
		rdbtnMorningPowerWash.setBounds(0, 29, 157, 25);
		panel_2.add(rdbtnMorningPowerWash);
		
		JButton btnDoneAM = new JButton("Done");
		btnDoneAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,   ///***After the user clicks the done button it display a message dialog****//
	                    "Your response has been recorded");

			}
		});
		btnDoneAM.setBounds(164, 29, 75, 25);
		panel_2.add(btnDoneAM);
		
		JRadioButton rdbtnNightPowerWash = new JRadioButton("Night Power Wash");
		rdbtnNightPowerWash.setBounds(0, 79, 138, 25);
		panel_2.add(rdbtnNightPowerWash);
		
		JButton btnDonePM = new JButton("Done");
		btnDonePM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
	                    "Your response has been recorded");  //***Shows the response has been recorded//
			}
		});
		btnDonePM.setBounds(164, 79, 78, 25);
		panel_2.add(btnDonePM);
	}
}
