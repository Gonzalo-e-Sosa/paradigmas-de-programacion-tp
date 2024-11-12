package Clases.Hechizos;
import Clases.Personajes.Personaje;
import Interfaces.Hechizo;
import org.jpl7.Query;

public class Expelliarmus implements Hechizo {
    private int costo = 50;
    public static final int NIVEL_REQUERIDO = 3;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        Query q = new Query("puede_lanzar_hechizo(expelliarmus, "
                + lanzador.getEnergia() + ", " + lanzador.getNivelDeMagia() + ").");

        // Si tiene energia y nivel, lo tira
        if (q.hasSolution()) {
            System.out.println(lanzador.getNombre() + " lanza AvadaKedabra!");
        } else {
            System.out.println(lanzador.getNombre() + " no puede lanzar AvadaKedabra!");
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
