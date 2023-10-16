package com.latam.cr.hotel.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MenuUsuarioController {
	Calendar fecha = new GregorianCalendar();
	String ano = Integer.toString(fecha.get(Calendar.YEAR));
	String mes = Integer.toString(fecha.get(Calendar.MONTH)+1);
	String dia = Integer.toString(fecha.get(Calendar.DATE));
	
	public String fechaCompleta = dia+"/"+mes+"/"+ano;
}
