package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;

public class Expelliarmus implements Hechizo {
    private int costo = 50;
    public static final int NIVEL_REQUERIDO = 4;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        if (costo > lanzador.getEnergia()) {
            System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar Expelliarmus!");
            return;
        }
        objetivo.restarEnergia(objetivo.getEnergia());
        lanzador.restarEnergia(costo);
        System.out.println("El personaje objetivo " + objetivo.getNombre() + ", ha sido desarmado por " + lanzador.getNombre() + ".");
    }

    @Override
    public boolean esOfensivo() {
        return true;
    }
}
