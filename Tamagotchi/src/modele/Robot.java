package modele;

public class Robot extends Tamagotchi {

    // Créer nouvelles variables

    public Robot(String name) {
        super(name);
    }

    // -----Etat Tamagotchi-----

    public void recharger() {
        // Incrémentation de l'attribut faim par la constante INC_
        // faim = incrementerValeur(faim, strategie.getInc_Faim(),
        // strategie.getMax_Faim());
    }

    public void recycler() {
        // Incrémentation de l'attribut sommeil par la constante INC_SOMMEIL
        // sommeil = incrementerValeur(sommeil, strategie.getInc_Sommeil(),
        // strategie.getMax_Sommeil());
        // return sommeil;
    }

    public void maj() {
        // Incrémentation de l'attribut hygiene par la constante INC_HYGIENE
        // hygiene = incrementerValeur(hygiene, strategie.getInc_Hygiene(),
        // strategie.getMax_Hygiene());
        // return hygiene;
    }

    public void blague() {
        // Incrémentation de l'attribut loisir par la constante INC_LOISIR
        // loisir = incrementerValeur(loisir, strategie.getInc_Loisir(),
        // strategie.getMAX_Loisir());
        // return loisir;
    }

    // -----Getters----

    public int getMaj() {
        // return hygiene;
    }

    public int getRecharge() {
        // return faim;
    }

    public int getRecycler() {
        // return sommeil;
    }

    public int getBlague() {
        // return loisir;
    }

    // Créer des setters différents ou reprendre ceux de Tamagotchi.java ?

    @Override
    protected StrategieConstantes initialiserStrategie() {
        return new StrategieRobot();
    }
}
