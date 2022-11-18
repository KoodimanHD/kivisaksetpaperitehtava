package kivipaperisakset;

/**
 *
 * @author Otso Poussa, Ira Dook
 * Luokka sisältää Kivi-sakset-paperi -pelin muuttujat, sekä toiminnan ohjaavan main-metodin.
 * 
 */
public class Peli {
	private static int pelatutPelit; // Pelattujen pelien lkm
	private static int tasapelit; // Tasapelien lkm

	/**
	 * 
	 * @param args
	 * Ohjaa pelin toimintaa. Metodin do-while -toistorakenne suorittaa erän kerrallaan.
	 * Jokaisessa erässä metodi printtaa pelin sen hetkiset pisteytykset ja kutsuu vertaileValinnat-metodia selvittämään, mikä erän lopputulos on.
	 * Do-while lause toistaa eriä, kunnes toisella pelaajalla on vähintään 3 voittoa.
	 */
	public static void main(String args[]) {
		pelatutPelit = 0;
		tasapelit = 0;
		boolean peliLoppui = false;
		
		Pelaaja p1 = new Pelaaja(), p2 = new Pelaaja();

		// Peli suoritetaan tässä do-while-lohkossa.
		do {
			System.out.println("ErÃ¤: " + pelatutPelit + " =====================\n");
			System.out.println("Tasapelien lukumÃ¤Ã¤rÃ¤: " + tasapelit + "\n");
			System.out.println("\nPelaaja 1:llÃ¤ koossa " + p1.getVoitot() + " voittoa.\n" 
			+ "\nPelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.\n");
			System.out.println("Pelaaja 1: " + p1.teeValinta() + " Pelaaja 2: " + p2.teeValinta());

			vertaileValinnat(p1, p2);
			pelatutPelit++;
			
			if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
				peliLoppui = true;
				System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
			}
			System.out.println();
		} while (peliLoppui != true);
	}
	
	/**
	 * Vertailee kahden parametrina saadun pelaajan tekemiä valintoja, ja nostaa sen perusteella voittaneen pelaajan voittoja.
	 * Tasapelin sattuessa nostaa tasapelit-muuttujaa.
	 * Metodin sisältää if-lauseet joilla, tarkistetaan, onko pelaaja2 tehnyt voittavat valinnan, tai onko sattunut tasapeli. 
	 * Jos nämä eivät täyty metodi lisää pelaaja1:delle uuden voiton.
	 * @param pelaaja1
	 * @param pelaaja2
	 */
	
	static void vertaileValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
		if (pelaaja1.getValinta() == pelaaja2.getValinta()) {
			tasapelit++;
			System.out.println("\n\t\t\t Tasapeli \n");
			return;
		}
		if ((pelaaja1.getValinta().equals("kivi")) && (pelaaja2.getValinta().equals("paperi"))) {
			System.out.println("Pelaaja 2 voittaa erän");
			pelaaja2.setVoitot();
			return;
		}
		if ((pelaaja1.getValinta().equals("paperi")) && (pelaaja2.getValinta().equals("sakset"))) {
			System.out.println("Pelaaja 2 voittaa erän");
			pelaaja2.setVoitot();
			return;
		}
		if ((pelaaja1.getValinta().equals("sakset")) && (pelaaja2.getValinta().equals("kivi"))) {
			System.out.println("Pelaaja 2 voittaa erän");
			pelaaja2.setVoitot();
			return;
		}
		System.out.println("Pelaaja 1 voittaa erän.");
		pelaaja1.setVoitot();
	}
}
