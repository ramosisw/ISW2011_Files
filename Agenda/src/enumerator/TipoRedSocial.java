package enumerator;

public enum TipoRedSocial {

	FACEBOOK("The Facebook"), TWITTER("Twitter"), GOOGLEPLUS("G+");
	private final String nombre;

	private TipoRedSocial(String nombre) {
		this.nombre = nombre;
	}

	public String getName() {
		return this.nombre;
	}
}
