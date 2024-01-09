package modele;

import javax.swing.ImageIcon;

public class Robot extends Tamagotchi {

    // Créer nouvelles variables
    private double batterie, processeur, humeur;

    public Robot(String name) {
        super(name);
        // A MODIFIER POUR BONNE IMAGE
        cheminImage = "Tamagotchi/src/ressources/img/Robot.png";
        setImage(new ImageIcon(cheminImage).getImage());

        this.batterie = ((StrategieRobot) strategie).MAX_BATTERIE;
        this.processeur = ((StrategieRobot) strategie).MAX_PROCESSEUR;
        this.humeur = ((StrategieRobot) strategie).MAX_HUMEUR;
    }

    // -----Etat Tamagotchi-----

    public void recharger() {
        batterie += ((StrategieRobot) strategie).INC_BATTERIE;
        batterie = Math.min(batterie, ((StrategieRobot) strategie).MAX_BATTERIE); // Permet de ne pas dépasse la borne
                                                                                  // max
    }

    public void libererMemoire() {
        processeur -= ((StrategieRobot) strategie).DEC_PROCESSEUR;
        processeur = Math.min(processeur, ((StrategieRobot) strategie).MAX_PROCESSEUR);
    }

    public void userVie() {
        vie -= ((StrategieRobot) strategie).DEC_VIE;
    }

    public void blaguer() {
        // Permet au robot de faire une blague aléatoirement dans une liste

    }

    // -----Getters----
    public int getBatterie() {
        return (int) batterie;
    }

    public int getProcesseur() {
        return (int) processeur;
    }

    public int getHumeur() {
        return (int) humeur;
    }

    // Créer des setters différents ou reprendre ceux de Tamagotchi.java ?

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieRobot();
    }
}
