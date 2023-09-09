package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranCuisine extends JPanel {
    private TamagotchiControleur controleur;

    public EcranCuisine(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
