package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;
/**
 * 
 * @author QA - Rahul Tiwari
 * In this class, validation of How It Works Page functionality is covered.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-11">Raise JIRA Issue Here</a>
 */
public class HowItWorksPageTests extends TestSetUp{
	@Test(priority=1,enabled=true)
	public void verifyHowItWorksPageContainsData() {
		String start="Validation of How It Works Page ----- Started";
		String completed="Validation of How It Works Page ----- Completed.";
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickHowItWorksLink().verifyurl("how-it-works");
		
		Log.info(completed);
		reportStep(completed, "PASS");
	}
}
