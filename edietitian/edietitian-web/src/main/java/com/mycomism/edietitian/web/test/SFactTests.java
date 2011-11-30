package com.mycomism.edietitian.web.test;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.mycomism.SFact;


@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class SFactTests {


	@Test
	public void test2SFactsEquallity1() throws Exception {
		SFact fact1 = new SFact("id", SFact.TYPE_DECIMAL, new BigDecimal(1.0));
		SFact fact2 = new SFact("id", SFact.TYPE_DECIMAL, new BigDecimal(1.0));
		
		assertTrue(fact1.equals(fact2));
	}
	@Test
	public void test2SFactsEquallity2() throws Exception {
		SFact fact1 = new SFact("id", SFact.TYPE_DECIMAL, new BigDecimal(1.0));
		SFact fact2 = new SFact("id", SFact.TYPE_DECIMAL, new BigDecimal(2.0));
		
		assertTrue(!fact1.equals(fact2));
	}
	@Test
	public void test2SFactsEquallity3() throws Exception {
		SFact fact1 = new SFact("id1", SFact.TYPE_DECIMAL, new BigDecimal(1.0));
		SFact fact2 = new SFact("id2", SFact.TYPE_DECIMAL, new BigDecimal(1.0));
		
		assertTrue(!fact1.equals(fact2));
	}



}
