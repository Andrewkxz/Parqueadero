package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
/**
 * Clase para manejar la información de un Vehiculo
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
public abstract class Vehiculo {
    private final String placa;
    private final String modelo;
    private final Propietario propietario;

    /**
     * Método constructor de la clase Vehiculo
     * @param placa valor de la placa del vehiculo
     * @param modelo valor del modelo del vehiculo
     * @param propietario valor del propietario del vehiculo
     */
    public Vehiculo(String placa, String modelo, Propietario propietario) {
        ASSERTION.assertion(placa != null && !placa.isBlank(), "Error: la placa no puede ser nula ni vacía");
        ASSERTION.assertion(modelo != null && !modelo.isBlank(), "Error: el modelo no puede ser nulo ni vacío");
        ASSERTION.assertion(propietario != null, "Error: el propietario no puede ser nulo ni vacío");
        
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
    }
    /**
     * Método para obtener la placa del vehiculo
     * @return placa del vehiculo
     */
    public String getPlaca() {
        return placa;
    }
    /**
     * Método para obtener el modelo del vehiculo
     * @return modelo del vehiculo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * Método para obtener el propietario del vehiculo
     * @return propietario del vehiculo
     */
    public Propietario getPropietario() {
        return propietario;
    }
    /**
     * Método abstracto para obtener la tarifa de un vehiculo pero que sobrescriben las clases hijas a su manera.
     */
    public abstract double getTarifa();
    /**
     * Método para cambiar la tarifa de un vehiculo pero que sobrescriben las clases hijas a su manera.
     */
    public abstract void setTarifa(double tarifa);
    

    
}
