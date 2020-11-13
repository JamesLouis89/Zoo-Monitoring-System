package zoo;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldusername;
	private JTextField textFieldpassword;
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
	
	Connection connection = null;
	public CreateAccount() {
		connection = sqLiteConnection.dbConnector();
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblinfoLabel = new JLabel("<html>Enter a username and password.<BR><BRUsername Must Contain:<BR>-1 Uppercase<BR>-A Number<BR>-A Special Character ex !, @<BR><BR>Password Must Be:<BR>-Minimum of 8 characters<BR>-Contain an uppercase<BR>-Contain numbers<BR>-Contain special characters ex: !,@");
		lblinfoLabel.setBounds(10, 0, 200, 199);
		contentPane.add(lblinfoLabel);
		
		textFieldusername = new JTextField();
		textFieldusername.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldusername.setText("Username");
		textFieldusername.setBounds(231, 50, 175, 20);
		contentPane.add(textFieldusername);
		textFieldusername.setColumns(10);
		
		textFieldpassword = new JTextField();
		textFieldpassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldpassword.setText("Password");
		textFieldpassword.setBounds(231, 111, 175, 20);
		contentPane.add(textFieldpassword);
		textFieldpassword.setColumns(10);
		
		////*****Below statements takes user's input and stores it in the database to create account*****////
		
		
		JButton btnCreatePassword = new JButton("Create Account");
		btnCreatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into users (username, password) values(?, ?)";

					PreparedStatement preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, textFieldusername.getText());
					preparedstatement.setString(2, textFieldpassword.getText());
					
					preparedstatement.execute();

					preparedstatement.close();
					
					
					
				}catch(Exception ev) {
					ev.printStackTrace();
			}
			}
		});
		btnCreatePassword.setBounds(231, 176, 175, 23);
		contentPane.add(btnCreatePassword);
		
		
		
		
		
		
	}
}
