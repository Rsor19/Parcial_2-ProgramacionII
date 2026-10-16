package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.App;
import javafx.fxml.FXML;

import java.io.IOException;

public class InicioController {
    @FXML private void abrirRegistro() throws IOException { App.mostrarVista("registrar-solicitud.fxml", 920, 700); }
    @FXML private void abrirConsultas() throws IOException { App.mostrarVista("consultar-solicitudes.fxml", 920, 620); }
    @FXML private void abrirCatalogo() throws IOException { App.mostrarVista("catalogo.fxml", 920, 620); }
}
