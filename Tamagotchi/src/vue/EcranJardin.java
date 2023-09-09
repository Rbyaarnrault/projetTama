package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranJardin extends JPanel {
    private TamagotchiControleur controleur;

    public EcranJardin(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
