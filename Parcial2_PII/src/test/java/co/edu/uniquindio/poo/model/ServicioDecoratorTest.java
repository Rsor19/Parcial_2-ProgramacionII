package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioDecoratorTest {

    @Test
    void testDecorarServicioConSoporteYDomicilio() {
        IServicioTecnologico servicioBase = new MantenimientoPreventivo("M01", "Reparación", "Disco duro", 150.0);
        IServicioTecnologico servicioConSoporte = new SoporteTecnicoDecorator(servicioBase, 50.0, "Nivel 2");
        IServicioTecnologico servicioCompleto = new AtencionDomicilioDecorator(servicioConSoporte, 30.0);
        assertEquals(230.0, servicioCompleto.getCosto(), 0.01);
        assertTrue(servicioCompleto.getDescripcion().contains("Soporte Técnico Nivel 2"));
        assertTrue(servicioCompleto.getDescripcion().contains("Atención a Domicilio"));
    }
}