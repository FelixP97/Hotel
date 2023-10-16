package com.latam.cr.hotel.controller;

import java.math.BigDecimal;
import java.sql.Date;  
import java.util.List;
import com.latam.cr.hotel.modelo.*;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.latam.cr.hotel.dao.BusquedaDao;
import com.latam.cr.hotel.utils.JPAUtils;
public class BusquedaController {
	EntityManager em = JPAUtils.getEntityManager();
	BusquedaDao busquedaDao = new BusquedaDao(em);
	
	public void abrirConexion() {
		em.getTransaction().begin();
	}
	public void cerrarConexion() {
		em.close();
	}
	public List<Huesped> mostrarHuespedes() {
		
		List<Huesped> huesped = busquedaDao.consultarTodosHuespedes();
		em.flush();
		em.clear();
		return huesped;
	    
	}
	public List<Reserva> mostrarReservas() {
		List<Reserva> reserva = busquedaDao.consultarTodasReservas();
		em.flush();
	    em.clear();
		return reserva;
	    
	}
	public void modificarHuespedes(Long id,String nombre,String apellido,Date fechaNacimiento,String nacionalidad,String telefono,Long idReservas) {
		busquedaDao.actualizarHuesped(id,nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReservas);
		em.getTransaction().commit();
		
	}
	public void modificarReservas(Long id, Date fechaEntrada, Date fechaSalida,BigDecimal valor,String formaPago) {
		busquedaDao.actualizarReserva(id,fechaEntrada,fechaSalida,valor,formaPago);
		em.getTransaction().commit();
	}
	public void removerHuesped(Long id) {
		Huesped huesped = new Huesped(id);
		busquedaDao.removerHuesped(huesped);
		em.getTransaction().commit();
	}
	public void removerReserva(Long id) {
		Reserva reserva = new Reserva(id);
		busquedaDao.removerReserva(reserva);
		em.getTransaction().commit();
	}
}
