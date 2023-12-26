package util;

import javax.swing.*;
import java.awt.*;

public class BoutonTriangle extends JButton {
    private Polygon triangle;

    public BoutonTriangle(Direction direction) {
        this.triangle = createTriangle(direction);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    private Polygon createTriangle(Direction direction) {
        Polygon polygon = new Polygon();
        switch (direction) {
            case UP:
                polygon.addPoint(0, 10);
                polygon.addPoint(10, 10);
                polygon.addPoint(5, 0);
                break;
            case DOWN:
                polygon.addPoint(0, 0);
                polygon.addPoint(10, 0);
                polygon.addPoint(5, 10);
                break;
            case LEFT:
                polygon.addPoint(10, 0);
                polygon.addPoint(10, 10);
                polygon.addPoint(0, 5);
                break;
            case RIGHT:
                polygon.addPoint(0, 0);
                polygon.addPoint(0, 10);
                polygon.addPoint(10, 5);
                break;
        }
        return polygon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillPolygon(triangle);
        g2d.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        BoutonTriangle upButton = new BoutonTriangle(Direction.UP);
        BoutonTriangle downButton = new BoutonTriangle(Direction.DOWN);
        BoutonTriangle leftButton = new BoutonTriangle(Direction.LEFT);
        BoutonTriangle rightButton = new BoutonTriangle(Direction.RIGHT);

        panel.add(upButton);
        panel.add(downButton);
        panel.add(leftButton);
        panel.add(rightButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
