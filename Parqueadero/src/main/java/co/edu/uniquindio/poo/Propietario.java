package co.edu.uniquindio.poo;
/**
 * Clase que agrupa los datos de un propietario
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
public class Propietario extends Persona{
    /**
     * Método constructor de la clase Propietario
     * @param nombres valor de los nombres del propietario
     * @param apellidos valor de los apellidos del propietario
     * @param edad valor de la edad del propietario
     * @param celular valor del celular del propietario
     * @param correo valor del correo del propietario
     */
    public Propietario(String nombres, String apellidos, int edad, String celular, String correo){
        super(nombres, apellidos, edad, celular, correo);
    }
    
}
