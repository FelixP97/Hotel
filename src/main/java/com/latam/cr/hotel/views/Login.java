package com.latam.cr.hotel.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.latam.cr.hotel.controller.*;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	UsuarioController usuario = new UsuarioController();

	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(467, 0, 343, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 40, 329, 503);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\img-hotel-login-.png"));
		
		JButton btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarApp();
			}
		});
		btnSalir.setBorder(null);
		btnSalir.setBackground(new Color(100, 149, 237));
		btnSalir.setBounds(288, 10, 31, 26);
		panel.add(btnSalir);
		btnSalir.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\cerrar-24px.png"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Proyectos\\JAVA\\Hotel_Alura\\hotel\\src\\main\\resources\\imagenes\\lOGO-50PX.png"));
		lblNewLabel_1.setBounds(50, 63, 50, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(105, 105, 105));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuario.setBounds(50, 212, 118, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setForeground(UIManager.getColor("Button.darkShadow"));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContrasena.setBounds(50, 311, 157, 30);
		contentPane.add(lblContrasena);
		
		JLabel lblIniciar = new JLabel("INICIAR SESIÓN");
		lblIniciar.setForeground(new Color(30, 144, 255));
		lblIniciar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblIniciar.setBounds(49, 142, 211, 30);
		contentPane.add(lblIniciar);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUsuario.setBorder(null);
		txtUsuario.setForeground(new Color(192, 192, 192));
		txtUsuario.setText("Ingrese su nombre de usuario");
		txtUsuario.setBounds(50, 252, 227, 30);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 292, 210, 12);
		contentPane.add(separator);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setForeground(new Color(192, 192, 192));
		txtContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtContrasena.setText("1234567");
		txtContrasena.setBorder(null);
		txtContrasena.setBounds(50, 351, 210, 30);
		contentPane.add(txtContrasena);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(30, 144, 255));
		separator_1.setBounds(50, 391, 210, 12);
		contentPane.add(separator_1);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usu = txtUsuario.getText();
				String pass = txtContrasena.getText();
				usuario.entrar(usu, pass);
				boolean ingresar = usuario.entrar(usu, pass);
				if(ingresar) {
					Login.this.setVisible(false);
					Login.this.dispose();
					MenuUsuario menu = new MenuUsuario();
					menu.setVisible(true);
				} 
				if(ingresar==false){
					JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
				}
				
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(30, 144, 255));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setBounds(49, 429, 119, 50);
		contentPane.add(btnEntrar);
	}
	public void cerrarApp() {
		usuario.cerrarConexion();
		this.dispose();
	}
}
