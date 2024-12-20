package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjectModel.homePageObjects;
import PageObjectModel.registerPageObjects;
import Resources.baseClass;
import Resources.commonMethods;
import Resources.constants;

public class RegisterTestCases extends baseClass {
	
	@Test(dependsOnMethods={"VerifyRegistrationWithBlankData"})
	 public void VerifyRegistrationWithValidData() throws IOException {

	  homePageObjects hpo = new homePageObjects(driver);

	  hpo.clickOnMyAccount().click();
	  hpo.clickOnMyResgister().click();

	  registerPageObjects rpo = new registerPageObjects(driver);

	
	    commonMethods.handlExplictWait(driver, 10, rpo.EnterFirstName());
	  rpo.EnterFirstName().sendKeys(constants.FirstName); //10
	  rpo.EnterLastName().sendKeys(constants.LastName);
	  rpo.EnterEmail().sendKeys(EmailAddress);
	  
	  commonMethods.handlExplictWait(driver, 15, rpo.EnterTelephone());
	  rpo.EnterTelephone().sendKeys(constants.Telephone); //15
	  rpo.EnterPassword().sendKeys(constants.Password);
	  rpo.EnterConfirmPassword().sendKeys(constants.ConfirmPassword);
	  rpo.CheckCheckbox().click();
	  rpo.ClickContinue().click();

	  String ExpectedResult = constants.RegistrationExpectedResult;
	  String ActualResult = rpo.RegisteredSuccessfullyMessage().getText();
	  
	   commonMethods.handleAssertion(ActualResult, ExpectedResult);
	   
	 }
	 
	 @Test
	 public void VerifyRegistrationWithBlankData() {

	  homePageObjects hpo = new homePageObjects(driver);

	  hpo.clickOnMyAccount().click();
	  hpo.clickOnMyResgister().click();

	  registerPageObjects rpo = new registerPageObjects(driver);
	  
	  rpo.ClickContinue().click();
	  

	  String FirstNameExpectedResult = constants.FirstNameRegistrationErrorMessage;
	  String FirstNameActualResult = rpo.FirstNameErrorMessage().getText();
	  
	  commonMethods.handleAssertion(FirstNameActualResult, FirstNameExpectedResult);
	  
	  String LastNameExpectedResult = constants.LastNameRegistrationErrorMessage;
	  String LastNameActualResult = rpo.LastNameErrorMessage().getText();
	  
      commonMethods.handleAssertion(LastNameActualResult, LastNameExpectedResult);
      
	  String EmailExpectedResult = constants.EmailRegistrationErrorMessage;
	  String EmailActualResult = rpo.EmailErrorMessage().getText();
	  
      commonMethods.handleAssertion(EmailActualResult, EmailExpectedResult);	
      
	  String TelePhoneExpectedResult = constants.TelephoneRegistrationErrorMessage;
	  String TelePhoneActualResult = rpo.TelePhoneErrorMessage().getText();
	  
      commonMethods.handleAssertion(TelePhoneActualResult, TelePhoneExpectedResult);	
      
	  String PasswordExpectedResult = constants.PasswordRegistrationErrorMessage;
	  String PasswordActualResult = rpo.PasswordErrorMessage().getText();
	  
      commonMethods.handleAssertion(PasswordActualResult, PasswordExpectedResult);	
      
	  String CheckBoxExpectedResult = constants.CheckBoxRegistrationErrorMessage;
	  String CheckBoxActualResult = rpo.CheckBoxErrorMessage().getText();
	  
      commonMethods.handleAssertion(CheckBoxActualResult, CheckBoxExpectedResult);	
      //Added test case by trupti
	 }

}
