package entidades;


public class RedSocial {
	private int id;
	private String cuenta;
	private enumerator.TipoRedSocial tipo;
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
	 * @return the cuenta
	 */
	public String getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	/**
	 * @return the tipo
	 */
	public enumerator.TipoRedSocial getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(enumerator.TipoRedSocial tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return this.cuenta;
	}
}
