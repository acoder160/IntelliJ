package main.java.org.examenpokemon.service;

/**
 * Excepción personalizada para errores de validación en la capa de servicio.
 * <p>
 * Permite comunicar fallos de negocio (por ejemplo, campos vacíos o valores inválidos)
 * desde los métodos Service hasta el nivel de aplicación.
 *
 * @author Profesor Sycamore
 */
public class ServiceException extends Exception {

    /**
     * Crea una nueva excepción con el mensaje indicado.
     *
     * @param message descripción del error.
     */
    public ServiceException(String message) {
        super(message);
    }
}
