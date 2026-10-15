package co.edu.uniquindio.poo.model;

/** Sistema heredado cuya interfaz recibe la especialidad como entero. */
public class LegacySupport {
    /**
     * Consulta un técnico usando la interfaz del sistema heredado.
     * @param codigoEspecialidad código numérico de la especialidad
     * @return identificador del técnico asignado
     */
    public String consultarTecnico(int codigoEspecialidad) {
        return "TEC-" + codigoEspecialidad;
    }
}
