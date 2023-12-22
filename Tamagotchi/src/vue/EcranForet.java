package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranForet extends EcranJeu {

    public EcranForet(TamagotchiControleur contr) {
        super(contr);
        this.setLayout(null);
        super.initialiserPanels();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 400, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(500, 360, 120, 30);
        this.add(btnQuitter);
        // BTN Lieux
        btnFeu.setBounds(280, 320, 80, 30);
        this.add(btnFeu);
        btnRiviere.setBounds(280, 400, 80, 30);
        this.add(btnRiviere);
        // BTN Actions
        btnManger.setBounds(280, 240, 80, 30);
        this.add(btnManger);
        btnJouer.setBounds(380, 220, 80, 30);
        this.add(btnJouer);
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        super.actualiserComposantsAvecAttributs();
    }

}
