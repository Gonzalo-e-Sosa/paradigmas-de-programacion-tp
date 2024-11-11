package clases.personajes;

import java.util.ArrayList;
import java.util.Random;

import interfaces.Unidad;
import interfaces.Hechizo;


public abstract class Personaje implements Unidad{	
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
	    do {
	    	indice = random.nextInt(hechizos.size());
	    }while(!(hechizos.get(indice).esOfensivo()));
	    
		Hechizo hechizoSeleccionado = hechizos.get(indice);
	    		
	    if (objetivo instanceof Personaje) {
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

	public int getNivelDeMagia() {
		return nivelDeMagia;
	}

	public int getEnergia() {
		return energia;
	}
	
	public void setEnergia(int energia) {
		if(energia<= 0)
			throw new Error("Enegia debe ser un valor positivo.");
			
		this.energia = energia;
	}

	public void sumarEnergia(int energia) {
		if(energia <= 0)
			throw new Error("Energía debe ser un valor positivo.");
		this.energia += energia;
	}
	
	public void restarEnergia(int energia) {
		this.energia -= Math.abs(energia);
	}
	
	
	public void sumarPuntosDeVida(int puntosDeVida) {
		if(puntosDeVida <= 0)
			throw new Error("Puntos de vida debe ser positivo.");
			
		if(this.puntosDeVida + puntosDeVida > this.puntosDeVidaMax) {
			this.puntosDeVida = this.puntosDeVidaMax;
		}else {			
			this.puntosDeVida += puntosDeVida;
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
	}
}