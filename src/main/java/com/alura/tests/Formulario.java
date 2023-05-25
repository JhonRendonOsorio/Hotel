package com.alura.tests;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private Connection connection;
	private Date checkInDate;
	private Date checkOutDate;
	private String valorReserva;
	private String currentNumReserva;
	private String numeroReserva;

	/**
	 * Launch the application.
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setDatosReserva(java.util.Date checkInDate2, java.util.Date checkOutDate2, String valorReserva,
			String numeroReserva) {
		this.checkInDate = new java.sql.Date(checkInDate2.getTime());
		this.checkOutDate = new java.sql.Date(checkOutDate2.getTime());
		this.valorReserva = valorReserva;
		this.currentNumReserva = valorReserva;
		textField_3.setText(numeroReserva);
	}

	public void setNumeroReserva(String numeroReserva) {
		textField_3.setText(numeroReserva);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {

		String rutaImagenBackGround = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\registro2.png";
		String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistoHuesped = new JLabel("Registo Huesped");
		lblRegistoHuesped.setForeground(SystemColor.textHighlight);
		lblRegistoHuesped.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRegistoHuesped.setBounds(365, 72, 286, 30);
		contentPane.add(lblRegistoHuesped);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(363, 127, 138, 13);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(363, 151, 193, 19);
		contentPane.add(textField);

		JLabel lblNewLabelApellido = new JLabel("Apellido");
		lblNewLabelApellido.setBounds(363, 199, 138, 13);
		contentPane.add(lblNewLabelApellido);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(363, 222, 193, 19);
		contentPane.add(textField_1);

		JLabel lblNewLabelFecha = new JLabel("Fecha de Nacimiento");
		lblNewLabelFecha.setBounds(363, 280, 138, 13);
		contentPane.add(lblNewLabelFecha);

		JXDatePicker datePicker = new JXDatePicker();
		datePicker.setBounds(363, 303, 193, 19);
		contentPane.add(datePicker);

		JLabel lblNewLabelNacionalidad = new JLabel("Nacionalidad");
		lblNewLabelNacionalidad.setBounds(363, 349, 193, 13);
		contentPane.add(lblNewLabelNacionalidad);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Albania Indonesia", "Alemania Irak",
				"Angola Irlanda (Eire)", "Antigua y Barbuda Islas Feroe", "Argentina Islas Vírgenes (Norteamericanas)",
				"Aruba Israel", "Australia Italia", "Bahamas Jamaica", "Bangladesh Japón", "Barbados Letonia",
				"Bélgica Líbano", "Belice Malasia", "Bolivia Martinica", "Brasil México", "Canadá Nicaragua",
				"Chile Nigeria", "China (Continental) Noruega",
				"China-Taiwán (Formosa) Otras de las Indias Occidentales Británicas", "Colombia Países Bajos",
				"Corea del Sur Pakistán", "Costa Rica Paraguay", "Cuba Perú", "Curazao Polonia", "Dinamarca Portugal",
				"Dominica Puerto Rico", "Ecuador Reino Unido", "El Salvador República Dominicana",
				"Emiratos Árabes Unidos Rusia", "España San Martín (Parte Sur)",
				"Estados Unidos de América Santa Lucía", "Francia Sri Lanka", "Gambia Suecia", "Ghana Suiza",
				"Granada Suriname", "Grecia Tailandia", "Guadalupe y Dependencias Trinidad y Tobago",
				"Guatemala Turquía", "Guyana Uruguay", "Haití Venezuela", "Honduras Vietnam",
				"Hong Kong Zona Libre de Colón (Panamá)", "India" }));
		comboBox.setBounds(363, 372, 193, 19);
		contentPane.add(comboBox);

		JLabel lblNewLabelTelefono = new JLabel("Telefono");
		lblNewLabelTelefono.setBounds(363, 426, 193, 13);
		contentPane.add(lblNewLabelTelefono);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(363, 449, 193, 19);
		contentPane.add(textField_2);

		JLabel lblNewLabelNumeroReserva = new JLabel("Numero de Reserva");
		lblNewLabelNumeroReserva.setBounds(363, 497, 193, 13);
		contentPane.add(lblNewLabelNumeroReserva);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(363, 520, 193, 19);
		contentPane.add(textField_3);
		System.out.println(numeroReserva);
		setNumeroReserva(numeroReserva);

		JButton btnGuardar = new JButton("");
		btnGuardar.setBackground(new Color(255, 255, 255));

		btnGuardar.setBounds(556, 545, 33, 40);
		contentPane.add(btnGuardar);

		JButton btnCancel = new JButton("");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(599, 545, 33, 40);
		contentPane.add(btnCancel);
		String rutaImagenBackGroundCancelar = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\cancel.png";
		MenuUser.setImagenDeFondoBoton(btnCancel, rutaImagenBackGroundCancelar);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(641, 545, 33, 40);
		contentPane.add(btnExit);
		String rutaImagenBackGroundSalir = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\exit.png";
		MenuUser.setImagenDeFondoBoton(btnExit, rutaImagenBackGroundSalir);
		btnExit.addActionListener(e -> System.exit(0));

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(556, 22, 138, 107);
		contentPane.add(lblLogo);
		MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setForeground(SystemColor.white);
		lblNewLabel1.setBackground(new Color(255, 255, 255));
		lblNewLabel1.setBounds(0, 0, 353, 595);
		contentPane.add(lblNewLabel1);
		MenuUser.setImagenDeFondoLabel(lblNewLabel1, rutaImagenBackGround);
		System.out.println(checkInDate);
		btnGuardar.addActionListener(e -> {
			String nombre = textField.getText();
			String apellido = textField_1.getText();
			String facimiento = datePicker.getDate().toString();
			String nacionalidad = comboBox.getSelectedItem().toString();
			String telefono = (textField_2.getText());
			String numeroReserva = (textField_3.getText());

			try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root",
					"@Merica1")) {
				String consulta = "INSERT INTO clientes (checkin, checkout, pagar, nombre, apellido, facimiento, nacionalidad, telefono, numreserva) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = conexion.prepareStatement(consulta);

				statement.setDate(1, new java.sql.Date(checkInDate.getTime()));
				statement.setDate(2, new java.sql.Date(checkOutDate.getTime()));
				statement.setString(3, valorReserva);
				statement.setString(4, textField.getText());
				statement.setString(5, textField_1.getText());
				statement.setString(6, datePicker.getDate().toString());
				statement.setString(7, comboBox.getSelectedItem().toString());
				statement.setString(8, telefono);
				statement.setString(9, numeroReserva);

				statement.executeUpdate();
				statement.close();

				btnGuardar.setEnabled(false);
				JOptionPane.showMessageDialog(btnGuardar, "Los Datos Fueron Guardados Exitosamente");
				MenuUser frameMenu = new MenuUser();
				frameMenu.setVisible(true);
				dispose();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		String rutaImagenBackGroundSave = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\save.png";
		MenuUser.setImagenDeFondoBoton(btnGuardar, rutaImagenBackGroundSave);
	}

}
