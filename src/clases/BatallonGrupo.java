package clases;

import java.util.ArrayList;
import java.util.List;

import interfaces.Unidad;

public class BatallonGrupo implements Unidad{
	private List<Unidad> miembros;
	
	public BatallonGrupo() {
		this.miembros = new ArrayList<>();
	}
	
	public void agregarUnidad(Unidad unidad) {
		miembros.add(unidad);
	}
	
    public void removerUnidad(Unidad unidad) {
        miembros.remove(unidad);
    }
    
    @Override
    public void atacar(Unidad objetivo) {
        // Todos los miembros atacan al objetivo
        for (Unidad miembro : miembros) {
            if (miembro.estaVivo()) {
                miembro.atacar(objetivo);
            }
        }
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

}
