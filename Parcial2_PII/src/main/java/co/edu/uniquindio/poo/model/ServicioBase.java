package co.edu.uniquindio.poo.model;

/**
 * Clase base para los servicios tecnológicos creados por las fábricas.
 */
public abstract class ServicioBase implements IServicioTecnologico {
    protected String codigo;
    protected String nombre;
    protected String descripcion;
    protected double costoBase;

    /**
     * Construye un servicio base.
     * @param codigo código único del servicio
     * @param nombre nombre del servicio
     * @param descripcion descripción del servicio
     * @param costoBase costo base del servicio
     */
    protected ServicioBase(String codigo, String nombre, String descripcion, double costoBase) {
        if (costoBase < 0) {
            throw new IllegalArgumentException("El costo base no puede ser negativo");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
    }

    @Override public String getCodigo() { return codigo; }
    @Override public String getNombre() { return nombre; }
    @Override public String getDescripcion() { return descripcion; }
    @Override public double getCosto() { return costoBase; }
}
