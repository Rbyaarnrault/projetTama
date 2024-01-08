package vue;

import javax.swing.*;

import controlleur.TamagotchiControleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcranDeveloppeur extends JPanel {

    private JSlider sliderTimer;

    public EcranDeveloppeur(TamagotchiControleur contr) {
        this.setLayout(new BorderLayout());

        sliderTimer = new JSlider(1, 100, 1); // curseur actif à cette valeur

        sliderTimer.setMajorTickSpacing(33);
        sliderTimer.setPaintTicks(true);
        sliderTimer.setPaintLabels(true);

        if (contr.getPartie() != null) {
            sliderTimer.setValue(contr.getPartie().getVitesseTimerDecrement());
        }
        BoutonColore boutonValider;
        boutonValider = new BoutonColore("Valider");
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contr.getPartie().setVitesseTimerDecrement(getVitesseTimer());
                contr.changerEcran(contr.getPanelActif()); // Rappelle le dernier écran actif
            }
        });

        JPanel panelSlider = new JPanel(new BorderLayout());
        panelSlider.add(new JLabel("Vitesse multipliée par X"), BorderLayout.NORTH);
        panelSlider.add(sliderTimer, BorderLayout.CENTER);
        panelSlider.add(boutonValider, BorderLayout.SOUTH);

        this.add(panelSlider, BorderLayout.CENTER);
    }

    public int getVitesseTimer() {
        return sliderTimer.getValue();
    }

    public JSlider getSlider() {
        return sliderTimer;
    }
}
