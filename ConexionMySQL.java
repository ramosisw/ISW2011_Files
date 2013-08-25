package persistencia;

import java.sql.*;

public class ConexionMySQL {

	private Connection conexion;
	private String url;

	public ConexionMySQL(String servidor, String database, String usuario,
			String password) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			url = "jdbc:mysql://" + servidor + "/" + database;
			conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexion a Base de Datos " + url
					+ " . . . . .Ok");

		} catch (SQLException ex) {
			System.out.println(ex);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
		}
	}

	public Connection getConexion() {
		return conexion;
	}

	public Connection cerrarConexion() {
		try {
			conexion.close();
			System.out.println("Cerrando conexion a " + url + " . . . . . Ok");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		conexion = null;
		return conexion;
	}

}
