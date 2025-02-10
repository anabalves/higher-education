package com.fatec.testes.cap0730042022;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteListaVazia {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testaListaVazia() {
		// dado que – a variavel lista está vazia
		List<String> lista;
		lista = new ArrayList<String>();
		// quando consulta o tamanho da lista
		int tamanho = lista.size();
		// então – o tamanho é igual a zero
		assertEquals(0, tamanho);
	}

	@Test
	public void verifica_se_a_lista_tem_o_mesmo_conteudo() {
		List<String> lista = new ArrayList<String>();
		lista.add("jose");
		lista.add("silva");
		lista.add("marina");
		assertEquals("jose", lista.get(0));
		assertEquals("silva", lista.get(1));
		assertEquals("marina", lista.get(2));
	}

	@Test
	public void verifica_se_a_lista_tem_o_mesmo_conteudov2() {
		List<String> lista1 = new ArrayList<String>();
		lista1.add("jose");
		lista1.add("silva");
		lista1.add("marina");
		List<String> lista2 = Collections.synchronizedList(lista1);
		for (int i = 0; i < lista1.size(); i++) {
			assertEquals(lista1.get(i), lista2.get(i));
		}
	}

	@Test
	public void verifica_se_a_lista_tem_o_mesmo_conteudo2() {
		List<String> lista1 = new ArrayList<String>();
		lista1.add("jose");
		lista1.add("silva");
		lista1.add("marina");
		List<String> lista2 = Collections.synchronizedList(lista1);
		assertEquals(lista1, lista2);
	}

	@Test
	void testaListAdd() {
		List<String> list = new ArrayList<String>();
		assertFalse(list.contains("hello"));
		list.add("hello");
		assertTrue(list.contains("hello"));
	}

}
