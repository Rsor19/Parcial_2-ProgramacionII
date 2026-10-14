package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.MantenimientoPreventivo;

/**
 * Fábrica concreta encargada de instanciar objetos de tipo MantenimientoPreventivo
 * aplicando el patrón Factory Method.
 */
public class MantenimientoPreventivoFactory implements IServicioFactory {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;

    /**
     * Constructor de la fábrica de mantenimiento preventivo.
     *
     * @param codigo Código único del servicio.
     * @param nombre Nombre del servicio.
     * @param descripcion Descripción detallada.
     * @param costoBase Costo base del mantenimiento.
     */
    public MantenimientoPreventivoFactory(String codigo, String nombre, String descripcion, double costoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
    }

    @Override
    public IServicioTecnologico crearServicio() {
        return new MantenimientoPreventivo(codigo, nombre, descripcion, costoBase);
    }
}