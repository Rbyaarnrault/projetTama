package modele;

import java.util.Map;
import java.util.Random;

public class Meteo {
    // Utilisation d'un générateur de nombres aléatoires
    private Random random = new Random();

    // Constantes pour les probabilités
    private static final double PROBABILITE_BEAU_TEMPS = 50.0;
    private static final double PROBABILITE_NUAGEUX = 20.0;
    private static final double PROBABILITE_PLUIE = 25.0;
    private static final double PROBABILITE_ORAGE = 5.0;

    // Constantes pour les états
    private static final String ETAT_BEAU_TEMPS = "Beau temps";
    private static final String ETAT_NUAGEUX = "Nuageux";
    private static final String ETAT_PLUIE = "Pluie";
    private static final String ETAT_ORAGE = "Orage";

    // Map pour associer les probabilités aux états
    private Map<String, Double> probaParEtat = Map.of(
            ETAT_BEAU_TEMPS, PROBABILITE_BEAU_TEMPS,
            ETAT_NUAGEUX, PROBABILITE_NUAGEUX,
            ETAT_PLUIE, PROBABILITE_PLUIE,
            ETAT_ORAGE, PROBABILITE_ORAGE);
    private String conditionActuelle = "Inconnu"; // Initialisation avec une valeur par défaut

    // Méthode pour obtenir la condition météo actuelle
    public String obtenirNouvelleConditionMeteo() {
        double probabilite = random.nextDouble() * 100;

        for (Map.Entry<String, Double> entry : probaParEtat.entrySet()) {
            if (probabilite < entry.getValue()) {
                conditionActuelle = entry.getKey();
                return conditionActuelle;
            } else {
                probabilite -= entry.getValue();
            }
        }

        conditionActuelle = "Inconnu";
        return conditionActuelle;
    }

    public String getConditionActuelle() {
        return conditionActuelle;
    }
}
