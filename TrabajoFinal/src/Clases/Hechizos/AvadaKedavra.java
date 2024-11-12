/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Hechizos;
import Clases.Personajes.Personaje;
import Interfaces.Hechizo;
import org.jpl7.Query;
/**
 *
 * @author Diego
 */

public class AvadaKedavra implements Hechizo{
    private int danioBase = 20;
    private int costo = 30;
    public static final int NIVEL_REQUERIDO = 2;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        
        Query q = new Query("puede_lanzar_hechizo(avadakedavra, "
                + lanzador.getEnergia() + ", " + lanzador.getNivelDeMagia() + ").");

        // Si tiene energia y nivel, lo tira
        if (q.hasSolution()) {
            System.out.println(lanzador.getNombre() + " lanza AvadaKedabra!");
        } else {
            System.out.println(lanzador.getNombre() + " no puede lanzar AvadaKedabra!");
            return;
        }
//        if (costo > lanzador.getEnergia()) {
//            System.out.println(lanzador.getNombre() + " no tiene energia suficiente para lanzar AvadaKedavra!");
//            return;
//        }

        objetivo.restarPuntosDeVida(danioBase * lanzador.getmultiplicadorDeHechizo());
        lanzador.restarEnergia(costo);
        System.out.println("El personaje " + objetivo.getNombre() + ", ha sido atacado por " + lanzador.getNombre() + "!");
        System.out.println("A " + objetivo.getNombre() + " solo le queda: " + objetivo.getPuntosDeVida() + " de vida!");
    }

    @Override
    public boolean esOfensivo() {
        return true;
    }
}
