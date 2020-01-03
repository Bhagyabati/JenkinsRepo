package com.jenkinsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AmazonTest{

	static WebDriver driver;
	String expectedResult;

	@Test(dataProvider="getData")
	public void login(String username, String password) {
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		String expectedResult = "Hello, P";
		String actualResult = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/span[1]")).getText();
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@BeforeClass
	public static void test() {
		System.setProperty("webdriver.gecko.driver", "D://geckodriver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.get(
				"https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fie%3DUTF8%26tag%3Dabkexpt1-21%26ascsubtag%3D_k_EAIaIQobChMI473m0_vX5AIVjiQrCh3xPwOAEAAYASAAEgIQD_D_BwE_k_%26ext_vrnc%3Dhi%26gclid%3DEAIaIQobChMI473m0_vX5AIVjiQrCh3xPwOAEAAYASAAEgIQD_D_BwE%26ref_%3Dnav_signin&switch_account=");
	}
	@AfterClass	
	public static void close(){
		driver.close();
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[1][2];		
		data[0][0]="pbhagyavati1@gmail.com";
		data[0][1]="bhavani222";
		
		return data;
		
	}
}
