package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnect {
	
	private Connection conn;
	
	public DataBaseConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
	    System.out.println("Driver O.K.");
		String url = "jdbc:postgresql://localhost:5432/ChatRoom";
	    String user = "postgres";
	    String passwd = "2Gh3tt097218*";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		
	}
	  
	public ResultSet query (String requete) throws SQLException{
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(requete);
	}

	public int modification(String requete) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(requete);
	}
}