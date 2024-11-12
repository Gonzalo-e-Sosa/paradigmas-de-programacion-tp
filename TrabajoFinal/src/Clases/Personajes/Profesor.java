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
public class Profesor extends Mago {

    public Profesor(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
        super(nombre, puntosDeVida, nivelDeMagia, energia, 1);
        
        this.agregarHechizo(new Protego());
        this.agregarHechizo(new AvadaKedavra());
    }

    public void mejorarHabilidadAliado(Personaje aliado) {
        System.out.println(getNombre() + " mejora la habilidad mágica de " + aliado.getNombre());
        aliado.sumarEnergia(10);  // Podrías aumentar otro atributo según lo que defina la habilidad
    }

    // Método para lanzar un hechizo protector
    public void lanzarHechizoProtector() {
        if (getEnergia() > 15) {
            System.out.println(getNombre() + " lanza un hechizo protector sobre sí mismo.");
            restarEnergia(15);
            sumarPuntosDeVida(30); // Recupera vida como efecto del hechizo protector
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo protector.");
        }
    }

}
