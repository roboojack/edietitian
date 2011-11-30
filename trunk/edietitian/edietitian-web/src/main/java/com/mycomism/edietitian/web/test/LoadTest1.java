package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;



public class LoadTest1 {
	final int NUM_THREADS=10;
	
	@Test
	public void testParallelScale() throws Exception {
		Vector<Thread> threads = new Vector<Thread>();

		for (int i = 0; i < NUM_THREADS; i++) {
			threads.add(new Thread(new RunnableThread(i)));
			threads.lastElement().start();
		}
		for (int i = 0; i < NUM_THREADS; i++) {
			threads.get(i).join();
		}
		
	}
	
	
}

class RunnableThread implements Runnable {

	int id;
	public RunnableThread(int i) {
		id=i;
	}

	
	public void run() {
		System.out.println(new Date() + " Started Thread" + id);
		LoadTest test = new LoadTest();
		test.simpleTestCase1();
		//test.run();

		//Display info about this particular thread
		System.out.println(new Date() + " Finished Thread" + id);
	}
}