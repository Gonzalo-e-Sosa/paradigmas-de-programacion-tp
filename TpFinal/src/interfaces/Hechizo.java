package interfaces;

import clases.personajes.Personaje;

public interface Hechizo {
    void ejecutar(Personaje lanzador, Personaje objetivo);
    boolean esOfensivo();
    public int obtenerDaño();
    
    // Agregamos la constante que cada hechizo implementará
    int NIVEL_REQUERIDO = 0;  // Valor por defecto, que puede ser sobrescrito en cada hechizo

	String getNombre();
	int getNivelRequerido();
}

