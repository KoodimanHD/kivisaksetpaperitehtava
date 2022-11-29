package kivipaperisakset;

/**
 *
 * @author Otso Poussa
 * Luokka muodostaa pelaaja-olion. Olio pelaa kivi-paperi-sakset-peliä.
 * <b>voitot</b>-muuttuja sisältää pelaajan voittamien erien määrän.
 * <b>valinta</b>-muuttuja sisältää pelaajan arpoman valinnan (kivi, paperi tai sakset).
 * 
 */
public class Pelaaja {
	private int voitot;      // Voittojen lukum��r�
    private String valinta;	// T�m�n hetkinen valinta.

    public Pelaaja() {
    	this.voitot = 0;
    	this.valinta = "";
    }
    /**
     * Generoi <b>Math.random</b> -kokonaisluvun 1-3 väliltä, ja valitsee tämän perusteella <i>kiven</i>, <i>paperin</i> tai <i>sakset</i>.
     */
    public String teeValinta() {
        this.valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = ("kivi");
                break;
            case 1:
                valinta = ("paperi");
                break;
            case 2:
                valinta = ("sakset");
                break;
        }
        return valinta;
    }

    public String getValinta() {
		return valinta;
	}
    
    public void setValinta(String valinta) {
		this.valinta = valinta;
	}

	public void setVoitot() {
        this.voitot++;
    }
    
	public int getVoitot() {
        return (voitot);
    }
}
