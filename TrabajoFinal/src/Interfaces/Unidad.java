/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Diego
 */
public interface Unidad {

    void atacar(Unidad objetivo); // permite atacar a otro objeto "Unidad"

    boolean estaVivo(); // verifica si el personaje o batallón sigue en combate
}
