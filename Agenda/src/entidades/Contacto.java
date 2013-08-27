package entidades;
import java.util.List;
public class Contacto {
	private int id;
	private String nombre;
	private String direccion;
	private List<Telefono> telefonos;
	private List<RedSocial> redes;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefonos
	 */
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	/**
	 * @return the redes
	 */
	public List<RedSocial> getRedes() {
		return redes;
	}
	/**
	 * @param redes the redes to set
	 */
	public void setRedes(List<RedSocial> redes) {
		this.redes = redes;
	}
	
	public String toString(){
		return nombre;
	}
	
}
