package com.latam.cr.hotel.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import com.latam.cr.hotel.controller.RegistroHuespedController;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class RegistroHuesped extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtReserva;
	RegistroHuespedController registroHuespedController = new RegistroHuespedController();
	int xMouse, yMouse;
	public RegistroHuesped() {
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
		setBounds(100, 100, 930, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 496, 633);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\registro.png"));
		lblNewLabel.setBounds(0, 105, 496, 507);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\Ha-100px.png"));
		lblNewLabel_1.setBounds(198, 10, 100, 108);
		panel.add(lblNewLabel_1);
		
		JButton btnRegresar = new JButton("<");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroHuesped.this.setVisible(false);
				RegistroHuesped.this.dispose();
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
			}
		});
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(new Color(100, 149, 237));
		btnRegresar.setBounds(26, 20, 52, 21);
		panel.add(btnRegresar);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTRO HUÉSPED");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(611, 50, 218, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE");
		lblNewLabel_2_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(554, 87, 88, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("APELLIDO");
		lblNewLabel_2_1_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(554, 158, 103, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("FECHA DE NACIMIENTO");
		lblNewLabel_2_1_2.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(554, 234, 233, 27);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("NACIONALIDAD");
		lblNewLabel_2_1_3.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_3.setBounds(554, 308, 158, 27);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("TELEFONO");
		lblNewLabel_2_1_4.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_4.setBounds(554, 392, 103, 27);
		contentPane.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("NUMERO DE RESERVA");
		lblNewLabel_2_1_5.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_5.setBounds(554, 467, 211, 27);
		contentPane.add(lblNewLabel_2_1_5);
		
		JDateChooser dtcNacimiento = new JDateChooser();
		dtcNacimiento.getCalendarButton().setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\calendario (1).png"));
		dtcNacimiento.setDateFormatString("yyyy-MM-dd");
		dtcNacimiento.setBounds(554, 261, 211, 37);
		contentPane.add(dtcNacimiento);
		
		JComboBox cbxNacionalidad = new JComboBox();
		cbxNacionalidad.setModel(new DefaultComboBoxModel(new String[] {"Costarricense", "Peruano", "Colombiano", "Salvadoreño", "Americano"}));
		cbxNacionalidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbxNacionalidad.setBounds(554, 346, 211, 36);
		contentPane.add(cbxNacionalidad);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String fechaNacimiento = ((JTextField)dtcNacimiento.getDateEditor().getUiComponent()).getText();
				String nacionalidad = (String)cbxNacionalidad.getSelectedItem();
				String telefono = txtTelefono.getText();
				String  idReservas = txtReserva.getText();
				registroHuespedController.insertarHuesped(nombre, apellido, Date.valueOf(fechaNacimiento), nacionalidad, telefono, Long.valueOf(idReservas));
				}catch(IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "No puede dejar espacios de fecha en blanco", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuardar.setBackground(new Color(30, 144, 255));
		btnGuardar.setBounds(701, 572, 128, 36);
		contentPane.add(btnGuardar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(30, 144, 255));
		separator.setBounds(554, 146, 207, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(30, 144, 255));
		separator_1.setBounds(554, 222, 207, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(30, 144, 255));
		separator_2.setBounds(554, 456, 207, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(30, 144, 255));
		separator_3.setBounds(554, 535, 207, 2);
		contentPane.add(separator_3);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(null);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombre.setBounds(554, 113, 211, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		txtApellido.setBorder(null);
		txtApellido.setBounds(554, 185, 211, 27);
		contentPane.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(554, 419, 211, 27);
		contentPane.add(txtTelefono);
		
		txtReserva = new JTextField();
		txtReserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReserva.setColumns(10);
		txtReserva.setBorder(null);
		txtReserva.setBounds(554, 498, 211, 27);
		contentPane.add(txtReserva);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarApp();
			}
		});
		btnSalir.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\cerrar-24px.png"));
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setBounds(889, 10, 31, 26);
		contentPane.add(btnSalir);
	}
	public void cerrarApp() {
		this.dispose();
	}
}
