package Hechizos;

import Personajes.Personaje;
import Interfaces.Hechizo;


public class AvadaKedavra implements Hechizo{
	private int danioBase = 20;
	private int costo = 30;
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if(costo > lanzador.getEnergia()) {
			System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar AvadaKedavra!");
			return;
		}
		objetivo.danio(danioBase * lanzador.getXMulti());
		lanzador.gastoEnergia(costo);
		System.out.println("El personaje " + objetivo.getNombre() + ", ha sido atacado por " + lanzador.getNombre() + "!");
		System.out.println("A" + objetivo.getNombre() + " solo le queda: " + objetivo.getPuntosDeVida() + " de vida!");
	}
}