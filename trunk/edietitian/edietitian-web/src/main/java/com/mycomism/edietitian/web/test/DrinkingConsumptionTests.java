package com.mycomism.edietitian.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class DrinkingConsumptionTests extends TestBasicSetup {

	@Test
	public void test1() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=180lbs / 81.6kg");
		selenium.select("id=age_input", "label=30s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=drink_input_true");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=drinksPerWeek_input", "label=10");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("are obese. By drinking 10 drinks per " +
				"week, you are adding approximately 1000 to " +
				"2000 calories per week to your caloric intake"));
	}

	@Test
	public void test2() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=170lbs / 77.1kg"); // 10lbs less
		selenium.select("id=age_input", "label=30s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=drink_input_true");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=drinksPerWeek_input", "label=15"); // 5 drinks more
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("are obese. By drinking 15 drinks per " +
				"week, you are adding approximately 1500 to " +
				"3000 calories per week to your caloric intake"));
	}

	@Test
	public void test3() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=160lbs / 75.6kg"); // 160lbs
		selenium.select("id=age_input", "label=30s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=drink_input_true");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=drinksPerWeek_input", "label=20"); // 20 drinks
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("are obese. By drinking 20 drinks per " +
				"week, you are adding approximately 2000 to " +
				"4000 calories per week to your caloric intake"));
	}

	
}
