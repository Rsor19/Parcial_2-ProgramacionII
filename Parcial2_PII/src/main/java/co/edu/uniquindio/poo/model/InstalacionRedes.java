package co.edu.uniquindio.poo.model;

/** Servicio concreto para instalar redes. */
public class InstalacionRedes extends ServicioBase {
    private int numeroPuntos;

    public InstalacionRedes(String codigo, String nombre, String descripcion,
                            double costoBase, int numeroPuntos) {
        super(codigo, nombre, descripcion, costoBase);
        if (numeroPuntos < 0) throw new IllegalArgumentException("El número de puntos no puede ser negativo");
        this.numeroPuntos = numeroPuntos;
    }

    public int getNumeroPuntos() { return numeroPuntos; }
}
