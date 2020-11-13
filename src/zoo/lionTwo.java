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

public class lionTwo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lionTwo frame = new lionTwo();
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
	Connection connection = null;
	
	public lionTwo() {
		setTitle("Lion Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lionInfo = new JLabel("<html>Lion's Name: Lenord<br/>Age:3<br/>Feeding Schedule: 3x Daily <html>");
		lionInfo.setBounds(10, 20, 192, 77);
		contentPane.add(lionInfo);
		
		JLabel labelLionImage = new JLabel("");
		Image lion = new ImageIcon(this.getClass().getResource("/Lion.png")).getImage();
		labelLionImage.setIcon(new ImageIcon(lion));
		labelLionImage.setBounds(10, 99, 159, 161);
		contentPane.add(labelLionImage);
		
		JButton btnDispose = new JButton("Ok");
		btnDispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnDispose.setBounds(39, 277, 89, 23);
		contentPane.add(btnDispose);
		
		JTextArea textAreadisplaynotes = new JTextArea();
		textAreadisplaynotes.setBounds(196, 53, 310, 196);
		contentPane.add(textAreadisplaynotes);
		
		JButton btnloadRecord = new JButton("Load Record");
		btnloadRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM animal Where animal like 'Lenord%'";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					ResultSet resultset = preparedstatement.executeQuery();
					List<String> phdate = new ArrayList<String>();
					while(resultset.next()) {
						String notes = resultset.getString(2);
						
						
						textAreadisplaynotes.append(notes + "\n");
					}
					
				}catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnloadRecord.setBounds(307, 277, 115, 23);
		contentPane.add(btnloadRecord);
		
	}
}
