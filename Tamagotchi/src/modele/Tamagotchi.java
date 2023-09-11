package modele;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tamagotchi {

    private String nom, type;
    private int dureeVie, vie, hygiene, faim, sommeil;

    public Tamagotchi(String name, String type) { // Instancie un objet tamagotchi par son nom
        if ((type.equals("Chien")) || (type.equals("Chat")) || (type.equals("Robot"))) {
            this.nom = name;
            this.type = type;
            this.dureeVie = 0; // Départ du compteur de durée de vie
            this.vie = 100;
            this.hygiene = 100;
            this.faim = 100;
            this.sommeil = 100;

        } else {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Vous devez choisir le type de Tamagotchi !");
        }
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
