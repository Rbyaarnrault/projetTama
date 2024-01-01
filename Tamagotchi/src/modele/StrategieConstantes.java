package modele;

import java.io.Serializable;

public abstract class StrategieConstantes implements Serializable {
    // Constantes pour les valeurs limites maximales
    protected int MIN_VIE, MAX_VIE;
    protected int MIN_HYGIENE, MAX_HYGIENE;
    protected int MIN_FAIM, MAX_FAIM;
    protected int MIN_SOMMEIL, MAX_SOMMEIL;
    protected int MIN_LOISIR, MAX_LOISIR;

    // Constantes pour les incrémentation et decrémentations
    protected int DEC_HYGIENE, INC_HYGIENE;
    protected int DEC_FAIM, INC_FAIM;
    protected int DEC_SOMMEIL, INC_SOMMEIL;
    protected int DEC_LOISIR, INC_LOISIR;

    public int getMin_Vie() {
        return MIN_VIE;
    }

    public int getMax_Vie() {
        return MAX_VIE;
    }

    public int getMin_Hygiene() {
        return MIN_HYGIENE;
    }

    public int getMax_Hygiene() {
        return MAX_HYGIENE;
    }

    public int getMin_Faim() {
        return MIN_FAIM;
    }

    public int getMax_Faim() {
        return MAX_FAIM;
    }

    public int getMin_Sommeil() {
        return MIN_SOMMEIL;
    }

    public int getMax_Sommeil() {
        return MAX_SOMMEIL;
    }

    public int getMin_Loisir() {
        return MIN_LOISIR;
    }

    public int getMAX_Loisir() {
        return MAX_LOISIR;
    }

    // ----------------------

    public int getDec_Hygiene() {
        return DEC_HYGIENE;
    }

    public int getInc_Hygiene() {
        return INC_HYGIENE;
    }

    public int getDec_Faim() {
        return DEC_FAIM;
    }

    public int getInc_Faim() {
        return INC_FAIM;
    }

    public int getDec_Sommeil() {
        return DEC_SOMMEIL;
    }

    public int getInc_Sommeil() {
        return INC_SOMMEIL;
    }

    public int getDec_Loisir() {
        return DEC_LOISIR;
    }

    public int getInc_Loisir() {
        return INC_LOISIR;
    }

}