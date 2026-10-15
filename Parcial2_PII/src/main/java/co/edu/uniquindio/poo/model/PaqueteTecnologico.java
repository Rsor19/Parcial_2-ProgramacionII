package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class PaqueteTecnologico implements  IServicioTecnologico{
    private String codigo;
    private String nombre;
    private String descripcion;
    private double descuento;
    private List<IServicioTecnologico> elementos;

    /**
     * Constructor para la clase PaqueteTecnologico
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param descuento
     */
    public PaqueteTecnologico(String codigo, String nombre, String descripcion, double descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.elementos = new ArrayList<>();
    }

    /**
     * Agrega un servicio al paquete.
     */
    public void agregarElemento(IServicioTecnologico servicio) {
        if (servicio != null && !verificarCiclo(servicio)) {
            elementos.add(servicio);
        } else {
            throw new IllegalArgumentException("No se puede agregar el elemento, es nulo y el sistema no lo permite.");
        }
    }

    /**
     * Elimina un servicio del paquete.
     */
    public void eliminarElemento(IServicioTecnologico elemento) {
        elementos.remove(elemento);
    }

    /**
     * Valida que un paquete no se contenga a sí mismo para evitar un bucle infinito.
     */
    public boolean verificarCiclo(IServicioTecnologico elemento) {
        if (elemento == this) {
            return true;
        }
        if (elemento instanceof PaqueteTecnologico) {
            PaqueteTecnologico paquete = (PaqueteTecnologico) elemento;
            for (IServicioTecnologico subElemento : paquete.getElementos()) {
                if (verificarCiclo(subElemento)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<IServicioTecnologico> getElementos() {
        return elementos;
    }

    /**
     * Metodo de la interface {@link IServicioTecnologico} que permite conocer el costo total del paquete
     * @return
     */
    @Override
    public double getCosto() {
        double costoTotal = 0.0;
        for (IServicioTecnologico elemento : elementos) {
            costoTotal += elemento.getCosto();
        }
        return costoTotal * (1.0 - descuento);
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    /**
     * Genera la descripción detallada del paquete, concatenando la informacion por medio de un StringBuilder
     *
     * @return Descripción completa con el detalle de los elementos internos.
     */
    @Override
    public String getDescripcion() {
        StringBuilder desc = new StringBuilder(descripcion + " [Contiene: ");
        for (int i = 0; i < elementos.size(); i++) {
            desc.append(elementos.get(i).getNombre());
            if (i < elementos.size() - 1) {
                desc.append(", ");
            }
        }
        desc.append("]");
        return desc.toString();
    }
}
