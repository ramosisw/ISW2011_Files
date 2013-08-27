package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionMySQL;

public class RedSocial {
	public List<entidades.RedSocial> getRedesSociales(int id_contacto) {
		List<entidades.RedSocial> redesSociales = new ArrayList<entidades.RedSocial>();
		ConexionMySQL mysql = new ConexionMySQL();
		Connection conn = mysql.getConexion();
		String query = "SELECT * FROM tbl_redsocial WHERE id_contacto= ? ;";
		
		
		try {
			PreparedStatement st=conn.prepareStatement(query);
			st.setInt(1, id_contacto);
			
			ResultSet rs =st.executeQuery();
			//System.out.println(rs.getString("cuenta"));
			while (rs.next()) {
				//crear una nueva red social para el contacto
				entidades.RedSocial redSocial = new entidades.RedSocial();
				//obtener los datos para ese red social
				redSocial.setId(rs.getInt("id"));
				redSocial.setCuenta(rs.getString("cuenta"));
				redSocial.setTipo(enumerator.TipoRedSocial.values()[rs.getInt("tipo")]);
				//agregar la red social a la liste de redes sociales
				redesSociales.add(redSocial);

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

		return redesSociales;
	}
}
