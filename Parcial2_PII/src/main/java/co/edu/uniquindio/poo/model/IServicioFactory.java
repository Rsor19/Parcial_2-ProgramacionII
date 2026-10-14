package co.edu.uniquindio.poo.model;
/**
 * Interfaz IServicioFactory que define el Factory Method para la creación
 * de servicios tecnológicos por medio de sus fabricas
 */

public interface IServicioFactory {
    /**
     * Método fábrica encargado de instanciar y retornar un servicio tecnológico específico.
     *
     * @return Una instancia concreta que implementa IServicioTecnologico.
     */
    IServicioTecnologico crearServicio();
}
