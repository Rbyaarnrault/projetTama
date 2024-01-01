package controlleur;

import java.io.*;
import modele.Partie;

public class Sauvegarde {

    public void sauvegarderPartie(Partie partie, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(partie);
            System.out.println("Partie sauvegardée avec succès dans " + nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partie chargerPartie(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            return (Partie) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
