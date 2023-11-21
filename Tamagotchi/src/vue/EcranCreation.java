package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.TamagotchiControleur;

public class EcranCreation extends JPanel {

    private TamagotchiControleur controleur;
    private JComboBox<String> choixEspece;

    public EcranCreation(TamagotchiControleur controleur) {
        this.controleur = controleur;

        JPanel panBoutonComposant = creerPanelComposant();
        this.add(panBoutonComposant);
    }

    private JPanel creerPanelComposant() {
        JPanel panBoutonComposant = new JPanel();
        panBoutonComposant.setLayout(new GridLayout(4, 1, 5, 5)); // Utilisation d'une grille pour l'alignement

        // Création des composants

        JTextField barreNom = new JTextField();
        String[] especes = { "Chien", "Chat", "Robot", "Lapin" };
        choixEspece = new JComboBox<>(especes);
        JButton effacerButton = new JButton("Effacer");
        JButton validerButton = new JButton("Valider");

        JPanel panEspece = new JPanel(new FlowLayout());

        // Ajout des composants aux JPanels
        panBoutonComposant.add(createLabelledPanel("Nom:", barreNom)); // Ajout d'un label au JTexteField
        panEspece.add(choixEspece);
        this.add(panEspece);

        // Ajout des écouteurs
        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer le contenu des champs de texte
                barreNom.setText(null);

            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valider la création d'une partie
                if (!barreNom.getText().equals("")) {

                    // SI COMBOBOX A BIEN CHOISI UN ITEM
                    if (choixEspece.getSelectedItem() != null) {
                        String espece = (String) choixEspece.getSelectedItem();
                        controleur.creerNouvellePartie(barreNom.getText(), espece);
                    } else {
                        afficherFenetreErreur("Vous devez choisir une espèce !");
                    }

                } else {
                    afficherFenetreErreur("Vous devez entrer un nom !");
                }
            }
        });

        JPanel boutonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        boutonsPanel.add(effacerButton);
        boutonsPanel.add(validerButton);
        panBoutonComposant.add(boutonsPanel);

        return panBoutonComposant;
    }

    private JPanel createLabelledPanel(String label, JComponent component) {
        JPanel panBoutonComposant = new JPanel(new BorderLayout());
        JLabel labelComponent = new JLabel(label);
        panBoutonComposant.add(labelComponent, BorderLayout.WEST);
        panBoutonComposant.add(component, BorderLayout.CENTER);
        return panBoutonComposant;
    }

    private void afficherFenetreErreur(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
