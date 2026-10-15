package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.Empresa;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Platform.startup(() -> {
            try {
                stage = new Stage();
                stage.setTitle("Tech Solutions");
                mostrarVista("inicio.fxml", 920, 620);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private static final Empresa EMPRESA = new Empresa("Tech Solutions");
    private static Stage stage;

    public static Empresa getEmpresa() { return EMPRESA; }

    public static void mostrarVista(String vista, double ancho, double alto) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/fxml/" + vista));
        Scene scene = new Scene(loader.load(), ancho, alto);
        stage.setScene(scene);
    }



}

