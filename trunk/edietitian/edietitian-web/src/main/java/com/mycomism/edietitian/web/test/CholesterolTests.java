package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class CholesterolTests extends TestBasicSetup {

	@Test
	public void testEnsureHighCholesterolBackGroundInfoPresentAtEnd() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		selenium.select("id=age_input", "label=10s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=highCholesterol_input"); // has high cholesterol
		selenium.click("id=myQuestionnaire_action_1");
//		selenium.select("id=numEggsPerDay_input", "label=<1"); // egg consumption per day < 1
//		selenium.click("id=useEggSubstitutes_input"); // uses egg substitute
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("You have High Cholesterol"));
		assertTrue(selenium.isTextPresent("less than 300 mg per day of dietary cholesterol"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();

	}

	
	
	@Test
	public void testEnsureHighCholesterolBackGroundInfoNotPresentAtEnd() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		selenium.select("id=age_input", "label=10s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=highCholesterol_input"); // select has high cholesterol
		selenium.click("id=highCholesterol_input"); // deselect has high cholesterol
		selenium.click("id=myQuestionnaire_action_1");
//		selenium.select("id=numEggsPerDay_input", "label=<1"); // egg consumption per day < 1
//		selenium.click("id=useEggSubstitutes_input"); // uses egg substitute
		selenium.waitForPageToLoad("30000");
		
		
		assertFalse(selenium.isTextPresent("You have High Cholesterol"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();

	}
	

	@Test
	public void testCholesterol1() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		selenium.select("id=age_input", "label=10s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=highCholesterol_input"); // has high cholesterol
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=numEggsPerDay_input", "label=<1"); // egg consumption per day < 1
//		selenium.click("id=useEggSubstitutes_input"); // uses egg substitute
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("You have High Cholesterol"));
		assertTrue(selenium.isTextPresent("less than 300 mg per day of dietary cholesterol"));
		assertFalse(selenium.isTextPresent("Egg Substitutes"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();

	}

	@Test
	public void testCholesterol2() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		selenium.select("id=age_input", "label=10s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=highCholesterol_input"); // has high cholesterol
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=numEggsPerDay_input", "label=2"); // egg consumption per day = 2
//		selenium.click("id=useEggSubstitutes_input"); // uses egg substitute
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("You have High Cholesterol"));
		assertTrue(selenium.isTextPresent("less than 300 mg per day of dietary cholesterol"));
		assertTrue(selenium.isTextPresent("Egg Substitutes"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();

	}

	@Test
	public void testCholesterol3() throws Exception {
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		selenium.select("id=age_input", "label=10s");
		selenium.click("id=gender_input_male");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=highCholesterol_input"); // has high cholesterol
		selenium.click("id=myQuestionnaire_action_1");
		selenium.select("id=numEggsPerDay_input", "label=2"); // egg consumption per day = 2
		selenium.click("id=useEggSubstitutes_input"); // but uses egg substitute
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		
		
		assertTrue(selenium.isTextPresent("You have High Cholesterol"));
		assertTrue(selenium.isTextPresent("less than 300 mg per day of dietary cholesterol"));
		assertTrue(selenium.isTextPresent("good to hear you are using an egg substitute"));
		assertFalse(selenium.isTextPresent("Egg Substitutes"));
		
		verifyMandatoryInferredFactsArePresentInFinalState();

	}

	
	
	
	
	
	
	
	
	
	
	
	
}
