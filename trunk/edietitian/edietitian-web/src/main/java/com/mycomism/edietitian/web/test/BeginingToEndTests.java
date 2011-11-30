package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class BeginingToEndTests extends TestBasicSetup {

	@Test
	public void testTestBMI_BMR_Age20_Female_Height65_Weight110_ExerciseOutputLight() throws Exception {
		selenium.select("height_input", "label=5' 5'' / 165cm");
		selenium.select("weight_input", "label=110lbs / 49.9kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("exercise_input_true");
		selenium.click("myQuestionnaire_action_1");
		selenium.select("exerciseDaysPerWeek_input", "label=1");
		selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
		selenium.select("exerciseType_input", "label=run");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		

		selenium.click("//div[@id='accordion']/h3[2]");
		//selenium.waitForPageToLoad("3000");
		assertTrue(selenium.isTextPresent("20"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("65.0"));
		assertTrue(selenium.isTextPresent("110"));
		

		selenium.click("//div[3]/div/h3[3]");
		selenium.waitForPageToLoad("2000");
		assertTrue(selenium.isTextPresent("18.3"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("1270"));
		assertTrue(selenium.isTextPresent("1748"));
		assertTrue(selenium.isTextPresent("light"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();
	}
	
	
	@Test
	public void testTestBMI_BMR_Age20_Female_Height65_Weight110_ExerciseOutputLight1() throws Exception {
		selenium.select("height_input", "label=5' 5'' / 165cm");
		selenium.select("weight_input", "label=110lbs / 49.9kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("exercise_input_true");
		selenium.click("myQuestionnaire_action_1");
		selenium.select("exerciseDaysPerWeek_input", "label=1");
		selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
		selenium.select("exerciseType_input", "label=run");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("18.3"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("1270"));
		assertTrue(selenium.isTextPresent("1748"));
		assertTrue(selenium.isTextPresent("65.0"));
		assertTrue(selenium.isTextPresent("110"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("light"));
		assertTrue(selenium.isTextPresent("20"));

		verifyMandatoryInferredFactsArePresentInFinalState();
	}
	
	@Test
	public void test1_2() throws Exception {
		selenium.select("height_input", "label=5' 5'' / 165cm");
		selenium.select("weight_input", "label=110lbs / 49.9kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.click("exercise_input_true");						// exercise=yes
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.select("exerciseDaysPerWeek_input", "label=4");	// exercises 4 day/week
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("18.3"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("1270"));
		assertTrue(selenium.isTextPresent("1970"));
		assertTrue(selenium.isTextPresent("65.0"));
		assertTrue(selenium.isTextPresent("110"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("moderate"));
		assertTrue(selenium.isTextPresent("20"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();
	}
	@Test
	public void test1_3() throws Exception {
		selenium.select("height_input", "label=5' 5'' / 165cm");
		selenium.select("weight_input", "label=110lbs / 49.9kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.click("exercise_input_true");						// exercise=yes
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.select("exerciseDaysPerWeek_input", "label=6");	// exercises 4 day/week
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("18.3"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("heavy"));
		assertTrue(selenium.isTextPresent("1270"));
		assertTrue(selenium.isTextPresent("2192"));
		assertTrue(selenium.isTextPresent("65.0"));
		assertTrue(selenium.isTextPresent("110"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("20"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();
	}
	@Test
	public void test1_4() throws Exception {
		selenium.select("height_input", "label=5' 5'' / 165cm");
		selenium.select("weight_input", "label=110lbs / 49.9kg");
		selenium.select("age_input", "label=20s");
		selenium.click("gender_input_female");
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.click("exercise_input_true");						// exercise=yes
		selenium.click("myQuestionnaire_action_1"); 				// next screen
		selenium.select("exerciseDaysPerWeek_input", "label=7 + physical job or 2x training");	// exercises 4 day/week
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.click("myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("18.3"));
		assertTrue(selenium.isTextPresent("underweight"));
		assertTrue(selenium.isTextPresent("veryHeavy"));
		assertTrue(selenium.isTextPresent("1270"));
		assertTrue(selenium.isTextPresent("2415"));
		assertTrue(selenium.isTextPresent("65.0"));
		assertTrue(selenium.isTextPresent("110"));
		assertTrue(selenium.isTextPresent("female"));
		assertTrue(selenium.isTextPresent("20"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();
	}

}
