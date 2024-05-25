package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

/**
 * Clase que agrupa los datos de un Carro
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
public class Carro extends Vehiculo{
    private static double tarifa;
    /**
     * Método constructor de la clase Carro
     * @param placa valor de la placa del carro
     * @param modelo valor del modelo del carro
     * @param propietario valor del propietario del carro
     */
    public Carro(final String placa, final String modelo, final Propietario propietario) {
        super(placa, modelo, propietario);
    }
    /**
     * Método para obtener la tarifa del vehículo
     * @return tarifa del vehiculo al que se le desea obtener la tarifa
     */
    @Override
    public double getTarifa() {
        return tarifa;
    }
    /**
     * Método para cambiar la tarifa de un vehiculo y se le cambie a todas las instancias de este
     */
    @Override
    public void setTarifa(double tarifa) {
        ASSERTION.assertion(tarifa > 0.0, "Error, la tarifa debe ser mayor que cero");
        Carro.tarifa = tarifa;
    }
}

