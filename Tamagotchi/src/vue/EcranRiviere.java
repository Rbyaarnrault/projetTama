package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranRiviere extends JPanel {
    private TamagotchiControleur controleur;

    public EcranRiviere(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }

}