package modele;

import static modele.Tamagotchi.DEC_FAIM;
import static modele.Tamagotchi.DEC_HYGIENE;
import static modele.Tamagotchi.DEC_LOISIR;
import static modele.Tamagotchi.DEC_SOMMEIL;
import static modele.Tamagotchi.MIN_FAIM;
import static modele.Tamagotchi.MIN_HYGIENE;
import static modele.Tamagotchi.MIN_LOISIR;
import static modele.Tamagotchi.MIN_SOMMEIL;

public class Chien extends Tamagotchi {

    private static final int CHIEN_DEC_FAIM = 2, CHIEN_INC_FAIM = 20;
    private static final int CHIEN_DEC_HYGIENE = 5, CHIEN_INC_HYGIENE = 25;
    private static final int CHIEN_DEC_SOMMEIL = 1, CHIEN_INC_SOMMEIL = 10;
    private static final int CHIEN_DEC_LOISIR = 2, CHIEN_INC_LOISIR = 40;

    private int dureeVie, vie, hygiene, faim, sommeil, loisir;

    public Chien(String nom) {
        super(nom, "Chien");
        dureeVie = super.getDureeVie();
        vie = super.getVie();
        hygiene = super.getHygiene();
        faim = super.getFaim();
        sommeil = super.getSommeil();
        loisir = super.getSommeil();

    }

    public void decrementer() {
        // Diminution selon les constantes chosies des attributs

        faim = decrecrementerValeur(faim, CHIEN_DEC_FAIM, super.MIN_FAIM);
        hygiene = decrecrementerValeur(hygiene, CHIEN_DEC_HYGIENE, MIN_HYGIENE);
        sommeil = decrecrementerValeur(sommeil, CHIEN_DEC_SOMMEIL, MIN_SOMMEIL);
        loisir = decrecrementerValeur(loisir, CHIEN_DEC_LOISIR, MIN_LOISIR);
        super.actualiserVie();
    }

}
