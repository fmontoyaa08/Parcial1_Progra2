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
		System.out.println("0) Salir");
		System.out.print("Opción: ");
	}

	private static void listarTodos(Biblioteca biblioteca) {
		for (Libro libro : biblioteca.listarTodos()) {
			System.out.println(libro);
		}
	}

	
}
