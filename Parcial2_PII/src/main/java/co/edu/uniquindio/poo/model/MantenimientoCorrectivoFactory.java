package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.MantenimientoCorrectivo;

/**
 * Fábrica concreta encargada de instanciar objetos de tipo MantenimientoCorrectivo
 * aplicando el patrón Factory Method.
 */
public class MantenimientoCorrectivoFactory implements IServicioFactory {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;

    /**
     * Constructor de la fábrica de mantenimiento correctivo.
     *
     * @param codigo Código único del servicio.
     * @param nombre Nombre del servicio.
     * @param descripcion Descripción detallada.
     * @param costoBase Costo base del mantenimiento correctivo.
     */
    public MantenimientoCorrectivoFactory(String codigo, String nombre, String descripcion, double costoBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
    }

    @Override
    public IServicioTecnologico crearServicio() {
        return new MantenimientoCorrectivo(codigo, nombre, descripcion, costoBase);
    }
}