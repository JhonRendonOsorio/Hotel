package com.alura.tests;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldBusqueda;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private JButton btnMenuUser;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Busqueda frame = new Busqueda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Busqueda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 959, 675);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textFieldBusqueda = new JTextField();
        textFieldBusqueda.setBounds(607, 164, 210, 19);
        contentPane.add(textFieldBusqueda);
        textFieldBusqueda.setColumns(10);
        
        String rutaImagenBackGroundIcono = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\lupa.png";

        JButton btnBusqueda = new JButton("");
        btnBusqueda.setBackground(new Color(255, 255, 255));
        btnBusqueda.setBounds(831, 134, 61, 49);
        contentPane.add(btnBusqueda);
        MenuUser.setImagenDeFondoBoton(btnBusqueda, rutaImagenBackGroundIcono);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(43, 193, 849, 287);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setBackground(Color.white);
        scrollPane.setViewportView(table);
        scrollPane.setBackground(Color.white);
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        tableModel.addColumn("Check In");
        tableModel.addColumn("Check Out");
        tableModel.addColumn("Pagar");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Fecha de Nacimiento");
        tableModel.addColumn("Nacionalidad");
        tableModel.addColumn("Teléfono");
        tableModel.addColumn("Número de Reserva");
        
        btnBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = textFieldBusqueda.getText();
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario",
                        "root", "@Merica1")) {
                    String consulta = "SELECT checkin, checkout, pagar, nombre, apellido, facimiento, nacionalidad, telefono, numreserva FROM clientes WHERE checkin LIKE ? OR checkout LIKE ? OR pagar LIKE ? OR nombre LIKE ? OR apellido LIKE ? OR facimiento LIKE ? OR nacionalidad LIKE ? OR telefono LIKE ? OR numreserva LIKE ?";

                    PreparedStatement statement = connection.prepareStatement(consulta);
                    String parametro = "%" + textoBusqueda + "%";
                    for (int i = 1; i <= 9; i++) {
                        statement.setString(i, parametro);
                    }
                    ResultSet resultSet = statement.executeQuery();
                    tableModel.setRowCount(0);
                    while (resultSet.next()) {
                        Date checkIn = resultSet.getDate("checkin");
                        Date checkOut = resultSet.getDate("checkout");
                        String pagar = resultSet.getString("pagar");
                        String nombre = resultSet.getString("nombre");
                        String apellido = resultSet.getString("apellido");
                        String facimiento = resultSet.getString("facimiento");
                        String nacionalidad = resultSet.getString("nacionalidad");
                        String telefono = resultSet.getString("telefono");
                        String numReserva = resultSet.getString("numreserva");

                        Object[] row = {checkIn, checkOut, pagar, nombre, apellido, facimiento, nacionalidad, telefono, numReserva};
                        tableModel.addRow(row);
                    }
                    resultSet.close();
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        String rutaImagenBackGrounEditar = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\editar.png";
        btnEditar = new JButton("");
        btnEditar.setBackground(new Color(255, 255, 255));
        btnEditar.setBounds(569, 567, 45, 41);
        contentPane.add(btnEditar);
        MenuUser.setImagenDeFondoBoton(btnEditar, rutaImagenBackGrounEditar);
        btnEditar.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String checkIn = table.getValueAt(selectedRow, 0).toString();
                String checkOut = table.getValueAt(selectedRow, 1).toString();
                String pagar = table.getValueAt(selectedRow, 2).toString();
                String nombre = table.getValueAt(selectedRow, 3).toString();
                String apellido = table.getValueAt(selectedRow, 4).toString();
                String facimiento = table.getValueAt(selectedRow, 5).toString();
                String nacionalidad = table.getValueAt(selectedRow, 6).toString();
                String telefono = table.getValueAt(selectedRow, 7).toString();
                String numReserva = table.getValueAt(selectedRow, 8).toString();

                String nuevoCheckIn = obtenerNuevoValor(checkIn);
                String nuevoCheckOut = obtenerNuevoValor(checkOut);
                String nuevoPagar = obtenerNuevoValor(pagar);
                String nuevoNombre = obtenerNuevoValor(nombre);
                String nuevoApellido = obtenerNuevoValor(apellido);
                String nuevoFacimiento = obtenerNuevoValor(facimiento);
                String nuevaNacionalidad = obtenerNuevoValor(nacionalidad);
                String nuevoTelefono = obtenerNuevoValor(telefono);
                String nuevoNumReserva = obtenerNuevoValor(numReserva);

                table.setValueAt(nuevoCheckIn, selectedRow, 0);
                table.setValueAt(nuevoCheckOut, selectedRow, 1);
                table.setValueAt(nuevoPagar, selectedRow, 2);
                table.setValueAt(nuevoNombre, selectedRow, 3);
                table.setValueAt(nuevoApellido, selectedRow, 4);
                table.setValueAt(nuevoFacimiento, selectedRow, 5);
                table.setValueAt(nuevaNacionalidad, selectedRow, 6);
                table.setValueAt(nuevoTelefono, selectedRow, 7);
                table.setValueAt(nuevoNumReserva, selectedRow, 8);

                actualizarValoresEnBaseDeDatos(checkIn, nuevoCheckIn, checkOut, nuevoCheckOut, pagar, nuevoPagar, nombre, nuevoNombre, apellido, nuevoApellido, facimiento, nuevoFacimiento, nacionalidad, nuevaNacionalidad, telefono, nuevoTelefono, numReserva, nuevoNumReserva);

                JOptionPane.showMessageDialog(null, "Los valores se han actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila.");
            }
        });

        btnEliminar = new JButton("");
        btnEliminar.setBackground(new Color(255, 255, 255));
        btnEliminar.addActionListener(e -> eliminarFilaSeleccionada());
        btnEliminar.setBounds(648, 567, 45, 41);
        contentPane.add(btnEliminar);
        String rutaImagenBackGrounEliminar = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\delete.png";
        MenuUser.setImagenDeFondoBoton(btnEliminar, rutaImagenBackGrounEliminar);
        
        btnCancelar = new JButton("");
        btnCancelar.setBackground(new Color(255, 255, 255));
        btnCancelar.setBounds(726, 567, 45, 41);
        contentPane.add(btnCancelar);
        btnCancelar.addActionListener(e -> System.exit(0));
        String rutaImagenBackGroundCancel = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\cancel.png";
        MenuUser.setImagenDeFondoBoton(btnCancelar, rutaImagenBackGroundCancel);

        btnMenuUser = new JButton("");
        btnMenuUser.setBackground(new Color(255, 255, 255));
        btnMenuUser.setBounds(847, 567, 45, 41);
        contentPane.add(btnMenuUser);
        String rutaImagenBackGroundMenuuser = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\exit.png";
        MenuUser.setImagenDeFondoBoton(btnMenuUser, rutaImagenBackGroundMenuuser);
        
        String rutaImagenBackGroundLogo = "C:\\Users\\jhono\\eclipse-workspace\\hotel\\img\\logo.png";
        JLabel lblLogo = new JLabel("");
        lblLogo.setBounds(43, 27, 141, 115);
        contentPane.add(lblLogo);
        MenuUser.setImagenDeFondoLabel(lblLogo, rutaImagenBackGroundLogo);
        btnMenuUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuUser frameMenu = new MenuUser();
                frameMenu.setVisible(true);
                dispose();
            }
        });
    }

    private String obtenerNuevoValor(String valorActual) {
        String nuevoValor = JOptionPane.showInputDialog(null, "Ingrese el nuevo valor:", valorActual);
        if (nuevoValor != null) {
            return nuevoValor;
        } else {
            return valorActual;
        }
    }

    private void actualizarValoresEnBaseDeDatos(String checkInAnterior, String nuevoCheckIn, String checkOutAnterior, String nuevoCheckOut,
                                                String pagarAnterior, String nuevoPagar, String nombreAnterior, String nuevoNombre, String apellidoAnterior, String nuevoApellido,
                                                String facimientoAnterior, String nuevoFacimiento, String nacionalidadAnterior, String nuevaNacionalidad,
                                                String telefonoAnterior, String nuevoTelefono, String numReservaAnterior, String nuevoNumReserva) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root",
                "@Merica1")) {
            String consulta = "UPDATE clientes SET checkin = ?, checkout = ?, pagar = ?, nombre = ?, apellido = ?, facimiento = ?, nacionalidad = ?, telefono = ?, numreserva = ? WHERE checkin = ? AND checkout = ? AND pagar = ? AND nombre = ? AND apellido = ? AND facimiento = ? AND nacionalidad = ? AND telefono = ? AND numreserva = ?";

            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, nuevoCheckIn);
            statement.setString(2, nuevoCheckOut);
            statement.setString(3, nuevoPagar);
            statement.setString(4, nuevoNombre);
            statement.setString(5, nuevoApellido);
            statement.setString(6, nuevoFacimiento);
            statement.setString(7, nuevaNacionalidad);
            statement.setString(8, nuevoTelefono);
            statement.setString(9, nuevoNumReserva);
            statement.setString(10, checkInAnterior);
            statement.setString(11, checkOutAnterior);
            statement.setString(12, pagarAnterior);
            statement.setString(13, nombreAnterior);
            statement.setString(14, apellidoAnterior);
            statement.setString(15, facimientoAnterior);
            statement.setString(16, nacionalidadAnterior);
            statement.setString(17, telefonoAnterior);
            statement.setString(18, numReservaAnterior);

            System.out.println("Consulta de actualización: " + statement.toString());

            int filasActualizadas = statement.executeUpdate();
            System.out.println("Filas actualizadas: " + filasActualizadas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarFilaSeleccionada() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String checkIn = table.getValueAt(selectedRow, 0).toString();
            String checkOut = table.getValueAt(selectedRow, 1).toString();
            String pagar = table.getValueAt(selectedRow, 2).toString();
            String nombre = table.getValueAt(selectedRow, 3).toString();
            String apellido = table.getValueAt(selectedRow, 4).toString();
            String facimiento = table.getValueAt(selectedRow, 5).toString();
            String nacionalidad = table.getValueAt(selectedRow, 6).toString();
            String telefono = table.getValueAt(selectedRow, 7).toString();
            String numReserva = table.getValueAt(selectedRow, 8).toString();

            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/formulario", "root", "@Merica1")) {
                String consulta = "DELETE FROM clientes WHERE checkin = ? AND checkout = ? AND pagar = ? AND nombre = ? AND apellido = ? AND facimiento = ? AND nacionalidad = ? AND telefono = ? AND numreserva = ?";
                PreparedStatement statement = connection.prepareStatement(consulta);
                statement.setString(1, checkIn);
                statement.setString(2, checkOut);
                statement.setString(3, pagar);
                statement.setString(4, nombre);
                statement.setString(5, apellido);
                statement.setString(6, facimiento);
                statement.setString(7, nacionalidad);
                statement.setString(8, telefono);
                statement.setString(9, numReserva);

                int filasEliminadas = statement.executeUpdate();
                System.out.println("Filas eliminadas: " + filasEliminadas);

                tableModel.removeRow(selectedRow);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila.");
        }
    }
}
