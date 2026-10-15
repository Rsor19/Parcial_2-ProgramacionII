package co.edu.uniquindio.poo.model;

/**
 * Decorador concreto que añade la característica de soporte técnico
 * a cualquier servicio tecnológico o paquete, incrementando su costo base
 * y actualizando su descripción.
 */
public class SoporteTecnicoDecorator extends ServicioDecorator {

    private double costoSoporte;
    /**
     * Constructor del decorador de soporte técnico.
     *
     * @param servicioDecorado El servicio tecnológico que va a recibir esta característica.
     * @param costoSoporte     El costo adicional por el servicio de soporte técnico.
     */
    public SoporteTecnicoDecorator(IServicioTecnologico servicioDecorado, double costoSoporte) {
        super(servicioDecorado);
        if (costoSoporte < 0) {
            throw new IllegalArgumentException("El costo de soporte no puede ser negativo.");
        }
        this.costoSoporte = costoSoporte;
    }

    /**
     * Calcula el costo total del servicio sumando el costo del servicio
     * más el costo adicional por el soporte técnico.
     *
     * @return Costo total actualizado con el soporte.
     */
    @Override
    public double getCosto() {
        return super.getCosto() + costoSoporte;
    }

    /**
     * Agrega una descripcion del soporte técnico.
     *
     * @return Descripción extendida.
     */
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + " + Incluye Soporte Técnico, Costo Soporte: " + costoSoporte + " ";
    }
}