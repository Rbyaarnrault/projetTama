package vue;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TamagotchiAnimation extends JPanel {
    private JFXPanel fxPanel;

    public TamagotchiAnimation() {
        setLayout(new BorderLayout());

        fxPanel = new JFXPanel();

        add(fxPanel, BorderLayout.CENTER);

        // Créez un minuteur pour la mise à jour de l'animation Swing
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise à jour de l'animation Swing ici si nécessaire
            }
        });

        // Démarrez le minuteur
        timer.start();

        // Initialisation de l'animation JavaFX dans un thread séparé
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initFX();
            }
        });
    }

    private void initFX() {
        Scene scene = new Scene(new TamagotchiAnimationFX());
        fxPanel.setScene(scene);
    }
}
