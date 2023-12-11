package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import modele.Tamagotchi;

import java.awt.*;

//import javafx.scene.layout.FlowPane;

public class PanelProgressBar extends JPanel {

    private JProgressBar barreVie, barreNourriture, barreSommeil, barreHygiene, barreLoisir;

    public PanelProgressBar() {

        this.setBackground(Color.lightGray);

        JLabel lab1 = new JLabel("Vie");
        barreVie = new JProgressBar();

        JLabel lab2 = new JLabel("Nourriture");
        barreNourriture = new JProgressBar();

        JLabel lab3 = new JLabel("Sommeil");
        barreSommeil = new JProgressBar();

        JLabel lab4 = new JLabel("Hygiène");
        barreHygiene = new JProgressBar();

        JLabel lab5 = new JLabel("Loisir");
        barreLoisir = new JProgressBar();

        // Afficher le pourcentage des JProgressBar
        barreVie.setStringPainted(true);
        barreNourriture.setStringPainted(true);
        barreSommeil.setStringPainted(true);
        barreHygiene.setStringPainted(true);
        barreLoisir.setStringPainted(true);

        // Ajout à l'écran
        this.add(lab1);
        this.add(barreVie);
        this.add(lab2);
        this.add(barreNourriture);
        this.add(lab3);
        this.add(barreSommeil);
        this.add(lab4);
        this.add(barreHygiene);
        this.add(lab5);
        this.add(barreLoisir);

        // Arrangement en grille (col, lig, hgap, vgap)
        this.setLayout(new GridLayout(5, 2, 10, 10));
        this.setBounds(400, 10, 180, 120);
    }

    public void actualiserConstantes(Tamagotchi tama) {
        // Met les barres aux valeurs des attributs du tamagotchi
        setValueBarreVie(tama.getVie());
        setValueBarreNourriture(tama.getFaim());
        setValueBarreSommeil(tama.getSommeil());
        setValueBarreHygiene(tama.getHygiene());
        setValueBarreLoisir(tama.getLoisir());
        this.revalidate();
    }

    // getters des JprogressBar
    public JProgressBar getBarreVie() {
        return barreVie;
    }

    public JProgressBar getBarreNourriture() {
        return barreNourriture;
    }

    public JProgressBar getBarreSommeil() {
        return barreSommeil;
    }

    public JProgressBar getBarreHygiene() {
        return barreHygiene;
    }

    public JProgressBar getBarreLoisir() {
        return barreLoisir;
    }

    // setters des JprogressBar

    public void setValueBarreVie(int i) {
        barreVie.setValue(i);
    }

    public void setValueBarreNourriture(int i) {
        barreNourriture.setValue(i);
    }

    public void setValueBarreSommeil(int i) {
        barreSommeil.setValue(i);
    }

    public void setValueBarreHygiene(int i) {
        barreHygiene.setValue(i);
    }

    public void setValueBarreLoisir(int i) {
        barreLoisir.setValue(i);
    }
}
