package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar la clase Parqueadero
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
public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void datosCompletosParqueadero() {

        LOG.info("Iniciando test de datos completos del parqueadero");

        var parqueadero = new Parqueadero("Parkeando", 20);

        assertEquals("Parkeando", parqueadero.getNombre());
        assertEquals(20, parqueadero.getNumeroPuestos());

        LOG.info("Finalizando test de datos completos del parqueadero");

    }

    @Test
    public void addVehiculosDiferentes() {

        LOG.info("Iniciando test de añadir vehiculos diferentes al parqueadero");

        var parqueadero = new Parqueadero("Parkeando", 20);

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        assertEquals(true, parqueadero.verificarPuestoDisponible(1, 1));
        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        assertEquals(false, parqueadero.verificarPuestoDisponible(1,1));
        assertEquals(true, parqueadero.verificarPuestoDisponible(2, 2));
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        assertEquals(false, parqueadero.verificarPuestoDisponible(2,2));
        assertEquals(true, parqueadero.verificarPuestoDisponible(3, 3));
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);
        assertEquals(false, parqueadero.verificarPuestoDisponible(3,3));

        LOG.info("Finalizando test de añadir vehiculos diferentes al parqueadero");

    }

    @Test
    public void addVehiculosIguales() {

        LOG.info("Iniciando test de añadir vehiculos diferentes al parqueadero");

        var parqueadero = new Parqueadero("Parkeando", 20);

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoClasica2 = new Moto("NEL47E", "MT 09 2024", propietario3, 200, TipoMoto.CLASICA);

        parqueadero.addVehiculoPuestoDado(carro, 3, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);

        assertEquals(false, parqueadero.verificarPuestoDisponible(3, 1));
        assertEquals(false, parqueadero.verificarPuestoDisponible(2, 2));
        // assertEquals(true, parqueadero.verificarPuestoDisponible("5", "5",
        // Estado.LIBRE));
        assertThrows(Throwable.class, () -> parqueadero.addVehiculoPuestoDado(motoClasica2, 2, 2));

        LOG.info("Finalizando test de añadir vehiculos diferentes al parqueadero");

    }

    @Test
    public void crearPuestos() {

        LOG.info("Iniciando test de crear puestos del parqueadero");

        var parqueadero = new Parqueadero("Parkeando", 5);

        assertEquals(25, parqueadero.getPuestos().size());

        LOG.info("Finalizando test de crear puestos del parqueadero");

    }

    @Test
    public void generarReporteParqueaderoSinVehiculos() {

        LOG.info("Iniciando test de generarReporteParqueaderoSinVehiculos");

        var parqueadero = new Parqueadero("parkeando", 5);

        LocalDate fecha = LocalDate.now();
        YearMonth mes = YearMonth.now();

        List<Double> reporteDiarioEsperado = List.of(0.0, 0.0, 0.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));
        assertEquals(0.0, parqueadero.generarReporteMensual(mes));

        LOG.info("Finalizando test de generarReporteParqueaderoSinVehiculos");
    }

    @Test
    public void generarReporteDiarioParqueaderoConVehiculos() {

        LOG.info("Iniciando test de generarReporteDiarioParqueaderoConVehiculos");

        var parqueadero = new Parqueadero("parkeando", 5);

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusHours(1));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(1));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusHours(1));

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(3500.0, 2000.0, 2800.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Finalizando test de generarReporteDiarioParqueaderoConVehiculos");

    }

    @Test
    public void calcularTarifaDespuesDeXhoras() {

        LOG.info("Inicializando test de calcularTarifaDespuesDeXhoras");

        var parqueadero = new Parqueadero("parkeando", 5);

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusHours(8));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(8));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusHours(8));

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(28000.0, 16000.0, 22400.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Inicializando test de calcularTarifaDespuesDeXhoras");

    }
    @Test
    public void calcularTarifaMenosDe1Hora() {

        LOG.info("Inicializando test de calcularTarifaMenosDe1Hora");

        var parqueadero = new Parqueadero("parkeando", 5);

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusMinutes(10));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusMinutes(8));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusMinutes(15));

        LocalDate fecha = LocalDate.now();

        List<Double> reporteDiarioEsperado = List.of(3500.0, 2000.0, 2800.0);
        Collection<Double> reporteDiario = parqueadero.generarReporteDiario(fecha);

        assertEquals(reporteDiarioEsperado, new LinkedList<>(reporteDiario));

        LOG.info("Inicializando test de calcularTarifaMenosDe1Hora");
        
    }

    @Test
    public void generarReporteMensual() {

        LOG.info("Inicializando test de generarReporteMensual");

        var parqueadero = new Parqueadero("parkeando", 5);

        var administrador = new Administrador("Camilo", "Jaramillo", 45, "27327832829", "camilo@gmail.com");

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");
        var propietario2 = new Propietario("Andrés", "Rodriguez", 20, "1234567890", "andres@gmail.com");
        var propietario3 = new Propietario("Camila", "Zamudio", 19, "87438784", "camila@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);
        var motoClasica = new Moto("NEL47C", "MT 09 2024", propietario2, 200, TipoMoto.CLASICA);
        var motoHibrida = new Moto("MSD38G", "BWS FI", propietario3, 150, TipoMoto.HIBRIDA);

        administrador.cambiarTarifa(carro, 3500.0);
        administrador.cambiarTarifa(motoClasica, 2000.0);
        administrador.cambiarTarifa(motoHibrida, 2800.0);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);
        parqueadero.addVehiculoPuestoDado(motoClasica, 2, 2);
        parqueadero.addVehiculoPuestoDado(motoHibrida, 3, 3);

        parqueadero.removeVehiculoPuestoDado(1, 1, LocalDateTime.now().plusDays(2));
        parqueadero.removeVehiculoPuestoDado(2, 2, LocalDateTime.now().plusHours(15));
        parqueadero.removeVehiculoPuestoDado(3, 3, LocalDateTime.now().plusMonths(1));

        YearMonth mes = YearMonth.now();

        /*
         * carro: 48h*3500.0 = 168000.0, motoClasica: 15h*2000.0 = 30000.0, motoHibrida:
         * 31d*24h = 744h| 744h*2800.0 = 2083200.0
         * Total: 168000.0 + 30000.0 + 2083200.0 = 2281200
         */
        assertEquals(2281200, parqueadero.generarReporteMensual(mes));

        LOG.info("Finalizando test de generarReporteMensual");

    }

    @Test
    public void identificarPropietarioVehiculoPuesto() {
        
        LOG.info("Inicializando test de identificarPropietarioVehiculoPuesto");

        var parqueadero = new Parqueadero("parkeando", 5);

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);

        assertEquals(propietario1, parqueadero.identificarPropietarioPuestoDado(1, 1));

        LOG.info("Finalizando test de identificarPropietarioVehiculoPuesto");

    }
    @Test
    public void identificarPropietarioVehiculoPuestoSinVehiculo(){

        LOG.info("Inicializando test de identificarPropietarioVehiculoPuestoSinVehiculo");

        var parqueadero = new Parqueadero("parkeando", 5);

        var propietario1 = new Propietario("Yerilin", "Ul", 27, "0987654321", "yerilin@gmail.com");

        var carro = new Carro("AYS27G", "Duster", propietario1);

        parqueadero.addVehiculoPuestoDado(carro, 1, 1);

        assertThrows(Throwable.class, ()-> parqueadero.identificarPropietarioPuestoDado(2, 2));

        LOG.info("Finalizando test de identificarPropietarioVehiculoPuestoSinVehiculo");
        
    }
}
