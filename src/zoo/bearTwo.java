package zoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class bearTwo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bearTwo frame = new bearTwo();
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
	public bearTwo() {
		setTitle("Bear Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel labelBearImage = new JLabel("");
		Image bear = new ImageIcon(this.getClass().getResource("/bear.png")).getImage();
		contentPane.setLayout(null);
		labelBearImage.setIcon(new ImageIcon(bear));
		labelBearImage.setBounds(27, 115, 191, 185);
		contentPane.add(labelBearImage);
		
		JLabel label_1 = new JLabel("<html>Bear's Name: Smokey the Bear <br/>Age:7<br/>Feeding Schedule: 4x Daily with AM and PM snacks. <html>");
		label_1.setBounds(46, 0, 179, 85);
		contentPane.add(label_1);
		
		JTextArea textArealoadrecords = new JTextArea();
		textArealoadrecords.setBounds(228, 9, 431, 334);
		contentPane.add(textArealoadrecords);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(56, 369, 126, 23);
		contentPane.add(btnClose);
		
		JButton btnLoadRecord = new JButton("Load Records");
		btnLoadRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM animal Where animal like 'Smokey the Bear%'";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					ResultSet resultset = preparedstatement.executeQuery();
					List<String> phdate = new ArrayList<String>();
					while(resultset.next()) {
						String notes = resultset.getString(2);
						
						
						textArealoadrecords.append(notes + "\n");
					}
					
				}catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnLoadRecord.setBounds(391, 369, 179, 23);
		contentPane.add(btnLoadRecord);
	}

}
