package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerPageObjects {

	public WebDriver driver;
	 
	 private By FirstName = By.xpath("//input[@name='firstname']");
	 private By LastName = By.xpath("//input[@name='lastname']");
	 private By Email = By.xpath("//input[@name='email']");
	 private By Telephone = By.xpath("//input[@name='telephone']");
	 private By Password = By.xpath("//input[@name='password']");
	 private By ConfirmPassword = By.xpath("//input[@name='confirm']");
	 private By Checkbox = By.xpath("//input[@name='agree']");
	 private By ContinueButton = By.xpath("//input[@value='Continue']");
	 private By RegisteredSucceessfully = By.xpath("//h1[text()='Your Account Has Been Created!']");
	 
	 private By RegistrationFirstNameErrorMessage = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
	 private By RegistrationLastNameErrorMessage = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']");
	 private By RegistrationEmailErrorMessage = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
	 private By RegistrationTelephoneErrorMessage = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']");
	 private By RegistrationPasswordErrorMessage = By.xpath("//div[text()='Password must be between 4 and 20 characters!']");
	 private By RegistrationCheckBoxErrorMessage = By.xpath("//div[text()=' Warning: You must agree to the Privacy Policy!']");
	 
	 
	 
	 public registerPageObjects(WebDriver driver) {
	  this.driver=driver;
	 }

	 public WebElement EnterFirstName() {
	  return driver.findElement(FirstName);
	  
	 }
	 
	 public WebElement EnterLastName() {
	  return driver.findElement(LastName);
	 }
	 
	 public WebElement EnterEmail() {
	  return driver.findElement(Email);
	 
	 }
	 
	 public WebElement EnterTelephone() {
	  return driver.findElement(Telephone);
	 }
	 
	 public WebElement EnterPassword() {
	  return driver.findElement(Password);
	 }
	 public WebElement EnterConfirmPassword() {
	  return driver.findElement(ConfirmPassword);
	 }
	 public WebElement CheckCheckbox() {
	  return driver.findElement(Checkbox);
	 }
	 public WebElement ClickContinue() {
	  return driver.findElement(ContinueButton);
	 }
	 
	 public WebElement RegisteredSuccessfullyMessage() {
	  return driver.findElement(RegisteredSucceessfully);
	 }
	 
	 public WebElement FirstNameErrorMessage() {
	  return driver.findElement(RegistrationFirstNameErrorMessage);
	 }
	 
	 public WebElement LastNameErrorMessage() {
	  return driver.findElement(RegistrationLastNameErrorMessage);
	 }
	 
	 public WebElement EmailErrorMessage() {
	  return driver.findElement(RegistrationEmailErrorMessage);
	 }
	 
	 public WebElement TelePhoneErrorMessage() {
	  return driver.findElement(RegistrationTelephoneErrorMessage);
	 }
	 
	 public WebElement PasswordErrorMessage() {
	  return driver.findElement(RegistrationPasswordErrorMessage);
	 }
	 
	 public WebElement CheckBoxErrorMessage() {
	  return driver.findElement(RegistrationCheckBoxErrorMessage);
	 }
	 

}
