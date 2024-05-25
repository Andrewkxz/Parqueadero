package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

/**
 * Clase que agrupa los datos del administrador
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
public class Administrador extends Persona{
    /**
     * Método constructor de la clase Administrador
     */
    public Administrador(String nombres, String apellidos, int edad, String celular, String correo) {
        super(nombres, apellidos, edad, celular, correo);
    }
    /**
     *Método para cambiar la tarifa de un vehiculo según su instancia de la clase Vehiculo
     * @param vehiculo vehiculo al que se desea cambiar su tarifa según su instancia de Vehiculo
     * @param tarifa tarifa a la cual se desea cambiar su valor
     */
    public void cambiarTarifa (Vehiculo vehiculo, double tarifa){
        ASSERTION.assertion(tarifa > 0, "Error: la tarifa debe ser mayor que cero");
        vehiculo.setTarifa(tarifa);
    }
    
}
