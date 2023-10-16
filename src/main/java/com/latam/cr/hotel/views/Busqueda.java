package com.latam.cr.hotel.views;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;  
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import com.latam.cr.hotel.controller.BusquedaController;
import com.latam.cr.hotel.modelo.Huesped;
import com.latam.cr.hotel.modelo.Reserva;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private DefaultTableModel model;
	private JTable tbHuespedes;
	private JTable tbReservas;
	BusquedaController busquedaController = new BusquedaController();
	int xMouse, yMouse;

	public Busqueda() {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int y = e.getYOnScreen();
				int x = e.getXOnScreen();
				setLocation(x-xMouse,y-yMouse);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		setUndecorated(true);
		busquedaController.abrirConexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(333, 51, 261, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\Ha-100px.png"));
		lblNewLabel.setBounds(65, 62, 100, 93);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBackground(new Color(30, 144, 255));
		btnBuscar.setBounds(724, 119, 128, 36);
		contentPane.add(btnBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBuscar.setColumns(10);
		txtBuscar.setBorder(null);
		txtBuscar.setBounds(503, 119, 211, 27);
		contentPane.add(txtBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(30, 144, 255));
		separator.setBounds(503, 153, 207, 2);
		contentPane.add(separator);
		
		
		
		JTabbedPane panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPestanas.setBounds(23, 165, 829, 332);
		contentPane.add(panelPestanas);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = panelPestanas.getSelectedIndex();
				if (selectedIndex == 0) {
					actualizarDatosHuespedes();
					JOptionPane.showMessageDialog(null, "Se ha editado el huesped exitosamente");
					busquedaController.abrirConexion();
				}
				if(selectedIndex == 1) {
					actualizarDatosReservas();
					JOptionPane.showMessageDialog(null, "Se ha editado la reserva exitosamente");
					busquedaController.abrirConexion();
				}
				
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditar.setBackground(new Color(30, 144, 255));
		btnEditar.setBounds(586, 513, 128, 36);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = panelPestanas.getSelectedIndex();
				if (selectedIndex == 0) {
					removerHuespedes();
					JOptionPane.showMessageDialog(null, "Se ha eliminado el huesped exitosamente");
					busquedaController.abrirConexion();
				}
				if(selectedIndex == 1) {
					removerReserva();
					JOptionPane.showMessageDialog(null, "Se ha eliminado la reserva exitosamente");
					busquedaController.abrirConexion();
				}
				
				
			}
		});
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminar.setBackground(new Color(30, 144, 255));
		btnEliminar.setBounds(724, 513, 128, 36);
		contentPane.add(btnEliminar);
		
		JPanel plHuespedes = new JPanel();
		panelPestanas.addTab("Huespedes", new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\pessoas.png"), plHuespedes, null);
		panelPestanas.setBackgroundAt(0, new Color(30, 144, 255));
		plHuespedes.setForeground(new Color(0, 0, 0));
		plHuespedes.setBackground(new Color(30, 144, 255));
		plHuespedes.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 824, 294);
		plHuespedes.add(scrollPane);
		tbHuespedes = new JTable();
		tbHuespedes.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(tbHuespedes);
		
		model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("NOMBRE");
		model.addColumn("APELLIDOS");
		model.addColumn("FECHA DE NACIMIENTO");
		model.addColumn("NACIONALIDAD");
		model.addColumn("TELEFONO");
		model.addColumn("ID RESERVAS");
		tbHuespedes.setModel(model);
		mostrarHuespedes();
		
		
		
		JPanel plReservas = new JPanel();
		plReservas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plReservas.setBackground(new Color(255, 255, 255));
		panelPestanas.addTab("Reservas", new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\reservado.png"), plReservas, null);
		panelPestanas.setBackgroundAt(1, new Color(30, 144, 255));
		plReservas.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 824, 286);
		plReservas.add(scrollPane_1);
		
		tbReservas = new JTable();
		scrollPane_1.setViewportView(tbReservas);
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("FECHA ENTRADA");
		model.addColumn("FECHA SALIDA");
		model.addColumn("VALOR");
		model.addColumn("FORMA PAGO");
		tbReservas.setModel(model);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarApp();
			}
		});
		btnSalir.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\cerrar-24px.png"));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(884, 10, 31, 26);
		contentPane.add(btnSalir);
		
		JButton btnRegresar = new JButton("<");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda.this.setVisible(false);
				Busqueda.this.dispose();
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
			}
		});
		btnRegresar.setForeground(new Color(30, 144, 255));
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(new Color(255, 255, 255));
		btnRegresar.setBounds(23, 10, 52, 21);
		contentPane.add(btnRegresar);
		mostrarReservas();
	}
	public void mostrarHuespedes() {
		List<Huesped>huespedes =busquedaController.mostrarHuespedes();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		for(Huesped obj : huespedes) {
			Object[] fila = new Object[7];
			fila[0] = obj.getId();
			fila[1] = obj.getNombre();
			fila[2] = obj.getApellido();
			fila[3] = date.format(obj.getFecha_de_nacimiento());
			fila[4] = obj.getNacionalidad();
			fila[5] = obj.getTelefono();
			fila[6] = obj.getId_reservas();
			
			model.addRow(fila);
		}
	}
	public void mostrarReservas() {
		List<Reserva>reservas =busquedaController.mostrarReservas();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		for(Reserva obj : reservas) {
			Object[] fila = new Object[7];
			fila[0] = obj.getId();
			fila[1] = date.format(obj.getFecha_entrada());
			fila[2] = date.format(obj.getFecha_salida());
			fila[3] = obj.getValor();
			fila[4] = obj.getForma_pago();
			
			model.addRow(fila);
		}
	}
	
	public void actualizarDatosHuespedes() {
		
		int fila = tbHuespedes.getSelectedRow();
		Long id = Long.parseLong(this.tbHuespedes.getValueAt(fila, 0).toString());
		String nombre = tbHuespedes.getValueAt(fila, 1).toString();
		String apellido = tbHuespedes.getValueAt(fila, 2).toString();
		Date fechaNacimiento = Date.valueOf(tbHuespedes.getValueAt(fila, 3).toString()) ;
		String nacionalidad = tbHuespedes.getValueAt(fila, 4).toString();
		String telefono = tbHuespedes.getValueAt(fila, 5).toString();
		Long idReservas = Long.parseLong(this.tbHuespedes.getValueAt(fila, 6).toString());
		busquedaController.modificarHuespedes(id,nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReservas);
		
	}
	public void actualizarDatosReservas() {
		
		int fila = (tbReservas.getSelectedRow());
		Long id = Long.parseLong(this.tbReservas.getValueAt(fila, 0).toString());
		Date fechaEntrada = Date.valueOf(tbReservas.getValueAt(fila, 1).toString()) ;
		Date fechaSalida = Date.valueOf(tbReservas.getValueAt(fila, 2).toString()) ;
		BigDecimal valor = new BigDecimal(tbReservas.getValueAt(fila, 3).toString());
		String formaPago = tbReservas.getValueAt(fila, 4).toString();
		busquedaController.modificarReservas(id, fechaEntrada, fechaSalida,valor,formaPago);
		
	}
	public void removerHuespedes() {	
		int fila = tbHuespedes.getSelectedRow();
		Long id = Long.parseLong(this.tbHuespedes.getValueAt(fila, 0).toString());
		busquedaController.removerHuesped(id);
		
	}
	public void removerReserva() {	
		int fila = (tbReservas.getSelectedRow());
		Long id = Long.parseLong(this.tbReservas.getValueAt(fila, 0).toString());
		busquedaController.removerReserva(id);
	}
	public void cerrarApp() {
		busquedaController.cerrarConexion();
		this.dispose();
	}
}
