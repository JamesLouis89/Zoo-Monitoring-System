package zoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.sqlite.SQLiteConnection;

public class addNote extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterAnimalName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addNote frame = new addNote();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	Connection connection = null;

	public addNote() {
		setTitle("Add Animal Note");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterAnimalName = new JTextField();
		txtEnterAnimalName.setText("Enter Animal Name");
		txtEnterAnimalName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterAnimalName.setBounds(112, 37, 194, 20);
		contentPane.add(txtEnterAnimalName);
		txtEnterAnimalName.setColumns(10);
		
		JTextArea txtrEnterAnimalNotes = new JTextArea();
		txtrEnterAnimalNotes.setText("Enter Animal Notes Here. Please Include Date");
		txtrEnterAnimalNotes.setBounds(32, 68, 367, 150);
		contentPane.add(txtrEnterAnimalNotes);
		
		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				try {
					
					String query = "insert into animal (animal, notes) values (?,?)";
					Connection connection = sqLiteConnection.dbConnector();
					PreparedStatement preparedstatement = connection.prepareStatement(query);
					preparedstatement.setString(1, txtEnterAnimalName.getText());
					preparedstatement.setString(2, txtrEnterAnimalNotes.getText());
					JOptionPane.showMessageDialog(null, "Your Entry has been recorded.");
					preparedstatement.execute();
					preparedstatement.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnRecord.setBounds(163, 229, 89, 23);
		contentPane.add(btnRecord);
	}
}
