package com.latam.cr.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.cr.hotel.modelo.Usuario;


public class UsuarioDao {
	private EntityManager em;

	public UsuarioDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Usuario usuario) {
		this.em.persist(usuario);
	}
	
	public String consultarContrasenaPorUsuario(String usuario) {
		String	jpql="SELECT U.contrasena FROM Usuario AS U WHERE U.usuario=:usuario";
		return em.createQuery(jpql,String.class).setParameter("usuario", usuario).getSingleResult();
	}
	
	public String consultarUsuarioPorUsuario(String usuario) {
		String	jpql="SELECT U.usuario FROM Usuario AS U WHERE U.usuario=:usuario";
		return em.createQuery(jpql,String.class).setParameter("usuario", usuario).getSingleResult();
	}
}
