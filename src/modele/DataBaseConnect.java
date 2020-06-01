package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * <b> Classe qui permet la connexion à la base de données Postgres </b>
 * 
 *<p>
 *Les méthodes utilisées servent à manipuler la base de données
 *</p>
 * @author adilbahou
 *
 */
public class DataBaseConnect {
	
	private Connection conn;
	
	public DataBaseConnect() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
	    System.out.println("Driver O.K.");
		String url = "jdbc:postgresql://localhost:5432/ChatRoom";
	    String user = "postgres";
	    String passwd = "2Gh3tt097218*";
		conn = DriverManager.getConnection(url, user, passwd);
		System.out.println("Connexion effective !");
		
	}
	  /**
	   * Méthode permettant de faire une requete SELECT avec un retour
	   * 
	   * @param requete
	   */
	public ResultSet query (String requete) throws SQLException{
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(requete);
	}
	/**
	 * Méthode permettant de faire une modification sans attendre un retour
	 * @param requete
	 */
	public int modification(String requete) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(requete);
	}
	
}