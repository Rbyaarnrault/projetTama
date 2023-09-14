package modele;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tamagotchi {

    private String nom, type;
    private int dureeVie, vie, hygiene, faim, sommeil, loisir;

    public Tamagotchi(String name, String type) { // Instancie un objet tamagotchi par son nom
        if ((type.equals("Chien")) || (type.equals("Chat")) || (type.equals("Robot"))) {
            this.nom = name;
            this.type = type;
            this.dureeVie = 0; // Départ du compteur de durée de vie
            this.vie = 100;
            this.hygiene = 100;
            this.faim = 100;
            this.sommeil = 100;
            this.loisir = 100;

        } else {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Vous devez choisir le type de Tamagotchi !");
        }
    }

    // -----Etat Tamagotchi-----

    public int manger() {
        // Définition de la constante à ajouter lorsqu'il mange
        int i = 30;

        if (faim <= 100 - i) {
            faim += i;
        } else {
            faim = 100;
        }
        return faim;
    }

    public int fatigue() {
        // Définition de la constante à ajouter lorsqu'il dort
        int i = 30;

        if (sommeil <= 100 - i) {
            sommeil += i;
        } else {
            sommeil = 100;
        }
        return sommeil;
    }

    public int proprete() {
        // Définition de la constante à ajouter lorsqu'il se lave
        int i = 30;

        if (hygiene <= 100 - i) {
            hygiene += i;
        } else {
            hygiene = 100;
        }
        return hygiene;
    }

    public int jouer() {
        // Définition de la constante à ajouter lorsqu'il jouer
        int i = 30;

        if (loisir <= 100 - i) {
            loisir += i;
        } else {
            loisir = 100;
        }
        return loisir;
    }

    // -----Getters-----
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    public int getVie() {
        return vie;
    }

    public int getHygiene() {
        return hygiene;
    }

    public int getFaim() {
        return faim;
    }

    public int getSommeil() {
        return sommeil;
    }

    // -----Setters-----
    public void setNom(String n) {
        nom = n;
    }

    public void setVie(int v) {
        vie = v;
    }

    public void setHygiene(int h) {
        hygiene = h;
    }

    public void setFaim(int f) {
        faim = f;
    }

    public void setSommeil(int s) {
        sommeil = s;
    }

    public void setDureeVie(int d) {
        dureeVie = d;
    }
}
