package controlleur;

import java.io.*;

import modele.Chat;
import modele.Chien;
import modele.Partie;
import modele.Poussin;
import modele.Robot;

public class Sauvegarde {

    public void sauvegarderPartie(Partie partie, String nomFichier) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {

            oos.writeObject(partie);

            // Seul moyen pour stocker le chemin d'accès de l'image
            if (partie.getTamagotchi() instanceof Chien) {
                oos.writeObject("Tamagotchi/src/ressources/img/chien.png");
            } else if (partie.getTamagotchi() instanceof Chat) {
                oos.writeObject("");
            } else if (partie.getTamagotchi() instanceof Poussin) {
                oos.writeObject("");
            } else if (partie.getTamagotchi() instanceof Robot) {
                oos.writeObject("");
            }

            System.out.println("Partie sauvegardée avec succès dans " + nomFichier);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partie chargerPartie(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            Object obj = ois.readObject();

            if (obj instanceof Partie) {
                // Me permet de voir le contenu de partie en debug pour voir si tout est
                // fonctionnel
                Partie partie = (Partie) obj;
                return partie;
            } else {
                System.out.println("Le fichier ne contient pas une instance de Partie.");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la lecture de la sauvegarde : " + e.getMessage());
            return null;
        }
    }
}
