package kivipaperisakset;

/**
 * @author Otso Poussa Luokka sisältää Kivi-sakset-paperi -pelin muuttujat,
 *         sekä toiminnan ohjaavan main-metodin.
 * 
 */
public class Peli {
	private static int pelatutPelit; // Pelattujen pelien lkm
	private static int tasapelit; // Tasapelien lkm

	/**
	 * Ohjaa pelin toimintaa. Metodin do-while -toistorakenne suorittaa erän
	 * kerrallaan. Jokaisessa erässä metodi printtaa pelin sen hetkiset
	 * pisteytykset ja kutsuu vertaileValinnat-metodia selvittämään, mikä erän
	 * lopputulos on. Do-while lause toistaa eriä, kunnes peliLoppui-muuttuja on
	 * true.
	 */
	public static void main(String args[]) {
		pelatutPelit = 0;
		tasapelit = 0;
		boolean peliLoppui = false;
		Pelaaja p1 = new Pelaaja(), p2 = new Pelaaja();

		do {
			System.out.println("Erä: " + pelatutPelit + " =====================\n");
			System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
			System.out.println("\nPelaaja 1:lla koossa " + p1.getVoitot() + " voittoa.\n" + "\nPelaaja 2:lla koossa "
					+ p2.getVoitot() + " voittoa.\n");
			System.out.println("Pelaaja 1: " + p1.teeValinta() + " Pelaaja 2: " + p2.teeValinta());

			vertaileValinnat(p1, p2);
			pelatutPelit++;

			peliLoppui = tarkistaTilanne(p1, p2);
			System.out.println();
		} while (peliLoppui != true);
	}

	/**
	 * Metodi tarkistaa pelaajien voitettujen erien määrän. Jos jommalla kummalla
	 * pelaajalla on vähintään 3 voittoa, metodi palauttaa true.
	 * 
	 * @param p1
	 * @param p2
	 * @return true tai false, eli p��t�s siit� p��ttyk� peli vai ei.	 */
	public static boolean tarkistaTilanne(Pelaaja p1, Pelaaja p2) {
		if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
			System.out.println("KOLME VOITTOA - PELI P��TTYY");
			return true;
		}
		return false;
	}

	/**
	 * Vertailee kahden parametrina saadun pelaajan tekemiä valintoja, ja nostaa
	 * sen perusteella voittaneen pelaajan voittoja. Tasapelin sattuessa nostaa
	 * tasapelit-muuttujaa. Metodin sisältää if-lauseet joilla, tarkistetaan,
	 * onko pelaaja2 tehnyt voittavat valinnan, tai onko sattunut tasapeli. Jos
	 * nämä eivät täyty metodi lisää pelaaja1:delle uuden voiton.
	 * 
	 * @param pelaaja1
	 * @param pelaaja2
	 */
	public static void vertaileValinnat(Pelaaja pelaaja1, Pelaaja pelaaja2) {
		if (pelaaja1.getValinta().equals(pelaaja2.getValinta())) {
			tasapelit++;
			System.out.println("\n\t\t\t Tasapeli \n");
			return;
		}
		if ((pelaaja1.getValinta().equals("kivi")) && (pelaaja2.getValinta().equals("paperi"))) {
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.lisaaVoitto();
			return;
		}
		if ((pelaaja1.getValinta().equals("paperi")) && (pelaaja2.getValinta().equals("sakset"))) {
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.lisaaVoitto();
			return;
		}
		if ((pelaaja1.getValinta().equals("sakset")) && (pelaaja2.getValinta().equals("kivi"))) {
			System.out.println("Pelaaja 2 voittaa er�n");
			pelaaja2.lisaaVoitto();
			return;
		}
		System.out.println("Pelaaja 1 voittaa er�n.");
		pelaaja1.lisaaVoitto();
	}
}
