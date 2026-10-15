package co.edu.uniquindio.poo.model;

/** Información de disponibilidad y desplazamiento de un técnico. */
public class InfoTecnico {
    private String idTecnico;
    private boolean disponible;
    private double costoDesplazamiento;

    /**
     * Construye la información de un técnico.
     * @param idTecnico identificador del técnico
     * @param disponible indica si el técnico está disponible
     * @param costoDesplazamiento costo asociado al desplazamiento
     */
    public InfoTecnico(String idTecnico, boolean disponible, double costoDesplazamiento) {
        this.idTecnico = idTecnico;
        this.disponible = disponible;
        this.costoDesplazamiento = costoDesplazamiento;
    }

    public String getIdTecnico() { return idTecnico; }
    public boolean isDisponible() { return disponible; }
    public double getCostoDesplazamiento() { return costoDesplazamiento; }

    public void setIdTecnico(String idTecnico) { this.idTecnico = idTecnico; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public void setCostoDesplazamiento(double costoDesplazamiento) { this.costoDesplazamiento = costoDesplazamiento; }
}
