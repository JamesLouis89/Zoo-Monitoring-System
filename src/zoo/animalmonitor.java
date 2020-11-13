

//This class displays the animal monitoring menu. The user can click and animal, a new screen opens and displays the info for that animal//

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

public class animalmonitor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					animalmonitor frame = new animalmonitor();
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
	public animalmonitor() {
		
		//Creates window for animal monitoring//
		setTitle("Animal Monitoring");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an animal for details");
		lblPleaseSelectAn.setBounds(104, 11, 236, 34);
		contentPane.add(lblPleaseSelectAn);
		
		//Opens Lion information//
		JButton btnDetailsForLion = new JButton("Details for Lion");
		btnDetailsForLion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//** Calling a dialog class**//
				lionTwo dialog = new lionTwo();
                dialog.setVisible(true);
				
			}
		});
		btnDetailsForLion.setBounds(114, 51, 160, 25);
		contentPane.add(btnDetailsForLion);
		
		//Opens Tiger info//
		JButton btnDetailsForTiger = new JButton("Details for Tiger");
		btnDetailsForTiger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tigerTwo dialog = new tigerTwo();
				dialog.setVisible(true);
			}
		});
		btnDetailsForTiger.setBounds(114, 108, 160, 25);
		contentPane.add(btnDetailsForTiger);
		
		
		//Opens Bears info//
		JButton btnDetailsForBears = new JButton("Details for Bears");
		btnDetailsForBears.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bearTwo dialog = new bearTwo();
				dialog.setVisible(true);
			}
		});
		btnDetailsForBears.setBounds(114, 158, 160, 25);
		contentPane.add(btnDetailsForBears);
		
		JButton btnAnimalNotes = new JButton("Add Notes");
		btnAnimalNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNote dialog = new addNote();
				dialog.setVisible(true);
				
			}
		});
		btnAnimalNotes.setBounds(114, 205, 160, 23);
		contentPane.add(btnAnimalNotes);
	}
}
