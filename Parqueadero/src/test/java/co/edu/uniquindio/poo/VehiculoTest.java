package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Vehiculo
 * 
 * @author Jaider Andrés Melo Rodríguez
 * @author Yerilin Ul Yalanda
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(VehiculoTest.class.getName());

    @Test
    public void datosCompletosMoto(){

        LOG.info("Iniciando test de datos completos de moto");

        var propietario = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var moto = new Moto("NEL47C", "MT 09 2024", propietario, 200, TipoMoto.CLASICA);

        assertEquals("NEL47C", moto.getPlaca());
        assertEquals("MT 09 2024", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(200, moto.getVelocidadMaxima());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());

        LOG.info("Finalizando test de datos completos de moto");

    }

    @Test
    public void datosCompletosCarro(){

        LOG.info("Iniciando test de datos completos de carro");

        var propietario = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var carro = new Carro("AYS27G", "Duster", propietario);

        assertEquals("AYS27G", carro.getPlaca());
        assertEquals("Duster", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando test de datos completos de carro");

    }

    @Test
    public void datosNulosMoto(){

        LOG.info("Iniciando test de datos nulos de moto");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
        assertThrows(Throwable.class, () -> new Moto(null, null, null, 0, null));

        LOG.info("Finalizando test de datos nulos de moto");

    }

    @Test
    public void datosNulosCarro(){

        LOG.info("Iniciando test de datos nulos de carro");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
        assertThrows(Throwable.class, () -> new Carro(null, null, null));

        LOG.info("Finalizando test de datos nulos de carro");

    }

    @Test
    public void datosNegativosMoto(){

        LOG.info("Iniciando test de datos negativos de moto");
        
        var propietario = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        assertThrows(Throwable.class, () -> new Moto("NEL47C", "MT 09 2024", propietario, -60, TipoMoto.HIBRIDA));

        LOG.info("Finalizando test de datos negativos de moto");
        
    }

}
