package com.alura.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

public class PruebaConexion extends JFrame{
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/formulario?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "@Merica1");
		System.out.println("cerrando");
		con.close();
	}
}
