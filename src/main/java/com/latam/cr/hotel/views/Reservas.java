package com.latam.cr.hotel.views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import com.latam.cr.hotel.controller.ReservaController;
import java.sql.Date;
public class Reservas extends JFrame {

	private JPanel contentPane;
	ReservaController reservaController = new ReservaController();
	private String precio;
	public Reservas() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 595);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(406, 0, 515, 568);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\reservas-img-3.png"));
		lblNewLabel.setBounds(33, 199, 472, 279);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\Ha-100px.png"));
		lblNewLabel_1.setBounds(218, 52, 100, 100);
		panel.add(lblNewLabel_1);
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarApp();
			}
		});
		btnSalir.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\cerrar-24px.png"));
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(30, 144, 255));
		btnSalir.setBounds(474, 10, 31, 26);
		panel.add(btnSalir);
		
		JLabel lblNewLabel_2 = new JLabel("SISTEMA DE RESERVAS");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(48, 66, 241, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("FECHA DE CHECK IN");
		lblNewLabel_2_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(44, 130, 211, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("FECHA DE CHECK OUT");
		lblNewLabel_2_1_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(44, 214, 233, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("VALOR DE LA RESERVA");
		lblNewLabel_2_1_1_1.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(44, 297, 241, 27);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("FORMA DE PAGO");
		lblNewLabel_2_1_2.setForeground(new Color(112, 128, 144));
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1_2.setBounds(44, 384, 211, 27);
		contentPane.add(lblNewLabel_2_1_2);
		
		JDateChooser dtcCheckIn = new JDateChooser();
		dtcCheckIn.getCalendarButton().setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\calendario (1).png"));
		dtcCheckIn.setDateFormatString("yyyy-MM-dd");
		dtcCheckIn.setBounds(44, 167, 211, 37);
		contentPane.add(dtcCheckIn);
		
		JDateChooser dtcCheckOut = new JDateChooser();
		dtcCheckOut.getCalendarButton().setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\calendario (1).png"));
		dtcCheckOut.setDateFormatString("yyyy-MM-dd");
		dtcCheckOut.setBounds(44, 250, 211, 37);
		contentPane.add(dtcCheckOut);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(30, 144, 255));
		separator.setBounds(48, 372, 207, 2);
		contentPane.add(separator);
		
		JComboBox cbxFormaPago = new JComboBox();
		cbxFormaPago.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbxFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Credito", "Debito", "Efectivo"}));
		cbxFormaPago.setBounds(48, 432, 207, 36);
		contentPane.add(cbxFormaPago);
		
		JLabel lblNewLabel_3 = new JLabel("$");
		lblNewLabel_3.setForeground(new Color(169, 169, 169));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(54, 334, 21, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblValor = new JLabel("");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(85, 334, 170, 28);
		contentPane.add(lblValor);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String fechaIn = ((JTextField)dtcCheckIn.getDateEditor().getUiComponent()).getText();
				String fechaOut = ((JTextField)dtcCheckOut.getDateEditor().getUiComponent()).getText();
				Long valor=reservaController.convercionDias(Date.valueOf(fechaIn),Date.valueOf(fechaOut));
				precio=Long.toString(valor);
				lblValor.setText(precio);
				String formaPago = (String)cbxFormaPago.getSelectedItem();
				reservaController.InsertarReserva(Date.valueOf(fechaIn), Date.valueOf(fechaOut), formaPago);
				JOptionPane.showMessageDialog(null, "Se ha hecho la reservacion con exito");
				}
				catch(IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "No puede dejar espacios de fecha en blanco", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSiguiente.setBackground(new Color(30, 144, 255));
		btnSiguiente.setBounds(210, 491, 128, 36);
		contentPane.add(btnSiguiente);
		
		JButton btnRegresar = new JButton("<");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas.this.setVisible(false);
				Reservas.this.dispose();
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.setVisible(true);
			}
		});
		btnRegresar.setForeground(new Color(30, 144, 255));
		btnRegresar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegresar.setBorder(null);
		btnRegresar.setBackground(new Color(255, 255, 255));
		btnRegresar.setBounds(10, 10, 52, 21);
		contentPane.add(btnRegresar);
		
		}
	public void cerrarApp() {
		this.dispose();
	}
}
