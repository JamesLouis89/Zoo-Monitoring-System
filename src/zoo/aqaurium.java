//This class allows for interaction with the aquarium menu. User can enter time it was checked and water pH level//

package zoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.sqlite.SQLiteConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
public class aqaurium extends JFrame {
	

	private JPanel contentPane;
	private JTextField textFieldEnterTime;
	private JTextField textFieldEnterpH;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aqaurium frame = new aqaurium();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	

	Connection connection = null;

	public aqaurium() {
		//Creates windows for menu//
		setTitle("Aquarium Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 553, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html> Please check aquarium 4x a day <BR>Please record water ph and click check pH level</html>");   //Displays information for employee to know about habitat//
		lblNewLabel.setBounds(33, 22, 288, 51);
		contentPane.add(lblNewLabel);
		
		textFieldEnterTime = new JTextField("Enter Time and Date Here"); // A text field that allows user to enter the time the habitat was checked//
		textFieldEnterTime.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEnterTime.setBounds(30, 119, 159, 20);
		contentPane.add(textFieldEnterTime);
		textFieldEnterTime.setColumns(10);
		
		JButton btnRecordTime = new JButton("Record "); //Button to record time the habitat was checked.
		btnRecordTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//*** this block inserts the date and ph into the databse***///
				try {
					
					String query = "insert into waterph (date, ph) values (?,?)";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, textFieldEnterpH.getText());
					preparedstatement.setString(2, textFieldEnterTime.getText());
					JOptionPane.showMessageDialog(null, "Your Entry has been recorded.");
					preparedstatement.execute();
					preparedstatement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRecordTime.setBounds(33, 195, 110, 23);
		contentPane.add(btnRecordTime);
		
		JLabel lblWaterpH = new JLabel("The water needs a pH between 6.8 and 7.6"); // Information for ph//
		lblWaterpH.setBounds(33, 72, 213, 36);
		contentPane.add(lblWaterpH);
		
		textFieldEnterpH = new JTextField();  // Area for user to enter the pH//
		textFieldEnterpH.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEnterpH.setText("Enter pH Here");
		textFieldEnterpH.setBounds(33, 164, 96, 20);
		contentPane.add(textFieldEnterpH);
		textFieldEnterpH.setColumns(10);
		
		JButton btnRecordpH = new JButton("Check pH"); // Button to record pH// 
		btnRecordpH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//*** checks to see if ph is within range, displays warning message if too high or low****//
				double waterPh;
				waterPh = Double.parseDouble(textFieldEnterpH.getText());
				if (waterPh > 7.6) {
					JOptionPane.showMessageDialog(null, "WARNING! The pH is too high!");

				}
				else if(waterPh < 6.8) {
					JOptionPane.showMessageDialog(null, "WARNING! The ph is too low!");

				}
				else {
					JOptionPane.showMessageDialog(null, "The pH is within normal limits.");

				}
			}
		});
		btnRecordpH.setBounds(150, 195, 96, 23);
		contentPane.add(btnRecordpH);
		
		JTextArea textAreaDisplayPh = new JTextArea();
		textAreaDisplayPh.setBounds(314, 11, 213, 176);
		contentPane.add(textAreaDisplayPh);
		
		JButton btnLoadRecord = new JButton("Load Records");
		btnLoadRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//*** loads ph and date entries from database to text area***///
				try {
					String query = "SELECT * FROM waterph";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					ResultSet resultset = preparedstatement.executeQuery();
					List<String> phdate = new ArrayList<String>();
					while(resultset.next()) {
						String ph = resultset.getString(1);
						String date = resultset.getString(2);
						
						textAreaDisplayPh.append(ph + " " + date + "\n");
					}
					
				}catch(Exception ev) {
					JOptionPane.showMessageDialog(null, ev.getMessage(),"Error",
							JOptionPane.ERROR_MESSAGE);
			}
			}
				
		});
		btnLoadRecord.setBounds(345, 198, 144, 20);
		contentPane.add(btnLoadRecord);
}
}
