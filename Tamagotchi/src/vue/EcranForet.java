package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranForet extends JPanel {
    private TamagotchiControleur controleur;

    public EcranForet(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
