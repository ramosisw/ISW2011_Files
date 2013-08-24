package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Julio C. Ramos
 * @e-mail ramos.isw@gmail.com
 */
public class Conexion {

    public String db = "db_biblioteca";
    public String url = "jdbc:mysql://localhost:3306/" + db;
    public String user = "root";
    public String pass = "root";

    public Connection Conectar() {

        Connection link = null;

        try {
            //Aqui se carga el Driver de MySQL
            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            //Aqui se crea el enlace hacia la base de datos mediante la variable link
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
        }

        return link;
    }
}
