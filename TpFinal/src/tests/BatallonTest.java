package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clase.Batallon;
import clases.personajes.Mago;
import clases.personajes.Mortifago;
import interfaces.Unidad;

class BatallonTest {
    private Batallon batallon;
    private Unidad personaje1;
    private Unidad personaje2;

    @BeforeEach
    void setUp() {
        batallon = new Batallon();
        personaje1 = new Mago("Harry", 100, 30, 10, 2);
        personaje2 = new Mago("Peter", 100, 20, 10, 2);
        batallon.agregarUnidad(personaje1);
        batallon.agregarUnidad(personaje2);
    }

    @Test
    void testAgregarUnidad() {
        assertEquals(2, batallon.getMiembros().size(), "El batallón debe tener 2 miembros");
    }

    @Test
    void testRemoverUnidad() {
        batallon.removerUnidad(personaje1);
        assertEquals(1, batallon.getMiembros().size(), "El batallón debe tener 1 miembro después de remover uno");
    }

    @Test
    void testAtacar() {
        Unidad enemigo = new Mortifago("Voldemort", 50, 20, 40, 30);
        batallon.atacar(enemigo);
        
        assertFalse(enemigo.estaVivo());
    }

    @Test
    void testEstaVivoConMiembrosVivos() {
        assertTrue(batallon.estaVivo());
    }
}