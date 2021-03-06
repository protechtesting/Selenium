package com.pps.wordpress.paytm.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *This file will validate Store Category page and its functionality.
 *Test Data needs to be created before running the scripts.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-2">Raise JIRA Issue Here</a>
 */
public class StoreCategoryPageTests extends TestSetUp{
	
	
	/**
	 * <p><strong>Verify Default componenets of Store Category Page</strong><dd> 
     * Log In /Sign Up(Link))<dd>
	 * How it Works(Link)<dd>
     * Search Retailer or Coupons(Input box)<dd>
     * Contact Us
     * Breadcrump
	 * <p>PreCondition: User must be guest
	 */
	@Test(priority=1)
	public void VerifyDefaultComponentsofStoreCategoryPage()
	{
		try {
			reportStep("verification of Default components in home page started", "INFO");
			Log.info("verification of Default components in home page started started");
			
			String shortDescription=Utils.getTestData(9, "shortDescriptionSortByNewest");
			String category=Utils.getTestData(2, "category");
			Log.info("verification of Default components in home page started");
			reportStep("verification of Default components in home page started", "INFO");
			
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			verifyStorecategoryheaderFieldsPresent();
			
			
			Log.info("verification of Default components in store category page Completed");
			reportStep("verification of Default components in store page Completed", "PASS");
		}catch(Exception e) {
			Log.info("verification of Default components in store category page Completed");
			reportStep("verification of Default components in store category page Completed", "FAIL");
		}	

		
		
	}
	
	
	/**
	 * This method will validate Sort By Newest Functionality
	 */
	@Test(priority=4,enabled=true)
	public void verifySortByNewestFunctionality() {
		String start="Validation of Ato Z Sorting functionality --- started";
		String completed="Validation of Ato Z Sorting functionality --- completed";
		String shortDescription=Utils.getTestData(9, "shortDescriptionSortByNewest");
		String category=Utils.getTestData(2, "category");
		Log.info(start);
		reportStep(start, "INFO");
		try {
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickOnNewestLink().
			verifytextOfFirstShortDescriptionSortBy(shortDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will validate Sort By A-Z Functionality
	 */
	@Test(priority=2,enabled=true)
	public void verifySortByAtoZFunctionality() throws Exception {
		String start="Validation of Ato Z Sorting functionality --- started";
		String completed="Validation of Ato Z Sorting functionality --- completed";
		String category=Utils.getTestData(2, "category");
		Log.info(start);
		reportStep(start, "INFO");
		try {
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickOnAtoZLink().
			verifyStoreCardsAreSorted();
		} catch (Exception e) {
			throw e;
		}
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	@Test(priority=3,enabled=true)
	public void verifySortByPercentFunctionality() throws Exception {
		String start="Validation of Sorting By Percent in Store Category Page functionality --- started";
		String completed="Validation of Sorting By Percent in Store Category Page functionality  --- completed";
		String shortDescription=Utils.getTestData(9, "shortDescriptionSortByPercent");
		String category=Utils.getTestData(2, "category");
		Log.info(start);
		reportStep(start, "INFO");
		try {
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickOnAtoZLink().
			verifytextOfFirstShortDescriptionSortBy(shortDescription);
		} catch (Exception e) {
			throw e;
		}
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * 
	 * @throws Exception
	 * This method will validate Sort By Amount Functionality in Store Category Page
	 */
	@Test(priority=3,enabled=true)
	public void verifySortByAmountFunctionality() throws Exception {
		String start="Validation of Sorting By Amount functionality in Store category Page --- started";
		String completed="Validation of Sorting By Amount functionality in Store category Page --- completed";
		String shortDescription=Utils.getTestData(9, "shortDescriptionSortByAmount");
		String category=Utils.getTestData(2, "category");
		Log.info(start);
		reportStep(start, "INFO");
		try {
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).
			clickOnAtoZLink().
			verifytextOfFirstShortDescriptionSortBy(shortDescription);
		} catch (Exception e) {
			throw e;
		}
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * @throws Exception
	 * 
	 * This method will validate Sort By Popularity Functionality in Store Category Page
	 */
	@Test(priority=1,enabled=true)
	public void verifySortByPopularityFunctionality() throws Exception {
		String start="Validation of Sorting By Popularity functionality in Store category Page --- started";
		String completed="Validation of Sorting By Popularity functionality in Store category Page --- completed";
		String shortDescription=Utils.getTestData(9, "shortDescriptionSortByPopularity");
		String category=Utils.getTestData(2, "category");
		Log.info(start);
		reportStep(start, "INFO");
		try {
			new WPHomePage(driver, logger).
			clickHambergerMenu().
			clickMainCategory(category).clickOnPopularityLink().			
			verifytextOfFirstShortDescriptionSortBy(shortDescription);
		} catch (Exception e) {
			throw e;
		}
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify pagination functionality in Store Category Page.
	 * Precondition : For a particular category , number of store should be around 60.
	 */
	@Test(priority=5,enabled=true)
	public void verifyPaginationFunctionalityInStoreCategoryPage() {
		String start="Validation of Pagination Functionality in Store category Page --- started";
		String completed="Validation of Sorting By  Pagination Functionality in Store category Page --- completed";
		String category=Utils.getTestData(2, "category2");
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickHambergerMenu().
		clickMainCategory(category).
		verifyPaginationFunctionalityInStoreCategoryPage();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	
	
	
	/**
	 * This method will verify the top store functionality in Store Category Page.
	 * Precondition : For a particular category , number of store should be around 60.
	 */
	@Test(priority=5,enabled=true)
	public void verifyTopStorefunctionality() {
		String start="Validation of Pagination Functionality in Store category Page --- started";
		String completed="Validation of Sorting By  Pagination Functionality in Store category Page --- completed";
		String category=Utils.getTestData(2, "category2");
		Log.info(start);
		reportStep(start, "INFO");
		new WPHomePage(driver, logger).
		clickHambergerMenu().
		clickMainCategory(category).
		verifyPaginationFunctionalityInStoreCategoryPage();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
}
