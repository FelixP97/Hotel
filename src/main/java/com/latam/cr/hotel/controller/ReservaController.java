package com.latam.cr.hotel.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import java.time.Instant;
import java.util.Date;
import com.latam.cr.hotel.dao.ReservaDao;
import com.latam.cr.hotel.utils.JPAUtils;
import com.latam.cr.hotel.modelo.Reserva;
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;

public class ReservaController {
	EntityManager em = JPAUtils.getEntityManager();
	 private Long valor=(long) 0;
	
	public void InsertarReserva(Date fechaIn,Date fechaOut,String formaPago) {
		Date date = (Date) Date.from(Instant.now());
		if(fechaOut.before(fechaIn)) {
			JOptionPane.showMessageDialog(null, "Fecha de salida es menor que la de entrada", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(fechaIn.before(date)) {
			JOptionPane.showMessageDialog(null, "Fecha de entrada es menor que la de fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
		Reserva reserva = new Reserva(fechaIn, fechaOut, new BigDecimal(valor), formaPago);
		ReservaDao reservaDao = new ReservaDao(em);
		em.getTransaction().begin();
		reservaDao.guardar(reserva);
		em.getTransaction().commit();
		em.close();
	    }
	    
	}
	public Long convercionDias(Date fechaIn,Date fechaOut) {
		long diferenciaEnMillis = fechaOut.getTime() - fechaIn.getTime();
		long diferenciaEnDias = TimeUnit.DAYS.convert(diferenciaEnMillis, TimeUnit.MILLISECONDS);
		valor = diferenciaEnDias * 150;
		return valor;
	}
}
