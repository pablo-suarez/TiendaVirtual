package com.Controlador.TiendaVirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.DAO.TiendaVirtual.Conexion;

@SpringBootApplication
public class TiendaVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualApplication.class, args);
		Conexion con = new Conexion();
		con.getConnection();
	}

}
