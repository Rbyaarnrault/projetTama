package modele;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.time.Duration;
import java.time.Instant;

public class Robot extends Tamagotchi {

    // Créer nouvelles variables
    private double batterie, processeur, humeur;
    private int compteurRecharge;

    public Robot(String name) {
        super(name);
        // A MODIFIER POUR BONNE IMAGE
        cheminImage = "Tamagotchi/src/ressources/img/Robot.png";
        setImage(new ImageIcon(cheminImage).getImage());

        compteurRecharge = 0;
        this.vie = ((StrategieRobot) strategie).MAX_VIE;
        this.batterie = ((StrategieRobot) strategie).MAX_BATTERIE;
        this.processeur = ((StrategieRobot) strategie).MAX_PROCESSEUR;
        this.humeur = ((StrategieRobot) strategie).MAX_HUMEUR;
    }

    protected void actualiserVie() {
        // Calcule la valeur de "vie" selon le nb de recharge
        // Recharger use la batterie
        vie = compteurRecharge * strategie.DEC_VIE;
    }

    // -----Etat Tamagotchi-----
    public void actualisationDecrementationConstantes(int vitesseTimerDecr) {

        if (vie > 0) { // Si vie en positif non nul
            // Calcul de la décrémentation depuis la dernière actualisation
            Instant maintenant = Instant.now(); // Fixe l'instant ou j'actualise
            Duration dureeEcoulee = Duration.between(derniereActualisation, maintenant);

            // vitesseTimerDecr permet de faire varier la vitesse d'écoulement du temps
            // entre 1 et 100 fois plus vite
            long tempsEcouleMillis = dureeEcoulee.toMillis() * vitesseTimerDecr;

            // Methode qui va adapter la strategie selon la météo
            // checkConditionMeteo();

            // Plus la constante sera grande est plus le "temps" semblera long entre 2
            // decrement
            // ici 216000 = 6h
            batterie -= ((tempsEcouleMillis / 216000.0) * strategie.DEC_BATTERIE);
            processeur += ((tempsEcouleMillis / 216000) * strategie.INC_PROCESSEUR);
            humeur -= ((tempsEcouleMillis / 216000) * strategie.DEC_HYGIENE);

            // Affectation du temps fixé pour situer la dernière actualisation
            derniereActualisation = maintenant;

            // recalcule la valeur de vie
            actualiserVie();

        } else {
            // On le fait mourir une seule fois et pas à chaques secondes
            if (estMort == false) {
                mourir(); // Sinon faire mourir le tama
                // Evite du processing si le tama est mort
            }
        }
    }

    public void recharger() {
        compteurRecharge += 1;
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

    public void mourir() {
        if (getVie() <= 0) {
            // Mise au min de tous les attributs
            estMort = true;
            batterie = strategie.MIN_BATTERIE;
            processeur = strategie.MIN_PROCESSEUR;
            humeur = strategie.MIN_HUMEUR;

            // Afficher un message informant de la mort
            JOptionPane.showMessageDialog(new JFrame(), "Votre Tamagotchi est mort. Game Over.",
                    "Game Over", JOptionPane.YES_OPTION);
        }
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
