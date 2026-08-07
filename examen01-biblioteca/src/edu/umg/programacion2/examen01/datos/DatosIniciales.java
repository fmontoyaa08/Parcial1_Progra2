package edu.umg.programacion2.examen01.datos;

import java.util.ArrayList;
import java.util.List;

import edu.umg.programacion2.examen01.modelo.Libro;

/**
 * Catálogo de arranque, para no depender de ningún API externo durante el
 * examen (a diferencia de la Clase 3, aquí no hace falta internet).
 */
public class DatosIniciales {

	public static List<Libro> obtener() {
		List<Libro> libros = new ArrayList<>();
		libros.add(new Libro("978-1", "Cien años de soledad", "Gabriel García Márquez", "Novela", 1967));
		libros.add(new Libro("978-2", "El Principito", "Antoine de Saint-Exupéry", "Infantil", 1943));
		libros.add(new Libro("978-3", "Rayuela", "Julio Cortázar", "Novela", 1963));
		libros.add(new Libro("978-4", "1984", "George Orwell", "Ciencia ficción", 1949));
		libros.add(new Libro("978-5", "Un mundo feliz", "Aldous Huxley", "Ciencia ficción", 1932));
		libros.add(new Libro("978-6", "La casa de los espíritus", "Isabel Allende", "Novela", 1982));
		libros.add(new Libro("978-7", "Matilda", "Roald Dahl", "Infantil", 1988));
		libros.add(new Libro("978-8", "Fahrenheit 451", "Ray Bradbury", "Ciencia ficción", 1953));
		return libros;
	}
}
