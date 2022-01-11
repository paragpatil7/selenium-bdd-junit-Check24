package com.test.stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import org.junit.Assert;

import static io.restassured.RestAssured.given;


import com.Check24.pages.Check24Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Check24API{

    
   
    static ExtentTest test;
    static ExtentReports report;
    

       
    
    @Given("I hit the rest GET API service with ID as {string}")
    public void i_hit_the_rest_get_api_service_with_id_as(String ID) {
        
    	String url="https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/"+ID;
    	Response res=given().get(url);
    	int statusCode=res.getStatusCode();
    	writeStatus(statusCode,ID);
  	   	Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/);
    }
  
    public static void writeStatus(int statusCode,String ID)
    {
    	if(statusCode==200)
    	{
    		test.log(LogStatus.PASS, "for ID "+ID+" got response code as "+statusCode);
    	}
    	else
    	{
    	test.log(LogStatus.FAIL, "for ID "+ID+" got response code as "+statusCode);
    	}
    }
    

    @Before("@API_TEST_Only")
    public void setupDriver()  {
       	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResultsAPI.html");
    	test = report.startTest("Check24API Automation");
    	
       }

    @After("@API_TEST_Only")
    public void quitDriver(){
    	report.endTest(test);
    	report.flush();
       
    }

}
