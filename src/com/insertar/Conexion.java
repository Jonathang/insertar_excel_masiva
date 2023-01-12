package com.insertar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	String driver 	= "oracle.jdbc.OracleDriver";
	String url 		= "jdbc:oracle:thin:@10.82.57.36:4410:SCBDDES";
	String user		= "SCORECREDITO";
	String pass		= "Sc0r3cr3d1t0DEV";
	
	
	public Connection conectarOracle()
	{
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
			e.getMessage();
		}
		return con;
	}
}
