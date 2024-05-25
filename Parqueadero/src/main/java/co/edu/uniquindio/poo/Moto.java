package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
/**
 * Clase que agrupa los datos de una moto
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
public class Moto extends Vehiculo{
    private final double velocidadMaxima;
    private final TipoMoto tipoMoto;
    private static double tarifaClasica;
    private static double tarifaHibrida;
    /**
     * Método constructor de la clase moto
     * @param placa valor de la placa de la moto
     * @param modelo valor del modelo de la moto
     * @param propietario valor del propietario de la moto
     * @param velocidadMaxima valor de la velocidad maxima de la moto
     * @param tipoMoto valor del tipo de moto de la moto
     */
    public Moto(String placa, String modelo, Propietario propietario, double velocidadMaxima, TipoMoto tipoMoto) {
        super(placa, modelo, propietario);

        ASSERTION.assertion(velocidadMaxima > 0, "Error: la velocidad maxima no puede ser negativa");
        ASSERTION.assertion(tipoMoto != null, "Error: el tipo de moto no puede ser nulo");

        this.velocidadMaxima = velocidadMaxima;
        this.tipoMoto = tipoMoto;
    }
    /**
     * Método para obtener la velocidad maxima de la moto
     * @return velocidad maxima de la moto
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    /**
     * Método para obtener el tipo de moto de la moto
     * @return tipoMoto de la moto
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
    /**
     * Método para obtener la tarifa de una moto dado su tipoMoto
     * @return tarifaClasica si el tipoMoto es CLASICA
     * @return tarifaHibrida si el tipoMoto es HIBRIDA
     */
    @Override
    public double getTarifa() {
        if(tipoMoto==TipoMoto.CLASICA){
            return tarifaClasica;
        }else{
            return tarifaHibrida;
        }
        
    }
    /**
     * Método para cambiar la tarifa de una moto y que se le cambie a toda la instancia de esta dependiendo de su tipoMoto, ya que la *tarifaClasica es diferente a la tarifaHibrida
     */
    @Override
    public void setTarifa(double tarifa) {
        ASSERTION.assertion(tarifa > 0.0, "Error: la tarifa debe ser mayor que cero");
        if(tipoMoto == TipoMoto.CLASICA){
            Moto.tarifaClasica = tarifa;
        }else{
            Moto.tarifaHibrida = tarifa;
        }
    }
    
}
