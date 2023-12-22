package vue;

import controlleur.TamagotchiControleur;

public class EcranFeu extends EcranJeu {

    public EcranFeu(TamagotchiControleur contr) {
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
        btnForet.setBounds(280, 320, 80, 30);
        this.add(btnForet);
        btnTente.setBounds(280, 400, 80, 30);
        this.add(btnTente);
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
