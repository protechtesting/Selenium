package com.pps.wordpress.icici.testcases;

import org.testng.annotations.Test;

import com.pps.wordpress.pages.WPHomePage;
import com.pps.wordpress.pages.WPPaymentPage;

import utility.Log;
import utility.TestSetUp;
import utility.Utils;

/**
 * 
 * @author QA - Rahul Tiwari
 *
 *This Test Case will verify proper redirection to Payment Form when a user clicks on "REQUEST CASHBACK PAYMENT" or
 *when user clicks on "REQUEST REWARDS PAYMENT" button in Payment link of Left Navigation Panel.
 *Also this will verify various pop up message which will appear on clicking this two buttons.
 * <p>
 * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-15">Raise JIRA Issue Here</a>
 */


public class WP_VerifyRedirectionTOCashBackInPaymentsLeftNav extends TestSetUp{
	/**
	 * This method will verify Successful Navigation to Payment Form 
	 * for a New User by clicking  Request Cash back Payment button.
	 * Precondition:Cashback equals to or greater than Threshold.
     * <p>
     * {@link} <a href="https://pouringpounds.atlassian.net/jira/software/projects/PTA/boards/20/backlog?selectedIssue=PTA-9">Raise JIRA Issue Here</a>
	 */
	@Test(priority=1,enabled=true)
	public void verifyNewUserWillBeAbleToNavigateToPaymentFormByClickingCashbackButton() {
		String start="Validation of navigation from Payment Page to Payment Form by clicking Request cash back Payment button for New User.---- STARTED";
		String completed="Validation of navigation from Payment Page to Payment Form by clicking Request cash back Payment button for New User.---- COMPLETED";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify that an already registered user who has requested many times previously will also be 
	 * navigated to Payment form by clicking  Request Cash Back Payment button in Payment Form.
	 * Cash back amount should be greater than threshold amount.
	 * Precondition : 
	 */

	@Test(priority=2,enabled=true)
	public void verifyExistingUserWillBeNavigatedToPaymentFormByClickingRequestCashBackPaymentInPaymentPage() {
		String start="Validation of navigation from Payment Page to Payment Form by clicking Request cash back Payment button for Existing User.---- STARTED";
		String completed="Validation of navigation from Payment Page to Payment Form by clicking Request cash back Payment button for Existing User.---- COMPLETED";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType="Cashback";
		
		String refno = Utils.getTestData(10, "ExistingFEDID");
		String email="CK"+refno+"@pouringpounds.com";
		reportStep("Verification of Successful Login started", "PASS");
		Utils.clearCashbackRewards(driver, email); 
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify Navigation to Payment Page for a new user from Payment Page Left Navigation
	 * by clicking Request Cash back Payment button.
	 * Precondition : User should have Rs 300 as cashback and Rs 300 as Rewards
	 */
	@Test(priority=8,enabled=true)
	public void verifySuccessfulNavigationToPaymentFormByClickingRequestCashBackPaymentForNewUser() {
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New User .---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String email=Utils.generateRandomEmailId();
		
		String refno=Utils.generateRandomMobileNumber();
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyChoosePaymentMethodIsVisible();
		Log.info("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request cash back Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify Successful Payment processing 
	 * for a New User using Rewards Payment Processing method.
	 * Precondition : Rewards=>250
	 */
	@Test(priority=11,enabled=true)
	public void verifySuccessfulNavigationToPaymentFormViaPaymentPageByClickingRequestRewardPaymentForNewUser() {
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New User.---- Started");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New User .---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestRewardsPaymentButton().
		verifyChoosePaymentMethodIsVisible();
		Log.info("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED");
		reportStep("Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user will not be able to Navigate to Payment Form and see pop up error if he has cash back less
	 * than Threshold limit. Set Threshold= 250 & Cash back amount =249
	 * Precondition : User should have Rs 249 Confirm Cashback. Threashhold limit should be Rs 250. User  Clicks Request Cashback Payment
	 */
	@Test(priority=4,enabled=true)
	public void verifyUserIsUnableToProcessCashbackIfCashBackIsLessThanThresholdLimit() {
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for  Request Cash Back Payment via Payment Page.>---- Started");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- Started", "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED");
		reportStep("Validation of Presence of Message \"PAYMENT THRESHOLD NOT REACHED\" for Cash Back>---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify new user is will not be able to navigate to Payment Form and sees "PAYMENT THRESHOLD NOT REACHED" pop up error message
	 * when Rewards Payment Request If he has Rewards  less than Threshold limit. 
	 * Set Threshold= 250 & Rewards amount =249
	 * Precondition : 
	 */
	@Test(priority=15,enabled=true)
	public void verifyUserIsUnableToProcessRewardsIfRewardsIsLessThanThresholdLimit() {
		String started="Validation of Presence of Pop Up Message \"PAYMENT THRESHOLD NOT REACHED\" for REQUEST Rewards BUTTON---- Started";
		String completed="Validation of Presence of Pop Up Message \"PAYMENT THRESHOLD NOT REACHED\" for REQUEST Rewards BUTTON---- COMPLETED";
		Log.info(started);
		reportStep(started, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickManageCashback().
		clickPaymentsMenuOnHomePage().
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify successful payment processing for combined cash back and rewards scenario.
	 * User Clicks Request Cash back button.
	 * Both Cash back and Rewards Rewards Amount should be greater than threshold limit for a new user.
	 * Payment Processing Type should be Rewards.
	 * Precondition : Rewards+Cashback=>Threshold. User Clicks Request Reward
	 */
	@Test(priority=15,enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestRewardsPaymentInPaymentPageAndCombineRewardsPlusCashBackLinkBothValueGreater() {
		String completed="Validation of successful payment processing by clicking Request Rewards Payment button for New user.---- COMPLETED";
		String started="Validation of successful payment processing by clicking Request Rewards Payment button for New User.---- Started";
		Log.info(started);
		reportStep(started, "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards4().
		clickCombineRewardsPlusCashBackLink().	
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify successful Navigation to Payment From via Payment Page by clicking
	 * for combined cash back and rewards scenario.
	 * Cash back + Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button in Payment Page.
	 * User clicks on Combined Cash back + Rewards
	 * Precondition : Rewards+Cashback=>Threshold. User Clicks Request Reward
	 */
	@Test(priority=16,enabled=true)
	public void verifySuccessfulCombinedCashbackRewardsByClickingRequestCashbackPaymentInPaymentPageAndCombineRewardsPlusCashBackLinkCombineValueGreater() {
		String started="Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- Started";
		String completed="Validation of successful Combine Rewards + Cashback Scenario By Clicking Request Cashback Payment And Combine Rewards+Cashback Button---- COMPLETED";
		Log.info(started);
		reportStep(started, "INFO");
		String amount1=Utils.getTestData(6, "combineCashbackAmount1");
		String amount2=Utils.getTestData(6, "combineCashbackAmount2");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount1, email, cashBackType).
		addCashbackRewards(amount2, email, cashBackTypeRewards).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards3().
		clickCombineRewardsPlusCashBackLink().
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify successful navigation to Payment Form via Payment Page by clicking
	 * combined cash back and rewards Button.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Rewards button.
	 * Payment Processing Type should be Rewards.
	 * Precondition : Rewards=>250 Cashback=>250
	 */
	@Test(priority=14,enabled=true)
	public void verifySuccessfulNavigationToPaymentFormViaPaymentPageByClickingCombinedCashbackRewardsAndRequestRewardsWhenBothPaymentTypeGreaterThanThreshold() {
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- Started", "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestRewardsPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards().
		clickCombineRewardsPlusCashBackLink().
		verifyChoosePaymentMethodIsVisible();
		Log.info("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED");
		reportStep("Validation of successful Combine Rewards + Cashback Scenario When Cashback & Rewards both Are Greater than Threshold---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify successful payment processing for Only Redeem Cash back Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.
	 * Precondition : Rewards=>250 Cashback=>250
	 */
	@Test(priority=17,enabled=true)
	public void verifySuccessfulNavigationToPaymentFormByClickingOnlyRedeemCashbackEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		String started="Validation of successful  payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold in Payment Page.-- Started";
		String completed="Validation of successful  payment processing for Only Redeem Cash back Earnings scenario When Cashback & Rewards both Are Greater than Threshold in Payment Page.-- COMPLETED";
		Log.info(started);
		reportStep(started, "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().		
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards5().
		clickOnlyRedeemCashBackEarningsLink().
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}

	/**
	 * This method will verify successful navigation to Payment Form  for Only Redeem Rewards Earnings scenario.
	 * Both Cash back and Rewards Amount should be greater than threshold limit for a new user.
	 * User Clicks Request Cash back button and Only Redeem Cash back Earnings.
	 * Payment Processing Type should be Cash back.
	 * Precondition : Rewards=>250 Cashback=>250
	 */
	@Test(priority=12,enabled=true)
	public void verifyNavigationToPaymentFormByClickingOnlyRedeemRewardsEarningsWhenBothPaymentTypeGreaterThanThreshold() {
		String started="Validation of successful successful navigation to Payment Form for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- Started";
		String completed="Validation of successful successful navigation to Payment Form for Only Redeem Rewards Earnings scenario When Cashback & Rewards both Are Greater than Threshold.---- COMPLETED";
		Log.info(started);
		reportStep(started, "INFO");
		String amount=Utils.getTestData(6, "moreThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String cashBackTypeRewards=Utils.getTestData(6, "RewardsType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		addCashbackRewards(amount, email, cashBackTypeRewards).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		verifyPresenceMessageToCombineCashBackAndRewards1().
		clickOnlyRedeemRewardsEarningsLink().
		verifyChoosePaymentMethodIsVisible();
		Log.info(completed);
		reportStep(completed, "PASS");
	}
	

	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click "REQUEST CASHBACK PAYMENT" Link in Payment Page.
	 * After one request is made. User clicks on Payment Form Left Navigation to see the pop up
	 * error.
	 * Precondition : A cashback Payment request is still pending
	 */

	@Test(priority=6,enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnRequestCashbackPaymentInPaymentPage() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String accountHolderName=Utils.getTestData(6, "accountHolderName");
		String ifscCode=Utils.getTestData(6, "ifscCode");
		String bankAccountNumber=Utils.getTestData(6, "bankAccountNumber");
		String bankBranchName=Utils.getTestData(6, "bankBranchName");
		String bankName=Utils.getTestData(6, "bankName");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestCashbackPaymentButton().
		enterNameOfAccountHolder(accountHolderName).
		enterBankName(bankName).
		enterBankBranchName(bankBranchName).
		enterBankIfscCode(ifscCode).
		enterBankAccountNumber(bankAccountNumber).
		clickGetPaidButton();
		otp=Utils.getOTPCode(refno, driver);
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickPaymentLinkLeftNavigationPanel().
		verifyPresenceMessagePaymentRequestAlreadyPending();
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST CASHBACK PAYMENT---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify presence of error message "A payment request from you is already Pending. 
	 * This will be processed shortly. Once this is paid, you can request for another payment."
	 * User Logins and click "REQUEST REWARDS PAYMENT" Link in Payment Page.
	 * Precondition : A cashback Payment request is still pending
	 */
	@Test(priority=5,enabled=true)
	public void verifyPaymentRequestAlreadyPendingMessageByClickingOnRequestRewardsPaymentInPaymentPage() {
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- Started", "INFO");
		String amount=Utils.getTestData(6, "thresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String otp="";
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		clickRequestRewardsPaymentButton().
		enterEmailAddress(email).
		clickGetPaidButton();
		otp=Utils.getOTPCode(refno, driver);
		new WPPaymentPage(driver, logger).
		enterOTP(otp).
		clickVerifyOTPButton().
		clickClosePopUpIcon().
		addCashbackRewards(amount, email, cashBackType).
		clickPaymentLinkLeftNavigationPanel().
		verifyPresenceMessagePaymentRequestAlreadyPending();
		Log.info("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED");
		reportStep("Validation of Payment Request is Already Pending By clicking on REQUEST REWARDS PAYMENT---- COMPLETED", "PASS");
	}

	/**
	 * This method will verify error message pop up when a new user clicks on payment Link on Home Page.
	 * Rewards + Cash back less than Threshold. 
	 * Precondition : User should Sign Up freshly
	 */
	@Test(priority=9,enabled=true)
	public void verifyUserWillReceivePopUpErrorWhenTryingToNavigateToPaymentPageLeftNavLessThanThreshold() {
		String start="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Payment Menu in Home Page ---- Started";
		String completed="Validation of Pop Up Error Message PAYMENT THRESHOLD NOT REACHED By Payment Menu in Home Page ---- completed";
		Log.info(start);
		reportStep(start, "INFO");
		String amount=Utils.getTestData(6, "lessThanThresholdAmount");
		String cashBackType=Utils.getTestData(6, "cashBackType");
		String refno=Utils.generateRandomMobileNumber();
		String email="CK"+refno+"@pouringpounds.com";
		new WPHomePage(driver, logger).clickOnProceedButton()
		.clickManageCashback()
		.enterReference(refno)
		.refreshHomePage(driver)
		.verifypartner1loggedin().
		addCashbackRewards(amount, email, cashBackType).
		clickMyAccountLabel().
		clickPaymentsMenuOnHomePage().
		verifyPresenceMessageThresholdNotReached().
		verifyPresenceMessageUnableToProcessRequest();
		Log.info(completed);
		reportStep(completed, "PASS");

	}

}
