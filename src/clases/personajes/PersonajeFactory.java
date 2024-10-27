package clases.personajes;

public class PersonajeFactory {

	public static Mago crearMago() {
		// TODO Auto-generated method stub
		return new Mago(null, 0, 0);
	}

	public static Mortifago crearMortifago() {
		// TODO Auto-generated method stub
		return new Mortifago(null, 0, 0);
	}

}
