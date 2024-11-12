package trabajofinal;
import java.util.Random;
import org.jpl7.*;
import Clases.Batallon;
import Clases.Personajes.PersonajeFactory;


public class TrabajoFinal {
    public static void main(String[] args) {
        Batallon batallonMagos = new Batallon();
        Batallon batallonMortifagos = new Batallon();
        
        Query query = new Query("consult('C:\\\\\\\\Users\\\\\\\\Diego\\\\\\\\Desktop\\\\\\\\TestPro').");
        if (query.hasSolution()) {
            System.out.println("Prolog cargado correctamente.");
        } else {
            System.out.println("Error al cargar el archivo.");
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            batallonMagos.agregarUnidad(PersonajeFactory.crearMago());
            batallonMortifagos.agregarUnidad(PersonajeFactory.crearMortifago());
        }

        System.out.println("a");
        // Simulación de la batalla
        while (batallonMagos.estaVivo() && batallonMortifagos.estaVivo()) {
            batallonMagos.atacar(batallonMortifagos);
            if (batallonMortifagos.estaVivo()) {
                batallonMortifagos.atacar(batallonMagos);
            }
            System.out.println("----------------------------");
        }

        if (batallonMagos.estaVivo()) {
            System.out.println("¡Los magos han ganado la batalla!");
        } else {
            System.out.println("¡Los mortífagos han ganado la batalla!");
        }
    }
}

//        Batallon batallonMagos2 = new Batallon();
//        Batallon batallonMortifagos2 = new Batallon();
//
//        // Añadir personajes a los batallones
//        for (int i = 0; i < 3; i++) {
//            batallonMagos2.agregarUnidad(PersonajeFactory.crearMago());
//            batallonMortifagos2.agregarUnidad(PersonajeFactory.crearMortifago());
//        }
//
//        Random rand = new Random();
//        while (batallonMagos2.tienePersonajesSaludables() && batallonMortifagos2.tienePersonajesSaludables()) {
//            if (rand.nextBoolean()) {
//                batallonMagos.atacar(batallonMortifagos);
//                if (batallonMortifagos2.tienePersonajesSaludables()) {
//                    batallonMortifagos.atacar(batallonMagos);
//                }
//            } else {
//                batallonMortifagos.atacar(batallonMagos);
//                if (batallonMagos2.tienePersonajesSaludables()) {
//                    batallonMagos.atacar(batallonMortifagos);
//                }
//            }
//            System.out.println("----------------------------");
//        }
//
//        // Determina el ganador
//        if (batallonMagos2.tienePersonajesSaludables()) {
//            System.out.println("¡Los magos han ganado la batalla!");
//        } else {
//            System.out.println("¡Los mortífagos han ganado la batalla!");
//        }
//    }
    
