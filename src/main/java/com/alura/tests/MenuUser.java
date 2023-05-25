package com.alura.tests;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class MenuUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void setImagenDeFondoBoton(JButton boton, String rutaImagen) {
		ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
		int anchoBoton = boton.getWidth();
	    int altoBoton = boton.getHeight();
	    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
	    ImageIcon imagenFondo = new ImageIcon(imagenRedimensionada);
	    boton.setIcon(imagenFondo);
	}
	
	public static void setImagenDeFondoLabel(JLabel label, String rutaImagen) {
		ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
		
		int anchoBoton = label.getWidth();
	    int altoBoton = label.getHeight();
	    
	    Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH);
	    ImageIcon imagenFondo = new ImageIcon(imagenRedimensionada);
	    label.setIcon(imagenFondo);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUser frame = new MenuUser();
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
	public MenuUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		String rutaImagenReserva = "C:\\Users\\jhono\\eclipse-workspace\\HoelAlura\\img\\reserva.png";
		String rutaImagenBusqueda = "C:\\Users\\jhono\\eclipse-workspace\\HoelAlura\\img\\busqueda.png";
		String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";
		String rutaImagenBackGroundHotel = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\reception.png";

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnReservas = new JButton("");
		btnReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserva reservas = new Reserva();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnReservas.setBackground(new Color(255, 255, 255));
		btnReservas.setForeground(new Color(255, 255, 255));
		btnReservas.setBounds(486, 246, 78, 69);
		contentPane.add(btnReservas);
		setImagenDeFondoBoton(btnReservas, rutaImagenReserva);
		
		JButton btnBusqueda = new JButton("");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Busqueda frameBusqueda = new Busqueda();
				frameBusqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setForeground(Color.WHITE);
		btnBusqueda.setBackground(Color.WHITE);
		btnBusqueda.setBounds(486, 377, 78, 69);
		contentPane.add(btnBusqueda);
		setImagenDeFondoBoton(btnBusqueda, rutaImagenBusqueda);
		
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusqueda.setBounds(481, 348, 96, 19);
		contentPane.add(lblBusqueda);
		
		JLabel lblReserva = new JLabel("Reserva");
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setBounds(481, 208, 96, 19);
		contentPane.add(lblReserva);
		
		JLabel lblHotel = new JLabel("");
		lblHotel.setBackground(new Color(255, 255, 255));
		lblHotel.setBounds(0, 0, 353, 595);
		contentPane.add(lblHotel);
		MenuUser.setImagenDeFondoLabel(lblHotel, rutaImagenBackGroundHotel);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(431, 45, 196, 162);
		contentPane.add(lblLogo);
		MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);
		
	}
}
