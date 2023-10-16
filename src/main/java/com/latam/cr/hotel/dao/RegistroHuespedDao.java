package com.latam.cr.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.cr.hotel.modelo.Huesped;

public class RegistroHuespedDao {

	private EntityManager em;

	public RegistroHuespedDao(EntityManager em) {
		this.em = em;
	}
	public void guardar(Huesped huesped) {
		this.em.persist(huesped);
	}
}
