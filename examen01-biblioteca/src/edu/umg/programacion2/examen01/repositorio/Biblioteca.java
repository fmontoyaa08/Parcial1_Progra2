package edu.umg.programacion2.examen01.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.umg.programacion2.examen01.excepciones.LibroNoDisponibleException;
import edu.umg.programacion2.examen01.modelo.Libro;

/**
 * Igual que RepositorioUsuarios/CatalogoProductos de clases anteriores: el
 * mismo catálogo de libros guardado en tres colecciones distintas, cada una
 * optimizada para una operación distinta.
 * <p>
 * - ArrayList&lt;Libro&gt;: catálogo completo, en orden de llegada.
 * - HashMap&lt;String, Libro&gt;: encontrar un libro por ISBN al instante.
 * - HashSet&lt;String&gt;: saber qué categorías existen, sin repetidas.
 */
public class Biblioteca {

	private final List<Libro> libros = new ArrayList<>();
	private final Map<String, Libro> librosPorIsbn = new HashMap<>();
	private final Set<String> categorias = new HashSet<>();

	public void agregar(Libro libro) {
		libros.add(libro);
		librosPorIsbn.put(libro.getIsbn(), libro);
		categorias.add(libro.getCategoria());
	}

	public void cargarTodos(List<Libro> librosACargar) {
		for (Libro libro : librosACargar) {
			agregar(libro);
		}
	}

	public List<Libro> listarTodos() {
		return libros;
	}

	public Libro buscarPorIsbn(String isbn) {
		return librosPorIsbn.get(isbn);
	}

	public Set<String> listarCategorias() {
		return categorias;
	}

	public int total() {
		return libros.size();
	}

	/**
	 * Ya resuelto: sirve de referencia para las 3 preguntas prácticas de
	 * abajo. Presta un libro por ISBN. Si no existe o ya está prestado,
	 * propaga la excepción para que quien llame decida qué mostrar.
	 */
	public void prestarPorIsbn(String isbn) throws LibroNoDisponibleException {
		Libro libro = buscarPorIsbn(isbn);
		if (libro == null) {
			throw new LibroNoDisponibleException("No existe ningún libro con ISBN " + isbn);
		}
		libro.prestar();
	}

	
}
