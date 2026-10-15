package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaqueteTecnologicoTest {

    @Test
    void testCalcularCostoPaqueteConDescuento() {

        IServicioTecnologico servicio1 = new MantenimientoPreventivo("M01", "Preventivo PC", "Limpieza", 100.0);
        IServicioTecnologico servicio2 = new InstalacionRedes("R01", "Red LAN", "Cableado", 200.0, 4);
        PaqueteTecnologico paquete = new PaqueteTecnologico("P01", "Paquete Integral", "Todo incluido", 0.10);
        paquete.agregarElemento(servicio1);
        paquete.agregarElemento(servicio2);

        assertEquals(270.0, paquete.getCosto(), 0.01);
    }

    @Test
    void testVerificarCicloEvitaReferenciaCircular() {
        PaqueteTecnologico paquetePadre = new PaqueteTecnologico("P01", "Padre", "Principal", 0.0);
        PaqueteTecnologico paqueteHijo = new PaqueteTecnologico("P02", "Hijo", "Secundario", 0.0);
        paquetePadre.agregarElemento(paqueteHijo);
        assertThrows(IllegalArgumentException.class, () -> {
            paqueteHijo.agregarElemento(paquetePadre);
        });
    }
}