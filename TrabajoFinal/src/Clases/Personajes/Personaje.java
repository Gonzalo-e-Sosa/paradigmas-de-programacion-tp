package Clases.Personajes;

import java.util.*;
import Interfaces.Unidad;
import Interfaces.Hechizo;

public class Personaje implements Unidad {

    private String nombre;
    private double puntosDeVidaMax;
    private double puntosDeVida;
    private int nivelDeMagia;
    private int energiaMax;
    private int energia;
    private double multiplicadorDeHechizo;
    private ArrayList<Hechizo> hechizos;

    public Personaje(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double multiplicadorDeHechizo) {
        this.nombre = nombre;
        this.puntosDeVidaMax = puntosDeVida;
        this.puntosDeVida = puntosDeVida;
        this.nivelDeMagia = nivelDeMagia;
        this.energiaMax = energia;
        this.energia = energia;
        this.multiplicadorDeHechizo = multiplicadorDeHechizo;
        this.hechizos = new ArrayList<>();
    }

    @Override
    public void atacar(Unidad objetivo) {
        //Simular ataque
        if (hechizos.isEmpty()) {
            System.out.println(nombre + " no tiene hechizos para lanzar.");
            return;
        }

        // Selecciona un hechizo aleatorio de la lista
        Random random = new Random();
        int indice;
            indice = random.nextInt(hechizos.size());

        Hechizo hechizoSeleccionado = hechizos.get(indice);

        
        
        if (nivelDeMagia < Hechizo.NIVEL_REQUERIDO) {
            System.out.println(nombre + " no tiene el nivel suficiente para lanzar " + hechizoSeleccionado.getClass().getSimpleName() + ".");
            return; // No lanzar el hechizo si no tiene el nivel adecuado
        }

        if(objetivo instanceof Personaje) {
        	Personaje enemigo = (Personaje) objetivo;
        	
        	// Ejecuta el hechizo sobre el objetivo
        	hechizoSeleccionado.ejecutar(this, enemigo);
        	System.out.println(nombre + " lanza " + hechizoSeleccionado.getClass().getSimpleName() + " a " + enemigo.getNombre());        	
        }
    }

    @Override
    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntosDeVida() {
        return puntosDeVida;
    }

    public double getPuntosDeVidaMax() {
        return puntosDeVida;
    }

    public int getNivelDeMagia() {
        return nivelDeMagia;
    }

    public int getEnergia() {
        return energia;
    }
    
    public int getEnergiaMax() {
        return energiaMax;
    }

    public void setEnergia(int energia) {
        if (energia <= 0) {
            throw new Error("Enegia debe ser un valor positivo.");
        }

        this.energia = energia;
    }

    public void sumarEnergia(int energia) {
        if (energia <= 0) {
            throw new Error("Energía debe ser un valor positivo.");
        }
        this.energia += energia;
        if (this.energia > energiaMax) {
            this.energia = energiaMax;  // Aseguramos que la energía no exceda el máximo
        }
    }

    public void restarEnergia(int energia) {
        this.energia -= Math.abs(energia);
    }

    public void sumarPuntosDeVida(double d) {
        if (d <= 0) {
            throw new Error("Puntos de vida debe ser positivo.");
        }

        if (this.puntosDeVida + d > this.puntosDeVidaMax) {
            this.puntosDeVida = this.puntosDeVidaMax;
        } else {
            this.puntosDeVida += d;
        }
    }

    public void restarPuntosDeVida(double puntosDeVida) {
        this.puntosDeVida -= Math.abs(puntosDeVida);
    }

    public double getmultiplicadorDeHechizo() {
        return this.multiplicadorDeHechizo;
    }

    public ArrayList<Hechizo> getHechizos() {
        return hechizos;
    }

    public void agregarHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
        System.out.println("Hechizo " + hechizo.getClass().getSimpleName() + " agregado a " + nombre);
    }
}
