package com.Ecommerce.guru99;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Macys.base.Utils;

public class Flipkart extends Utils {

	static WebDriver driver;
	static Actions key;
	static WebDriverWait wait;

	@Test
	public static void launch_Browser() throws InterruptedException {
		System.setProperty(firefor_Browser, path);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(filpkart);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.name("q")).sendKeys("ipad" + Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));
		key=new Actions(driver);
		key.click(driver.findElement(By.name("q"))).build().perform();
		driver.findElement(By.xpath("//div[contains(text(),'64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey)')]"))
				.click();
		Set<String> setofWindows = driver.getWindowHandles();
		for (String window : setofWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains("64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey)"))
				break;
		}
		driver.navigate().refresh();
		wait=new WebDriverWait(driver,10);
		WebElement element = driver.findElement(By.xpath("//form/button"));
		key.click(element).perform();
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.titleContains("Flipkart.com: Secure Payment"));
		
		if(driver.getTitle().contains("Flipkart.com: Secure Payment"))
		driver.findElement(By.xpath("//div/input")).sendKeys("email or phone number");
		driver.findElement(By.tagName("button")).click();
//		driver.quit();
	}
}
