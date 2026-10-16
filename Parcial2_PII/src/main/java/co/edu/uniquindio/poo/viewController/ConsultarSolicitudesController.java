package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.SolicitudServicio;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import co.edu.uniquindio.poo.model.InfoTecnico;
import co.edu.uniquindio.poo.model.LegacySupportAdapter;
import co.edu.uniquindio.poo.model.LegacySupport;

import java.io.IOException;

public class ConsultarSolicitudesController {
    @FXML private TextField codigo;
    @FXML private ComboBox<String> especialidad;
    @FXML private Label resultado, tecnico;

    @FXML private void initialize() {
        especialidad.getItems().addAll("105", "210", "315");
        especialidad.getSelectionModel().selectFirst();
    }

    @FXML private void consultarTecnico() {
        InfoTecnico info = new LegacySupportAdapter(new LegacySupport())
                .consultarDisponibilidadTecnico(especialidad.getValue());
        tecnico.setText(info.isDisponible() ? info.getIdTecnico() + " disponible" : "SIN_TECNICO");
        tecnico.setStyle(info.isDisponible() ? "-fx-text-fill: #10B981; -fx-font-weight: bold;"
                : "-fx-text-fill: #EF4444; -fx-font-weight: bold;");
    }

    @FXML private void consultar() {
        SolicitudServicio solicitud = App.getSistema().consultarSolicitud(codigo.getText());
        if (solicitud == null) {
            resultado.setText("SIN_SOLICITUD: no se encontró el código indicado");
            resultado.setStyle("-fx-text-fill: #EF4444; -fx-font-weight: bold;");
        } else {
            resultado.setText("Solicitud encontrada\nCliente: " + solicitud.getCliente().getNombre()
                    + "\nFecha: " + solicitud.getFechaCreacion()
                    + "\nCosto: $" + solicitud.calcularCostoTotal());
            resultado.setStyle("-fx-text-fill: #10B981; -fx-font-weight: bold;");
        }
    }

    @FXML private void eliminar() {
        boolean eliminada = App.getSistema().eliminarSolicitud(codigo.getText());
        resultado.setText(eliminada ? "Solicitud eliminada" : "No existe una solicitud con ese código");
        resultado.setStyle(eliminada
                ? "-fx-text-fill: #10B981; -fx-font-weight: bold;"
                : "-fx-text-fill: #EF4444; -fx-font-weight: bold;");
    }

    @FXML private void volver() throws IOException { App.mostrarVista("inicio.fxml", 920, 620); }
}
