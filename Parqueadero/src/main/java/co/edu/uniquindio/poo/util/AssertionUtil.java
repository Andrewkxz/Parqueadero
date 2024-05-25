package co.edu.uniquindio.poo.util;

import java.util.function.Supplier;

public enum AssertionUtil {
    ASSERTION;

    public void assertion(boolean condicion, Supplier<RuntimeException> exception){
        if(!condicion){
            throw exception.get();
        }
    }

    public void assertion(boolean condicion, String mensaje){
        assertion(condicion, ()-> new RuntimeException(mensaje));
    }

    public void assertion(boolean condicion){
        assertion(condicion, "Error: Condición no cumplida");
    }
}
