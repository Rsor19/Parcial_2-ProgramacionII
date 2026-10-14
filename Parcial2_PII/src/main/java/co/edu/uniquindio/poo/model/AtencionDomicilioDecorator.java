package co.edu.uniquindio.poo.model;
/**
 * Decorador concreto que añade la característica de atención a domicilio
 * de cualquier servicio tecnológico o paquete, incrementando su costo base
 * y actualizando su descripción.
 */
public class AtencionDomicilioDecorator extends ServicioDecorator {

    private double costoTraslado;

    /**
     * Constructor del decorador de atención a domicilio.
     *
     * @param servicioDecorado El servicio tecnológico que va a recibir esta característica.
     * @param costoTraslado    El costo adicional por el desplazamiento o visita a domicilio.
     */
    public AtencionDomicilioDecorator(IServicioTecnologico servicioDecorado, double costoTraslado) {
        super(servicioDecorado);
        if (costoTraslado < 0) {
            throw new IllegalArgumentException("El costo de traslado no puede ser negativo.");
        }
        this.costoTraslado = costoTraslado;
    }

    /**
     * Calcula el costo total del servicio sumando el costo del servicio
     * más el costo adicional por la atención a domicilio.
     *
     * @return Costo total actualizado con el domicilio.
     */
    @Override
    public double getCosto() {
        return super.getCosto() + costoTraslado;
    }

    /**
     * Enriquece la descripción del servicio original agregando la descripcion
     * de que incluye la atención a domicilio.
     *
     * @return Descripción extendida del domicilio.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Incluye Atención a Domicilio, Costo Traslado: " + costoTraslado + " ";
    }
}
