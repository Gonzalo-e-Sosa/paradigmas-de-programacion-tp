package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;


public class AvadaKedavra implements Hechizo{
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		System.out.println("MENSAJE");
	}

}
