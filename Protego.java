package Hechizos;

import Personajes.Personaje;
import Interfaces.Hechizo;

public class Protego implements Hechizo{
	private int curaBase = 50;
	private int costo = 10;
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if(costo > lanzador.getEnergia()) {
			System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar Protego!");
			return;
		}
		objetivo.curacion(curaBase * lanzador.getXMulti());
		lanzador.gastoEnergia(costo);
		System.out.println("El personaje objetivo " + objetivo.getNombre() + ", ha sido protegido por " + lanzador.getNombre() + ".");
	}

}