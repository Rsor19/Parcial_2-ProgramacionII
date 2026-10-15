package co.edu.uniquindio.poo.model;

/**
 * Decorador concreto que añade la característica de atención prioritaria
 * a cualquier servicio tecnológico, incrementando su costo
 * y actualizando su descripción para reflejar la prioridad del servicio.
 */
public class AtencionPrioritariaDecorator extends ServicioDecorator {

    private double costoPrioridad;
    private String tiempoRespuesta;

    /**
     * Constructor del decorador de atención prioritaria.
     *
     * @param servicioDecorado El servicio tecnológico que va a recibir esta característica.
     * @param costoPrioridad   El costo adicional por la atención prioritaria.
     * @param tiempoRespuesta  El tiempo estimado de respuesta garantizado.
     */
    public AtencionPrioritariaDecorator(IServicioTecnologico servicioDecorado, double costoPrioridad, String tiempoRespuesta) {
        super(servicioDecorado);
        if (costoPrioridad < 0) {
            throw new IllegalArgumentException("El costo de prioridad no puede ser negativo.");
        }
        this.costoPrioridad = costoPrioridad;
        this.tiempoRespuesta = tiempoRespuesta;
    }

    /**
     * Calcula el costo total del servicio sumando el costo del servicio
     * más el adicional por la atención prioritaria.
     *
     * @return Costo total actualizado con la prioridad.
     */
    @Override
    public double getCosto() {
        return super.getCosto() + costoPrioridad;
    }

    /**
     * Agrega la descripción de la atención prioritaria y su tiempo de respuesta.
     *
     * @return Descripción  detallada de la prioridad.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Incluye Atención Prioritaria, tiempo de Respuesta: " + tiempoRespuesta + ", Costo: " + costoPrioridad + " ";
    }
}