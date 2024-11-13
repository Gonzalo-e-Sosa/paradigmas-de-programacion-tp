package clases.personajes;

import clases.hechizos.HechizoFactory;
import interfaces.Hechizo;

import java.util.Random;

public class PersonajeFactory {
    private static Random random = new Random();

    public static Personaje crearMago() {
        Personaje mago;
        
        // Selecciona un tipo de personaje Mago aleatorio (Auror, Estudiante, Profesor)
        switch (random.nextInt(3)) {
            case 0:
                mago = new Auror("Auror Mago", 1000, 800, 800, 10);
                break;
            case 1:
                mago = new Estudiante("Estudiante Mago", 500, 400, 400, 7);
                break;
            default:
                mago = new Profesor("Profesor Mago", 750, 300, 300, 8);
                break;
        }

        // Asignar hechizos al Mago
        agregarHechizos(mago);

        return mago;
    }
    
    public static Personaje crearMortifago() {
        Personaje mortifago;
        
        // Selecciona un tipo de personaje Mortífago aleatorio (Comandante, Seguidor)
        if (random.nextBoolean()) {
            mortifago = new Comandante("Comandante Mortífago", 1000, 900, 900, 9);
        } else {
            mortifago = new Seguidor("Seguidor Mortífago", 700, 250, 250, 7);
        }

        // Asignar hechizos al Mortífago
        agregarHechizos(mortifago);

        return mortifago;
    }

    // Método auxiliar para asignar hechizos a un personaje según su nivel de magia
    private static void agregarHechizos(Personaje personaje) {
        Hechizo avadaKedavra = HechizoFactory.crearHechizo("avadakedavra", personaje);
        Hechizo expelliarmus = HechizoFactory.crearHechizo("expelliarmus", personaje);
        Hechizo protego = HechizoFactory.crearHechizo("protego", personaje);

        if (avadaKedavra != null) personaje.agregarHechizo(avadaKedavra);
        if (expelliarmus != null) personaje.agregarHechizo(expelliarmus);
        if (protego != null) personaje.agregarHechizo(protego);
    }
}

