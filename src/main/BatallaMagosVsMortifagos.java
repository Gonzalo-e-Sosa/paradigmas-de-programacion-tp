package main;

import java.util.Random;
import clase.Batallon;
import clases.personajes.PersonajeFactory;

public class BatallaMagosVsMortifagos {
    public static void main(String[] args) {
        // Crear los batallones de magos y mortífagos
        Batallon batallonMagos = new Batallon();
        Batallon batallonMortifagos = new Batallon();

        // Añadir personajes a los batallones
        for (int i = 0; i < 3; i++) {
            batallonMagos.agregarPersonaje(PersonajeFactory.crearMago());
            batallonMortifagos.agregarPersonaje(PersonajeFactory.crearMortifago());
        }

        // Simulación de la batalla
        Random rand = new Random();
        while (batallonMagos.estaVivo() && batallonMortifagos.estaVivo()) {
            if (rand.nextBoolean()) {
                batallonMagos.atacar(batallonMortifagos);
                if (batallonMortifagos.estaVivo()) {
                    batallonMortifagos.atacar(batallonMagos);
                }
            } else {
                batallonMortifagos.atacar(batallonMagos);
                if (batallonMagos.estaVivo()) {
                    batallonMagos.atacar(batallonMortifagos);
                }
            }
            System.out.println("----------------------------");
        }

        // Determinar el ganador
        if (batallonMagos.estaVivo()) {
            System.out.println("¡Los magos han ganado la batalla!");
        } else {
            System.out.println("¡Los mortífagos han ganado la batalla!");
        }
    }
}
  
  
  
