package kivipaperisakset;

/**
 *
 * @author Otso Poussa, Ira Dook
 * Luokka sis�lt�� Kivi-sakset-paperi -pelin muuttujat, sek� toiminnan ohjaavan main-metodin.
 * 
 */
public class Peli {
	private static int pelatutPelit; // Pelattujen pelien lkm
	private static int tasapelit; // Tasapelien lkm

	/**
	 * 
	 * @param args
	 * Ohjaa pelin toimintaa. Metodin do-while -toistorakenne suorittaa er�n kerrallaan.
	 * Jokaisessa er�ss� metodi printtaa pelin sen hetkiset pisteytykset ja kutsuu vertaileValinnat-metodia selvitt�m��n, mik� er�n lopputulos on.
	 * Do-while lause toistaa eri�, kunnes toisella pelaajalla on v�hint��n 3 voittoa.
	 */
	public static void main(String args[]) {
		pelatutPelit = 0;
		tasapelit = 0;
		boolean peliLoppui = false;
		
		Pelaaja p1 = new Pelaaja(), p2 = new Pelaaja();

		// Peli suoritetaan t�ss� do-while-lohkossa.
		do {
			System.out.println("Erä: " + pelatutPelit + " =====================\n");
			System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
			System.out.println("\nPelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.\n" 
			+ "\nPelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.\n");
			System.out.println("Pelaaja 1: " + p1.teeValinta() + " Pelaaja 2: " + p2.teeValinta());

			vertaileValinnat(p1, p2);
			pelatutPelit++;
			
			if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
				peliLoppui = true;
				System.out.println("KOLME VOITTOA - PELI P��TTYY");
			}
			System.out.println();
		} while (peliLoppui != true);
	}
	
	/**
	 * Vertailee kahden parametrina saadun pelaajan tekemi� valintoja, ja nostaa sen perusteella voittaneen pelaajan voittoja.
	 * Tasapelin sattuessa nostaa tasapelit-muuttujaa.
	 * Metodin sis�lt�� if-lauseet joilla, tarkistetaan, onko pelaaja2 tehnyt voittavat valinnan, tai onko sattunut tasapeli. 
	 * Jos n�m� eiv�t t�yty metodi lis�� pelaaja1:delle uuden voiton.
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
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.setVoitot();
			return;
		}
		if ((pelaaja1.getValinta().equals("paperi")) && (pelaaja2.getValinta().equals("sakset"))) {
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.setVoitot();
			return;
		}
		if ((pelaaja1.getValinta().equals("sakset")) && (pelaaja2.getValinta().equals("kivi"))) {
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.setVoitot();
			return;
		}
		System.out.println("Pelaaja 1 voittaa er�n.");
		pelaaja1.setVoitot();
	}
}
