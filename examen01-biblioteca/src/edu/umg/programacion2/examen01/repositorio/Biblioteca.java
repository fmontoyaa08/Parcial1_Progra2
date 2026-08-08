package edu.umg.programacion2.examen01.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.umg.programacion2.examen01.excepciones.LibroNoDisponibleException;
import edu.umg.programacion2.examen01.modelo.Libro;

public class Biblioteca {

	private final List<Libro> catalogo = new ArrayList<>();

	public void cargarTodos(List<Libro> nuevosLibros) {
		this.catalogo.addAll(nuevosLibros);
	}

	public int total() {
		return catalogo.size();
	}

	public List<Libro> listarTodos() {
		return new ArrayList<>(catalogo);
	}

	// =========================================================================
	// PREGUNTA PRÁCTICA 1: Contar libros por categoría
	// =========================================================================
	public Map<String, Integer> contarLibrosPorCategoria() {
		Map<String, Integer> conteo = new HashMap<>();
		for (Libro libro : catalogo) {
			String categoria = libro.getCategoria();
			conteo.put(categoria, conteo.getOrDefault(categoria, 0) + 1);
		}
		return conteo;
	}

	// =========================================================================
	// PREGUNTA PRÁCTICA 2: Buscar por título parcial (sin importar mayúsculas/minúsculas)
	// =========================================================================
	public List<Libro> buscarPorTituloParcial(String texto) {
		List<Libro> resultados = new ArrayList<>();
		if (texto == null || texto.trim().isEmpty()) {
			return resultados;
		}

		String textoMinuscula = texto.toLowerCase().trim();
		for (Libro libro : catalogo) {
			if (libro.getTitulo().toLowerCase().contains(textoMinuscula)) {
				resultados.add(libro);
			}
		}
		return resultados;
	}

	// =========================================================================
	// PREGUNTA PRÁCTICA 3: Libro más antiguo de una categoría
	// =========================================================================
	public Libro libroMasAntiguoDeCategoria(String categoria) {
		if (categoria == null || categoria.trim().isEmpty()) {
			return null;
		}

		Libro masAntiguo = null;
		for (Libro libro : catalogo) {
			if (libro.getCategoria().equalsIgnoreCase(categoria.trim())) {
				if (masAntiguo == null || libro.getAnioPublicacion() < masAntiguo.getAnioPublicacion()) {
					masAntiguo = libro;
				}
			}
		}
		return masAntiguo;
	}

	// =========================================================================
	// MÉTODO DE REFERENCIA: Prestar por ISBN
	// =========================================================================
	public void prestarPorIsbn(String isbn) throws LibroNoDisponibleException {
		for (Libro libro : catalogo) {
			if (libro.getIsbn().equalsIgnoreCase(isbn)) {
				libro.prestar();
				return;
			}
		}
		throw new LibroNoDisponibleException("No se encontró ningún libro con el ISBN: " + isbn);
	}

	// =========================================================================
	// RETO OPCIONAL: Prestar el primero disponible de una categoría
	// =========================================================================
	public Libro prestarPrimerDisponibleDeCategoria(String categoria) throws LibroNoDisponibleException {
		if (categoria == null || categoria.trim().isEmpty()) {
			throw new LibroNoDisponibleException("La categoría ingresada no es válida.");
		}

		for (Libro libro : catalogo) {
			if (libro.getCategoria().equalsIgnoreCase(categoria.trim()) && libro.estaDisponible()) {
				libro.prestar();
				return libro;
			}
		}

		throw new LibroNoDisponibleException("No hay libros disponibles para préstamo en la categoría: " + categoria);
	}
}