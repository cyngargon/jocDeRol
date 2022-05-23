package jocderol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BaseDades {
    private Connection conn;
    
    public BaseDades() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/jocrol";
        String usuari = "root";
        String contrasenya = "mysql";
        conn = DriverManager.getConnection(url, usuari, contrasenya);
    }
	
	public void insertarRegistre(String nom, int puntuacio, int tempsJugat) throws SQLException{
		String query = "INSERT INTO jocrol VALUES (?, ?, ?);";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, nom);
		pst.setInt(2, puntuacio);
		pst.setInt(3, tempsJugat);
	}
	
	
    
    public void close() throws SQLException{
        conn.close();
    }
    
    
}
