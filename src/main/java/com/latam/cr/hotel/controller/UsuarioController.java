package com.latam.cr.hotel.controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

import com.latam.cr.hotel.dao.UsuarioDao;
import com.latam.cr.hotel.utils.JPAUtils;
import com.latam.cr.hotel.views.*;

public class UsuarioController {
	boolean entrar;
	EntityManager em = JPAUtils.getEntityManager();
	
	UsuarioDao usuarioDao = new UsuarioDao(em);
	
	public boolean entrar(String usu,String pass) {
		try {
		String usuario = usuarioDao.consultarUsuarioPorUsuario(usu);
		String contrasena = usuarioDao.consultarContrasenaPorUsuario(usu);
		if(usuario.equals(usu) && contrasena.equals(pass)) {
			entrar = true;
		}
		}catch(NoResultException e) {
			JOptionPane.showMessageDialog(null, "Usuario no existe");

		}
		return entrar;
	}
	public void cerrarConexion() {
		em.close();
	}
}
