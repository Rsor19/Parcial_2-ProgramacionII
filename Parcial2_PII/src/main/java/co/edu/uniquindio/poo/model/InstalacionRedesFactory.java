package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.InstalacionRedes;

/**
 * Fábrica concreta encargada de instanciar objetos de tipo InstalacionRedes
 * aplicando el patrón Factory Method.
 */
public class InstalacionRedesFactory implements IServicioFactory {

    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoBase;
    private int numeroPuntos;

    /**
     * Constructor de la fábrica de instalación de redes.
     *
     * @param codigo Código único del servicio.
     * @param nombre Nombre del servicio.
     * @param descripcion  Descripción detallada.
     * @param costoBase Costo base de la instalación.
     * @param numeroPuntos Cantidad de puntos de red a instalar.
     */
    public InstalacionRedesFactory(String codigo, String nombre, String descripcion, double costoBase, int numeroPuntos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.numeroPuntos = numeroPuntos;
    }

    @Override
    public IServicioTecnologico crearServicio() {
        return new InstalacionRedes(codigo, nombre, descripcion, costoBase, numeroPuntos);
    }
}