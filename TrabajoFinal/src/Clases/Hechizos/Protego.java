package Clases.Hechizos;
import Clases.Personajes.Personaje;
import Interfaces.Hechizo;
import org.jpl7.Query;

public class Protego implements Hechizo {
    private int curaBase = 50;
    private int costo = 10;
    public static final int NIVEL_REQUERIDO = 1;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        Query q = new Query("puede_lanzar_hechizo(protego, "
                + lanzador.getEnergia() + ", " + lanzador.getNivelDeMagia() + ").");

        // Si tiene energia y nivel, lo tira
        if (q.hasSolution()) {
            System.out.println(lanzador.getNombre() + " lanza Protego!");
        } else {
            System.out.println(lanzador.getNombre() + " no puede lanzar Protego!");
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
