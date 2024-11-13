package main;

import clase.Batallon;
import clases.personajes.PersonajeFactory;

public class BatallaMagosVsMortifagos {
  public static void main(String[] args) {
    Batallon batallonMagos = new Batallon();
    Batallon batallonMortifagos = new Batallon();

    // Agregar 3 magos y 3 mortífagos a los batallones
    for (int i = 0; i < 3; i++) {
      batallonMagos.agregarUnidad(PersonajeFactory.crearMago());
      batallonMortifagos.agregarUnidad(PersonajeFactory.crearMortifago());
    }

    // Simulación de la primera batalla
    System.out.println("Comienza la batalla entre Magos y Mortífagos");
    while (batallonMagos.estaVivo() && batallonMortifagos.estaVivo()) {
        System.out.println("\nBatallón de Magos ataca al Batallón de Mortífagos:");
        batallonMagos.atacar(batallonMortifagos);
        batallonMortifagos.recibirDaño();
        
        if (batallonMortifagos.estaVivo()) {
            System.out.println("\nBatallón de Mortífagos ataca al Batallón de Magos:");
            batallonMortifagos.atacar(batallonMagos);
            batallonMagos.recibirDaño();
        }
        
        System.out.println("----------------------------");
   
    }
    
    if (batallonMagos.estaVivo()) {
        System.out.println("¡Los magos han ganado la primera batalla!");
    } else {
        System.out.println("¡Los mortífagos han ganado la primera batalla!");
    }

    }
   
}


  
  
