package com.insertar;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Extraer> dato = new ArrayList<Extraer>();
		dato = importarCSV();
		insertarOracle(dato);
	}

	public static List<Extraer> importarCSV() {
		List<Extraer> dato = new ArrayList<>();
	
		
		try {
			CsvReader leerdatos = new CsvReader("E:\\Users\\jggarcial\\Desktop\\dc.csv");
			leerdatos.readHeaders();
			
			while(leerdatos.readRecord()) {
				int pais 		= Integer.parseInt(leerdatos.get(0));
				int canal 		= Integer.parseInt(leerdatos.get(1));
				int sucursal 	= Integer.parseInt(leerdatos.get(2));
				int folio 		= Integer.parseInt(leerdatos.get(3));
				String clob 	= leerdatos.get(4);
				int estatus 	= Integer.parseInt(leerdatos.get(5));
				String registro = leerdatos.get(6);
				String ultima 	= leerdatos.get(7);
				String user 	= leerdatos.get(8);
				
				dato.add(new Extraer(pais, canal, sucursal, folio, clob, estatus, registro, ultima, user));
				
			//	System.out.println("Lista de usuarios del CSV\n");
				for(Extraer d : dato) {
					System.out.println(d.getPais()+", "+
										d.getCanal()+", "+
										d.getSucursal()+", "+
										d.getFolio()+", "+
										d.getClob()+", "+
										d.getEstatus()+", "+
										d.getRegistro()+", "+
										d.getUltima()+", "+
										d.getUser()
							);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return dato;
	}
	
	public static void insertarOracle(List<Extraer> datos) {
		System.out.println("\nSe va a insertar: "+datos.size()+ " REGISTROS\n");
		
		Conexion sql = new Conexion();
		Connection con = sql.conectarOracle();
		
		String query = "INSERT INTO TA_SCRBHVR_DS(FIIDPAIS, FIIDCANAL, FIIDSUCURSAL, FCFOLIO, FCDATOS, FIESTATUS, FDREGISTRO, ULTIMA_MODIFICACION, USUARIO_MODIFICO) "
						+ "VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			//INDICES DE COLUMNA 
			PreparedStatement ps = con.prepareStatement(query);
			for(int i = 0; i<datos.size(); i++) {

				ps.setInt(1, datos.get(i).getPais());
				ps.setInt(2, datos.get(i).getCanal());
				ps.setInt(3, datos.get(i).getSucursal());
				ps.setInt(4, datos.get(i).getFolio());
				ps.setString(5, datos.get(i).getClob());
				ps.setInt(6, datos.get(i).getEstatus());
				ps.setString(7, datos.get(i).getRegistro());
				ps.setString(8, datos.get(i).getUltima());
				ps.setString(9, datos.get(i).getUser());
				
				ps.executeUpdate();
				
				System.out.println("Se inserto el elemento: " + (i+1)+ "/"+ datos.size());
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error en el query");
		}
	}
}


















