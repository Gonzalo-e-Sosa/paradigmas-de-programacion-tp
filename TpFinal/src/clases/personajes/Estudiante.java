package clases.personajes;

public class Estudiante extends Mago {
	
	public Estudiante(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
		super(nombre, puntosDeVida, nivelDeMagia, energia, 0.5);
	}
	
    public void lanzarHechizoBasico(Personaje objetivo) {
        if (getEnergia() > 8) {
            System.out.println(getNombre() + " lanza un hechizo básico contra " + objetivo.getNombre());
            restarEnergia(8);
            objetivo.restarPuntosDeVida(15 * getmultiplicadorDeHechizo());
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo básico.");
        }
    }

    // Método de concentración para recuperar energía
    public void concentrarse() {
        System.out.println(getNombre() + " se concentra y recupera energía.");
        sumarEnergia(10);
    }
}
