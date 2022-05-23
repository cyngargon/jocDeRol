package jocderol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDades {
    private Connection conn;
    
    public BaseDades() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/jocrol";
        String usuari = "root";
        String contrasenya = "mysql";
        conn = DriverManager.getConnection(url, usuari, contrasenya);
    }
	
	public void insertarRegistre(String nom, int puntuacio, int tempsJugat) throws SQLException{
		String query = "INSERT INTO dades_partida (nom, puntuacio, tempsJugat, dataJoc) VALUES (?, ?, ?, sysdate());";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, nom);
		pst.setInt(2, puntuacio);
		pst.setInt(3, tempsJugat);
		int nRows = pst.executeUpdate();
		System.out.println("NUM LINIES MODIFICADES: " + nRows);
	}
	
	public void mostrarRegistresOrdenats() throws SQLException{
		String query = "SELECT * FROM dades_partida ORDER BY dataJoc;";
		PreparedStatement pst = conn.prepareStatement(query);
		ResultSet rs = pst.executeQuery(query);
		while (rs.next()) {
			System.out.println("--> NOM: " + rs.getString("nom") 
					+ "\tPUNTUACIO: " + rs.getInt("puntuacio") 
					+ "\tTEMPS: " + rs.getInt("tempsJugat") + "''" 
					+ "\tDATE: (" +rs.getString("dataJoc") + ")");
		}
	}
	
	
    
    public void close() throws SQLException{
        conn.close();
    }
    
    
}
