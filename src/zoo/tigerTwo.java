package zoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class tigerTwo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tigerTwo frame = new tigerTwo();
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
	public tigerTwo() {
		setTitle("Tiger Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 694, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTiger = new JLabel("<html>Tiger's Name: Mike the Tiger<br/>Age:6<br/>Feeding Schedule: 4x daily with snacks in morning and afternoon<html>");
		lblTiger.setBounds(10, 11, 190, 94);
		contentPane.add(lblTiger);
		
		JLabel labeltigerImage = new JLabel("");
		labeltigerImage.setBounds(0, 182, 190, 179);
		Image tiger = new ImageIcon(this.getClass().getResource("/tiger.png")).getImage();
		labeltigerImage.setIcon(new ImageIcon(tiger));
		contentPane.add(labeltigerImage);
		
		JTextArea textAreaDisplayRecord = new JTextArea();
		textAreaDisplayRecord.setBounds(210, 25, 458, 336);
		contentPane.add(textAreaDisplayRecord);
		
		JButton btnLoadRecords = new JButton("Load Records");
		btnLoadRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM animal Where animal like 'Mike the Tiger%'";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					ResultSet resultset = preparedstatement.executeQuery();
					List<String> phdate = new ArrayList<String>();
					while(resultset.next()) {
						String notes = resultset.getString(2);
						
						
						textAreaDisplayRecord.append(notes + "\n");
					}
					
				}catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnLoadRecords.setBounds(356, 405, 229, 23);
		contentPane.add(btnLoadRecords);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(56, 405, 173, 23);
		contentPane.add(btnClose);
		
		
	}

}
