package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;

public class Protego implements Hechizo{
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		System.out.println("El personaje objetivo " + objetivo.getNombre() + ", ha sido protegido por " + lanzador.getNombre() + ".");
	}

}
