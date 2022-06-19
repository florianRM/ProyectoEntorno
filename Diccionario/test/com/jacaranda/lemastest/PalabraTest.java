package com.jacaranda.lemastest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jacaranda.lemas.DefinicionException;
import com.jacaranda.lemas.LemaException;
import com.jacaranda.lemas.Palabra;
import com.jacaranda.lemas.Significado;

class PalabraTest {

	@Test
	public void testPalabra() throws LemaException {
		Palabra target = new Palabra("Banco");
		String expected = "BANCO";
		String actual = target.getNombre();
		assertEquals(expected, actual, "La palabra debía estar en mayúsculas");
	}
	
	@Test
	public void testAddSignificado() throws DefinicionException {
		Palabra target;
		Significado aux = new Significado("Grupo de peces");
		try {
			target = new Palabra("Banco");
			target.addSignificado(aux);
			target.addSignificado(aux);
			fail("Debía lanzar una excepción");
		} catch (LemaException e) {
			System.out.println(e.getMessage());
		}
	}

}
