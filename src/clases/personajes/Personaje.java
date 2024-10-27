package clases.personajes;

import java.util.ArrayList;

import interfaces.Hechizo;


public abstract class Personaje{	
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

	public void lanzarHechizo() {
		
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
