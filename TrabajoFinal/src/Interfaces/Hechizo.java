/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import Clases.Personajes.*;

/**
 *
 * @author Diego
 */
public interface Hechizo {

    void ejecutar(Personaje lanzador, Personaje objetivo);

    boolean esOfensivo();

    //public int obtenerDaño();

    // Agregamos la constante que cada hechizo implementará
    int NIVEL_REQUERIDO = 0;  // Valor por defecto, que puede ser sobrescrito en cada hechizo
}
