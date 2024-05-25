package co.edu.uniquindio.poo;
/**
 * Clase que agrupa los datos de un comprador
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
public class Comprador extends Persona{
    /**
     * Método constructor de la clase Comprador
     * @param nombres valor de los nombres del comprador
     * @param apellidos valor de los apellidos del comprador
     * @param edad valor de la edad del comprador
     * @param celular valor del celular del comprador
     * @param correo valor del correo del comprador
     */
    public Comprador(String nombres, String apellidos, int edad, String celular, String correo) {
        super(nombres, apellidos, edad, celular, correo);
    }
    
}
