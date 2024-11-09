package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import clases.personajes.Personaje;

public class Batallon {
    private List<Personaje> personajes;

    public Batallon() {
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public boolean tienePersonajesSaludables() {
        return personajes.stream().anyMatch(p -> p.getPuntosDeVida() > 0);
    }

    public void atacar(Batallon batallonEnemigo) {
        Random random = new Random();
        
        for (Personaje atacante : personajes) {
            if (atacante.getPuntosDeVida() <= 0) continue; // Salta personajes debilitados
            
            // Seleccionar un personaje enemigo aleatorio que esté saludable
            List<Personaje> enemigosSaludables = batallonEnemigo.obtenerPersonajesSaludables();
            if (enemigosSaludables.isEmpty()) return;
            
            Personaje objetivo = enemigosSaludables.get(random.nextInt(enemigosSaludables.size()));
            atacante.lanzarHechizo(objetivo); // Lanza un hechizo contra el objetivo
        }
    }

    public List<Personaje> obtenerPersonajesSaludables() {
        return personajes.stream().filter(p -> p.getPuntosDeVida() > 0).toList();
    }
}
