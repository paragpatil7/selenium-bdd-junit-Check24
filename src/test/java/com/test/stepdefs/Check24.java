package com.test.stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import org.junit.Assert;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.Check24.pages.Check24Page;
import com.Check24.pages.RegPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Check24{

    private Check24Page check24Page;
    private RegPage RegPage;
    private WebDriver driver;
    static ExtentTest test;
    static ExtentReports report; 
    

    @Given("^I am on the check24 credit card web Page$")
    public void launchSite() {
    	check24Page = new Check24Page(driver);
    	RegPage= new RegPage(driver);
    	boolean WinStatus=check24Page.goTo();
    	
    	if(WinStatus)
    	{
    		
    		test.log(LogStatus.PASS, "check24 credit card web Page displyed correctly");
    	}
    	else
    	{
    		
    	test.log(LogStatus.FAIL, "Not able to open check24 credit card web Page : Please re-start application and run automation again.");
    	
    	}
    	Assert.assertTrue(WinStatus);
    }
    
    
    @Then("^I Verify that cookie is set in headers$")
    public void verifyCookieSetInHeaders() {
    	//add code here 
    	boolean CookieStatus=check24Page.verifyCookieSetInHeaders();
    	if(CookieStatus)
    	{
    		
    		test.log(LogStatus.PASS, "Cookie displyed correctly");
    	}
    	else
    	{
    		
    	test.log(LogStatus.FAIL, "Cookie not displyed correctly");
    	
    	}
    	Assert.assertTrue(CookieStatus);
    }
    
    @And("^I click on the weiter button on the first of the listed products$")
    public void navigateToListedProductsAndSelectFirst()  {
    	check24Page.navigateToListedProductsAndSelectFirst();
    	
    }
    

    @And("^I Enter the email id and click on weiter button$")
    public void EnterEmailAndClickWeiter() {
    	check24Page.EnterEmailAndClickWeiter();
    }

    
    @And("^I click on radio button and click on weiter button$")
    public void ClickRegAndClickonWeiter() throws InterruptedException {
    	check24Page.ClickRegAndClickonWeiter();
    }

    
    @Then("^I Verify that for all blank field proper error message is displayed$")
    public void verifyErrorMessageDisplayed() throws InterruptedException {
    	
    	boolean VerifyStatus =	RegPage.verifyErrorMessageDisplayed();
     	
    	if(VerifyStatus)
    	{
    		test.log(LogStatus.PASS, "All the Error Message are Correct");
    	}
    	else
    	{
    		test.log(LogStatus.FAIL, "Error Message are not Coorect: check logs for details");
    	}
    	Assert.assertTrue(VerifyStatus);
    }
    
    
    @And("^I fill in all fields with valid values and click on weiter button$")
    public void EnterValidValuesinRgAndClickonWeiter() {
    	RegPage.EnterValidValuesinRgAndClickonWeiter();
    }

    
    
    @Then("^I Verify that page move to next page with out any error$")
    public void verifyPageMovetoNextPage() {
    	boolean result = RegPage.getResult();
    	if(result)
    	{
    		test.log(LogStatus.PASS, "Entered all valid deatils and page move to next page successfully ");
    	}
    	else
    	{
    	test.log(LogStatus.FAIL, "Page Not move to next page");
    	}
    	Assert.assertTrue(result);
    }

    @Before("@UI_Only")
    public void setupDriver() throws MalformedURLException {
       
    	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
    	test = report.startTest("Check24 Automation");
    	   	
    	//driver=new ChromeDriver();
    	driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 
       }

    @After("@UI_Only")
    public void quitDriver(){
    	report.endTest(test);
    	report.flush();
       this.driver.quit();
    }

}