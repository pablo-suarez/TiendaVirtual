package com.DAO.TiendaVirtual;
import java.sql.*;


public class Conexion {
	
	String BD = "tiendadb";
	String Usuario = "root";
	String Clave = "";
	String url = "jdbc:mysql://localhost/"+BD;
	
	Connection con=null;
	
	public Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url,Usuario,Clave);
			if(con!=null){
				System.out.println("Conexion a base de datos "+BD+" OK \n");
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void desconectar() {
		con = null;
	}

}
