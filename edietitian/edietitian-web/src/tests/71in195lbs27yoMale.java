package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class 71in195lbs27yoMale extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/edietitian-web/");
		selenium.start();
	}

	@Test
	public void test71in195lbs27yoMale() throws Exception {
		selenium.open("/edietitian-web/reset.jsp?knowledgebase=buttons&null");
		selenium.type("height_input", "71");
		selenium.type("weight_input", "195");
		selenium.type("age_input", "27");
		selenium.click("gender_input_male");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
