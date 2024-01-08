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

}