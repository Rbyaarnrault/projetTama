package modele;

// Classe qui définit les constantes pour un poussin
public class StrategiePoussin extends StrategieConstantes {

    public StrategiePoussin() {
        // Initialisation des constantes spécifiques au poussin
        // Constantes pour les valeurs limites
        MIN_VIE = 0;
        MAX_VIE = 100;
        MIN_HYGIENE = 0;
        MAX_HYGIENE = 100;
        MIN_FAIM = 0;
        MAX_FAIM = 100;
        MIN_SOMMEIL = 0;
        MAX_SOMMEIL = 100;
        MIN_LOISIR = 0;
        MAX_LOISIR = 100;

        // Constantes pour les incrémentation et decrémentations de chaque attribut pour
        // un poussin
        DEC_HYGIENE = 6;
        INC_HYGIENE = 70;
        DEC_FAIM = 8;
        INC_FAIM = 40;
        DEC_SOMMEIL = 8;
        INC_SOMMEIL = 80;
        DEC_LOISIR = 6;
        INC_LOISIR = 40;
    }
}