package interfaces;

public interface Unidad {
    void atacar(Unidad objetivo); // permite atacar a otro "Unidad"
    boolean estaVivo(); // verifica si el personaje o batallón sigue en combate
	void recibirDaño();
	String getNombre();
}