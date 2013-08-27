package vistas;

import java.util.List;

public class AgendaConsola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Contactos:");
		List<entidades.Contacto> contactos = new negocio.Agenda()
				.getContactos();
		if (contactos != null)
			for (entidades.Contacto contacto : contactos) {
				System.out.println(contacto.getNombre());
				// Imprimir sus numeros telefonicos
				System.out.println("Sus Telefonos: ");
				for (entidades.Telefono telefonos : contacto.getTelefonos()) {
					System.out.println("\t" + telefonos.getNumero()
							+ ", Tipo: " + telefonos.getTipo());
				}
				// Imprimir sus redes sociales
				System.out.println("Redes Sociales:");
				for (entidades.RedSocial redSocial : contacto.getRedes()) {
					System.out.println("\tCuenta: " + redSocial.getCuenta()
							+ ", Tipo: " + redSocial.getTipo().getName());
				}
				System.out
						.println("--------------------------------------------");
			}
		else
			System.out.println("No tiene contactos");

	}

}
