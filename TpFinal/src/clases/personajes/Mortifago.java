package clases.personajes;

// ataques oscuros y habilidades especiales
public class Mortifago extends Personaje {

	public Mortifago(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double multiplicador) {
		super(nombre, puntosDeVida, nivelDeMagia, energia, multiplicador);
	}
	   public void lanzarHechizoOscuro(Personaje objetivo) {
	        if (getEnergia() > 20) {
	            System.out.println(getNombre() + " lanza un hechizo oscuro contra " + objetivo.getNombre());
	            restarEnergia(20);
	            objetivo.restarPuntosDeVida(30 * getmultiplicadorDeHechizo()); // Daño aumentado
	        } else {
	            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo oscuro.");
	        }
	    }

	    // Habilidad especial para drenar vida del objetivo
	    public void drenarVida(Personaje objetivo) {
	        if (getEnergia() > 10) {
	            System.out.println(getNombre() + " usa drenar vida contra " + objetivo.getNombre());
	            restarEnergia(10);
	            double danio = 15 * getmultiplicadorDeHechizo();
	            objetivo.restarPuntosDeVida(danio);
	            sumarPuntosDeVida(danio / 2); // Recupera la mitad del daño infligido
	        } else {
	            System.out.println(getNombre() + " no tiene suficiente energía para drenar vida.");
	        }
	    }
}
