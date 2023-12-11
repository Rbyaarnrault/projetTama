package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranDeveloppeur extends JPanel {

    private JSlider sliderTimer;
    private JButton boutonValider;

    public EcranDeveloppeur(int valeurParDefaut, ActionListener validerListener) {
        this.setLayout(new BorderLayout());

        sliderTimer = new JSlider(1, 10, valeurParDefaut); // Ajoutez la valeur par défaut
        sliderTimer.setMajorTickSpacing(1);
        sliderTimer.setPaintTicks(true);
        sliderTimer.setPaintLabels(true);

        boutonValider = new JButton("Valider");
        boutonValider.addActionListener(validerListener);

        JPanel panelSlider = new JPanel(new BorderLayout());
        panelSlider.add(new JLabel("Ajuster la vitesse du timer"), BorderLayout.NORTH);
        panelSlider.add(sliderTimer, BorderLayout.CENTER);
        panelSlider.add(boutonValider, BorderLayout.SOUTH);

        this.add(panelSlider, BorderLayout.CENTER);
    }

    public int getVitesseTimer() {
        return sliderTimer.getValue();
    }
}
