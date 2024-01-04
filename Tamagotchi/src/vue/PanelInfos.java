package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Partie;
import util.ChronoFormateur;

public class PanelInfos extends JPanel {

    private JLabel nom, duree, physique, moral, meteo;

    // Définition d'une couleur en hexadécimal
    String hexColor = "#C2794C"; // marron clair
    String hexColor2 = "#5E271E"; // marron foncé
    Color maCouleur = Color.decode(hexColor);
    Color texte = Color.decode(hexColor2);

    public PanelInfos() {
        this.setBackground(maCouleur);

        JLabel lab1 = new JLabel("Nom:");
        nom = new JLabel("");

        JLabel lab2 = new JLabel("Durée de Vie:");
        duree = new JLabel("");

        JLabel lab3 = new JLabel("Forme physique:");
        physique = new JLabel("?");

        JLabel lab4 = new JLabel("Moral:");
        moral = new JLabel("?");

        JLabel lab5 = new JLabel("Météo:");
        meteo = new JLabel("");

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Marge

        // nom positionnée à la première colonne, première ligne
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(lab1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(nom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(lab2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(duree, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(lab3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(physique, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(lab4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(moral, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(lab5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(meteo, gbc);

        this.setBounds(10, 10, 200, 160);

    }

    public void actualiserInfos(Partie partie) {
        // Met les barres aux valeurs des attributs du tamagotchi
        setLabelNom(partie.getTamagotchi().getNom());
        setLabelDuree(actualiserDuree(partie.getTamagotchi().getDureeVie()));
        setLabelPhysique("?"); // A DEFINIR DANS TAMA
        setLabelMoral("?");
        setLabelMeteo(partie.getMeteo().getConditionActuelle());
        this.revalidate();
    }

    public String actualiserDuree(int durationInSeconds) {
        // Appel de la classe ChronoFormateur pour convertir la duree
        String dureeFormatee = ChronoFormateur.DureeFormat(durationInSeconds);
        return dureeFormatee;
    }

    // -----Setters----- (getters pas nécessaires car représente le tamagotchi)

    public void setLabelNom(String s) {
        nom.setText(s);
    }

    public void setLabelDuree(String s) {
        duree.setText(s);
    }

    public void setLabelPhysique(String s) {
        physique.setText(s);
    }

    public void setLabelMoral(String s) {
        moral.setText(s);
    }

    public void setLabelMeteo(String s) {
        meteo.setText(s);
    }
}
