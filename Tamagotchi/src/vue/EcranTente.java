package vue;

import controlleur.TamagotchiControleur;

public class EcranTente extends EcranJeu {

    public EcranTente(TamagotchiControleur contr) {
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
        btnFeu.setBounds(295, 400, 80, 30);
        this.add(btnFeu);
        // BTN Actions
        btnDormir.setBounds(360, 270, 80, 30);
        this.add(btnDormir);
    }

    // Méthode d'actualisation du PanelProgressBar
    @Override
    public void actualiserComposantsAvecAttributs() {
        super.actualiserComposantsAvecAttributs();
    }
}
