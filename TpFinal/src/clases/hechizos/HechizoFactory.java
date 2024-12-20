package clases.hechizos;

import clases.personajes.Personaje;
import interfaces.Hechizo;

public class HechizoFactory {
    public static Hechizo crearHechizo(String tipoHechizo, Personaje lanzador) {
        switch (tipoHechizo.toLowerCase()) {
            case "avadakedavra":
                if (lanzador.getNivelDeMagia() >= AvadaKedavra.NIVEL_REQUERIDO) {
                    return new AvadaKedavra();
                }
                break;
            case "expelliarmus":
                if (lanzador.getNivelDeMagia() >= Expelliarmus.NIVEL_REQUERIDO) {
                    return new Expelliarmus();
                }
                break;
            case "protego":
                if (lanzador.getNivelDeMagia() >= Protego.NIVEL_REQUERIDO) {
                    return new Protego();
                }
                break;
            default:
                System.out.println("Tipo de hechizo no reconocido.");
        }
        System.out.println("El nivel de magia de " + lanzador.getNombre() + " no es suficiente para lanzar " + tipoHechizo);
        return null;
    }
}


