package util;

import java.time.Duration;

public class ChronoFormateur {
    public static String DureeFormat(long dureeEnSecondes) {
        Duration duree = Duration.ofSeconds(dureeEnSecondes);

        // Conversions en unités de temps
        long annees = duree.toDays() / 365;
        long mois = (duree.toDays() % 365) / 30;
        long jours = duree.toDays() % 30;
        long heures = duree.toHours() % 24;
        long minutes = duree.toMinutes() % 60;
        long secondes = duree.getSeconds() % 60;

        // Chaine String plus facile à manier pour des modifications
        StringBuilder dureeFormatee = new StringBuilder();

        if (annees > 0) {
            if (annees > 1) { // Si au pluriel = au moins 2
                dureeFormatee.append(annees).append("ans ");
            } else { // Si c'est au singulier =1
                dureeFormatee.append(annees).append("an ");
            }
        }
        if (mois > 0) { // Pas besoin ici car mot invariable
            dureeFormatee.append(mois).append("mois ");
        }
        if (jours > 0) {
            if (jours > 1) {
                dureeFormatee.append(jours).append("jours ");
            } else {
                dureeFormatee.append(jours).append("jour ");
            }
        }
        if (heures > 0) {
            if (heures > 1) {
                dureeFormatee.append(heures).append("h ");
            }
        }
        if (minutes > 0) {
            if (minutes > 1) {
                dureeFormatee.append(minutes).append("mins ");
            } else {
                dureeFormatee.append(minutes).append("min ");
            }
        }
        if (secondes > 0) {
            if (secondes > 1) {
                dureeFormatee.append(secondes).append("secs ");
            } else {
                dureeFormatee.append(secondes).append("sec ");
            }
        }

        return dureeFormatee.toString();
    }
}