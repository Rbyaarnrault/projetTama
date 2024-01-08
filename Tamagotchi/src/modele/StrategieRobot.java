package modele;

// Classe qui définit les constantes pour un robot
public class StrategieRobot extends StrategieConstantes {

    public StrategieRobot() {
        // Initialisation des constantes spécifiques au robot
        // Constantes pour les valeurs limites
        MIN_VIE = 0; // Recharge
        MAX_VIE = 100;
        MIN_BATTERIE = 0;
        MAX_BATTERIE = 100;
        MIN_PROCESSEUR = 0; // Surchauffe
        MAX_PROCESSEUR = 100;
        MIN_HUMEUR = 0;
        MAX_HUMEUR = 60; // HUMEUR

        // Constantes pour les incrémentation et decrémentations de chaque attribut pour
        // un robot
        DEC_VIE = 1; // Pas de INC car usure irreversible
        DEC_BATTERIE = 1;
        INC_BATTERIE = 3;
        DEC_PROCESSEUR = 3;
        INC_PROCESSEUR = 1;
        DEC_HUMEUR = 3;
        INC_HUMEUR = 40;
    }
}