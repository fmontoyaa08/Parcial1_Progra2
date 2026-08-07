package edu.umg.programacion2.examen01.modelo;

import edu.umg.programacion2.examen01.excepciones.LibroNoDisponibleException;

/**
 * Cualquier ítem que se pueda prestar y devolver debe implementar esta
 * interface. Mismo patrón que Pagable/Bonificable de clases anteriores: el
 * resto del programa trabaja contra el contrato, sin importar el tipo real.
 */
public interface Prestable {

	void prestar() throws LibroNoDisponibleException;

	void devolver();

	boolean estaDisponible();
}
