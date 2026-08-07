package edu.umg.programacion2.examen01.modelo;

import edu.umg.programacion2.examen01.excepciones.LibroNoDisponibleException;

/**
 * Modelo con encapsulamiento (privado + getters), igual que Usuario y
 * Producto de las clases anteriores. Implementa Prestable: sabe prestarse y
 * devolverse a sí mismo, y avisa cuando no se puede prestar lanzando una
 * excepción propia en vez de solo retornar false.
 */
public class Libro implements Prestable {

	private final String isbn;
	private final String titulo;
	private final String autor;
	private final String categoria;
	private final int anioPublicacion;
	private boolean disponible;

	public Libro(String isbn, String titulo, String autor, String categoria, int anioPublicacion) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.anioPublicacion = anioPublicacion;
		this.disponible = true; // 1. Todo libro nuevo entra disponible.
	}

	@Override
	public void prestar() throws LibroNoDisponibleException {
		// IMPORTANTE: no basta con "devolver false" si ya está prestado.
		// Lanzamos una excepción propia (checked) para obligar a quien llama
		// a decidir qué hacer, igual que con ApiUsuariosException en la Clase 3.
		if (!disponible) {
			throw new LibroNoDisponibleException("El libro \"" + titulo + "\" ya está prestado.");
		}
		disponible = false;
	}

	@Override
	public void devolver() {
		disponible = true;
	}

	@Override
	public boolean estaDisponible() {
		return disponible;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	@Override
	public String toString() {
		String estado = disponible ? "disponible" : "prestado";
		return String.format("[%s] %s (%d) - %s - %s - %s", isbn, titulo, anioPublicacion, autor, categoria, estado);
	}
}
