package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import controlleur.TamagotchiControleur;
import util.EcranActualisable;

public class EcranRiviere extends EcranJeu implements EcranActualisable {

    public EcranRiviere(TamagotchiControleur contr) {
        super(contr);
        this.setLayout(null);
        super.initialiserPanels();
    }

    protected void placerComposants() {
        btnDeveloppeur.setBounds(520, 400, 160, 20);
        this.add(btnDeveloppeur);
        btnQuitter.setBounds(500, 360, 120, 30);
        this.add(btnQuitter);
        btnLaver.setBounds(280, 240, 80, 30);
        this.add(btnLaver);
        btnForet.setBounds(280, 320, 80, 30);
        this.add(btnForet);

        // SI NE PAS FAIRE ADD FONCTIONNE PAS ? TU RAJOUTES :
        // btnPasAFFICHES.SETVISIBLE(false) et mettre les autres autres.
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        super.actualiserComposantsAvecAttributs();
    }
}
