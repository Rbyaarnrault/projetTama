package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranSalleBain extends JPanel {
    private TamagotchiControleur controleur;

    public EcranSalleBain(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }

}