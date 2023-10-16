package com.latam.cr.hotel.views;

import java.awt.EventQueue;
import com.latam.cr.hotel.views.RegistroHuesped;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.latam.cr.hotel.controller.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	MenuUsuarioController time =new  MenuUsuarioController();
	int xMouse, yMouse;
	public MenuUsuario() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 255, 608);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\aH-150px.png"));
		lblNewLabel.setBounds(40, 60, 150, 150);
		panel.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 220, 185, 12);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\icon-reservas.png"));
		lblNewLabel_1.setBounds(30, 280, 32, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\icon-buscar.png"));
		lblNewLabel_2.setBounds(30, 387, 32, 32);
		panel.add(lblNewLabel_2);
		
		JButton btnRegistroReservas = new JButton("Registro de reservas");
		btnRegistroReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario.this.setVisible(false);
				MenuUsuario.this.dispose();
				Reservas reservas = new Reservas();
				reservas.setVisible(true);
			}
		});
		btnRegistroReservas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistroReservas.setBorder(null);
		btnRegistroReservas.setForeground(new Color(255, 255, 255));
		btnRegistroReservas.setBackground(new Color(30, 144, 255));
		btnRegistroReservas.setBounds(72, 280, 138, 32);
		panel.add(btnRegistroReservas);
		
		JButton btnBusqueda = new JButton("Búsqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario.this.setVisible(false);
				MenuUsuario.this.dispose();
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
			}
		});
		btnBusqueda.setForeground(Color.WHITE);
		btnBusqueda.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBusqueda.setBorder(null);
		btnBusqueda.setBackground(new Color(30, 144, 255));
		btnBusqueda.setBounds(72, 387, 138, 32);
		panel.add(btnBusqueda);
		
		JButton btnRegistroHuesped = new JButton("Registro de huesped");
		btnRegistroHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario.this.setVisible(false);
				MenuUsuario.this.dispose();
				RegistroHuesped registroHuesped = new RegistroHuesped();
				registroHuesped.setVisible(true);
			}
		});
		btnRegistroHuesped.setForeground(Color.WHITE);
		btnRegistroHuesped.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistroHuesped.setBorder(null);
		btnRegistroHuesped.setBackground(new Color(30, 144, 255));
		btnRegistroHuesped.setBounds(72, 334, 138, 32);
		panel.add(btnRegistroHuesped);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\pessoas.png"));
		lblNewLabel_1_1.setBounds(30, 334, 32, 32);
		panel.add(lblNewLabel_1_1);
		
		JButton btnRegresar = new JButton("<");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario.this.setVisible(false);
				MenuUsuario.this.dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(new Color(30, 144, 255));
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegresar.setBounds(10, 20, 52, 21);
		panel.add(btnRegresar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(254, 79, 692, 125);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Sistema de reservas Hotel Alura");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(175, 10, 350, 28);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hoy es");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(45, 65, 88, 35);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setText(time.fechaCompleta);
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblFecha.setBounds(143, 65, 153, 35);
		panel_1.add(lblFecha);
		
		
		JLabel lblNewLabel_5 = new JLabel("Bienvenido");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_5.setBounds(320, 264, 140, 34);
		contentPane.add(lblNewLabel_5);
		
		JTextArea txtrSistemaDeReserva = new JTextArea();
		txtrSistemaDeReserva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrSistemaDeReserva.setText("Sistema de reserva de hotel. Controle y administre de forma óptima y facil\r\nel flujo de reservas y de huespédes del hotel\r\n\r\nEsta herramienta le permitirá llevar un control completo y detallado de sus\r\nreservas y huéspedes, tendrá acceso a herramientas especiales para tareas\r\nespecificas como lo son:\r\n\r\n\t-Registro de Reservas y Huéspedes\r\n\r\n\t-Edición de Reservas y Huéspedes existentes\r\n\r\n\t-Eliminar todo tipo de registros");
		txtrSistemaDeReserva.setBounds(320, 325, 511, 262);
		contentPane.add(txtrSistemaDeReserva);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\cerrar-24px.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarApp();
			}
		});
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(905, 10, 31, 26);
		contentPane.add(btnSalir);
	
	
	}
	public void cerrarApp() {
		this.dispose();
	}
}
