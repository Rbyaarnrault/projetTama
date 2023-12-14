package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controlleur.TamagotchiControleur;

public class EcranCreation extends JPanel {

    private JButton boutonEsp1, boutonEsp2, boutonEsp3, boutonEsp4;
    private int especeSelectionnee;

    public EcranCreation(TamagotchiControleur controleur) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // ----- barre de nom -----
        JTextField barreNom = new JTextField();
        barreNom.setPreferredSize(new Dimension(140, 40));
        barreNom.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        this.add(createLabelledPanel("Nom du Tamagotchi:", barreNom)); // Ajout d'un label au JTexteField

        // ----- Espèces -----
        JPanel panEspece = new JPanel(new FlowLayout(FlowLayout.CENTER));

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
        JButton effacerButton = new JButton("Effacer");
        JButton validerButton = new JButton("Valider");
        boutonsPanel.add(effacerButton);
        boutonsPanel.add(validerButton);
        this.add(boutonsPanel);

        // Ajout des écouteurs
        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer le contenu des champs de texte
                barreNom.setText(null);
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
        pan.add(labelComponent, BorderLayout.WEST);
        pan.add(component, BorderLayout.CENTER);
        return pan;
    }

    private JButton creerBouton(String texte) {
        JButton bouton = new JButton(texte);
        bouton.setPreferredSize(new Dimension(120, 150)); // Ajustez la taille selon vos besoins

        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Réinitialisez le style de tous les boutons
                reinitialiserStyleBoutons();

                // Mettez en valeur le bouton sélectionné
                bouton.setBorderPainted(false);
                bouton.setBackground(Color.YELLOW);
                bouton.setFont(new Font("Arial", Font.BOLD, 18)); // Ajustez la police selon vos besoins

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
        boutonEsp1.setBorderPainted(true);
        boutonEsp2.setBorderPainted(true);
        boutonEsp3.setBorderPainted(true);
        boutonEsp4.setBorderPainted(true);
        boutonEsp1.setBackground(null);
        boutonEsp2.setBackground(null);
        boutonEsp3.setBackground(null);
        boutonEsp4.setBackground(null);
        boutonEsp1.setFont(new Font("Arial", Font.PLAIN, 12)); // Police
        boutonEsp2.setFont(new Font("Arial", Font.PLAIN, 12));
        boutonEsp3.setFont(new Font("Arial", Font.PLAIN, 12));
        boutonEsp4.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    // Ajoutez une méthode pour obtenir l'espèce sélectionnée
    public int getEspeceSelectionnee() {
        return especeSelectionnee;
    }

    private void afficherFenetreErreur(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
