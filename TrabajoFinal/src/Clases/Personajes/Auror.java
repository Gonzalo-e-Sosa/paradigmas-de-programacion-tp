/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases.Personajes;

import Clases.Hechizos.AvadaKedavra;
import Clases.Hechizos.Expelliarmus;
import Clases.Hechizos.Protego;

/**
 *
 * @author Diego
 */
public class Auror extends Mago {

    public Auror(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
        super(nombre, puntosDeVida, nivelDeMagia, energia, 1.5);
    }

    // Método especial de auror para desarmar al enemigo
    public void lanzarHechizoDesarme(Personaje objetivo) {
        if (getEnergia() > 12) {
            System.out.println(getNombre() + " lanza un hechizo de desarme contra " + objetivo.getNombre());
            restarEnergia(12);
            objetivo.restarPuntosDeVida(20 * getmultiplicadorDeHechizo());
            // Podrías incluir lógica para reducir temporalmente el ataque del objetivo
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo de desarme.");
        }
    }
}
