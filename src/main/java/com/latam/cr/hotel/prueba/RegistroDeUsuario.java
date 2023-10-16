package com.latam.cr.hotel.prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.cr.hotel.modelo.Usuario;
import com.latam.cr.hotel.utils.JPAUtils;
import com.latam.cr.hotel.dao.*;
public class RegistroDeUsuario {

	public static void main(String[] args) {
		Usuario nuevo = new Usuario("Prueba","1234");
		
		EntityManager em = JPAUtils.getEntityManager();
		
		UsuarioDao usuarioDao = new UsuarioDao(em);
		
		String contrasena = usuarioDao.consultarContrasenaPorUsuario("Admin");
		System.out.println(contrasena);
		
	}

}
