package modele;

// Classe qui définit les constantes pour un robot
public class StrategieRobot extends StrategieConstantes {

    public StrategieRobot() {
        // Initialisation des constantes spécifiques au robot
        // Constantes pour les valeurs limites
        MIN_VIE = 0;
        MAX_VIE = 300;
        MIN_HYGIENE = 0;
        MAX_HYGIENE = 200;
        MIN_FAIM = 0;
        MAX_FAIM = 200; // REMPLACER PAR UN AUTRE NOM ???
        MIN_SOMMEIL = 0;
        MAX_SOMMEIL = 60; // VEILLE ?
        MIN_LOISIR = 0;
        MAX_LOISIR = 40; // ENLEVER CETTE CONSTANTE ?? FAIRE DE SON HUMEUR UNE EXAGERATION ??

        // Constantes pour les incrémentation et decrémentations de chaque attribut pour
        // un robot
        DEC_HYGIENE = 1;
        INC_HYGIENE = 50;
        DEC_FAIM = 3;
        INC_FAIM = 25;
        DEC_SOMMEIL = 1;
        INC_SOMMEIL = 40;
        DEC_LOISIR = 2;
        INC_LOISIR = 40;
    }
}