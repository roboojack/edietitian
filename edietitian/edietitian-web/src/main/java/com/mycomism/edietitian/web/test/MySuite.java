package com.mycomism.edietitian.web.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Robert Jackson
 */
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses(
		{
//			Test1.class,
			BeginingToEndTests.class,
			Test2.class,
			Test3.class,
			Test4.class,
			Test5.class,
			Test6.class,
			Test7.class,
			DrinkingConsumptionTests.class,
			SpecialIllnessTests.class,
			SFactTests.class,
			CholesterolTests.class
//			LoadTest.class
//			LoadTest1.class
		})
@Concurrent
public class MySuite {
}
