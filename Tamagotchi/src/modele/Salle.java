package modele;

import java.util.List;

public abstract class Salle {

    private Salle salleGauche;
    private Salle salleDroite;
    protected String nom;

    public abstract List<String> getActionsDisponibles();

    public abstract String effectuerAction(String action, Tamagotchi tamagotchi);

    // Méthodes pour définir les salles adjacentes
    public void setSalleGauche(Salle salle) {
        this.salleGauche = salle;
    }

    public void setSalleDroite(Salle salle) {
        this.salleDroite = salle;
    }

    // Méthodes pour obtenir les salles adjacentes
    public Salle getSalleGauche() {
        return salleGauche;
    }

    public Salle getSalleDroite() {
        return salleDroite;
    }

    public String getNomSalle() {
        return nom;
    }
}