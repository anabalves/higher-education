package com.fatec.testes.cap0730042022;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exemplo02 {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	private Collection<Object> collection;

	@BeforeEach
	public void setUp() {
		collection = new ArrayList<Object>();
	}

	@Test
	public void testEmptyCollection() {
		assertTrue(collection.isEmpty());
	}

	@Test
	public void testOneItemCollection() {
		collection.add("itemA");
		assertEquals(1, collection.size());
	}

}
