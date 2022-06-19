package com.jacaranda.lemastest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jacaranda.lemas.Letra;
import com.jacaranda.lemas.LetraException;

class LetraTest {

	@Test
	public void testLetra() throws LetraException {
		Letra target = new Letra('B');
		char expected = 'B';
		char actual = target.getLetra();
		assertEquals(expected, actual, "La letra debía ser igual a la introducida");
	}

	@Test
	public void testLetraException() {
		try {
			new Letra('@');
			fail("Debía lanzar una exepción");
		} catch (LetraException e) {
			System.out.println("La exepción de letra ha saltado:" + e.getMessage());
		}
	}

	@Test
	public void testAddPalabra() throws LetraException {
		Letra target = new Letra('B');
		target.addPalabra("Banco", "Grupo de peces");
		String expected = "BANCO\n  - GRUPO DE PECES\n";
		String actual = target.buscarPalabra("Banco");
		assertEquals(expected, actual, "La palabra no se ha introducido");
	}

	@Test
	public void testAddPalabraExistente() throws LetraException {
		Letra target = new Letra('B');
		target.addPalabra("Banco", "Grupo de peces");
		target.addPalabra("Banco", "Lugar donde se guarda dinero");
		String expected = "BANCO\n  - GRUPO DE PECES\n  - LUGAR DONDE SE GUARDA DINERO\n";
		String actual = target.buscarPalabra("Banco");
		assertEquals(expected, actual, "La palabra no se ha introducido");
	}

	@Test
	public void testAddPalabraSignificadoExiste() {
		try {
			Letra target = new Letra('B');
			target.addPalabra("Banco", "Grupo de peces");
			target.addPalabra("Banco", "Grupo de peces");
			fail("Debía lanzar una eepción");
		} catch (LetraException e) {
			System.out.println("La exepción de AddPalabraSignificadoExiste ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testBuscarPalabra() throws LetraException {
		Letra target = new Letra('B');
		target.addPalabra("Banco", "Grupo de peces");
		String expected = "BANCO\n  - GRUPO DE PECES\n";
		String actual = target.buscarPalabra("Banco");
		assertEquals(expected, actual, "La palabra no existe");
	}
	
	@Test
	public void testBuscarPalabraNoExiste() throws LetraException {
		Letra target = new Letra('B');
		String expected = "No existe la palabra";
		String actual = target.buscarPalabra("Barco");
		assertEquals(expected, actual, "Debería salir una cadena de que no existe la palabra");
	}
	
	@Test
	public void testBorrarPalabra() throws LetraException {
		Letra target = new Letra('B');
		target.addPalabra("Banco", "Grupo de peces");
		target.borrarPalabra("Banco");
		target.buscarPalabra("Banco");
		String expected = "No existe la palabra";
		String actual = target.buscarPalabra("Banco");
		assertEquals(expected, actual, "Debeía salir que no existe la palabra");
	}
	
	@Test
	public void testBorrarPalabraException() {
		Letra target;
		try {
			target = new Letra('B');
			target.borrarPalabra("Barco");
			fail("Debía saltar una excepción");
		} catch (LetraException e) {
			System.out.println("La excepción BorrarPalabra ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testListaPalabras() throws LetraException {
		Letra target = new Letra('B');
		target.addPalabra("Banco", "Grupo de peces");
		target.addPalabra("Barco", "Método de transporte");
		String expected = "BARCO\n  - MÉTODO DE TRANSPORTE\n\nBANCO\n  - GRUPO DE PECES\n\n";
		String actual = target.listaPalabras("B");
		assertEquals(expected, actual, "Debían listarse las palabra que empiezen por ese carácter");
	}
	
	@Test
	public void testListaPalabrasException() {
		try {
			Letra target = new Letra('B');
			target.listaPalabras(null);
			fail("Debía lanar una excepción");
		} catch (LetraException e) {
			System.out.println("La excepción de ListaPalabras ha saltado:" + e.getMessage());
		}
	}
}
