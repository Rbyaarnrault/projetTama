package modele;

// Classe qui définit les constantes pour un poussin
public class StrategiePoussin extends StrategieConstantes {

    public StrategiePoussin() {
        // Initialisation des constantes spécifiques au poussin
        // Constantes pour les valeurs limites
        MIN_VIE = 0;
        MAX_VIE = 50;
        MIN_HYGIENE = 0;
        MAX_HYGIENE = 50;
        MIN_FAIM = 0;
        MAX_FAIM = 40;
        MIN_SOMMEIL = 0;
        MAX_SOMMEIL = 60;
        MIN_LOISIR = 0;
        MAX_LOISIR = 40;

        // Constantes pour les incrémentation et decrémentations de chaque attribut pour
        // un poussin
        DEC_HYGIENE = 2;
        INC_HYGIENE = 50;
        DEC_FAIM = 3;
        INC_FAIM = 25;
        DEC_SOMMEIL = 1;
        INC_SOMMEIL = 40;
        DEC_LOISIR = 2;
        INC_LOISIR = 40;
    }
}