package interfaces;

import clases.personajes.Personaje;

public interface Hechizo {
	void ejecutar(Personaje lanzador, Personaje objetivo);
	boolean esOfensivo();
}
