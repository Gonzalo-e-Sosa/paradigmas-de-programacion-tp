package clases.personajes;

public class Comandante extends Mortifago {
	
	public Comandante(String nombre, double puntosDeVida, int nivelDeMagia, int energia, double d) {
		super(nombre, puntosDeVida, nivelDeMagia, energia, 2);
	}
	
    public void inspirarAliados() {
        System.out.println(getNombre() + " inspira a sus aliados, restaurándoles energía.");
        sumarEnergia(15);
    }

    // Método de ataque poderoso
    public void ataquePoderoso(Personaje objetivo) {
        if (getEnergia() > 25) {
            System.out.println(getNombre() + " realiza un ataque poderoso contra " + objetivo.getNombre());
            restarEnergia(25);
            objetivo.restarPuntosDeVida(40 * getmultiplicadorDeHechizo());
        } else {
            System.out.println(getNombre() + " no tiene suficiente energía para un ataque poderoso.");
        }
    }
}
