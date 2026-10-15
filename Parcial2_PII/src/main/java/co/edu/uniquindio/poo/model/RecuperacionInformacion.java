package co.edu.uniquindio.poo.model;

/**
 * Servicio concreto para recuperar información.
 */
public class RecuperacionInformacion extends ServicioBase {
    private double volumenDatosGb;

    public RecuperacionInformacion(String codigo, String nombre, String descripcion,
                                   double costoBase, double volumenDatosGb) {
        super(codigo, nombre, descripcion, costoBase);
        if (volumenDatosGb < 0) throw new IllegalArgumentException("El volumen no puede ser negativo");
        this.volumenDatosGb = volumenDatosGb;
    }

    public double getVolumenDatosGb() { return volumenDatosGb; }
}
