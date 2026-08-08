package edu.umg.programacion2.examen01;

import java.util.List;
import java.util.Scanner;

import edu.umg.programacion2.examen01.datos.DatosIniciales;
import edu.umg.programacion2.examen01.excepciones.LibroNoDisponibleException;
import edu.umg.programacion2.examen01.modelo.Libro;
import edu.umg.programacion2.examen01.repositorio.Biblioteca;

/**
 * Menú del examen: carga el catálogo inicial y prueba las 3 preguntas
 * prácticas (más el reto opcional) desde consola. No necesitas modificar
 * este archivo.
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.cargarTodos(DatosIniciales.obtener());
		System.out.println("Catálogo cargado: " + biblioteca.total() + " libros.");

		boolean salir = false;
		while (!salir) {
			mostrarMenu();
			String opcion = teclado.nextLine().trim();

			switch (opcion) {
			case "1":
				listarTodos(biblioteca);
				break;
			case "2":
				contarPorCategoria(biblioteca);
				break;
			case "3":
				buscarPorTitulo(biblioteca, teclado);
				break;
			case "4":
				masAntiguoDeCategoria(biblioteca, teclado);
				break;
			case "5":
				prestarPorIsbn(biblioteca, teclado);
				break;
			case "6":
				prestarPrimerDisponible(biblioteca, teclado);
				break;
			case "0":
				salir = true;
				break;
			default:
				System.out.println("Opción no válida.");
			}
		}

		teclado.close();
		System.out.println("Fin del examen.");
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("=== Examen Parcial 1 - Sistema de Biblioteca ===");
		System.out.println("1) Listar todo el catálogo");
		System.out.println("2) Contar libros por categoría (Pregunta práctica 1)");
		System.out.println("3) Buscar por título parcial (Pregunta práctica 2)");
		System.out.println("4) Libro más antiguo de una categoría (Pregunta práctica 3)");
		System.out.println("5) Prestar un libro por ISBN (ya resuelto, de referencia)");
		System.out.println("6) Prestar el primero disponible de una categoría (Reto opcional)");
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}

	private static void listarTodos(Biblioteca biblioteca) {
		for (Libro libro : biblioteca.listarTodos()) {
			System.out.println(libro);
		}
	}

	private static void contarPorCategoria(Biblioteca biblioteca) {
		try {
			System.out.println(biblioteca.contarLibrosPorCategoria());
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void buscarPorTitulo(Biblioteca biblioteca, Scanner teclado) {
		System.out.print("Texto a buscar en el título: ");
		String texto = teclado.nextLine().trim();
		try {
			List<Libro> resultado = biblioteca.buscarPorTituloParcial(texto);
			if (resultado.isEmpty()) {
				System.out.println("Sin coincidencias.");
				return;
			}
			for (Libro libro : resultado) {
				System.out.println(libro);
			}
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void masAntiguoDeCategoria(Biblioteca biblioteca, Scanner teclado) {
		System.out.print("Categoría (ej. Novela): ");
		String categoria = teclado.nextLine().trim();
		try {
			Libro resultado = biblioteca.libroMasAntiguoDeCategoria(categoria);
			System.out.println(resultado != null ? resultado : "No hay libros en esa categoría.");
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}

	private static void prestarPorIsbn(Biblioteca biblioteca, Scanner teclado) {
		System.out.print("ISBN a prestar: ");
		String isbn = teclado.nextLine().trim();
		try {
			biblioteca.prestarPorIsbn(isbn);
			System.out.println("Préstamo realizado.");
		} catch (LibroNoDisponibleException ex) {
			System.out.println("No se pudo prestar: " + ex.getMessage());
		}
	}

	private static void prestarPrimerDisponible(Biblioteca biblioteca, Scanner teclado) {
		System.out.print("Categoría (ej. Novela): ");
		String categoria = teclado.nextLine().trim();
		try {
			Libro prestado = biblioteca.prestarPrimerDisponibleDeCategoria(categoria);
			System.out.println("Prestado: " + prestado);
		} catch (LibroNoDisponibleException ex) {
			System.out.println("No se pudo prestar: " + ex.getMessage());
		} catch (UnsupportedOperationException ex) {
			System.out.println("Pendiente: " + ex.getMessage());
		}
	}
}
