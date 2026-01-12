package org.testcases;

import java.io.IOException;

import org.baseclasses.BaseMethods;
import org.junit.*;

public class Facebook extends BaseMethods {
	static BaseMethods baseMethods;
	
	@BeforeClass
	static public void init() {
		baseMethods = new BaseMethods();
		baseMethods.launchBrowser("chrome");
	}
	
	@Before
	public void loadFacebook() {
		baseMethods.getUrl("https://www.facebook.com/");
	}
	
	@After
	public void takeSnap() throws IOException {
		baseMethods.takeScreenshot();
	}
	
	@AfterClass
	static public void teardown() {
		baseMethods.quitDriver();
	}
	
	@Test
	public void validateFacebookLogin() {
		baseMethods.passValueInTextBox(baseMethods.findElement("id","email"), "wleknfgp");
		baseMethods.passValueInTextBox(baseMethods.findElement("id","pass"), "weingpwin");
		baseMethods.clickButton(baseMethods.findElement("xpath", "//button[@data-testid='royal-login-button']"));
	}
	
	@Test
	public void validateNewAccount() throws InterruptedException {
		baseMethods.clickButton(baseMethods.findElement("xpath", "//a[@data-testid='open-registration-form-button']"));
		baseMethods.passValueInTextBox(baseMethods.findElement("xpath", "//input[@name='firstname']"), "kfnpqf");
		baseMethods.passValueInTextBox(baseMethods.findElement("xpath", "//input[@name='lastname']"), "wefwb");
		baseMethods.dropdownSelect(baseMethods.findElement("id", "day"), "index", "1");
		baseMethods.dropdownSelect(baseMethods.findElement("id", "month"), "value", "8");
		baseMethods.dropdownSelect(baseMethods.findElement("id", "year"), "text", "1997");
		baseMethods.clickButton(baseMethods.findElement("xpath", "//input[@value='2']"));
		baseMethods.passValueInTextBox(baseMethods.findElement("xpath", "//input[@name='reg_email__']"), "qngpwien");
		baseMethods.passValueInTextBox(baseMethods.findElement("id", "password_step_input"), "agewg");
		baseMethods.clickButton(baseMethods.findElement("xpath", "//button[@name='websubmit']"));
		Thread.sleep(2000);
	}
	
}
