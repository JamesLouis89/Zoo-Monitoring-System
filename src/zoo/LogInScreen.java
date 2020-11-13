package zoo;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LogInScreen extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldun;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnCreateAccount;
	
	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInScreen frame = new LogInScreen();
					frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		}
	
	Connection conn = null; //**connection db calling class**//
	
	public LogInScreen() {
		setFont(new Font("Algerian", Font.PLAIN, 12));
		setForeground(Color.BLACK);
		setBackground(new Color(0, 0, 205));
		conn = sqLiteConnection.dbConnector(); //**method to connect**//
		setTitle("Glendale Zoo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.BLUE, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbluserName = new JLabel("Enter Username");
		lbluserName.setBounds(39, 56, 102, 34);
		contentPane.add(lbluserName);
		
		textFieldun = new JTextField();
		textFieldun.setBounds(151, 63, 183, 20);
		contentPane.add(textFieldun);
		textFieldun.setColumns(10);
		
		JLabel lblPassword = new JLabel("Enter Password");
		lblPassword.setBounds(39, 115, 102, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(151, 112, 183, 20);
		contentPane.add(passwordField);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from users where username=? and password=? ";  //****Setting up query**//
					PreparedStatement preparedstatement = conn.prepareStatement(query);  //**creating a prepared statement on query object**//
					preparedstatement.setString(1, textFieldun.getText()); //**getting the user text that they entered**///
					preparedstatement.setString(2, passwordField.getText());
					
					ResultSet resultset = preparedstatement.executeQuery(); //***Executes query from above stores in resultset variable**//
					
					//***creating a loop to check how many times user enters credentials
					int loginAttempt = 0;
					while(resultset.next()) {
						loginAttempt++;
						
					}
					//***if credentials are correct open mainmenu***///
					if(loginAttempt == 1) {
						JOptionPane.showMessageDialog(null, "Crendentials Accepted!");
						mainmenu dialog = new mainmenu();
						dialog.setVisible(true);
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Wrong Username and/or password!");
						

					}
				
					///****Closes the database***///
					resultset.close();
					preparedstatement.close();
			}catch(Exception ev) {
				JOptionPane.showMessageDialog(null, ev);
				
			}
			
			}
			
		});
		
		btnLogIn.setBounds(151, 159, 89, 23);
		contentPane.add(btnLogIn);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccount dialog = new CreateAccount();
				dialog.setVisible(true);
				
			}
		});
		btnCreateAccount.setBounds(151, 204, 122, 23);
		contentPane.add(btnCreateAccount);
	}
	}


