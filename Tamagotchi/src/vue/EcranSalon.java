package vue;

import javax.swing.JPanel;

import controlleur.TamagotchiControleur;

public class EcranSalon extends JPanel {
    private TamagotchiControleur controleur;

    public EcranSalon(TamagotchiControleur controleur) {
        this.controleur = controleur;
    }
}
