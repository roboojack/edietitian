package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;


@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class Test3 extends TestBasicSetup  {


	@Test
	public void testBMI_BMR_Age30_Female_Height60_Weight200_ExerciseOutputLittle() throws Exception {
		selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("height_input", "label=5' 0'' / 152cm");
		selenium.select("weight_input", "label=200lbs / 90.7kg");
		selenium.select("age_input", "label=30s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("39.1"));
		assertTrue(selenium.isTextPresent("1550"));
		assertTrue(selenium.isTextPresent("1860"));
		assertTrue(selenium.isTextPresent("obese"));
		assertTrue(selenium.isTextPresent("60"));
		assertTrue(selenium.isTextPresent("200"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("little"));
		assertTrue(selenium.isTextPresent("30"));

		

	}

}
