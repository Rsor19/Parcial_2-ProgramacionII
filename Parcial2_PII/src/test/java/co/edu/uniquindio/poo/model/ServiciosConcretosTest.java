package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiciosConcretosTest {

    @Test
    void testInstalacionRedesPuntosNegativosLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InstalacionRedes("RED-01", "Cableado Estructurado", "Instalación de switches", 200.0, -3);
        });
    }

    @Test
    void testRecuperacionInformacionVolumenNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RecuperacionInformacion("REC-01", "Rescate HDD", "Recuperación de sectores dañados", 400.0, -50.5);
        });
    }
}