package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.IServicioTecnologico;
import co.edu.uniquindio.poo.model.InstalacionRedesFactory;
import co.edu.uniquindio.poo.model.MantenimientoCorrectivoFactory;
import co.edu.uniquindio.poo.model.MantenimientoPreventivoFactory;
import co.edu.uniquindio.poo.model.RecuperacionInformacionFactory;
import co.edu.uniquindio.poo.model.PaqueteTecnologico;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class CatalogoController {
    @FXML private ComboBox<String> servicioSeleccionado;
    @FXML private Label detalleServicio;
    @FXML private TextField codigoPaquete, nombrePaquete, descripcionPaquete, descuentoPaquete;
    @FXML private ListView<String> serviciosPaquete;
    @FXML private Label resultadoPaquete;
    private final List<IServicioTecnologico> elementosPaquete = new ArrayList<>();

    @FXML private void initialize() {
        servicioSeleccionado.getItems().addAll("Mantenimiento preventivo", "Mantenimiento correctivo",
                "Instalación de redes", "Recuperación de información");
        servicioSeleccionado.getSelectionModel().selectFirst();
    }

    @FXML private void verDetalle() {
        IServicioTecnologico servicio = crearServicio();
        detalleServicio.setText("Código: " + servicio.getCodigo()
                + "\nNombre: " + servicio.getNombre()
                + "\nDescripción: " + servicio.getDescripcion()
                + "\nCosto base: $" + servicio.getCosto());
        detalleServicio.setStyle("-fx-text-fill: #6366F1; -fx-font-weight: bold;");
    }

    @FXML private void agregarAlPaquete() {
        IServicioTecnologico servicio = crearServicio();
        elementosPaquete.add(servicio);
        serviciosPaquete.getItems().add(servicio.getNombre());
        actualizarResumenPaquete();
    }

    @FXML private void quitarDelPaquete() {
        int indice = serviciosPaquete.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            elementosPaquete.remove(indice);
            serviciosPaquete.getItems().remove(indice);
            actualizarResumenPaquete();
        }
    }

    @FXML private void crearPaquete() {
        try {
            if (codigoPaquete.getText().isBlank() || nombrePaquete.getText().isBlank()) {
                throw new IllegalArgumentException("El código y el nombre del paquete son obligatorios.");
            }
            double descuento = descuentoPaquete.getText().isBlank()
                    ? 0 : Double.parseDouble(descuentoPaquete.getText()) / 100;
            if (descuento < 0 || descuento > 1) {
                throw new IllegalArgumentException("El descuento debe estar entre 0 y 100%.");
            }
            PaqueteTecnologico paquete = new PaqueteTecnologico(codigoPaquete.getText().trim(),
                    nombrePaquete.getText().trim(), descripcionPaquete.getText().trim(), descuento);
            elementosPaquete.forEach(paquete::agregarElemento);
            resultadoPaquete.setText("Paquete creado: " + paquete.getNombre()
                    + "\nComponentes: " + paquete.getElementos().size()
                    + "\nCosto total: $" + paquete.getCosto());
            resultadoPaquete.setStyle("-fx-text-fill: #10B981; -fx-font-weight: bold;");
        } catch (NumberFormatException e) {
            resultadoPaquete.setText("El descuento debe ser numérico.");
            resultadoPaquete.setStyle("-fx-text-fill: #EF4444; -fx-font-weight: bold;");
        } catch (RuntimeException e) {
            resultadoPaquete.setText(e.getMessage());
            resultadoPaquete.setStyle("-fx-text-fill: #EF4444; -fx-font-weight: bold;");
        }
    }

    private void actualizarResumenPaquete() {
        double total = elementosPaquete.stream().mapToDouble(IServicioTecnologico::getCosto).sum();
        resultadoPaquete.setText("Servicios seleccionados: " + elementosPaquete.size()
                + " | Costo base: $" + total);
        resultadoPaquete.setStyle("-fx-text-fill: #F59E0B; -fx-font-weight: bold;");
    }

    private IServicioTecnologico crearServicio() {
        return switch (servicioSeleccionado.getValue()) {
            case "Mantenimiento preventivo" -> new MantenimientoPreventivoFactory("MP-001", "Mantenimiento preventivo", "Revisión y prevención de fallas", 150000).crearServicio();
            case "Mantenimiento correctivo" -> new MantenimientoCorrectivoFactory("MC-001", "Mantenimiento correctivo", "Reparación de fallas", 220000).crearServicio();
            case "Instalación de redes" -> new InstalacionRedesFactory("IR-001", "Instalación de redes", "Instalación de un punto de red", 300000, 1).crearServicio();
            default -> new RecuperacionInformacionFactory("RI-001", "Recuperación de información", "Recuperación de datos", 250000, 1).crearServicio();
        };
    }

    @FXML private void volver() throws IOException { App.mostrarVista("inicio.fxml", 920, 620); }
}
