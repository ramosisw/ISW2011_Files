package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionMySQL;

public class Telefonos {
	public List<entidades.Telefono> getTelefonos(int id_contacto) {
		List<entidades.Telefono> telefonos = new ArrayList<entidades.Telefono>();
		ConexionMySQL mysql = new ConexionMySQL();
		Connection conn = mysql.getConexion();
		String query = "SELECT * FROM tbl_telefonos WHERE id_contacto= ? ;";
		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id_contacto);
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				
				// crear un nuevo telefono para el contacto
				entidades.Telefono telefono = new entidades.Telefono();
				// obtener los datos de ese numero telefonico
				telefono.setId(rs.getInt("id"));
				telefono.setNumero(rs.getString("numero"));
				telefono.setTipo(rs.getString("tipo"));
				// Agregar el telefono del contacto a la lista de sus telefonos
				telefonos.add(telefono);
				
			}
		} catch (SQLException ex) {
			// Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE,
			// null, ex);
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				// Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE,
				// null, ex);
			}
		}
		return telefonos;
	}
}
