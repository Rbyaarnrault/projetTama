package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modele.Tamagotchi;
import util.ChronoFormateur;

public class PanelInfos extends JPanel {

    private JLabel nom, duree, physique, moral;

    public PanelInfos() {
        this.setBackground(Color.lightGray);

        JLabel lab1 = new JLabel("Nom:");
        nom = new JLabel("?");

        JLabel lab2 = new JLabel("Durée de Vie:");
        duree = new JLabel("?");

        JLabel lab3 = new JLabel("Forme physique:");
        physique = new JLabel("?");

        JLabel lab4 = new JLabel("Moral:");
        moral = new JLabel("?");

        /*
         * GridLayout lay = new GridLayout(4, 2, 10, 10);
         * this.setLayout(lay);
         * this.setBounds(10, 10, 150, 80);
         * 
         * this.add(lab1);
         * this.add(nom);
         * this.add(lab2);
         * this.add(duree);
         * this.add(lab3);
         * this.add(physique);
         * this.add(lab4);
         * this.add(moral);
         */

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

        this.setBounds(10, 10, 200, 120);

    }

    public void actualiserInfos(Tamagotchi tama) {
        // Met les barres aux valeurs des attributs du tamagotchi
        setLabelNom(tama.getNom());
        setLabelDuree(actualiserDuree(tama.getDureeVie()));
        setLabelPhysique("?"); // A DEFINIR DANS TAMA
        setLabelMoral("?");
        this.revalidate();
    }

    public String actualiserDuree(long durationInSeconds) {
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
}
