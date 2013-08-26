package enumerator;
/*
* autor: Julio C. Ramos
* correo: ramos.isw@gmail.com
*/
public enum TipoRedSocial {
  //inicializo los enumeradores con su respectivo nombre
	FACEBOOK("Facebook"), TWITTER("Twitter"), GOOGLEPLUS("G+");
	//creo una variable donde guardar el nombre para mostrar de dicho enumerador
	private final String nombre;
  //metodo para asignar el nombre a cada enumerador
	TipoRedSocial(String nombre) {
		this.nombre = nombre;
	}
  //obtener el nombre del enumerador, es el que esta encerrado entre los parentecis
	public String getName() {
		return this.nombre;
	}
	
	/*Como se usa?
	* para poder asignar el objeto enumerador use la sigiente linea de codigo
	* redSocial.setTipo(enumerator.TipoRedSocial.values()[rs.getInt("tipo")]);
	* siendo rs la consulta y obtener el tipo, el identificador para el numerador que es la posicion
	* y a la hora de imprimir solo obtengo como extra al enumerador el metodo .getName();
	* System.out.println(contacto.getRedSocial().getTipo().getName());
	*para obtener como resultado Facebook, y no FACEBOOK, si no usamos el getName, 
	*se obtendra FACEBOOK como e originalmente el enumerator
	*
	*/ 
}
