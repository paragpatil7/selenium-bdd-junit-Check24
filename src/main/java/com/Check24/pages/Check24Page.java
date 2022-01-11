package com.Check24.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class Check24Page {

    private WebDriver driver;
    private WebDriverWait wait;

  
    @FindBy(xpath="//div[@id='501020']//a[@class='button'][normalize-space()='weiter']")
    private WebElement FirstProductWeiter_button;

    @FindBy(xpath = "//input[@id='cl_login']")
    private WebElement EmailId_textbox;


    @FindBy(xpath = "//button[@id='c24-uli-register-btn']")
    private WebElement Weiter_Button;

  
    @FindBy(xpath = "//div[@class='c24-uli-cl-box-option style-scope unified-login' and text()='Ich möchte als Gast fortfahren']")
    private WebElement Reg_Radio;
    
    
    @FindBy(xpath = "//a[@target='_self']")
    private WebElement Reg_Weiter_Button;
    
    
    @FindBy(xpath = "//a[text()='Akzeptieren']")
    private WebElement cookies_accept;
    
    public Check24Page(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3000);
        PageFactory.initElements(driver, this);
    }

    public boolean goTo(){
    	try
    	{
        this.driver.get("https://finanzen.check24.de/accounts/d/kreditkarte/result.html");
        return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
        
    	
    }
    
    public boolean verifyCookieSetInHeaders()
    {
    	
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
           
    	for(Cookie ck : driver.manage().getCookies())							
        {			
              if(ck.getName().equals("ppset") && ck.getValue().equals("kreditkarte"))
              {
            	  return true;            	  
              }
              
              
        }			
    	return false;
    }
    
    public void  navigateToListedProductsAndSelectFirst()
    {
    	 this.wait.until(ExpectedConditions.visibilityOf(this.FirstProductWeiter_button));
         this.FirstProductWeiter_button.click();
    }
    public void EnterEmailAndClickWeiter(){
    	
       this.wait.until(ExpectedConditions.visibilityOf(this.EmailId_textbox));
       String EmailID=CreateEmailId(6);
       this.EmailId_textbox.sendKeys(EmailID);
       this.EmailId_textbox.sendKeys(Keys.ENTER);
        
    	
    }
    
    public String CreateEmailId(int len)
    {
    	String  text = "";
   	 String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   	   for (int i = 0; i < len; i++)
   	     text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
   	   return text+"@gmail.com";
    }

    public void ClickRegAndClickonWeiter() throws InterruptedException{
     
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,250)", "");
	
	  wait.until(ExpectedConditions.elementToBeClickable(Reg_Radio)).click();
	  wait.until(ExpectedConditions.elementToBeClickable(Weiter_Button)).click();
	
    }
    
    

	
}