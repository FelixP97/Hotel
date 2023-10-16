package com.latam.cr.hotel.controller;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.latam.cr.hotel.dao.RegistroHuespedDao;
import com.latam.cr.hotel.modelo.Huesped;
import com.latam.cr.hotel.utils.JPAUtils;

public class RegistroHuespedController {
	
	EntityManager em = JPAUtils.getEntityManager();
	
	public void insertarHuesped(String nombre,String apellido,Date fechaNacimiento,String nacionalidad,String telefono,Long idReserva) {
		Huesped huesped = new Huesped(nombre,apellido,fechaNacimiento,nacionalidad,telefono,idReserva);
		RegistroHuespedDao registroHuespedDao = new RegistroHuespedDao(em);
		em.getTransaction().begin();
		registroHuespedDao.guardar(huesped);
		em.getTransaction().commit();
	    em.close();
	    JOptionPane.showMessageDialog(null, "Se registro el huesped con exito");
	}
}
