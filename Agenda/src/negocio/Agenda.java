package negocio;

import entidades.Contacto;
import java.util.*;

public class Agenda {

	public List<Contacto> getContactos() {
		List<Contacto> contactos = new persistencia.Contacto().getContactos();
		// Obtener numeros telefonicos y redes sociales para cada contacto
		for (Contacto contacto : contactos) {
			contacto.setTelefonos(new persistencia.Telefonos()
					.getTelefonos(contacto.getId()));
			contacto.setRedes(new persistencia.RedSocial()
					.getRedesSociales(contacto.getId()));
		}
		//

		return contactos;
	}
}
