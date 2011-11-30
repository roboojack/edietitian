package com.mycomism.edietitian.web.test;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

@RunWith(ConcurrentJunitRunner.class)
@Concurrent(threads = 20)
public class LoadTest extends TestBasicSetup {

	@Test
	public void simpleTestCase1() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase2() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}

	@Test
	public void simpleTestCase3() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase4() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	
	@Test
	public void simpleTestCase5() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase6() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase7() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}

	@Test
	public void simpleTestCase8() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase9() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}
	@Test
	public void simpleTestCase10() {
		for (int i = 0; i < 10; i++) {

			selenium.open("/edietitian-web/questionnaire.jsp?knowledgebase=edietitian&null");
			selenium.click("css=img[alt=edietitianHeaderImage -- Things to Think About]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Start eDietitian!");
			selenium.waitForPageToLoad("30000");
			selenium.select("height_input", "label=5' 5'' / 165cm");
			selenium.select("weight_input", "label=110lbs / 49.9kg");
			selenium.select("age_input", "label=20s");
			selenium.click("gender_input_female");
			selenium.click("myQuestionnaire_action_1");
			selenium.click("exercise_input_true");
			selenium.click("myQuestionnaire_action_1");
			selenium.select("exerciseDaysPerWeek_input", "label=1");
			selenium.select("exerciseMinutesPerSession_input", "label=1 hour");
			selenium.click("exerciseType_input_run");
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
			assertTrue(selenium.isTextPresent("30"));

		}
	}


}
