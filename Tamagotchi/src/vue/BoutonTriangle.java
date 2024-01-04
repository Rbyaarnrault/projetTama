package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonTriangle extends JButton {

    private Direction direction;

    public BoutonTriangle(Direction direction) {
        this.direction = direction;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gérer l'action du bouton triangle ici, si nécessaire
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillPolygon(createTriangle());
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
