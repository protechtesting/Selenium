package com.pps.wordpress.icici.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPMyEarningsPage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

public class WP_VerifyDefaultContentOfMyEarningsPageAndPaymentForm extends TestSetUp{

	/**
	 * This method will validate "TOTAL CASHBACK EARNED" and "TOTAL REWARDS EARNED" link can be expanded and collapsed.
	 * Also it will verify label of "TOTAL CASHBACK EARNED" and "TOTAL REWARDS EARNED" link in the header section
	 * <p>
     * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-14">Raise JIRA Issue Here</a>
	 */
	@Test(priority=1,enabled=true)
	public void verifyTotalEarningsEarnedAndTotalCashbackEarnedCanbeExpandedAndCollapsed() {
		String start="Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Started";
		String completed="Validation of \"TOTAL CASHBACK EARNED\" and \"TOTAL REWARDS EARNED\" link of Header Section My Earning Page Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
		String refno =Utils.getTestData(10, "ExistingFEDID");
		
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		verifyTotalCashBackEarnedHeaderLinkIsExpanded().
		verifyTotalRewardsEarnedHeaderLinkIsExpanded().
		clickTotalCashBackEarnedHeaderLink().
		clickTotalRewardsEarnedHeaderLink().
		verifyTotalCashBackEarnedHeaderLinkIsCollapsed().
		verifyTotalRewardsEarnedHeaderLinkIsCollapsed().
		clickTotalCashBackEarnedHeaderLink().
		clickTotalRewardsEarnedHeaderLink().
		verifyTotalCashBackEarnedHeaderLinkIsExpanded().
		verifyTotalRewardsEarnedHeaderLinkIsExpanded();
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will validate default content on My Earnings Label for a registered user.
	 * It will include validation of Paid Cahback, Paid Rewards, Pending Cashback, Pending Rewards, Available for Payment Cashback, Available
	 * for Payment Rewards, Your Total Earnings, etc..
	 */
	@Test(priority=2,enabled=true)
	public void verifyDefaultConetentsOfMyEarningsLeftNavPage() {
		String start="Validation of default content of My Earning Page in left Navigation Page for existing user Started";
		String completed="Validation of default content of My Earning Page in left Navigation for existing user Page Completed";
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String RewardsType=Utils.getTestData(6, "RewardsType");
		String refno =Utils.getTestData(10, "ExistingFEDID");

		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(0,"ValidUserId");
		String password=Utils.getTestData(0,"ValidPassword");
		reportStep("Verification of Successful Login started", "PASS");
	    new WPHomePage(driver, logger).
		clickOnlblSignInSignUP()
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
			verifyPresenceOfPaidCashbackHeaderSection().
		verifyPresenceOfPaidRewardsHeaderSection().
		verifyPresenceOfPendingCashbackHeaderSection().
		verifyPresenceOfPendingRewardsHeaderSection().
		verifyPresenceOfAvailableForPaymentCashbackHeaderSection().
		verifyPresenceOfAvailableForPaymentRewardsHeaderSection().
		verifyPresenceOfTotalCashbackEarnings().
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackType).
		verifyPresenceOfCashbackShowMoreLink().
		verifyPresenceOfMissingCashbackLabel().
		clickTabRewardEarnings().
		verifyPresenceOfMissingRewardsLabel().
		addCashbackRewards(amount, email, RewardsType).
		addCashbackRewards(amount, email, RewardsType).
		addCashbackRewards(amount, email, RewardsType).
		addCashbackRewards(amount, email, RewardsType).
		addCashbackRewards(amount, email, RewardsType).
		addCashbackRewards(amount, email, RewardsType).
		verifyPresenceOfTotalRewardEarnings().
	
		verifyPresenceOfRewardShowMoreLink();
		
		
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will verify Show More Functionality by initially counting number of rows under Cashback Earning Tab then it will click Show More 
	 * Link under this tab and count number of rows. If Number of rows after clicking Show more is greater than initial count. Show more functionality 
	 * is working as expected.
	 * Preconditions: Atleast 6 to 7 request should be processed for the user so that Show More link is visible.
	 */
	@Test(priority=3,enabled=true)
	public void verifyShowMoreFunctionalityUnderCashBackEarnings() {
		String start="Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Started";
		String completed="Validation of Show More Functionality For both Cashback Earnings and Rewards Earnings Tab Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String email=Utils.getTestData(2,"ValidUserId");
	
		String refno =Utils.getTestData(10, "ExistingFEDID");
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderCashBackEarningTab().
		clickTabRewardEarnings().
		verifyNumberOfRowsIsGreaterAfterClickingShowMoreLinkUnderRewardsEarningTab();
		Log.info(completed);
		reportStep(completed,"INFO");
	}
	
	/**
	 * This method will verify list of Payment Method available in Payment Form for a new User.
	 * 
	 */
	@Test(priority=4,enabled=true)
	public void verifyListOfPaymentMethodAvailableInPaymentForm() {
		String start="Validation of List of Payment Method Option Avaiable in Payment Form Started";
		String completed="Validation of List of Payment Method Option Avaiable in Payment Form Completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String paymentOptions=Utils.getTestData(6, "paymentOptions");
		
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigateToPaymentForm().
		verifyAllPaymentOptionsAreAvailable(paymentOptions);
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	

	

	/**
	 * This method will verify default Components of Payment Form When New User request Cash back Payment.
	 */
	@Test(priority=6,enabled=true)
	public void verifyDefaultComponentsOfPaymentFormWhenNewUserRequestCashbackPayment() {
		String start="Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		
		String email=Utils.generateRandomEmailId();
		
		
		
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		clickRequestCashbackPaymentButtonToNavigate().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		//verifyPresenceOfRewardsAmountAvailableForPaymentLabel().
		verifyPresenceOfChoosePaymentMethodLabel().
		verifyDefaultSelectedPaymentMethod("Bank Payment (NEFT)").
		verifyPresenceOfEnterBankDetailsLabel().
		verifyPresenceOfNameOfBankAccountHolderLabel().
		verifyPresenceOfBankNameLabel().
		verifyPresenceOfCashbackAvailableForPaymentLabel().
		verifyPresenceOfBankAccountNumberLabel().
		verifyPresenceOfBankIfscCodeLabel().
		verifyPresenceOfBankBranchNameLabel().
		verifyPresenceOfSelectCharityToDonateCashbackLabel().
		verifyPresenceOfCashbackYouWishToDonateLabel().
		verifyPresenceOfCashbackAvailableAfterDonationLabel().
		verifyPresenceOfWouldYouDonateCashbackCharityLabel().
		verifyTextOfGetPaidButton().
		verifyPresenceOfAmountAvailableAfterDonation().
		verifyPresenceCharityAmountTextBox();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
	
	/**
	 * This method will validate Month and Year drop down.
	 */
	@Test(priority=7,enabled=true)
	public void verifyMonthDropDownInMyEarningsPage() {
		String start="Validation of presence of default component in Payment Form when a user requested Cashback payment Started";
		String completed="Validation of presence of default component in Payment Form when a user requested Cashback payment completed";
		Log.info(start);
		reportStep(start,"INFO");
		
		String refno =Utils.getTestData(10, "ExistingFEDID");
		String email="CK"+refno+"@pouringpounds.com";
		
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		verifyFirstSelectedValueInMonthYearDropDownList();
		Log.info(completed);
		reportStep(completed,"PASS");
		
	}
	
	/**
	 * This method will validate default content of Payments Page when both cashback and rewards are more than or equal to threshold.
	 * Cash Back= Rs 250 and Rewards = Rs 250
	 * Each time a new user will be created.
	 *   
	 */
	@Test(priority=8,enabled=true)
	public void verifyDefaultContentOfPaymentPageWhenCashBackEqualToThreshold() {
		String start="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user Started";
		String completed="Validation of Default Content Of Payment Page When Both Cash Back And Rewards Equal To Threshold for a new user completed";
		Log.info(start);
		reportStep(start,"INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String rewardsType=Utils.getTestData(6, "RewardsType");
		
		String email=Utils.generateRandomEmailId();
		String password=Utils.getTestData(1, "password");
		String refno=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger)
		.clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin()
		.clickManageCashback().
		clickMyEarningLink().
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, rewardsType)
		.navigateToHomePage().
		clickManageCashback().
		clickPaymentsMenuOnHomePage().
		verifyAmountAvailableForPaymentLabel().
		verifyEarningAvailableForPaymentLabel().
		verifyCashBackAndRewardsAmount250Each().
		verifyInfoAboutRequestPayment1().
		verifyInfoAboutRequestPayment2().
		clickHereLinkInPaymentPage().
		clickHereLinkCloseIconInPaymentPage().
		verifyInfoAboutRequestPayment3();
		Log.info(completed);
		reportStep(completed,"PASS");
	}
}
