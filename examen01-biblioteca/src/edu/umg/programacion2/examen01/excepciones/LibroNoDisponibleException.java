package edu.umg.programacion2.examen01.excepciones;

/**
 * Excepción propia (checked), mismo patrón que ApiUsuariosException de la
 * Clase 3: se lanza cuando algo impide prestar un libro (ya está prestado,
 * o no existe). Quien llama a prestar() está obligado a manejarla.
 */
public class LibroNoDisponibleException extends Exception {

	public LibroNoDisponibleException(String mensaje) {
		super(mensaje);
	}
}
