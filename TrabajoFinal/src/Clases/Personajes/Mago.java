/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Personajes;

/**
 *
 * @author Diego
 */
public class Mago extends Personaje {

    public Mago(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double multiplicador) {
        super(nombre, puntosDeVida, nivelDeMagia, energia, multiplicador);
    }

    public void lanzarHechizoDefensivo() {
        if (getEnergia() > 10) {
            System.out.println(getNombre() + " lanza un hechizo defensivo.");
            restarEnergia(10);
            sumarPuntosDeVida(20); // Restaura algunos puntos de vida
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo defensivo.");
        }
    }

    public void lanzarHechizoOfensivo(Personaje objetivo) {
        if (getEnergia() > 15) {
            System.out.println(getNombre() + " lanza un hechizo ofensivo contra " + objetivo.getNombre());
            restarEnergia(15);
            objetivo.restarPuntosDeVida(25 * getmultiplicadorDeHechizo()); // Daño multiplicado por el hechizo
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo ofensivo.");
        }
    }
}
