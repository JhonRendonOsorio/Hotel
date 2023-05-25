package com.alura.tests;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		
		String rutaImagenBackGroundHotel= "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\hotel.png";
		String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabelUsuario = new JLabel("Usuario:");
		lblNewLabelUsuario.setBounds(382, 256, 100, 24);
		contentPane.add(lblNewLabelUsuario);
		
		JLabel lblNewLabelPassword = new JLabel("Contraseña:");
		lblNewLabelPassword.setBounds(382, 312, 100, 24);
		contentPane.add(lblNewLabelPassword);
		
		textFieldUsuario = new JTextField();
	
		textFieldUsuario.setBounds(502, 258, 175, 22);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(502, 315, 175, 19);
		contentPane.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnNewButtonLgin = new JButton("Login");
		
		btnNewButtonLgin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String valorIngresado = textFieldUsuario.getText();
				String valorIPassword = textFieldPassword.getText();
				
				
				
				if (!valorIngresado.isEmpty() && !valorIPassword.isEmpty()) {
					MenuUser menuuser = new MenuUser() ;
					menuuser.setVisible(true);
					dispose();
				}else {
					System.out.println("Completar campos");
					
				}
				
				
				
				
				
				
			
				
			}
		});
		btnNewButtonLgin.setBounds(382, 381, 139, 33);
		contentPane.add(btnNewButtonLgin);
		
		JButton btnNewButtonCancel = new JButton("Cancel");
		btnNewButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButtonCancel.setBounds(538, 381, 139, 33);
		contentPane.add(btnNewButtonCancel);
		
		JLabel lblRegistro = new JLabel("");
		lblRegistro.setBackground(new Color(255, 255, 255));
		lblRegistro.setBounds(0, 0, 353, 595);
		contentPane.add(lblRegistro);
		MenuUser.setImagenDeFondoLabel(lblRegistro, rutaImagenBackGroundHotel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(431, 45, 196, 162);
		contentPane.add(lblLogo);
		MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);
	}
}
