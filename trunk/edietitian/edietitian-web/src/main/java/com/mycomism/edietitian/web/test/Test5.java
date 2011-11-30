package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;


@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class Test5 extends TestBasicSetup  {


	@Test
	public void testBMI_BMR_Age30_Female_Height72_Weight150_ExerciseOutputLittle() throws Exception {
		selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("height_input", "label=6' 0'' / 183cm");
		selenium.select("weight_input", "label=150lbs / 68.0kg");
		selenium.select("age_input", "label=30s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		//selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("20.3"));
		assertTrue(selenium.isTextPresent("normal"));
		assertTrue(selenium.isTextPresent("1514"));
		assertTrue(selenium.isTextPresent("1817"));
		assertTrue(selenium.isTextPresent("72"));
		assertTrue(selenium.isTextPresent("150"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("little"));
		assertTrue(selenium.isTextPresent("30"));

		

	}

}
