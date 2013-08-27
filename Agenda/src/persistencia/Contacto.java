package persistencia;

import java.util.List;
import java.util.ArrayList;
import dataBase.ConexionMySQL;
import java.sql.*;

public class Contacto {

	public List<entidades.Contacto> getContactos() {
		List<entidades.Contacto> contactos= new ArrayList<entidades.Contacto>();
		ConexionMySQL mysql = new ConexionMySQL();
        Connection conn = mysql.getConexion();
        String query="SELECT * FROM tbl_contacto ORDER BY nombre;";
        Statement st;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
            	//crear un nuevo contato para la agenda
                entidades.Contacto contacto=new entidades.Contacto();
                //obtener los datos del contacto
                contacto.setId(rs.getInt("id"));
                contacto.setNombre(rs.getString("nombre"));
                contacto.setDireccion(rs.getString("direccion"));
                //agregar el contacto a la lista de la agenda
                contactos.add(contacto);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                //Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
		return contactos;
	}
	
}
