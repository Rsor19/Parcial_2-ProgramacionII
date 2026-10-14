package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Empresa que administra las solicitudes de servicio. */
public class Empresa {
    private String nombre;
    private final List<SolicitudServicio> listaSolicitudes;

    public Empresa(String nombre) {
        this.nombre = Objects.requireNonNull(nombre, "El nombre es obligatorio");
        this.listaSolicitudes = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = Objects.requireNonNull(nombre); }
    public List<SolicitudServicio> getListaSolicitudes() {
        return Collections.unmodifiableList(listaSolicitudes);
    }

    /**
     * Método que registra una solicitud
     * @param solicitud
     */
    public void registrarSolicitud(SolicitudServicio solicitud) {
        Objects.requireNonNull(solicitud, "La solicitud es obligatoria");
        if (consultarSolicitud(solicitud.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe una solicitud con el código: " + solicitud.getCodigo());
        }
        listaSolicitudes.add(solicitud);
    }

    /**
     * Método para consultar una solicitud por su código
     * @param codigo
     * @return
     */
    public SolicitudServicio consultarSolicitud(String codigo) {
        return listaSolicitudes.stream()
                .filter(solicitud -> Objects.equals(solicitud.getCodigo(), codigo))
                .findFirst().orElse(null);
    }

    /**
     * Método que actualiza una solicitud
     * @param codigo
     * @param solicitudActualizada
     * @return
     */
    public boolean actualizarSolicitud(String codigo, SolicitudServicio solicitudActualizada) {
        for (int i = 0; i < listaSolicitudes.size(); i++) {
            if (Objects.equals(listaSolicitudes.get(i).getCodigo(), codigo)) {
                if (!Objects.equals(codigo, solicitudActualizada.getCodigo())
                        && consultarSolicitud(solicitudActualizada.getCodigo()) != null) {
                    throw new IllegalArgumentException("Ya existe una solicitud con el código: " + solicitudActualizada.getCodigo());
                }
                listaSolicitudes.set(i, solicitudActualizada);
                return true;
            }
        }
        return false;
    }

    /**
     * Método que elimina una solicitud por el código
     * @param codigo
     * @return
     */
    public boolean eliminarSolicitud(String codigo) {
        return listaSolicitudes.removeIf(solicitud -> Objects.equals(solicitud.getCodigo(), codigo));
    }
}
