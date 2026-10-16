package co.edu.uniquindio.poo.Controller;

import co.edu.uniquindio.poo.model.*;
import java.time.LocalDate;
import java.util.List;

/** Controlador de aplicación que concentra los casos de uso y protege el modelo de la vista. */
public class SistemaController {
    private final Empresa empresa;

    public SistemaController(String nombreEmpresa) { empresa = new Empresa(nombreEmpresa); }

    public void registrarSolicitud(String codigo, String documento, String nombre, String correo,
                                   String observaciones, String tipoServicio) {
        validar(codigo, "El código es obligatorio");
        validar(documento, "El documento es obligatorio");
        validar(nombre, "El nombre es obligatorio");
        validar(correo, "El correo es obligatorio");
        if (!correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) throw new IllegalArgumentException("Ingresa un correo válido.");
        SolicitudServicio solicitud = SolicitudServicio.builder()
                .codigo(codigo.trim()).fechaCreacion(LocalDate.now())
                .cliente(new Cliente(documento.trim(), nombre.trim(), correo.trim()))
                .agregarServicio(crearServicio(tipoServicio))
                .observaciones(observaciones == null ? "" : observaciones.trim()).build();
        empresa.registrarSolicitud(solicitud);
    }

    public SolicitudServicio consultarSolicitud(String codigo) { return empresa.consultarSolicitud(codigo); }
    public boolean eliminarSolicitud(String codigo) { return empresa.eliminarSolicitud(codigo); }

    public IServicioTecnologico crearServicio(String tipo) {
        return switch (tipo) {
            case "Mantenimiento preventivo" -> new MantenimientoPreventivoFactory("MP-001", tipo, "Revisión y prevención de fallas", 150000).crearServicio();
            case "Mantenimiento correctivo" -> new MantenimientoCorrectivoFactory("MC-001", tipo, "Reparación de fallas", 220000).crearServicio();
            case "Instalación de redes" -> new InstalacionRedesFactory("IR-001", tipo, "Instalación de un punto de red", 300000, 1).crearServicio();
            case "Recuperación de información" -> new RecuperacionInformacionFactory("RI-001", tipo, "Recuperación de datos", 250000, 1).crearServicio();
            default -> throw new IllegalArgumentException("Selecciona un servicio válido.");
        };
    }

    public PaqueteTecnologico crearPaquete(String codigo, String nombre, String descripcion,
                                           double descuento, List<IServicioTecnologico> elementos) {
        validar(codigo, "El código del paquete es obligatorio");
        validar(nombre, "El nombre del paquete es obligatorio");
        if (descuento < 0 || descuento > 1) throw new IllegalArgumentException("El descuento debe estar entre 0 y 100%.");
        PaqueteTecnologico paquete = new PaqueteTecnologico(codigo.trim(), nombre.trim(), descripcion, descuento);
        elementos.forEach(paquete::agregarElemento);
        return paquete;
    }

    private void validar(String valor, String mensaje) {
        if (valor == null || valor.isBlank()) throw new IllegalArgumentException(mensaje);
    }
}
