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
	    if (hechizos.isEmpty()) {
	        System.out.println(nombre + " no tiene hechizos para lanzar.");
	        return;
	    }

	    // Seleccionamos un hechizo aleatorio
	    Random random = new Random();
	    int indice = random.nextInt(hechizos.size());
	    Hechizo hechizoSeleccionado = hechizos.get(indice);

	    // Verificamos que el hechizo sea ofensivo y si el nivel de magia es suficiente
	    if (hechizoSeleccionado.esOfensivo()) {
	        // Usamos la constante NIVEL_REQUERIDO directamente desde la clase del hechizo
	        try {
	            // Accedemos a la constante NIVEL_REQUERIDO de la clase del hechizo
	            int nivelRequerido = (int) hechizoSeleccionado.getClass().getField("NIVEL_REQUERIDO").get(null);

	            if (nivelDeMagia < nivelRequerido) {
	                System.out.println(nombre + " no tiene el nivel suficiente para lanzar " + hechizoSeleccionado.getClass().getSimpleName() + ".");
	                return;
	            }
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            System.out.println("Error al acceder al nivel requerido del hechizo.");
	            e.printStackTrace();
	            return;
	        }
	        
	        // Llamamos a ejecutar en el hechizo seleccionado para infligir el daño
	        hechizoSeleccionado.ejecutar(this, (Personaje) objetivo);
	    } else {
	        System.out.println(nombre + " intentó lanzar un hechizo no ofensivo.");
	    }
	}

	@Override
	public boolean estaVivo() {
		return puntosDeVida > 0;
	}
	
	@Override
    public void recibirDaño() {
        this.puntosDeVida -= this.nivelDeMagia * this.multiplicadorDeHechizo;
        if (this.puntosDeVida <= 0) {
            this.puntosDeVida = 0;
            System.out.println(this.nombre + " ha sido derrotado.");
        }
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
	    if (this.energia > energiaMax) {
	        this.energia = energiaMax;  // Aseguramos que la energía no exceda el máximo
	    }
	}
	
	public void restarEnergia(int energia) {
		this.energia -= Math.abs(energia);
	}
	
	
	public void sumarPuntosDeVida(double d) {
		if(d <= 0)
			throw new Error("Puntos de vida debe ser positivo.");
			
		if(this.puntosDeVida + d > this.puntosDeVidaMax) {
			this.puntosDeVida = this.puntosDeVidaMax;
		}else {			
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


	public int getEnergiaMax() {
		return this.energiaMax;
	}


	public double getPuntosDeVidaMax() {
		return this.puntosDeVidaMax;
	}
			
}

