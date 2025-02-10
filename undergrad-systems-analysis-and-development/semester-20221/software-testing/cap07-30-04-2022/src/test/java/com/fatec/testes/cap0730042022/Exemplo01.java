package com.fatec.testes.cap0730042022;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exemplo01 {
	
	static String str1;
	static String str2;
	static String str3;
	static String str4;
	static String str5;
	static int val1;
	static int val2;
	String[] arrayEsperado = { "um", "dois", "treis" };
	String[] arrayObtido = { "um", "dois", "treis" };

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.out.println("==> configura o estado da aplicação sob teste antes da execução de todos os testes...");
		//test data
		str1 = new String("abc");
		str2 = new String("abc");
		str3 = null;
		str4 = "abc";
		str5 = "abc";
		val1 = 5;
		val2 = 6;
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		System.out.println("==>libera os recursos utilizados depois da execução de todos os testes...");
	}

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("1-setup - configura o estado da aplicação antes de cada caso de teste.... ");
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.out.println("2-libera - é executado depois da execução do caso de teste.... ");
	}

	@Test
	public void test1() {
		System.out.println("Executa teste 1 ===>");
		assertEquals(str1, str2);
	}

	@Test
	public void test2() {
		System.out.println("Executa teste 2 ===>");
		assertTrue(val1 < val2);
	}

	@Test
	public void test3() {
		System.out.println("Executa teste 3 ===>");
		assertFalse(val1 > val2);
	}

	@Test
	public void test4() {
		System.out.println("Executa teste 4 ===>");
		assertNotNull(str1);
	}

	@Test
	public void test5() {
		System.out.println("Executa teste 5 ===>");
		assertArrayEquals(arrayEsperado, arrayObtido);
	}

}
