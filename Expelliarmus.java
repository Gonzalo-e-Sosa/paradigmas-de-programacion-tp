package Hechizos;

import Personajes.Personaje;
import Interfaces.Hechizo;

public class Expelliarmus implements Hechizo {
	private int costo = 50;
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if(costo > lanzador.getEnergia()) {
			System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar Expelliarmus!");
			return;
		}
		objetivo.gastoEnergia(objetivo.getEnergia());
		lanzador.gastoEnergia(costo);
		System.out.println("El personaje objetivo " + objetivo.getNombre() + ", ha sido desarmado por " + lanzador.getNombre() + ".");
	}

}