package co.edu.uniquindio.poo.model;

/** Servicio esperado por el sistema actual para consultar técnicos. */
public interface ITecnicoService {
    /**
     * Consulta la disponibilidad de un técnico por especialidad.
     * @param especialidad código o nombre de la especialidad
     * @return información del técnico encontrado
     */
    InfoTecnico consultarDisponibilidadTecnico(String especialidad);
}
