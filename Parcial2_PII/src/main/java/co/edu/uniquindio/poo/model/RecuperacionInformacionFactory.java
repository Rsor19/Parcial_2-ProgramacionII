package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.RecuperacionInformacion;

/**
 * Fábrica concreta encargada de instanciar objetos de tipo RecuperacionInformacion
 * aplicando el patrón Factory Method.
 */
public class RecuperacionInformacionFactory implements IServicioFactory {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;
    private double volumenDatosGb;

    /**
     * Constructor de la fábrica de recuperación de información.
     *
     * @param codigo Código único del servicio.
     * @param nombre Nombre del servicio.
     * @param descripcion Descripción detallada.
     * @param costoBase Costo base del servicio.
     * @param volumenDatosGb Volumen aproximado de datos a recuperar en Gigabytes.
     */
    public RecuperacionInformacionFactory(String codigo, String nombre, String descripcion, double costoBase, double volumenDatosGb) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.volumenDatosGb = volumenDatosGb;
    }

    @Override
    public IServicioTecnologico crearServicio() {
        return new RecuperacionInformacion(codigo, nombre, descripcion, costoBase, volumenDatosGb);
    }
}