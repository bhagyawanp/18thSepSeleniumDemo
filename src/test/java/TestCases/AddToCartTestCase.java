package TestCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddToCartTestCase {

	@Test
	public void verifyCartAmount() {

		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?");

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String iphoneCost = driver.findElement(By.xpath("//p[@class='price']")).getText();
		System.out.println(iphoneCost);

		String[] iphoneArray = iphoneCost.split(" ");
		System.out.println(Arrays.toString(iphoneArray));
		String iphonePrice = iphoneArray[0];
		System.out.println(iphonePrice);

		String finalIphonePrice = iphonePrice.replaceAll("[^\\d.]", "");
		;
		System.out.println(finalIphonePrice);

		double iphonePriceDouble = Double.parseDouble(finalIphonePrice);

		// add to cart --

		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();

		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("samsung");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

		String samsungCost = driver
				.findElement(By.xpath("(//h4//a[text()='Samsung Galaxy Tab 10.1']/following::p[@class='price'])"))
				.getText();
		System.out.println(samsungCost);

	}

}
