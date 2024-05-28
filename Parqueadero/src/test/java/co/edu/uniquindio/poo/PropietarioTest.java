package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Propietario
 * 
 * @author Jaider Andrés Melo Rodríguez
 * @author Yerilin Ul Yalanda
 * @author Juan Jose Mendez Carranza
 * 
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void datosCompletosPropietario(){

        LOG.info("Iniciando test de datos completos de propietario");

        var propietario = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");

        assertEquals("Yerilin", propietario.getNombres());
        assertEquals("Ul", propietario.getApellidos());
        assertEquals(27, propietario.getEdad());
        assertEquals("0987654321", propietario.getCelular());
        assertEquals("yerilin@gmail.com", propietario.getCorreo());

        LOG.info("Finalizando test de datos completos de propietario");

    }

    @Test
    public void datosNulosPropietario(){

        LOG.info("Iniciando test de datos nulos de propietario");

        assertThrows(Throwable.class, () -> new Propietario(null, null, 0, null, null));
        
        LOG.info("Finalizando test de datos nulos de propietario");

    }

    @Test
    public void datosVaciosPropietario(){

        LOG.info("Iniciando test de datos vacíos de propietario");

        assertThrows(Throwable.class, () -> new Propietario(" ", " ", 0, " ", " "));

        LOG.info("Finalizando test de datos vacíos de propietario");

    }

    @Test
    public void menorDeEdad(){
        
        LOG.info("Iniciando test de propietario menor de edad");

        assertThrows(Throwable.class, () -> new Propietario("Yerilin", "Ul", 13, "0987654321", "yerilin@gmail.com"));

        LOG.info("Finalizando test de propietario menor de edad");

    }
}
