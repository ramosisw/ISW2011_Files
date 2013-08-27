package dataBase;

import java.sql.*;

public class ConexionMySQL {

	
	private String servidor="localhost";
	private String puerto="3306";
	private String db="app_agenda";
	private String usuario="root";
	private String password=null;
	
	private Connection conexion;
	private String url;
	public ConexionMySQL() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			url = "jdbc:mysql://" + servidor + ":"+puerto+"/" + db;
			conexion = DriverManager.getConnection(url, usuario, password);
			/*System.out.println("Conexion a Base de Datos " + url
					+ " . . . . .Ok");*/

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
