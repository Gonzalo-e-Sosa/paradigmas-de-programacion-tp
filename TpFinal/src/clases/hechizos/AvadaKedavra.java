package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;

public class AvadaKedavra implements Hechizo {
    private int danioBase = 100;
    private int costo = 30;
    public static final int NIVEL_REQUERIDO = 3;

    @Override
    public void ejecutar(Personaje lanzador, Personaje objetivo) {
        if (lanzador.getEnergia() < costo) {
            System.out.println(lanzador.getNombre() + " no tiene energía suficiente para lanzar " + this.getNombre());
            return;
        }

        lanzador.restarEnergia(costo);
        objetivo.restarPuntosDeVida(danioBase);

        System.out.println(lanzador.getNombre() + " lanza " + this.getNombre() + " sobre " + objetivo.getNombre());
        System.out.println(objetivo.getNombre() + " ha recibido " + danioBase + " puntos de daño.");
        System.out.println(objetivo.getNombre() + " tiene " + objetivo.getPuntosDeVida() + " puntos de vida restantes.");
    }

    @Override
    public boolean esOfensivo() {
        return true;
    }

	@Override
    public int obtenerDaño() {
        // El daño depende del nivel de magia del lanzador
        return this.danioBase;
    }
	
    @Override
    public String getNombre() {
        return "Avada Kedavra";
    }

	@Override
	public int getNivelRequerido() {
		return NIVEL_REQUERIDO;
	}
	
}

