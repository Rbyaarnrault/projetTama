package vue;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BoutonColore extends JButton {

    public BoutonColore(String s) {
        // Définition d'une couleur en hexadécimal
        String hexColor = "#C2794C"; // marron clair
        String hexColor2 = "#5E271E"; // marron foncé
        Color clair = Color.decode(hexColor);
        Color fonce = Color.decode(hexColor2);

        this.setText(s);
        this.setBackground(clair);
        this.setForeground(fonce);
        this.setFocusPainted(false);
        // this.setFont(new Font("Segoe UI", Font.PLAIN, 16)); // Police
        this.addMouseListener(new MouseListener() {

            // Seulement 2 nous intéressent
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(fonce);
                setForeground(clair);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(clair);
                setForeground(fonce);
            }

            // -----------------
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

        });
    }
}
