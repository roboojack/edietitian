package com.mycomism.edietitian.web.test;


import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 5)
public class Test7 extends TestBasicSetup  {


	@Test
	public void testTestFeedbackOnResultsPage() throws Exception {
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
		selenium.type("name", "rob jack");
		selenium.type("email", "rob@gmail.com");
		selenium.type("suggestion", "You should fix your valve thing.");
		selenium.click("//input[@type='SUBMIT']");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Sending suggestion... SUCCESS"));
	}

	@Test
	public void testDisplayBMIAndWeightType1() throws Exception {
		selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian");
		selenium.click("css=img[alt=\"edietitianHeaderImage -- Things to Think About\"]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Start eDietitian!");
		selenium.waitForPageToLoad("30000");
		selenium.select("id=height_input", "label=4' 0'' / 122cm");
		selenium.select("id=weight_input", "label=80lbs / 36.3kg");
		assertFalse(selenium.isTextPresent("Your BMI is 24.4 and your Weight Type is normal"));
		assertFalse(selenium.isTextPresent("Your BMI is !!! and your Weight Type is normal"));
		assertFalse(selenium.isTextPresent("Your BMI is 1000.00 and your Weight Type is RED"));
		selenium.select("id=weight_input", "label=90lbs / 40.8kg");
		selenium.select("id=weight_input", "label=200lbs / 90.7kg");
		selenium.select("id=height_input", "label=7'00'' / 213cm");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		assertEquals("You must fix all errors first.", selenium.getAlert());
		selenium.click("id=myQuestionnaire_action_0");
		selenium.click("id=myQuestionnaire_action_0");
		selenium.click("id=myQuestionnaire_action_0");
		selenium.select("id=age_input", "label=50s");
		selenium.click("id=gender_input_female");
		assertTrue(selenium.isTextPresent("Your BMI is 19.9 and your Weight Type is normal. Also, your BMR is 1832.8"));
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.click("id=myQuestionnaire_action_1");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("You should consume 2199.0 calories per day because your exercise output is little"));
	}

}
