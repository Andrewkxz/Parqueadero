package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
/**
 * Clase que agrupa los datos de un puesto
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
public class Puesto {
    private final int posicionI;
    private final int posicionJ;
    private Estado estado;
    private Vehiculo vehiculo;
    /**
     * Método constructor de la clase Puesto
     * @param posicionI valor de la posición I del puesto
     * @param posicionJ valor de la posición J del puesto
     * @param estado valor del estado del puesto
     */
    public Puesto(int posicionI, int posicionJ, Estado estado) {
        ASSERTION.assertion(posicionI > 0,
                "Error: la posicion I debe ser mayor a cero");
        ASSERTION.assertion(posicionJ > 0,
                "Error: la posicion I debe ser mayor a cero");
        ASSERTION.assertion(estado != null, "Error: el estado no puede ser nulo");
        this.posicionI = posicionI;
        this.posicionJ = posicionJ;
        this.estado = estado;
    }
    /**
     * Método para obtener la posición I del puesto
     * @return posicionI del puesto
     */
    public int getPosicionI() {
        return posicionI;
    }
    /**
     * Método para obtener la posición J del puesto
     * @return posicionJ del puesto
     */
    public int getPosicionJ() {
        return posicionJ;
    }
    /**
     * Método para obtener el estado del puesto
     * @return estado del puesto
     */
    public Estado getEstado() {
        return estado;
    }
    /**
     * Método para cambiar el estado del puesto
     * @param estadoNuevo estado cambiado del puesto
     */
    public void setEstado(Estado estadoNuevo){
        this.estado = estadoNuevo;
    }
    /**
     * Método para obtener el vehiculo del puesto
     * @return vehiculo del puesto
     */
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    /**
     * Método para cambiar el vehiculo del puesto
     * @param vehiculo vehiculo cambiado del puesto
     */
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

}
