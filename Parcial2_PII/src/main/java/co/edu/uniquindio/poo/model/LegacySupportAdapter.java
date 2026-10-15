package co.edu.uniquindio.poo.model;

/** Adaptador que permite usar LegacySupport mediante ITecnicoService. */
public class LegacySupportAdapter implements ITecnicoService {
    private LegacySupport legacySupport;

    /**
     * Construye el adaptador con el sistema heredado que delegará la consulta.
     * @param legacySupport sistema heredado
     */
    public LegacySupportAdapter(LegacySupport legacySupport) {
        if (legacySupport == null) {
            throw new IllegalArgumentException("El soporte heredado es obligatorio");
        }
        this.legacySupport = legacySupport;
    }

    @Override
    public InfoTecnico consultarDisponibilidadTecnico(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        try {
            int codigoEspecialidad = Integer.parseInt(especialidad);
            String idTecnico = legacySupport.consultarTecnico(codigoEspecialidad);
            return new InfoTecnico(idTecnico, idTecnico != null, 0.0);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("La especialidad debe ser un código numérico", e);
        }
    }
}
