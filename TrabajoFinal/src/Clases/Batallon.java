/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.*;
import Clases.Personajes.Personaje;
import Interfaces.Unidad;
/**
 *
 * @author Diego
 */
public class Batallon implements Unidad{

    private List<Unidad> miembros;

    public Batallon() {
        this.miembros = new ArrayList<>();
    }

    public void agregarUnidad(Unidad unidad) {
        miembros.add(unidad);
    }

    public void removerUnidad(Unidad unidad) {
        miembros.remove(unidad);
    }

    @Override
    public void atacar(Unidad objetivo) {
        // Todos los miembros atacan al objetivo
        for (Unidad miembro : miembros) {
            if (miembro.estaVivo()) {
                miembro.atacar(objetivo);
            }
        }
    }

    @Override
    public boolean estaVivo() {
        // Si al menos un miembro está vivo, el batallón sigue en combate
        for (Unidad miembro : miembros) {
            if (miembro.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    public boolean tienePersonajesSaludables() {
        return estaVivo();
    }
    
    public List<Unidad> getMiembros() {
    	return this.miembros;
    }
}
