package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.SolicitudServicio;
import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.InstalacionRedesFactory;
import co.edu.uniquindio.poo.model.MantenimientoCorrectivoFactory;
import co.edu.uniquindio.poo.model.MantenimientoPreventivoFactory;
import co.edu.uniquindio.poo.model.RecuperacionInformacionFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class RegistrarSolicitudController {
    @FXML private TextField codigo, documento, nombre, correo, observaciones;
    @FXML private ComboBox<String> tipoServicio;
    @FXML private Label mensaje, costoPreview;

    @FXML private void initialize() {
        tipoServicio.getItems().addAll("Mantenimiento preventivo", "Mantenimiento correctivo",
                "Instalación de redes", "Recuperación de información");
        tipoServicio.getSelectionModel().selectFirst();
        tipoServicio.valueProperty().addListener((obs, anterior, actual) -> actualizarCosto());
        actualizarCosto();
    }

    private void actualizarCosto() {
        if (costoPreview != null) costoPreview.setText("Costo base estimado: $" + costoServicio());
    }

    private double costoServicio() {
        return switch (tipoServicio.getValue()) {
            case "Mantenimiento preventivo" -> 150000;
            case "Mantenimiento correctivo" -> 220000;
            case "Instalación de redes" -> 300000;
            case "Recuperación de información" -> 250000;
            default -> 0;
        };
    }

    private IServicioTecnologico crearServicio() {
        return switch (tipoServicio.getValue()) {
            case "Mantenimiento preventivo" -> new MantenimientoPreventivoFactory("MP-001", "Mantenimiento preventivo", "Servicio preventivo", costoServicio()).crearServicio();
            case "Mantenimiento correctivo" -> new MantenimientoCorrectivoFactory("MC-001", "Mantenimiento correctivo", "Servicio correctivo", costoServicio()).crearServicio();
            case "Instalación de redes" -> new InstalacionRedesFactory("IR-001", "Instalación de redes", "Instalación de puntos de red", costoServicio(), 1).crearServicio();
            default -> new RecuperacionInformacionFactory("RI-001", "Recuperación de información", "Recuperación de datos", costoServicio(), 1).crearServicio();
        };
    }

    @FXML private void guardar() {
        try {
            validarCampos();
            Cliente cliente = new Cliente(documento.getText().trim(), nombre.getText().trim(), correo.getText().trim());
            SolicitudServicio solicitud = SolicitudServicio.builder()
                    .codigo(codigo.getText()).fechaCreacion(LocalDate.now()).cliente(cliente)
                    .agregarServicio(crearServicio()).observaciones(observaciones.getText()).build();
            App.getSistema().registrarSolicitud(codigo.getText(), documento.getText(), nombre.getText(), correo.getText(), observaciones.getText(), tipoServicio.getValue());
            mensaje.setText("Solicitud registrada correctamente");
            mensaje.setStyle("-fx-text-fill: #10B981; -fx-font-weight: bold;");
        } catch (RuntimeException e) {
            mensaje.setText(e.getMessage());
            mensaje.setStyle("-fx-text-fill: #EF4444; -fx-font-weight: bold;");
        }
    }

    private void validarCampos() {
        if (codigo.getText().isBlank() || documento.getText().isBlank() || nombre.getText().isBlank()
                || correo.getText().isBlank()) {
            throw new IllegalArgumentException("Completa código, documento, nombre y correo.");
        }
        if (!correo.getText().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("Ingresa un correo válido.");
        }
    }

    @FXML private void volver() throws IOException { App.mostrarVista("inicio.fxml", 920, 620); }
}
