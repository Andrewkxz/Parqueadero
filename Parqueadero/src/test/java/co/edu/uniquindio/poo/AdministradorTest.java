package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Administrador
 * 
 * @author Jaider Andrés Melo Rodríguez
 * @author Yerilin Ul Yalanda
 * @since 2024-05
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AdministradorTest.class.getName());
    
    @Test
    public void tarifaPositiva(){

        LOG.info("Iniciado test tarifaPositiva");

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");
        var propietario4 = new Propietario("Camilo", "Zamudio", 20, "8743878444", "camilo@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);
        var motoClasica2 = new Moto("37437sh", "modelo", propietario4, 300, TipoMoto.CLASICA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        assertEquals(2000.0, motoClasica2.getTarifa());
        assertEquals(3500.0, carro.getTarifa());
        assertEquals(2000.0, motoClasica.getTarifa());
        assertEquals(2800.0, motoHibrida.getTarifa());

        LOG.info("Finalizando test tarifaPositiva");

    }

    @Test
    public void tarifaNegativa(){

        LOG.info("Iniciado test tarifaNegativa");

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(carro, -3500.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoClasica, -2000.0));
        assertThrows(Throwable.class, () -> administrador.cambiarTarifa(motoHibrida, -2800.0));

        LOG.info("Finalizando test tarifaNegativa");

    }
}
