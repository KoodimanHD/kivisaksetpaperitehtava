package test;

import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kivipaperisakset.Pelaaja;
/**
 * Testaa Pelaaja-luokan metodeja.
 * @author Otso
 *
 */
class TestataanPelaaja {
	Pelaaja p;

	@BeforeEach
	void setUp() throws Exception {
		p = new Pelaaja();
	}
	/**
	 * Testaa teeValinta-metodia.
	 * Tekee kutsun metodiin, jonka jälkeen tarkistaa tuloksen getterillä.
	 * Jos tulos on muu, kuin kivi, sakset tai paperi, testi ei mene läpi.
	 */
	@Test
	void test() {
		boolean validiValinta = false;
		p.teeValinta();

		if (p.getValinta().equals("kivi"))
			validiValinta = true;
		else if (p.getValinta().equals("sakset"))
			validiValinta = true;
		else if (p.getValinta().equals("paperi"))
			validiValinta = true;

		assertTrue(validiValinta, "tulos oli" + p.getValinta());
	}

}
