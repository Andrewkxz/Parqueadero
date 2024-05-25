package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Clase que agrupa la información del parqueadero.
 * 
 * @author Jaider Andrés Melo Rodríguez
 * @author Yerilin Ul Yalanda
 * @author Juan Jose Mendez Carranza
 * 
 * @since 2024-05
 * 
 * Licencia GNU/GPL V3.0
 * (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Parqueadero {
    private final String nombre;
    private int numeroPuestos;
    private final Collection<Registro> registros;
    private final Hashtable<String, Puesto> puestos;
    private final Collection<Vehiculo> vehiculos;

    /**
     * Método constructor de la clase Parqueadero
     * 
     * @param nombre        nombre del parqueadero
     * @param numeroPuestos numero de puestos el parquadero
     */
    public Parqueadero(String nombre, int numeroPuestos) {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "Error: el nombre no puede ser nulo ni estar vacío");
        ASSERTION.assertion(numeroPuestos > 0, "Error: el numero de puestos debe ser mayor de cero puestos");
        this.nombre = nombre;
        this.numeroPuestos = numeroPuestos;
        registros = new LinkedList<>();
        puestos = new Hashtable<>();
        vehiculos = new LinkedList<>();
        crearPuestos(numeroPuestos);
    }
    /**
     * Método para crear una cantidad de puestos especifica, cada puesto se representa por sus coordenadas (i, j) y se inicializa con el estado en LIBRE
     * @param numeroPuestos numero de puestos a crear numeroPuestos*numeroPuestos
     */
    public void crearPuestos(int numeroPuestos) {
        for (int i = 0; i < numeroPuestos; i++) {
            int posicionI = (i + 1);
            for (int j = 0; j < numeroPuestos; j++) {
                int posicionJ = (j + 1);
                String k = "(" + posicionI + ", " + posicionJ + ")";
                puestos.put(k, new Puesto(posicionI, posicionJ, Estado.LIBRE));
            }
        }
    }
    /**
     * Método para añadir un vehiculo a un puesto especifico en el estacionamiento, luego cambiando el estado de ese puesto a OCUPADO y registrando la fecha de entrada del vehiculo en el sistema.
     * @param vehiculo vehiculo que se va a añadir en un puesto
     * @param posicionI coordenada i del puesto en que se añadirá el vehiculo
     * @param posicionJ coordenada j del puesto en que se añadirá el vehiculo
     */
    public void addVehiculoPuestoDado(Vehiculo vehiculo, int posicionI, int posicionJ) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ) == true,
                "Error: el puesto se encuentra ocupado");
        if (verificarPuestoDisponible(posicionI, posicionJ)) {
            var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
            puesto.setVehiculo(vehiculo);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.OCUPADO);
            LocalDateTime fechaEntrada = LocalDateTime.now();
            Registro nuevoRegistro = new Registro(fechaEntrada, null, vehiculo);
            registros.add(nuevoRegistro);
            addVehiculo(vehiculo);
        }
    }
    /**
     * Método para eliminar un vehiculo de un puesto especifico del estacionamiento, luego cambiando su estado a LIBRE y registrando la fecha de salida del vehiculo en el sistema.
     * @param posicionI coordenada i del puesto en que se eliminará el vehiculo
     * @param posicionJ coordenada j del puesto en que se eliminará el vehiculo
     * @param fechaSalida fecha de salida del vehiculo que se va a remover
     */
    public void removeVehiculoPuestoDado(int posicionI, int posicionJ, LocalDateTime fechaSalida) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ)==false,
                "Error: el puesto se encuentra libre");
        if (!verificarPuestoDisponible(posicionI, posicionJ)) {
            var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
            var obtenerVehiculo = puesto.getVehiculo();
            for(Registro registro : registros){
                if (registro.getVehiculo().equals(obtenerVehiculo) && registro.getFechaSalida() == null) {
                    registro.setFechaSalida(fechaSalida);
                }
            }
            puesto.setVehiculo(null);
            actualizarEstadoPuesto(posicionI, posicionJ, Estado.LIBRE);
        }
    }
    /**
     * Método para determinar si un puesto existe dado su posicion I y J
     * @param i posición i del puesto que se desea verificar
     * @param j posición j del puesto que se desea verificar
     * @return boolean del puesto a verificar; true si está disponible, false si no lo está
     */
    public boolean verificarPuestoDisponible(int i, int j) {
        var puesto = puestos.get("(" + i + ", " + j + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.LIBRE)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Método privado para actualizar el estado de un puesto en especifico
     * @param posicionI posición I del puesto al que se le desea actualizar el estado
     * @param posicionJ posición J del puesto al que se le desea actualizar el estado
     * @param estadoNuevo nuevo estado del puesto al que se le desea cambiar el estado
     */
    private void actualizarEstadoPuesto(int posicionI, int posicionJ, Estado estadoNuevo) {
        Estado estado = Estado.LIBRE;
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        if (puesto.getEstado().equals(estado)) {
            puesto.setEstado(estadoNuevo);
        }
    }
    /**
     * Método para identificar el propietario de un vehiculo ubicado en un puesto dado
     * @param posicionI posición I del vehiculo que se desea buscar
     * @param posicionJ posición J del vehiculo que se desea buscar
     * @return propietario del vehiculo ubicado en el puesto buscado o null de ser el caso de no obtener un propietario del vehiculo
     */
    public Propietario identificarPropietarioPuestoDado(int posicionI, int posicionJ) {
        ASSERTION.assertion(verificarPuestoDisponible(posicionI, posicionJ)==false,
                "Error: el puesto se encuentra libre");
        var puesto = puestos.get("(" + posicionI + ", " + posicionJ + ")");
        if (puesto != null) {
            if (puesto.getEstado().equals(Estado.OCUPADO)) {
                var vehiculo = puesto.getVehiculo();
                return vehiculo.getPropietario();
            }
        }
        return null;
    }
    /**
     * Método para adicionar un vehiculo a la colección de vehiculos
     * @param vehiculo vehiculo que se desea adicionar
     */
    public void addVehiculo(Vehiculo vehiculo) {
        ASSERTION.assertion(!verificarVehiculo(vehiculo.getPlaca()), "Error: el vehiculo ya se encuentra registrado");

        vehiculos.add(vehiculo);
    }
    /**
     * Método privado para determinar si ya existe otro vehiculo con la placa indicada
     * @param placa placa que se desea verificar si existe o no de un vehiculo.
     * @return valor lógico que indica si existe o no un vehiculo con la placa indicada
     */
    private boolean verificarVehiculo(String placa) {
        Predicate<Vehiculo> placaIgual = vehiculo -> vehiculo.getPlaca().equals(placa);
        return vehiculos
                .stream()
                .filter(placaIgual)
                .findAny()
                .isPresent();
    }
    /**
     * Método para generar un reporte diario del dinero recaudado en el parqueadero y desglosando según el vehiculo (Carro, Moto híbrida y Moto clásica)
     * @param fecha fecha del dia que se desea generar el reporte
     * @return colección del dinero recaudado y desglosado según el vehiculo
     */
    public Collection<Double> generarReporteDiario(LocalDate fecha) {
        double dineroRecaudadoCarro = 0.0;
        double dineroRecaudadoMotoHibrida = 0.0;
        double dineroRecaudadoMotoClasica = 0.0;

        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().isEqual(fecha) && registro.getFechaSalida() != null) {
                var vehiculo = registro.getVehiculo();
                double tarifa = registro.calcularTarifa();

                if (vehiculo instanceof Carro) {
                    dineroRecaudadoCarro += tarifa;
                } else if (vehiculo instanceof Moto moto) {
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        dineroRecaudadoMotoClasica += tarifa;
                    } else {
                        dineroRecaudadoMotoHibrida += tarifa;
                    }

                }
            }
        }
        Collection<Double> reporteDiario = new LinkedList<>();
        reporteDiario.add(dineroRecaudadoCarro);
        reporteDiario.add(dineroRecaudadoMotoClasica);
        reporteDiario.add(dineroRecaudadoMotoHibrida);

        return  Collections
                .unmodifiableCollection(reporteDiario);
    }
