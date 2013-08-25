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
			/*
			*si mas adelante en proyectos posteriores necesitan conectarse a una base de datos que no
			*sea local ocuparan colocar un puerto, que sera proporcionado por el administrador
			*pra darles acceso total
			**entonces el url quedaria de la sig. manera
			* url = "jdbc:mysql://" + servidor + ":port/" + database;
			* remplasan la palabra "port" por el numero de puerto para la conexion. MySQL generalmente
			*es 3306
			*
			*/
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
