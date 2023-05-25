package com.alura.tests;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		String rutaImagenReserva = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\login.png";
		String rutaImagenExit = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\exit.png";
		String rutaImagenBackGround = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\reception.png";
		String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 632);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBounds(496, 272, 71, 59);
		
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Registro frameMenuUser = new Registro();
				frameMenuUser.setVisible(true);
				
				dispose();
			}
		});		
		
		MenuUser.setImagenDeFondoBoton(btnLogin, rutaImagenReserva);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(513, 236, 45, 13);
		contentPane.add(lblLogin);
		
		JButton btnExit = new JButton("");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(621, 514, 45, 48);
		contentPane.add(btnExit);
		btnExit.addActionListener(e -> System.exit(0));
		
		MenuUser.setImagenDeFondoBoton(btnExit, rutaImagenExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(0, 0, 353, 595);
		contentPane.add(lblNewLabel);
		MenuUser.setImagenDeFondoLabel(lblNewLabel, rutaImagenBackGround);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(431, 45, 196, 162);
		contentPane.add(lblLogo);
		MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);
	}
}
