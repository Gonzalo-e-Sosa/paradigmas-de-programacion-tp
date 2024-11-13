package clase;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;
import clases.personajes.Personaje;
import interfaces.Unidad;

public class Batallon implements Unidad{
    private List<Unidad> miembros;

    public Batallon() {
        this.miembros= new ArrayList<>();
    }

    public void agregarUnidad(Unidad unidad) {
        miembros.add(unidad);
    }
    
    public void removerUnidad(Unidad unidad) {
        miembros.remove(unidad);
    }
    
    @Override
    public void atacar(Unidad objetivo) {
        // Todos los miembros atacan a una unidad específica del batallón enemigo
        for (Unidad miembro : miembros) {
            if (miembro.estaVivo()) {
                Unidad enemigoObjetivo = obtenerObjetivoAleatorio((Batallon) objetivo);
                miembro.atacar(enemigoObjetivo);
            }
        }
    }

    // Método auxiliar para seleccionar un objetivo aleatorio vivo del batallón enemigo
    private Unidad obtenerObjetivoAleatorio(Batallon batallonEnemigo) {
        List<Unidad> enemigosVivos = new ArrayList<>();
        for (Unidad enemigo : batallonEnemigo.miembros) {
            if (enemigo.estaVivo()) {
                enemigosVivos.add(enemigo);
            }
        }
        return enemigosVivos.isEmpty() ? null : enemigosVivos.get(new Random().nextInt(enemigosVivos.size()));
    }

    @Override
    public boolean estaVivo() {
        // Si al menos un miembro está vivo, el batallón sigue en combate
        for (Unidad miembro : miembros) {
            if (miembro.estaVivo()) {
                return true;
            }
        }
        return false;
    }

	public boolean tienePersonajesSaludables() {
		return estaVivo();
	}

	@Override
	public void recibirDaño() {
	    // Calculamos el daño para el batallón: tomamos el daño de un hechizo o ataque
	    for (Unidad miembro : miembros) {
	        if (miembro.estaVivo() && miembro instanceof Personaje) {
	            // Calculamos el daño para cada miembro (Personaje)
	            ((Personaje) miembro).recibirDaño();  // Llamamos al método de recibir daño de Personaje
	        }
	    }
	}

	@Override
	public String getNombre() {
	    StringBuilder nombres = new StringBuilder("Miembros del batallón: ");
	    for (Unidad miembro : miembros) {
	        if (miembro.estaVivo()) {
	            nombres.append(miembro.getNombre()).append(", ");
	        }
	    }
	    return nombres.length() > 0 ? nombres.substring(0, nombres.length() - 2) : "Sin miembros vivos";
	}
	
	public List<Unidad> getMiembros(){
		return this.miembros;
	}
}
