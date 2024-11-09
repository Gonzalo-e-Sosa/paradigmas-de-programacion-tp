package clases.personajes;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Unidad;
import interfaces.Hechizo;


public abstract class Personaje implements Unidad{	
	private String nombre;
	private double puntosDeVida;
	private int nivelDeMagia;
	private ArrayList<Hechizo> hechizos;
	
	public Personaje(String nombre, double puntosDeVida, int nivelDeMagia) {
		this.nombre = nombre;
		this.puntosDeVida = puntosDeVida;
		this.nivelDeMagia = nivelDeMagia;
		this.hechizos = new ArrayList<>();
	}

	public void lanzarHechizo(Personaje objetivo) {
	    if (hechizos.isEmpty()) {
	        System.out.println(nombre + " no tiene hechizos para lanzar.");
	        return;
	    }
	    
	    // Selecciona un hechizo aleatorio de la lista
	    Random random = new Random();
	    Hechizo hechizoSeleccionado = hechizos.get(random.nextInt(hechizos.size()));
	    
	    // Ejecuta el hechizo sobre el objetivo
	    hechizoSeleccionado.ejecutar(this, objetivo);
	    System.out.println(nombre + " lanza " + hechizoSeleccionado.getClass().getSimpleName() + " a " + objetivo.getNombre());
		
	}
	
	public void atacar(Unidad objetivo) {
		//Simular ataque
		if(!hechizos.isEmpty()) {
			Hechizo hechizo = hechizos.get(0); // selecciona el primero
            if (objetivo instanceof Personaje) {
                Personaje enemigo = (Personaje) objetivo;
                hechizo.ejecutar(this, enemigo);
            }
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

	public int getNivelDeMagia() {
		return nivelDeMagia;
	}

	public ArrayList<Hechizo> getHechizos() {
		return hechizos;
	}
	
	public void agregarHechizo(Hechizo hechizo) {
        hechizos.add(hechizo);
    }
}