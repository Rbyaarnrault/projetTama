package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranTente extends JPanel {
    private TamagotchiControleur controleur;

    public EcranTente(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
