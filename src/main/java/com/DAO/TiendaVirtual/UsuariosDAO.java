package com.DAO.TiendaVirtual;

//Estaclase permite el acceso a la Base de Datos y realizar CRUD

import java.sql.*;
import java.util.ArrayList;

import com.DTO.TiendaVirtual.UsuarioVO;


public class UsuariosDAO {
	
	//Consultar Usuarios
	public ArrayList<UsuarioVO> listaUsuarios(){
		
		ArrayList<UsuarioVO> miLista =  new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try {
			PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet rs = consulta.executeQuery();
			while(rs.next()) {
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("email_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("password"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return miLista;
		
	}
	
	public ArrayList<UsuarioVO> ConsultarUsuario(int documento){
		ArrayList<UsuarioVO> miLista = new ArrayList<UsuarioVO>();
		Conexion con = new Conexion();
		
		try {
			PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = ?");
			consulta.setInt(1,documento);
			ResultSet rs=consulta.executeQuery();
			if(rs.next()) {
				UsuarioVO persona = new UsuarioVO();
				persona.setCedula(Integer.parseInt(rs.getString("cedula_usuario")));
				persona.setNombre(rs.getString("nombre_usuario"));
				persona.setCorreo(rs.getString("email_usuario"));
				persona.setUsuario(rs.getString("usuario"));
				persona.setClave(rs.getString("password"));
				
				miLista.add(persona);
			}
			rs.close();
			consulta.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
		return miLista;
	}
	
	public void RegistrarUsuario(UsuarioVO persona) {
		Conexion con = new Conexion();
		
		try {
			Statement stmt = con.getConnection().createStatement();
			stmt.executeUpdate("INSERT INTO usuarios (cedula_usuario,email_usuario,nombre_usuario,password,usuario) VALUES ('"+persona.getCedula()+"','"+persona.getCorreo()+"','"+persona.getNombre()+"','"+persona.getClave()+"','"+persona.getUsuario()+"')");
			stmt.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void ActualizarUsuario(UsuarioVO persona) {
		Conexion con = new Conexion();
		
		try {
			Statement stmt = con.getConnection().createStatement();
			stmt.executeUpdate("UPDATE usuarios SET email_usuario='"+persona.getCorreo()+"',nombre_usuario='"+persona.getNombre()+"',password='"+persona.getClave()+"',usuario='"+persona.getUsuario()+"' WHERE cedula_usuario='"+persona.getCedula()+"'");
			stmt.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void EliminarUsuario(int documento){
		
		Conexion con = new Conexion();
		
		try {
		      PreparedStatement stmt = con.getConnection().prepareStatement("DELETE FROM usuarios WHERE cedula_usuario = ?");
		      stmt.setInt(1, documento);
		      stmt.execute();
			

			stmt.close();
			con.desconectar();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
}
