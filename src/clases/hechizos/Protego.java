package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;

public class Protego implements Hechizo {
    private int curaBase = 50;
    private int costo = 10;
    public static final int NIVEL_REQUERIDO = 1;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        if (costo > lanzador.getEnergia()) {
            System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar Protego!");
            return;
        }
        objetivo.sumarPuntosDeVida((int) Math.round(curaBase * lanzador.getmultiplicadorDeHechizo()));
        lanzador.restarEnergia(costo);
        System.out.println("El personaje objetivo " + objetivo.getNombre() + ", ha sido protegido por " + lanzador.getNombre() + ".");
    }

    @Override
    public boolean esOfensivo() {
        return false;
    }
}
