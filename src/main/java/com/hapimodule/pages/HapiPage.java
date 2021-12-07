package com.hapimodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class HapiPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//a[@id='leftResourcePatient']")
    private WebElement PatientLink;

    @FindBy(xpath = "//a[@id='crud-tab']")
    private WebElement CRUDtab;

    @FindBy(xpath = "//button[@id='read-btn']")
    private WebElement readButton;

    

    public HapiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public boolean goTo(){
    	try
    	{
        this.driver.get("http://localhost:8080/");
        return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
        
    	
    }
    
    public void goToPatientPage(){
        this.wait.until(ExpectedConditions.visibilityOf(this.PatientLink));
        this.PatientLink.click();
    }

    public void clickCRUDtab(){
        this.wait.until(ExpectedConditions.visibilityOf(this.CRUDtab));
        this.CRUDtab.click();
    }
    
    public void clickReadbutton(){
        this.wait.until(ExpectedConditions.visibilityOf(this.readButton));
        this.readButton.click();
    }

      

    public boolean getResult(){
        By by = By.xpath("//strong[normalize-space()='Warning!']");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        By errorText = By.xpath("//p[normalize-space()='No ID specified']");
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(errorText));
        
        String pagesource=this.driver.getPageSource();
		if(pagesource.contains("Warning!") && pagesource.contains("No ID specified"))
		{
			return true;		
		}
		else
		{
			return false;
		}
        
    }

}