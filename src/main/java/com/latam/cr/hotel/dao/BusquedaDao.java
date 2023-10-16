package com.latam.cr.hotel.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import com.latam.cr.hotel.modelo.Huesped;
import com.latam.cr.hotel.modelo.Reserva;


import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;



public class BusquedaDao {

	private EntityManager em;

	public BusquedaDao(EntityManager em) {
		this.em = em;
	}
	public void actualizarHuesped(Long id,String nombre,String apellido,Date fechaNacimiento,String nacionalidad,String telefono,Long idReservas) {
		Huesped huesped = em.find(Huesped.class, id);
		huesped.setNombre(nombre);
		huesped.setApellido(apellido);
		huesped.setFecha_de_nacimiento(fechaNacimiento);
		huesped.setNacionalidad(nacionalidad);
		huesped.setTelefono(telefono);
		huesped.setId_reservas(idReservas);
	}
	public void actualizarReserva(Long id, Date fechaEntrada, Date fechaSalida,BigDecimal valor,String formaPago) {
		Reserva reserva = em.find(Reserva.class, id);
		reserva.setFecha_entrada(fechaEntrada);
		reserva.setFecha_salida(fechaSalida);
		reserva.setValor(valor);
		reserva.setForma_pago(formaPago);
	}
	
	public List<Huesped> consultarTodosHuespedes(){
		String jqpl= "SELECT H FROM Huesped AS H";
		return em.createQuery(jqpl,Huesped.class).getResultList();
	}
	public List<Reserva> consultarTodasReservas(){
		String jqpl= "SELECT R FROM Reserva AS R";
		return em.createQuery(jqpl,Reserva.class).getResultList();
	}
	
	public void removerHuesped(Huesped huesped) {
		huesped=this.em.merge(huesped);
		this.em.remove(huesped);
	}
	public void removerReserva(Reserva reserva) {
		reserva=this.em.merge(reserva);
		this.em.remove(reserva);
	}
	
}
