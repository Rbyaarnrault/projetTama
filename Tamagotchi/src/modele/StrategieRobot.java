package modele;

// Classe qui définit les constantes pour un robot
public class StrategieRobot extends StrategieConstantes {

    public StrategieRobot() {
        // Initialisation des constantes spécifiques au robot
        // Constantes pour les valeurs limites
        MIN_VIE = 0; // Recharge
        MAX_VIE = 100;
        MIN_HYGIENE = 0; // Surchauffe
        MAX_HYGIENE = 100;
        MIN_SOMMEIL = 0;
        MAX_SOMMEIL = 60; // HUMEUR

        // Constantes pour les incrémentation et decrémentations de chaque attribut pour
        // un robot
        DEC_HYGIENE = 2;
        INC_HYGIENE = 100;
        DEC_FAIM = 3;
        INC_FAIM = 1;
        DEC_SOMMEIL = 3;
        INC_SOMMEIL = 40;
    }
}