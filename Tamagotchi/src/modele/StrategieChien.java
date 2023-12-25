package modele;

// Classe qui définit les constantes pour un chien

public class StrategieChien extends StrategieConstantes {

    public StrategieChien() {
        // Initialisation des constantes spécifiques au chien
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
        // un chien
        DEC_HYGIENE = 2;
        INC_HYGIENE = 100;
        DEC_FAIM = 3;
        INC_FAIM = 30;
        DEC_SOMMEIL = 1;
        INC_SOMMEIL = 60;
        DEC_LOISIR = 2;
        INC_LOISIR = 50;

    }
}
