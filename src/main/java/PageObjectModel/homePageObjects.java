package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObjects {

	public WebDriver driver; // null//This driver dont have any scope

	private By myAccount = By.xpath("//a[@title='My Account']");
	private By register = By.xpath("//a[text()='Register']");
	private By Login = By.xpath("//a[text()='Login']");

	// create constrcutor
	public homePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickOnMyAccount() {
		return driver.findElement(myAccount);

	}

	public WebElement clickOnMyResgister() {
		return driver.findElement(register);

	}

	public WebElement ClickOnLogin() {

		return driver.findElement(Login);

	}

}
