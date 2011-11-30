package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class TestBasicSetup extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium(
				SeleniumTestingConstants.TEST_SERVER_HOST, 
				SeleniumTestingConstants.TEST_SERVER_PORT, 
				SeleniumTestingConstants.TEST_SERVER_BROWSER, 
				"http://" + SeleniumTestingConstants.TEST_WEPAPP_HOST + ":" + 
							SeleniumTestingConstants.TEST_WEBAPP_PORT + "/"
		);
		selenium.start();
		selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
		selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");

	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
	
	public void verifyMandatoryInferredFactsArePresentInFinalState() {

		assertTrue(selenium.isTextPresent("age"));
		assertTrue(selenium.isTextPresent("gender"));
		assertTrue(selenium.isTextPresent("height"));
		assertTrue(selenium.isTextPresent("weight"));

		assertTrue(selenium.isTextPresent("bmi"));
		assertTrue(selenium.isTextPresent("exerciseOutput"));
		assertTrue(selenium.isTextPresent("bmrAtRest"));
		assertTrue(selenium.isTextPresent("weightType"));
		assertTrue(selenium.isTextPresent("bmr"));

	}

	
}
