package org.baseclasses;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseMethods {
	
	WebDriver driver;
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("This method only supports chrome, edge and firefox browsers");
		}
	}
	
	public void getUrl(String url) {
		driver.get(url);
	}
	
	public WebElement findElement(String by,String locatorValue) {
		WebElement element = null;
		if (by.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		else if(by.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		return element;
	}
	
	public void passValueInTextBox(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	
	public void clickButton(WebElement ele) {
		ele.click();
	}
	
//	public void takeScreenshot() throws IOException {
//		String random = UUID.randomUUID().toString();
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File ss = ts.getScreenshotAs(OutputType.FILE);		
//		FileUtils.copyFile(ss,new File("C:\\Users\\Baskar A\\eclipse-workspace\\FrameworkGreens\\target\\"+random+".png"));
//	}
	
	public void takeScreenshot() throws IOException {
		String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_hhmmss"));
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(ss,new File("C:\\Users\\Baskar A\\eclipse-workspace\\FrameworkGreens\\target\\"+dateTime+".png"));
	}
	
	public void dropdownSelect(WebElement ele, String by, String data) {
		Select select = new Select(ele);
		if(by.equalsIgnoreCase("text")) {
			select.selectByVisibleText(data);
		}
		else if(by.equalsIgnoreCase("value")) {
			select.selectByValue(data);
		}
		else if(by.equalsIgnoreCase("index")) {
			int n = Integer.parseInt(data);
			select.selectByIndex(n);
		}
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
}
