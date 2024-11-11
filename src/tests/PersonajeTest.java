package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.hechizos.AvadaKedavra;
import clases.personajes.Mago;
import clases.personajes.Mortifago;
import clases.personajes.Personaje;
import interfaces.Hechizo;

class PersonajeTest {

    private Personaje personaje;
    private Personaje objetivo;
    //private ContextoHechizo contextoHechizo;
    
    @BeforeEach
    void setUp() {
        personaje = new Mago("Harry", 100.0, 10, 50, 1.2); 
        objetivo = new Mortifago("Voldemort", 120.0, 12, 60, 1.5);
        //contextoHechizo = new ContextoHechizo();
    }

    @Test
    void testAtacarSinHechizos() {
        personaje.atacar(objetivo);
        // No debe ocurrir nada, ya que no hay hechizos
    }

    @Test
    void testAtacarConHechizo() {
    	Hechizo hechizoDeAtaque = new AvadaKedavra();
        personaje.agregarHechizo(hechizoDeAtaque);
        personaje.atacar(objetivo);
    }

    @Test
    void testEstaVivo() {
        assertTrue(personaje.estaVivo());
        personaje.restarPuntosDeVida(200.0);
        assertFalse(personaje.estaVivo());
    }

    @Test
    void testSumarEnergiaPositiva() {
        personaje.sumarEnergia(10);
        assertEquals(60, personaje.getEnergia());
    }

    @Test
    void testSumarEnergiaNegativaLanzaError() {
        Error exception = assertThrows(Error.class, () -> personaje.sumarEnergia(-5));
        assertEquals("Energía debe ser un valor positivo.", exception.getMessage());
    }

    @Test
    void testRestarEnergiaPositiva() {
        personaje.restarEnergia(10);
        assertEquals(40, personaje.getEnergia());
    }

    @Test
    void testSetEnergiaCeroLanzaError() {
        Error exception = assertThrows(Error.class, () -> personaje.setEnergia(0));
        assertEquals("Enegia debe ser un valor positivo.", exception.getMessage());
    }

    @Test
    void testSumarPuntosDeVidaPositivos() {
        personaje.restarPuntosDeVida(50); // Reduce puntos de vida a 50
        personaje.sumarPuntosDeVida(30); // Suma puntos de vida
        assertEquals(80, personaje.getPuntosDeVida());
    }

    @Test
    void testSumarPuntosDeVidaMasQueMaximo() {
        personaje.sumarPuntosDeVida(200);
        assertEquals(100, personaje.getPuntosDeVida()); // Se ajusta al máximo
    }

    @Test
    void testSumarPuntosDeVidaNegativosLanzaError() {
        Error exception = assertThrows(Error.class, () -> personaje.sumarPuntosDeVida(-10));
        assertEquals("Puntos de vida debe ser positivo.", exception.getMessage());
    }

    @Test
    void testRestarPuntosDeVidaPositivos() {
        personaje.restarPuntosDeVida(40);
        assertEquals(60, personaje.getPuntosDeVida());
    }

    @Test
    void testGetMultiplicadorDeHechizo() {
        assertEquals(1.2, personaje.getmultiplicadorDeHechizo(), 0.01);
    }

    @Test
    void testAgregarHechizo() {
    	Hechizo hechizoDeAtaque = new AvadaKedavra();
        personaje.agregarHechizo(hechizoDeAtaque);
        ArrayList<Hechizo> hechizos = personaje.getHechizos();
        
        assertEquals(1, hechizos.size());
        assertEquals(hechizoDeAtaque, hechizos.get(0));
    }
}
