package com.jacaranda.lemastest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jacaranda.lemas.DefinicionException;
import com.jacaranda.lemas.Significado;

class SignificadoTest {

	@Test
	public void testSignificado() throws DefinicionException {
		Significado target = new Significado("Grupo de peces");
		String expected = "GRUPO DE PECES";
		String actual = target.getDefinicion();
		assertEquals(expected, actual, "El significado debía estar en mayúsculas");
	}

}
