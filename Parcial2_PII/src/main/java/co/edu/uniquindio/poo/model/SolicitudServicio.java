package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *  Solicitud de uno o varios servicios tecnológicos. Se construye mediante Builder.
 */
public class SolicitudServicio {
    private final String codigo;
    private final LocalDate fechaCreacion;
    private final Cliente cliente;
    private final List<IServicioTecnologico> serviciosContratados;
    private final String observaciones;
    private final double costoTotal;
    private final double costoDesplazamiento;

    private SolicitudServicio(Builder builder) {
        this.codigo = builder.codigo;
        this.fechaCreacion = builder.fechaCreacion;
        this.cliente = builder.cliente;
        this.serviciosContratados = new ArrayList<>(builder.serviciosContratados);
        this.observaciones = builder.observaciones;
        this.costoTotal = builder.costoTotal;
        this.costoDesplazamiento = builder.costoDesplazamiento;
    }

    public String getCodigo() {
        return codigo;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<IServicioTecnologico> getServiciosContratados() {
        return serviciosContratados;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public double getCostoTotal() {
        return costoTotal;
    }
    public double getCostoDesplazamiento() {
        return costoDesplazamiento;
    }

    public double calcularCostoTotal() {
        return serviciosContratados.stream().mapToDouble(IServicioTecnologico::getCosto).sum()
                + costoDesplazamiento;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String codigo;
        private LocalDate fechaCreacion;
        private Cliente cliente;
        private List<IServicioTecnologico> serviciosContratados = new ArrayList<>();
        private String observaciones;
        private double costoTotal;
        private double costoDesplazamiento;

        public Builder codigo(String codigo) { this.codigo = codigo; return this; }
        public Builder fechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; return this; }
        public Builder cliente(Cliente cliente) {
            this.cliente = cliente; return this;
        }

        /**
         * Builder de los servicios contratados
         * @param servicios
         * @return
         */
        public Builder serviciosContratados(List<IServicioTecnologico> servicios) {
            this.serviciosContratados = new ArrayList<>(servicios);
            return this;
        }
        public Builder agregarServicio(IServicioTecnologico servicio) {
            if (servicio != null) serviciosContratados.add(servicio);
            return this;
        }
        public Builder observaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }
        public Builder costoTotal(double costoTotal) {
            this.costoTotal = costoTotal;
            return this;
        }
        public Builder costoDesplazamiento(double costoDesplazamiento) {
            this.costoDesplazamiento = costoDesplazamiento;
            return this;
        }

        public SolicitudServicio build() {
            Objects.requireNonNull(codigo, "El código del servicio es obligatorio");
            Objects.requireNonNull(fechaCreacion, "La fecha de creación es obligatoria");
            Objects.requireNonNull(cliente, "El cliente es obligatorio");
            return new SolicitudServicio(this);
        }
    }
}
