package zoo;

import java.sql.*;

import javax.swing.JOptionPane;

//***Make sure to at jar file to library****/////

//****Connection class and method to connect to useraccount database***//
public class sqLiteConnection {
	Connection conn = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jloui\\Desktop\\zoo\\users.sqlite"); //**Sets the path where db is located**//
			JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}