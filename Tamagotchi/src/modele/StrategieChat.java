package modele;

// Classe qui définit les constantes pour un chat
public class StrategieChat extends StrategieConstantes {

    public StrategieChat() {
        // Initialisation des constantes spécifiques au chat
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
        // un chat
        DEC_HYGIENE = 2;
        INC_HYGIENE = 70;
        DEC_FAIM = 3;
        INC_FAIM = 50;
        DEC_SOMMEIL = 2;
        INC_SOMMEIL = 70;
        DEC_LOISIR = 2;
        INC_LOISIR = 50;
    }
}