package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LegacySupportAdapterTest {

    @Test
    void testConsultarDisponibilidadTecnicoExitoso() {
        LegacySupport legacySupport = new LegacySupport();
        ITecnicoService adapter = new LegacySupportAdapter(legacySupport);
        InfoTecnico info = adapter.consultarDisponibilidadTecnico("5");

        assertNotNull(info);
        assertEquals("TEC-5", info.getIdTecnico());
        assertTrue(info.isDisponible());
    }

    @Test
    void testEspecialidadNoNumericaLanzaExcepcion() {
        LegacySupport legacySupport = new LegacySupport();
        ITecnicoService adapter = new LegacySupportAdapter(legacySupport);
        assertThrows(IllegalArgumentException.class, () -> {
            adapter.consultarDisponibilidadTecnico("RedesAvanzadas");
        });
    }

    @Test
    void testEspecialidadNulaOVaciaLanzaExcepcion() {
        LegacySupport legacySupport = new LegacySupport();
        ITecnicoService adapter = new LegacySupportAdapter(legacySupport);

        assertThrows(IllegalArgumentException.class, () -> {
            adapter.consultarDisponibilidadTecnico(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            adapter.consultarDisponibilidadTecnico("   ");
        });
    }
}