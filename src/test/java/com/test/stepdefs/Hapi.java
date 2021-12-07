package com.test.stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.hapimodule.pages.HapiPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import org.junit.Assert;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Hapi{

    private HapiPage hapiPage;
    private WebDriver driver;
    static ExtentTest test;
    static ExtentReports report;
    

    @Given("^I am on the website HAPI web Page$")
    public void launchSite() {
    	hapiPage = new HapiPage(driver);
    	boolean WinStatus=hapiPage.goTo();
    	
    	if(WinStatus)
    	{
    		
    		test.log(LogStatus.PASS, "website HAPI web Page displyed correctly");
    	}
    	else
    	{
    		
    	test.log(LogStatus.FAIL, "Not able to open HAPI Home Page : Please re-start application and run automation again.");
    	
    	}
    	Assert.assertTrue(WinStatus);
    }
    
    @And("^I navigate to Patient Page$")
    public void navigateToPatientPage()  {
    	hapiPage.goToPatientPage();
    }

    @And("^I click on CRUD Operations tab$")
    public void ClickCRUDTab() {
    	hapiPage.clickCRUDtab();
    }

    
    @And("^I click the Read button without filling in an ID$")
    public void ClickReadButton() {
    	hapiPage.clickReadbutton();
    }

    
    @Then("^I Verify that correct error message is displyed on the page$")
    public void verifyErrorPageResults() {
    	boolean result = hapiPage.getResult();
    	if(result)
    	{
    		test.log(LogStatus.PASS, "correct error message is displyed on the page");
    	}
    	else
    	{
    	test.log(LogStatus.FAIL, "correct error message is not displyed on the page");
    	}
    	Assert.assertTrue(result);
    }

    @Before
    public void setupDriver() throws MalformedURLException {
        // BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
    	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
    	test = report.startTest("hapiPage");
    	
    	
    	driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 
    	
    	/*
    	String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        
        
    //    */
    }

    @After
    public void quitDriver(){
    	report.endTest(test);
    	report.flush();
        this.driver.quit();
    }

}