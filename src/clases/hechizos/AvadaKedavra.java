package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;


public class AvadaKedavra implements Hechizo{
	private int danioBase = 20;
	private int costo = 30;
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if(costo > lanzador.getEnergia()) {
			System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar AvadaKedavra!");
			return;
		}
		objetivo.restarPuntosDeVida(danioBase * lanzador.getmultiplicadorDeHechizo());
		lanzador.restarEnergia(costo);
		System.out.println("El personaje " + objetivo.getNombre() + ", ha sido atacado por " + lanzador.getNombre() + "!");
		System.out.println("A" + objetivo.getNombre() + " solo le queda: " + objetivo.getPuntosDeVida() + " de vida!");
	}
	
	@Override
	public boolean esOfensivo() {
		return true;
	}
}