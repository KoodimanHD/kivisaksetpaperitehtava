package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;
/**
 *Testaa Peli-luokan metodeja.
 */
class TestataanPeli {
	Pelaaja p1, p2;

	@BeforeEach
	void setUp() throws Exception {
		p1 = new Pelaaja();
		p2 = new Pelaaja();
	}
	/**
	 * Testaa vertailevalinta-metodia. Testattua skenaarioita ovat kaikki mahdolliset kivi-paperi-sakset -kombinaatiot.
	 * Testit suoritetaan asettamalla molemmille pelaajille parametreiss‰ m‰‰ritelty valinta, 
	 * ja sitten tarkistetaan ovat pelaajien voittojen m‰‰r‰ muuttunut halutusti.
	 * @param p1valinta Pelaajan 1 tekem‰ valinta.
	 * @param p2valinta Pelaaja, 2  tekem‰ valinta.
	 * @param p1Voitot Pelaajan 1 oletettu voittojen m‰‰r‰
	 * @param p2Voitot Pelaajan 2 oletettu voittojen m‰‰r‰
	 */
	@ParameterizedTest
	@CsvSource({ "kivi, paperi, 0, 1", "paperi, kivi, 1, 0", "paperi, sakset, 0, 1", "sakset, paperi, 1, 0",
			"sakset, kivi, 0, 1", "kivi, sakset, 1, 0", "kivi,kivi, 0, 0","sakset, sakset, 0, 0", "paperi, paperi, 0, 0"})
	void testataanVertaileValinta(String p1valinta, String p2valinta, int p1Voitot, int p2Voitot) {
		boolean huonoTulos = false;

		p1.setValinta(p1valinta);
		p2.setValinta(p2valinta);

		Peli.vertaileValinnat(p1, p2);

		if (p1.getVoitot() != p1Voitot) {
			huonoTulos = true;
		}
		if (p2.getVoitot() != p2Voitot) {
			huonoTulos = true;
		}
		assertEquals(false, huonoTulos, "Tulosten piti olla: " + p1Voitot + " / " + p2Voitot 
				+ ", Mutta olivat " + p1.getVoitot() + " / " + p2.getVoitot());
	}
	/**
	 * Testaa tarkistaTilanne -metodia.
	 * Testit toteutetaan lis‰‰m‰ll‰ pelaajille parametreissˆ m‰‰ritellyt m‰‰r‰t voittoja, jonka j‰lkeen tarkistetaan,
	 * palauttaako metodi halutun tuloksen (true / false).
	 * @param p1Voitot
	 * @param p2Voitot
	 * @param haluttuTulos
	 */
	@ParameterizedTest
	@CsvSource({"0,0,false", "1,1,false", "2,2,false", "3,3,true", "0,3,true", "3,0,true", "4,0, true", "99,-99, true"})
	void testataanTarkistaTilanne(int p1Voitot, int p2Voitot, boolean haluttuTulos) {
		while(p1.getVoitot() != p1Voitot) {
			p1.lisaaVoitto();
		}
		while(p2.getVoitot() != p2Voitot) {
			p2.lisaaVoitto();
		}
		assertEquals(haluttuTulos, Peli.tarkistaTilanne(p1, p2));
	}

}
