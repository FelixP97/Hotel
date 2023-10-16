package com.latam.cr.hotel.dao;

import javax.persistence.EntityManager;

import com.latam.cr.hotel.modelo.Reserva;

public class ReservaDao {

	private EntityManager em;

	public ReservaDao(EntityManager em) {
		this.em = em;
	}
	public void guardar(Reserva reserva) {
		this.em.persist(reserva);
	}
	
}
