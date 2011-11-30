package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;


@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class Test4 extends TestBasicSetup  {


	@Test
	public void testBMI_BMR_Age30_Female_Height72_Weight130_ExerciseOutputLight() throws Exception {
		selenium.open("/edietitian-web/index.jsp");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("height_input", "label=6' 0'' / 183cm");
		selenium.select("weight_input", "label=130lbs / 59.0kg");
		selenium.select("age_input", "label=30s");
		selenium.click("gender_input_female");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=exercise_input_true");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=exerciseDaysPerWeek_input", "label=2");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("17.6"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("1423"));
		assertTrue(selenium.isTextPresent("1957"));
		assertTrue(selenium.isTextPresent("72"));
		assertTrue(selenium.isTextPresent("130"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("light"));
		assertTrue(selenium.isTextPresent("30"));

		

	}


}
