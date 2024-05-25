package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
/**
 * Clase que agrupa los datos de una persona
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
public class Persona {
    private final String nombres;
    private final String apellidos;
    private final int edad;
    private final String celular;
    private final String correo;
    /**
     * Método constructor de la clase Persona
     * @param nombres valor de los nombres de la persona
     * @param apellidos valor de los apellidos de la persona
     * @param edad valor de la edad de la persona
     * @param celular valor del celular de la persona
     * @param correo valor del correo de la persona
     */
    public Persona(String nombres, String apellidos, int edad, String celular, String correo) {
        ASSERTION.assertion(nombres != null && !nombres.isBlank(), "Error: el nombre no puede ser nulo ni vacío.");
        ASSERTION.assertion(apellidos != null && !apellidos.isBlank(), "Error: el apellido no puede ser nulo ni vacío.");
        ASSERTION.assertion(edad >= 18, "Error: debe ser mayor de edad.");
        ASSERTION.assertion(celular != null && !celular.isBlank(), "Error: el celular no puede ser nulo ni vacío");
        ASSERTION.assertion(correo != null && !correo.isBlank(), "Error: el correo no puede ser nulo ni vacío");

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.celular = celular;
        this.correo = correo;
    }
    /**
     * Método para obtener los nombres de la persona
     * @return nombres de la persona
     */
    public String getNombres() {
        return nombres;
    }
    /**
     * Método para obtener los apellidos de la persona
     * @return apellidos de la persona
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Método para obtener la edad de la persona
     * @return edad de la persona
     */
    public int getEdad() {
        return edad;
    }
    /**
     * Método para obtener el celular de la persona
     * @return celular de la persona
     */
    public String getCelular() {
        return celular;
    }
    /**
     * Método para obtener el correo de la persona
     * @return correo de la persona
     */
    public String getCorreo() {
        return correo;
    }

    
}
