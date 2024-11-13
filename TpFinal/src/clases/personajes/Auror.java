package clases.personajes;

public class Auror extends Mago {
	
	public Auror(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
		super(nombre, puntosDeVida, nivelDeMagia, energia, 1.5);
	}
    // Método especial de auror para desarmar al enemigo
    public void lanzarHechizoDesarme(Personaje objetivo) {
        if (getEnergia() > 12) {
            System.out.println(getNombre() + " lanza un hechizo de desarme contra " + objetivo.getNombre());
            restarEnergia(12);
            objetivo.restarPuntosDeVida(20 * getmultiplicadorDeHechizo());
            // Podrías incluir lógica para reducir temporalmente el ataque del objetivo
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para lanzar un hechizo de desarme.");
        }
    }
}
