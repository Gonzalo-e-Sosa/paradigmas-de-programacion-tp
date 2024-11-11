package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clase.Batallon;
import clases.personajes.Personaje;
import clases.personajes.PersonajeFactory;
import interfaces.Unidad;

class BatallonTest {

    private Batallon batallonMagos;
    private Batallon batallonMortifagos;
    private Unidad mago;
    private Unidad mortifago;

    @BeforeEach
    void setUp() {
        batallonMagos = new Batallon();
        batallonMortifagos = new Batallon();
        mago = PersonajeFactory.crearMago(); // Asegúrate de que PersonajeFactory crea un objeto de tipo Unidad
        mortifago = PersonajeFactory.crearMortifago(); // Asegúrate de que PersonajeFactory crea un objeto de tipo Unidad
    }

    @Test
    void testAgregarUnidad() {
        batallonMagos.agregarUnidad(mago);
        assertEquals(1, batallonMagos.getMiembros().size(), "El batallón de magos debería tener 1 miembro.");
    }

    @Test
    void testRemoverUnidad() {
        batallonMagos.agregarUnidad(mago);
        batallonMagos.removerUnidad(mago);
        assertEquals(0, batallonMagos.getMiembros().size(), "El batallón de magos debería estar vacío después de remover la unidad.");
    }

    @Test
    void testEstaVivoCuandoBatallonTieneMiembrosVivos() {
        batallonMagos.agregarUnidad(mago);
        assertTrue(batallonMagos.estaVivo(), "El batallón de magos debería estar vivo cuando tiene miembros vivos.");
    }

    @Test
    void testEstaVivoCuandoBatallonNoTieneMiembrosVivos() {
        // Si el personaje está muerto, el batallón debería considerarse muerto
        mago.restarPuntosDeVida(100);  // Asegúrate de que el personaje esté muerto
        batallonMagos.agregarUnidad(mago);
        assertFalse(batallonMagos.estaVivo(), "El batallón de magos debería estar muerto si no tiene miembros vivos.");
    }

    @Test
    void testAtacarConMiembrosVivos() {
        batallonMagos.agregarUnidad(mago);
        batallonMortifagos.agregarUnidad(mortifago);
        batallonMagos.atacar(batallonMortifagos);
        assertTrue(mortifago.estaVivo(), "El mortífago debería estar vivo después del ataque.");
    }

    @Test
    void testAtacarConMiembrosMuertos() {
        mago.restarPuntosDeVida(100);  // Asegúrate de que el mago esté muerto
        batallonMagos.agregarUnidad(mago);
        batallonMortifagos.agregarUnidad(mortifago);
        batallonMagos.atacar(batallonMortifagos);
        assertTrue(mortifago.estaVivo(), "El batallón de mortífagos debería seguir vivo si no hay unidades vivas en el batallón de magos.");
    }

    @Test
    void testTienePersonajesSaludables() {
        batallonMagos.agregarUnidad(mago);
        assertTrue(batallonMagos.tienePersonajesSaludables(), "El batallón de magos debería tener personajes saludables.");
        
        mago.restarPuntosDeVida(100);  // Matar al mago
        assertFalse(batallonMagos.tienePersonajesSaludables(), "El batallón de magos no debería tener personajes saludables.");
    }
}
