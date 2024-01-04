package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.*;
import controlleur.TamagotchiControleur;

public class EcranCreation extends JPanel {

    private JButton boutonEsp1, boutonEsp2, boutonEsp3, boutonEsp4;
    private int especeSelectionnee;
    private Image img;

    // Définition d'une couleur en hexadécimal
    String hexColor = "#C2794C"; // marron clair
    String hexColor2 = "#5E271E"; // marron foncé
    Color maCouleur = Color.decode(hexColor);
    Color texte = Color.decode(hexColor2);

    public EcranCreation(TamagotchiControleur controleur) {
        this.img = new ImageIcon("Tamagotchi/src/ressources/img/chargePa.png").getImage();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ----- barre de nom -----
        JTextField barreNom = new JTextField();
        barreNom.setPreferredSize(new Dimension(140, 40));
        barreNom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.add(createLabelledPanel("Nom du Tamagotchi:", barreNom)); // Ajout d'un label au JTexteField

        // ----- Espèces -----
        JPanel panEspece = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panEspece.setOpaque(false);

        // Initialisation des boutons
        boutonEsp1 = creerBouton("Chien");
        boutonEsp2 = creerBouton("Chat");
        boutonEsp3 = creerBouton("Robot");
        boutonEsp4 = creerBouton("Poussin");

        // Ajout des boutons au panel espece
        panEspece.add(boutonEsp1);
        panEspece.add(boutonEsp2);
        panEspece.add(boutonEsp3);
        panEspece.add(boutonEsp4);

        // Initialisation de l'espèce sélectionnée

        especeSelectionnee = -1; // Aucune espèce sélectionnée par défaut

        // Ajout du panel Especes au panel Composants
        this.add(panEspece);

        // ----- boutons -----
        JPanel boutonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        boutonsPanel.setOpaque(false);
        JButton effacerButton = new JButton("Effacer");
        JButton validerButton = new JButton("Valider");
        JButton retourMenButton = new JButton("Retour");
        boutonsPanel.add(effacerButton);
        boutonsPanel.add(validerButton);
        boutonsPanel.add(retourMenButton);
        this.add(boutonsPanel);

        // Ajout des écouteurs

        retourMenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controleur.changerEcran("accueil");
            }
        });

        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer le contenu des champs de texte
                barreNom.setText(null);
                especeSelectionnee = -1;
                reinitialiserStyleBoutons();
            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valider la création d'une partie
                if (!barreNom.getText().equals("")) {

                    // Si une espece a bien été selectionnée
                    if (especeSelectionnee != -1) {
                        String espece = "";
                        if (especeSelectionnee == 1) { // espece prends la valeur "Text" du bouton selectionné
                            espece = boutonEsp1.getText();
                        } else if (especeSelectionnee == 2) {
                            espece = boutonEsp2.getText();
                        } else if (especeSelectionnee == 3) {
                            espece = boutonEsp3.getText();
                        } else if (especeSelectionnee == 4) {
                            espece = boutonEsp4.getText();
                        }
                        controleur.creerNouvellePartie(barreNom.getText(), espece);

                    } else {
                        afficherFenetreErreur("Vous devez choisir une espèce !");
                    }

                } else {
                    afficherFenetreErreur("Vous devez entrer un nom !");
                }
            }
        });
        // -----
    }

    private JPanel createLabelledPanel(String label, JComponent component) {
        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pan.setSize(200, 40);
        JLabel labelComponent = new JLabel(label);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        pan.setOpaque(false);
        pan.add(labelComponent, BorderLayout.WEST);
        pan.add(component, BorderLayout.CENTER);
        return pan;
    }

    private JButton creerBouton(String texte) {
        JButton bouton = new JButton(texte);
        bouton.setPreferredSize(new Dimension(120, 150)); // Ajustez la taille selon vos besoins
        bouton.setBackground(maCouleur);
        bouton.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // couleur hexadecimal
                String hexColor = "#C2794C"; // marron clair
                Color maCouleur = Color.decode(hexColor);
                String hexColor2 = "#5E271E"; // marron foncé
                Color texte = Color.decode(hexColor2);

                // Réinitialisez le style de tous les boutons
                reinitialiserStyleBoutons();

                // Mettez en valeur le bouton sélectionné
                bouton.setBorderPainted(false);
                bouton.setBackground(texte);
                bouton.setForeground(maCouleur);
                bouton.setFocusPainted(false);
                bouton.setFont(new Font("Segoe UI", Font.BOLD, 18));

                // Mettez à jour l'espèce sélectionnée
                if (e.getSource() == boutonEsp1) {
                    especeSelectionnee = 1;
                } else if (e.getSource() == boutonEsp2) {
                    especeSelectionnee = 2;
                } else if (e.getSource() == boutonEsp3) {
                    especeSelectionnee = 3;
                } else if (e.getSource() == boutonEsp4) {
                    especeSelectionnee = 4;
                }
            }
        });
        return bouton;
    }

    private void reinitialiserStyleBoutons() {
        // Réinitialisez le style de tous les boutons
        boutonEsp1.setForeground(texte);
        boutonEsp2.setForeground(texte);
        boutonEsp3.setForeground(texte);
        boutonEsp4.setForeground(texte);
        boutonEsp1.setBackground(maCouleur);
        boutonEsp2.setBackground(maCouleur);
        boutonEsp3.setBackground(maCouleur);
        boutonEsp4.setBackground(maCouleur);
        boutonEsp1.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Police
        boutonEsp2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        boutonEsp3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        boutonEsp4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    }

    // Ajoutez une méthode pour obtenir l'espèce sélectionnée
    public int getEspeceSelectionnee() {
        return especeSelectionnee;
    }

    private void afficherFenetreErreur(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
        }
    }

}
