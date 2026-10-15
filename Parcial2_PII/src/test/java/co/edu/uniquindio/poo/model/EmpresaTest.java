package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    private Empresa empresa;
    private SolicitudServicio solicitud1;
    private SolicitudServicio solicitud2;
    private Cliente clientePrueba;

    @BeforeEach
    void setUp() {
        empresa = new Empresa("TechSolutions S.A.S.");
        clientePrueba = new Cliente("12345678", "Ana Gómez", "ana@mail.com");
        solicitud1 = SolicitudServicio.builder()
                .codigo("SOL-001")
                .fechaCreacion(LocalDate.now())
                .cliente(clientePrueba)
                .build();

        solicitud2 = SolicitudServicio.builder()
                .codigo("SOL-002")
                .fechaCreacion(LocalDate.now())
                .cliente(clientePrueba)
                .build();
    }

    @Test
    void testRegistrarYConsultarSolicitud() {
        empresa.registrarSolicitud(solicitud1);

        SolicitudServicio encontrada = empresa.consultarSolicitud("SOL-001");
        assertNotNull(encontrada);
        assertEquals("SOL-001", encontrada.getCodigo());
    }

    @Test
    void testRegistrarSolicitudDuplicadaLanzaExcepcion() {
        empresa.registrarSolicitud(solicitud1);

        SolicitudServicio duplicada = SolicitudServicio.builder()
                .codigo("SOL-001")
                .fechaCreacion(LocalDate.now())
                .cliente(clientePrueba)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            empresa.registrarSolicitud(duplicada);
        });
    }

    @Test
    void testActualizarSolicitud() {
        empresa.registrarSolicitud(solicitud1);

        SolicitudServicio solicitudActualizada = SolicitudServicio.builder()
                .codigo("SOL-001")
                .fechaCreacion(LocalDate.now())
                .cliente(clientePrueba)
                .observaciones("Actualizado con éxito")
                .build();

        boolean resultado = empresa.actualizarSolicitud("SOL-001", solicitudActualizada);
        assertTrue(resultado);
        assertEquals("Actualizado con éxito", empresa.consultarSolicitud("SOL-001").getObservaciones());
    }

    @Test
    void testEliminarSolicitud() {
        empresa.registrarSolicitud(solicitud1);

        boolean eliminada = empresa.eliminarSolicitud("SOL-001");
        assertTrue(eliminada);
        assertNull(empresa.consultarSolicitud("SOL-001"));
    }
}