package com.alura.tests;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;



public class Reserva extends JFrame {

    private JTextField textField;
    private Formulario formularioFrame;
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Reserva frame = new Reserva();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Reserva() {
    	
    	String rutaImagenBackGroundReserva= "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\form.png";
		String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 632);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCheckIn = new JLabel("Fecha de Check In");
        lblCheckIn.setBounds(22, 162, 240, 29);
        contentPane.add(lblCheckIn);

        final JXDatePicker datePickerCheckIn = new JXDatePicker();
        datePickerCheckIn.setBounds(22, 201, 240, 21);
        contentPane.add(datePickerCheckIn);

        JLabel lblCheckOut = new JLabel("Fecha de Check Out");
        lblCheckOut.setBounds(22, 268, 240, 13);
        contentPane.add(lblCheckOut);

        final JXDatePicker datePickerCheckOut = new JXDatePicker();
        datePickerCheckOut.setBounds(22, 291, 240, 21);
        contentPane.add(datePickerCheckOut);

        JLabel lblValorReserva = new JLabel("Valor de Reserva");
        lblValorReserva.setBounds(22, 368, 240, 13);
        contentPane.add(lblValorReserva);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(22, 391, 240, 19);
        contentPane.add(textField);

        JLabel lblFormasPago = new JLabel("Forma de pago");
        lblFormasPago.setBounds(22, 454, 240, 13);
        contentPane.add(lblFormasPago);

        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(96, 517, 85, 21);
        contentPane.add(btnContinuar);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito", "Debito" }));
        comboBox.setBounds(22, 477, 240, 21);
        contentPane.add(comboBox);
        
        JLabel lblRegistro = new JLabel("");
        lblRegistro.setBounds(335, 0, 369, 595);
        contentPane.add(lblRegistro);
        MenuUser.setImagenDeFondoLabel(lblRegistro,rutaImagenBackGroundReserva );
        
        JLabel lblNewLabel = new JLabel("Sistema de Reserva");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(SystemColor.textHighlight);
        lblNewLabel.setBounds(82, 123, 267, 29);
        contentPane.add(lblNewLabel);
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(22, 20, 92, 79);
        contentPane.add(lblLogo);
        MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);

        datePickerCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date checkInDate = datePickerCheckIn.getDate();
                System.out.println("Fecha de Check In: " + checkInDate);
            }
        });

        datePickerCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date checkInDate = datePickerCheckIn.getDate();
                Date checkOutDate = datePickerCheckOut.getDate();
                long diff = checkOutDate.getTime() - checkInDate.getTime();
                long diffDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                
                System.out.println("Diferencia de días: " + diffDays);
                textField.setText(String.valueOf(diffDays * 20));
            }
        });

        btnContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root", "@Merica1");

                    // Obtener los datos de reserva
                    Date checkInDate = datePickerCheckIn.getDate();
                    Date checkOutDate = datePickerCheckOut.getDate();
                    String valorReserva = textField.getText();
                    String numeroReserva = UUID.randomUUID().toString();

                    System.out.println(numeroReserva);

                    if (formularioFrame == null) {
                        formularioFrame = new Formulario();
                        formularioFrame.setConnection(connection);
                    }

                    formularioFrame.setDatosReserva(checkInDate, checkOutDate, valorReserva, numeroReserva);
                    formularioFrame.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
