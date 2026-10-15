package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.model.IServicioTecnologico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioFactoryTest {

    @Test
    void testCrearMantenimientoPreventivoConFactory() {
        IServicioFactory fabrica = new MantenimientoPreventivoFactory("M99", "Preventivo Anual", "Revisión general", 120.0);
        IServicioTecnologico servicio = fabrica.crearServicio();
        assertNotNull(servicio);
        assertEquals("M99", servicio.getCodigo());
        assertEquals("Preventivo Anual", servicio.getNombre());
        assertEquals(120.0, servicio.getCosto(), 0.01);
    }

    @Test
    void testCrearInstalacionRedesConFactory() {
        IServicioFactory fabrica = new InstalacionRedesFactory("R99", "Red Oficina", "Instalación switch", 300.0, 8);
        IServicioTecnologico servicio = fabrica.crearServicio();
        assertNotNull(servicio);
        assertEquals("R99", servicio.getCodigo());
        assertEquals(300.0, servicio.getCosto(), 0.01);
    }
}