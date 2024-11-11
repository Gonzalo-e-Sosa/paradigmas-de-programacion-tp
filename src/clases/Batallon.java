package clase;

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

    public void removerPersonaje(Personaje personaje) {
        personajes.remove(personaje);
    }

    public boolean estaVivo() {
        // Si al menos un personaje tiene puntos de vida, el batallón sigue en combate
        return personajes.stream().anyMatch(p -> p.getPuntosDeVida() > 0);
    }

    public void atacar(Batallon batallonEnemigo) {
        Random random = new Random();

        for (Personaje atacante : personajes) {
            if (atacante.getPuntosDeVida() <= 0) continue; // Ignora personajes sin vida

            // Selecciona un objetivo enemigo al azar que esté saludable
            List<Personaje> enemigosSaludables = batallonEnemigo.obtenerPersonajesSaludables();
            if (enemigosSaludables.isEmpty()) return; // No hay enemigos vivos, fin de ataque

            Personaje objetivo = enemigosSaludables.get(random.nextInt(enemigosSaludables.size()));
            atacante.lanzarHechizo(objetivo); // Ataca al objetivo
            System.out.println(atacante.getNombre() + " atacó a " + objetivo.getNombre());
        }
    }

    private List<Personaje> obtenerPersonajesSaludables() {
        return personajes.stream().filter(p -> p.getPuntosDeVida() > 0).toList();
    }
}
