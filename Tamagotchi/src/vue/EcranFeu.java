package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranFeu extends JPanel {
    private TamagotchiControleur controleur;

    public EcranFeu(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
