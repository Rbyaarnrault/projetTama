package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleur.TamagotchiControleur;
import javax.swing.Box;

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

}
