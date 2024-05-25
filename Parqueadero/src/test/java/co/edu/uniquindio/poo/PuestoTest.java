package co.edu.uniquindio.poo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Parqueadero
 * 
 * @author Jaider Andrés Melo Rodríguez
 * @author Yerilin Ul Yalanda
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    @Test
    public void datosCompletosPuesto(){

        LOG.info("Iniciando test de datosCompletosPuesto");

        var puesto = new Puesto(1, 1, Estado.LIBRE);

        assertEquals(1, puesto.getPosicionI());
        assertEquals(1, puesto.getPosicionJ());
        assertEquals(Estado.LIBRE, puesto.getEstado());
        assertEquals(null, puesto.getVehiculo());

        LOG.info("Finalizando test de datosCompletosPuesto");

    }

    @Test 
    public void datosNegativosYnulosPuesto(){

        LOG.info("Iniciando test de datosNegativosYnulosPuesto");

        assertThrows(Throwable.class, () -> new Puesto(-1, -1, null));
        
        LOG.info("Finalizando test de datosNegativosYnulosPuesto");
        
    }
}