/**
 * Método para generar un reporte mensual del dinero recaudado en el parqueadero 
 * @param mes mes (con año) al que se desea generar un reporte
 * @return double del total de dinero recaudado en el mes buscado
 */
    public double generarReporteMensual(YearMonth mes) {
        double dineroRecaudado = 0.0;
        int año = mes.getYear();
        int mesBuscado = mes.getMonthValue();
        for (Registro registro : registros) {
            if (registro.getFechaEntrada().toLocalDate().getYear() == año
                    && registro.getFechaEntrada().toLocalDate().getMonthValue() == mesBuscado) {
                dineroRecaudado += registro.calcularTarifa();
            }
        }
        return dineroRecaudado;
    }
    /**
     * Método para obtener el nombre del parqueadero creado
     * @return nombre del parqueadero creado
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para obtener el numero de puestos del parqueadero creado
     * @return numero de puestos del parqueadero creado
     */
    public int getNumeroPuestos() {
        return numeroPuestos;
    }
    /**
     * Método para obtener la colección de registros añadidos en el parqueadero
     * @return colección de registros añadidos en el parqueadero
     */
    public Collection<Registro> getRegistros() {
        return Collections
                    .unmodifiableCollection(registros);
    }
    /**
     * Método para obtener los puestos del parqueadero creado
     * @return puestos del parqueadero creado
     */
    public Hashtable<String, Puesto> getPuestos() {
        return puestos;
    }
    /**
     * Método para obtener la colección de vehiculos añadidos al parqueadero creado
     * @return colección de vehiculos añadidos al parqueadero creado
     */
    public Collection<Vehiculo> getVehiculos() {
        return Collections
                    .unmodifiableCollection(vehiculos);
    }
}