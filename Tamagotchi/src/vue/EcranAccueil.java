package vue;

import javax.swing.*;

import controlleur.TamagotchiControleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

public class EcranAccueil extends JPanel {

    private TamagotchiControleur controleur;
    private Image img;

    // Définition d'une couleur en hexadécimal
    String hexColor = "#C2794C"; // marron clair
    String hexColor2 = "#5E271E"; // marron foncé
    Color maCouleur = Color.decode(hexColor);
    Color texte = Color.decode(hexColor2);

    public EcranAccueil(TamagotchiControleur controleur) {
        this.controleur = controleur;
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/pageAcc.png").getImage();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Animation de présentation en haut
        // JPanel animationPanel = createAnimationPanel();
        // add(animationPanel);

        add(Box.createVerticalGlue()); // Espace vertical

        // Conteneur pour les boutons
        JPanel panelBoutons = creerPanelBoutons();
        add(panelBoutons);
    }

    private JPanel creerPanelBoutons() {
        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));

        BoutonColore nouvellePartieButton = new BoutonColore("Nouvelle Partie");
        BoutonColore chargerPartieButton = new BoutonColore("Charger une Partie");

        // Gestionnaire d'événements des boutons
        nouvellePartieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aller à l'écran de création de la partie
                controleur.changerEcran("creation");
            }
        });

        chargerPartieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logique pour charger une partie
                controleur.changerEcran("sauvegardes");
            }
        });

        // Centrez les boutons horizontalement + styliser
        nouvellePartieButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        chargerPartieButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ajout d'un espace fixe entre les boutons
        panelBoutons.setOpaque(false);
        panelBoutons.add(nouvellePartieButton);
        panelBoutons.add(Box.createRigidArea(new Dimension(150, 50))); // Espace horizontal de 10 pixels
        panelBoutons.add(chargerPartieButton);

        return panelBoutons;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }
}
