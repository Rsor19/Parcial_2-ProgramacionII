package co.edu.uniquindio.poo.model;

/**
 * Clase Interface encargada del manejo de solciitudes de servicio y su funcionamiento con el decorator
 */
public interface IServicioTecnologico {
    /**
     * Retorna el código único del servicio.
     */
    String getCodigo();

    /**
     * Retorna el nombre del servicio.
     */
    String getNombre();

    /**
     * Retorna la descripción detallada del servicio.
     */
    String getDescripcion();

    /**
     * Retorna el costo total del servicio.
     */
    double getCosto();
}
