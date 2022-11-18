
package kivipaperisakset;

/**
 *
 * @author Otso Poussa, Ira Dook
 * Luokka muodostaa pelaaja-olion.
 */
public class Pelaaja {

	private int voitot;      // Voittojen lukum‰‰r‰
    private String valinta;	// T‰m‰n hetkinen valinta.

    public Pelaaja() {
    	this.voitot = 0;
    	this.valinta = "";
    }
    /**
     * Generoi <b>Math.random</b> -kokonaisluvun 1-3 v‰lilt‰, ja valitsee t‰m‰n perusteella <b>kiven</b>, <b>paperin</b> tai <b>sakset</b>.
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

	public void setVoitot() {
        this.voitot++;
    }

    public int getVoitot() {
        return (voitot);
    }
}
