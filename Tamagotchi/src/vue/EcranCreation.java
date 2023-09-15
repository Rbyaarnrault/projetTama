package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.TamagotchiControleur;

public class EcranCreation extends JPanel {

    private TamagotchiControleur controleur;

    public EcranCreation(TamagotchiControleur controleur) {
        this.controleur = controleur;

        JPanel panBoutonComposant = creerPanelComposant();
        this.add(panBoutonComposant);
    }

    public JPanel creerPanelComposant() {
        JPanel panBoutonComposant = new JPanel();
        panBoutonComposant.setLayout(new GridLayout(4, 1, 5, 5)); // Utilisation d'une grille pour l'alignement

        // Création des composants
        JTextField nomField = new JTextField();
        JTextField typeField = new JTextField();
        JButton effacerButton = new JButton("Effacer");
        JButton validerButton = new JButton("Valider");

        // Ajout des composants au JPanel
        panBoutonComposant.add(createLabelledPanel("Nom:", nomField));
        panBoutonComposant.add(createLabelledPanel("Type:", typeField));

        // Ajout des écouteurs
        effacerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Supprimer le contenu des champs de texte
                nomField.setText(null);
                validerButton.setText(null);
            }
        });
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Valider la création d'une partie
                if (!nomField.getText().equals("")) {

                    // Si le type est chien, chat ou robot, je crée la partie sinon j'averti
                    // l'utilisateur
                    if ((typeField.getText().equals("Chien")) || (typeField.getText().equals("Chat"))
                            || (typeField.getText().equals("Robot"))) {

                        controleur.creerNouvellePartie(nomField.getText(), typeField.getText());
                    } else {
                        afficherFenetreErreur("Le type n'est pas bon !");

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
