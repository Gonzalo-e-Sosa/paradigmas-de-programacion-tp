package tests;

import Clases.Hechizos.AvadaKedavra;
import Clases.Hechizos.Expelliarmus;
import Clases.Hechizos.Protego;
import Clases.Personajes.Personaje;
import Interfaces.Hechizo;
import Interfaces.Unidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {
    private Personaje personaje;
    private Personaje enemigo;
    private Hechizo protego;
    private Hechizo avadaKedavra;
    private Hechizo expelliarmus;

    @BeforeEach
    void setUp() {
        personaje = new Personaje("Harry", 100, 3, 100, 1.5);
        enemigo = new Personaje("Voldemort", 100, 3, 100, 1.5);
        
        protego = new Protego();
        avadaKedavra = new AvadaKedavra();
        expelliarmus = new Expelliarmus();

        personaje.agregarHechizo(protego);
        personaje.agregarHechizo(avadaKedavra);
        personaje.agregarHechizo(expelliarmus);
    }

    @Test
    void testEstaVivoInicialmente() {
        assertTrue(personaje.estaVivo());
    }

    @Test
    void testEstaVivoDespuesDeRecibirDanio() {
        personaje.restarPuntosDeVida(150);
        assertFalse(personaje.estaVivo());
    }

    @Test
    void testSumarEnergia() {
        personaje.setEnergia(50);
        personaje.sumarEnergia(30);
        assertEquals(80, personaje.getEnergia());

        personaje.sumarEnergia(50);
        assertEquals(personaje.getEnergiaMax(), personaje.getEnergia());
    }

    @Test
    void testRestarEnergia() {
        personaje.restarEnergia(30);
        assertEquals(70, personaje.getEnergia());

        personaje.restarEnergia(100);
        assertEquals(0, personaje.getEnergia());
    }

    @Test
    void testSumarPuntosDeVida() {
        personaje.restarPuntosDeVida(50);
        personaje.sumarPuntosDeVida(20);
        assertEquals(70, personaje.getPuntosDeVida());

        personaje.sumarPuntosDeVida(200);
        assertEquals(personaje.getPuntosDeVidaMax(), personaje.getPuntosDeVida());
    }

    @Test
    void testRestarPuntosDeVida() {
        personaje.restarPuntosDeVida(30);
        assertEquals(70, personaje.getPuntosDeVida());

        personaje.restarPuntosDeVida(100);
        assertEquals(0, personaje.getPuntosDeVida());
    }

    @Test
    void testAtacarSinHechizos() {
        Personaje sinHechizos = new Personaje("Ron", 100, 3, 100, 1.5);
        sinHechizos.atacar(enemigo);
        assertEquals(100, enemigo.getPuntosDeVida());
    }

    @Test
    void testAtacarConHechizoOfensivo() {
        personaje.atacar(enemigo);
        assertTrue(enemigo.getPuntosDeVida() < 100);
    }

    @Test
    void testAtacarConHechizoCurativo() {
        personaje.restarPuntosDeVida(50);
        personaje.atacar(personaje); 
        assertTrue(personaje.getPuntosDeVida() > 50);
    }
}