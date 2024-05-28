package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Clase que agrupa los datos de un registro
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
public class Registro{

    private final LocalDateTime fechaEntrada;
    private  LocalDateTime fechaSalida;
    private final Vehiculo vehiculo;
    /**
     * Método constructor de la clase Registro.
     * @param fechaEntrada valor de la fecha de entrada de un vehiculo al parqueadero
     * @param fechaSalida valor de la fecha de salida de un vehiculo del parqueadero
     * @param vehiculo valor del vehiculo al registro
     */
    public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.vehiculo = vehiculo;

    }
    /**
     * Método para calcular el tiempo que un vehiculo lleva estacionado en el parqueadero según su hora de entrada y su hora de salida y convertirlo en un entero de horas que el vehiculo lleva estacionado (si un vehículo estuvo parqueado menos de una hora, se le cobrará la hora completa).
    * 
    * @return horas que el vehiculo lleva estacionado
    */
    public int calcularTiempo (LocalDateTime fechaEntrada,LocalDateTime fechaSalida){
        Duration tiempo = Duration.between(fechaEntrada, fechaSalida);
        long horas = tiempo.toHours();
        if(tiempo.toMinutes() > 0 && tiempo.toMinutes() < 60){
            horas = 1;
        }
        return (int) horas;
        
    }
    /**
     * Método para calcular la tarifa que un vehiculo debe pagar según su instancia de vehiculo y cantidad de horas estacionado.
     * 
     * @return tarifa final que se debe pagar 
     */
    public double calcularTarifa(){
        int horasEstacionado = calcularTiempo(fechaEntrada, fechaSalida);
        double tarifaPorHora = vehiculo.getTarifa();
        return horasEstacionado * tarifaPorHora;
    }
    /**
     * Método para obtener la fecha de entrada de un vehiculo.
     * @return fecha de entrada de un vehiculo
     */
    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }
    /**
     * Método para obtener la fecha de salida de un vehiculo.
     * @return fecha de salida de un vehiculo
     */
    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }
    /**
     * Método para obtener el vehiculo estacionado.
     * @return vehiculo estacionado
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    /**
     * Método para cambiar la fecha de salida de un vehiculo.
     * @param fechaSalida fecha de salida cambiada  de un vehiculo
     */
    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
}
