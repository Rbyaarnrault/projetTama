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

        strategie = new StrategieRobot();
        this.batterie = strategie.MAX_BATTERIE;
        this.processeur = strategie.MAX_PROCESSEUR;
        this.humeur = strategie.MAX_HUMEUR;
    }

    // -----Etat Tamagotchi-----

    public void recharger() {
        batterie += strategie.INC_BATTERIE;
        batterie = Math.min(batterie, strategie.MAX_BATTERIE); // Permet de ne pas dépasse la borne max
    }

    public void libererMemoire() {
        processeur -= strategie.DEC_PROCESSEUR;
        processeur = Math.min(processeur, strategie.MAX_PROCESSEUR);
    }

    public void userVie() {
        vie -= strategie.DEC_VIE;
    }

    public void blaguer() {
        // Permet au robot de faire une blague aléatoirement dans une liste
        // Incrémentation de l'attribut loisir par la constante INC_LOISIR
        // loisir = incrementerValeur(loisir, strategie.getInc_Loisir(),
        // strategie.getMAX_Loisir());
        // return loisir;
    }

    // -----Getters----
    public int getBatterie() {
        return (int) batterie;
    }

    public int getProcesseur() {
        return (int) processeur;
    }

    // Créer des setters différents ou reprendre ceux de Tamagotchi.java ?

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieRobot();
    }
}
