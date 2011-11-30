package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class Test2 extends TestBasicSetup {

	@Test
	public void testBMI_BMR_Age20_Male_Height71_Weight200_ExerciseOutputLittle() throws Exception {
		selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("height_input", "label=5'11'' / 180cm");
		selenium.select("weight_input", "label=200lbs / 90.7kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_male");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("27.9"));
		assertTrue(selenium.isTextPresent("1940"));
		assertTrue(selenium.isTextPresent("2328"));
		assertTrue(selenium.isTextPresent("overweight"));
		assertTrue(selenium.isTextPresent("71"));
		assertTrue(selenium.isTextPresent("200"));
		assertTrue(selenium.isTextPresent("male"));
		assertTrue(selenium.isTextPresent("little"));
		assertTrue(selenium.isTextPresent("20"));
		
	}
	@Test
	public void testResetClient() throws Exception {
		selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("height_input", "label=5'11'' / 180cm");
		selenium.select("weight_input", "label=200lbs / 90.7kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_male");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("27.9"));
		assertTrue(selenium.isTextPresent("1940"));
		assertTrue(selenium.isTextPresent("2328"));
		assertTrue(selenium.isTextPresent("overweight"));
		assertTrue(selenium.isTextPresent("71"));
		assertTrue(selenium.isTextPresent("200"));
		assertTrue(selenium.isTextPresent("male"));
		assertTrue(selenium.isTextPresent("little"));
		assertTrue(selenium.isTextPresent("20"));

		// got back to first page
		//selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("physical characteristics"));
	}

}
