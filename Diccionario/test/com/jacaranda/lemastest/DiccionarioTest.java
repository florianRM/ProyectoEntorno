package com.jacaranda.lemastest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jacaranda.lemas.Diccionario;
import com.jacaranda.lemas.DiccionarioException;
import com.jacaranda.lemas.LetraException;

class DiccionarioTest {

	@Test
	public void testAddPalabra() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		target.addPalabra("Avión", "Método de transporte");
		String expected = "AVIÓN\n  - MÉTODO DE TRANSPORTE\n";
		String actual = target.buscarPalabra("Avión");
		assertEquals(expected, actual, "El diccionario no ha añadido la palabra");
	}
	
	@Test
	public void testAddPalabraExistente() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		target.addPalabra("Banco", "Grupo de peces");
		target.addPalabra("Banco", "Lugar donde se guarda dinero");
		String expected = "BANCO\n  - GRUPO DE PECES\n  - LUGAR DONDE SE GUARDA DINERO\n";
		String actual = target.buscarPalabra("Banco");
		assertEquals(expected, actual, "El diccionario no ha añadido los dos significados");
	}
	
	@Test
	public void testAddPalabraException() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.addPalabra(null, "Método de transporte");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de addPalabra palabra null ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testAddPalabraSignificadoException() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.addPalabra("Avión", "");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de addPalabra significado vacío ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testAddPalabraSifnificadoExistente() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.addPalabra("Avión", "Método de transporte");
			target.addPalabra("Avión", "Método de transporte");
			fail("Debía saltar una exepción");
		} catch (DiccionarioException e) {
			System.out.println("La exepción ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testBuscarPalabra() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		target.addPalabra("Avión", "Método de transporte");
		String expected = "AVIÓN\n  - MÉTODO DE TRANSPORTE\n";
		String actual = target.buscarPalabra("Avión");
		assertEquals(expected, actual, "El diccionario no ha guardado la palabra");
	}
	
	@Test
	public void testBuscarPalabraException() throws LetraException {
		Diccionario target = new Diccionario();
		try {
			target.buscarPalabra(null);
		} catch (DiccionarioException e) {
			System.out.println("La excepción de buscarPalabra ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testBuscarPalabraNoExistente() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		String expected = "No existe la palabra";
		String actual = target.buscarPalabra("Ave");
		assertEquals(expected, actual, "Ha encontrado una palabra que no existe");
	}
	
	@Test
	public void testBuscarPalabraCaracterEspecial() throws LetraException {
		Diccionario target = new Diccionario();
		try {
			target.buscarPalabra("/");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de buscarPalabraCaracterEspecial ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testListadoPalabrasQueEmpiezanPor() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		target.addPalabra("Avión", "Método de transporte");
		target.addPalabra("Ave", "Animal que vuela");
		String expected = "AVE\n  - ANIMAL QUE VUELA\n\nAVIÓN\n  - MÉTODO DE TRANSPORTE\n\n";
		String actual = target.listadoPalabrasQueEmpiezanPor("A");
		assertEquals(expected, actual, "El diccionario no ha guardado las palabras");
	}
	
	@Test
	public void testListadoPalabrasQueEmpiezanPorException() throws LetraException {
		Diccionario target = new Diccionario();
		try {
			target.listadoPalabrasQueEmpiezanPor(null);
			fail("Debía lanzar una excepción");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de listadoPalabrasQueEmpiezanPor" + e.getMessage());
		}
	}
	
	@Test
	public void testListadoPalabrasQueEmpiezanPorCaracterEspecial() throws LetraException {
		Diccionario target = new Diccionario();
		try {
			target.listadoPalabrasQueEmpiezanPor("@");
			fail("Debía lanzar una excepción");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de listadoPalabrasQueEmpiezanPorCaracterEspecial" + e.getMessage());
		}
	}

	
	@Test
	public void testBorrarPalabra() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		target.addPalabra("Avión", "Método de transporte");
		target.borrarPalabra("Avión");
		String expected = "No existe la palabra";
		String actual = target.buscarPalabra("Avión");
		assertEquals(expected, actual, "El diccionario no ha borrado la palabra");
	}
	
	@Test
	public void testBorrarPalabraException() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.borrarPalabra("");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de borrarPalabra ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testBorrarPalabraNoExiste() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.borrarPalabra("Avi");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de borrarPalabraNoExiste ha saltado:" + e.getMessage());
		}
	}
	
	@Test
	public void testBorrarPalabraCaracterEspecial() throws LetraException, DiccionarioException {
		Diccionario target = new Diccionario();
		try {
			target.borrarPalabra("@");
		} catch (DiccionarioException e) {
			System.out.println("La excepción de borrarPalabraCaracterEspecial ha saltado:" + e.getMessage());
		}
	}
	
}
