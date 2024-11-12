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
public class Seguidor extends Mortifago {

    public Seguidor(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
        super(nombre, puntosDeVida, nivelDeMagia, energia, 1);

        this.agregarHechizo(new Protego());
        this.agregarHechizo(new AvadaKedavra());
    }

    // Método para lanzar un hechizo de apoyo a un aliado
    public void lanzarHechizoApoyo(Personaje aliado) {
        if (getEnergia() > 10) {
            System.out.println(getNombre() + " lanza un hechizo de apoyo para " + aliado.getNombre());
            restarEnergia(10);
            aliado.sumarPuntosDeVida(20); // Cura un poco al aliado
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo de apoyo.");
        }
    }
    
    // Método para aumentar temporalmente la resistencia
    public void aumentarResistencia() {
        if (getEnergia() > 12) {
            System.out.println(getNombre() + " usa aumentar resistencia, volviéndose más difícil de dañar.");
            restarEnergia(12);
            sumarPuntosDeVida(15); // Recupera algo de vida o aumenta su resistencia de alguna manera
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para aumentar su resistencia.");
        }
    }

}
