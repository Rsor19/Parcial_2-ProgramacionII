package co.edu.uniquindio.poo.model;
/**
 * Clase abstracta Serviciodecorator que implementa el patrón de diseño Decorator
 * Sirve como base para agregar funcionalidades y costos adicionales de forma dinámica
 * a cualquier objeto que implemente IServicioTecnologico
 */
public class ServicioDecorator implements IServicioTecnologico {
    protected IServicioTecnologico servicioDecorado;

    /**
     * Constructor del decorador.
     *
     * @param servicioDecorado El servicio tecnológico al cual se le añadirán características adicionales
     */
    public ServicioDecorator(IServicioTecnologico servicioDecorado) {
        if (servicioDecorado == null) {
            throw new IllegalArgumentException("El servicio a decorar no puede ser nulo");
        }
        this.servicioDecorado = servicioDecorado;
    }

    /**
     * Retorna el código del servicio.
     *
     * @return Código.
     */
    @Override
    public String getCodigo() {
        return servicioDecorado.getCodigo();
    }

    /**
     * Retorna el nombre del servicio.
     *
     * @return Nombre .
     */
    @Override
    public String getNombre() {
        return servicioDecorado.getNombre();
    }

    /**
     * Retorna la descripción del servicio, sus clases hijas
     * sobrescribirán este método para añadir los detalles que se le agregaron.
     *
     * @return Descripción.
     */
    @Override
    public String getDescripcion() {
        return servicioDecorado.getDescripcion();
    }

    /**
     * Retorna el costo del servicio sus clases hijas sumarán el costo
     * adicional correspondiente al servicio que están decorando.
     *
     * @return Costo total con el adicional aplicado.
     */
    @Override
    public double getCosto() {
        return servicioDecorado.getCosto();
    }
}
