package vue;

import javax.swing.*;
import java.awt.*;

public class BoutonTriangle extends JButton {

    private Direction direction;

    // Définition d'une couleur en hexadécimal
    String hexColor2 = "#5E271E"; // marron foncé
    String hexColor = "#C2794C"; // marron clair
    Color clair = Color.decode(hexColor);
    Color fonce = Color.decode(hexColor2);

    public BoutonTriangle(Direction direction) {
        this.direction = direction;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(fonce);
        g2d.fillPolygon(createTriangle());

        // Ajout du contour marron clair
        g2d.setColor(clair);
        g2d.setStroke(new BasicStroke(6));
        g2d.drawPolygon(createTriangle());

        g2d.dispose();
    }

    private Polygon createTriangle() {
        Polygon polygon = new Polygon();
        switch (direction) {
            case HAUT:
                polygon.addPoint(0, 50);
                polygon.addPoint(50, 50);
                polygon.addPoint(25, 0);
                break;
            case BAS:
                polygon.addPoint(0, 0);
                polygon.addPoint(50, 0);
                polygon.addPoint(25, 50);
                break;
            case GAUCHE:
                polygon.addPoint(50, 0);
                polygon.addPoint(50, 50);
                polygon.addPoint(0, 25);
                break;
            case DROITE:
                polygon.addPoint(0, 0);
                polygon.addPoint(0, 50);
                polygon.addPoint(50, 25);
                break;
        }
        return polygon;
    }

    public enum Direction {
        HAUT, BAS, GAUCHE, DROITE
    }
}
