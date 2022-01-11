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

public class RegPage {

    private WebDriver driver;
    private WebDriverWait wait;

   
    @FindBy(xpath = "//button[@id='c24-uli-register-btn']")
    private WebElement Weiter_Button;

  
       
    @FindBy(xpath = "//a[@target='_self']")
    private WebElement Reg_Weiter_Button;
    
    @FindBy(xpath = "//label[@class='styles__Message-sc-10pthkh-2 kfsKbY' and text()='Bitte wählen Sie Ihre Anrede aus.']")
    private WebElement salutation_erro_Txt;
    
    @FindBy(xpath = "//label[@class='styles__Message-sc-10pthkh-2 kfsKbY' and text()='Bitte geben Sie Ihren Vornamen an.']")
    private WebElement first_name_erro_Txt;
    
    @FindBy(xpath = "//label[@class='styles__Message-sc-10pthkh-2 kfsKbY' and text()='Bitte geben Sie Ihren Nachnamen an.']")
    private WebElement last_name_erro_Txt;
  
    @FindBy(xpath = "//label[@class='styles__Message-sc-10pthkh-2 kfsKbY' and text()='Bitte geben Sie Ihr Geburtsdatum an.']")
    private WebElement date_of_birth_erro_Txt;
    
    @FindBy(xpath = "//label[@class='styles__Message-sc-10pthkh-2 kfsKbY' and text()='Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.']")
    private WebElement mobile_erro_Txt;

    
  
    @FindBy(xpath = "//label[@for='GENDER_MALE']")
    private WebElement gender_Radio;
    
    @FindBy(xpath = "//input[@id='GIVEN_NAME']")
    private WebElement first_name_textBox;
    
    @FindBy(xpath = "//input[@id='LAST_NAME']")
    private WebElement last_name_textBox;
    
    @FindBy(xpath = "//input[@placeholder and @label]")
    private WebElement DOB_textBox;
    
    @FindBy(xpath = "//input[@id='PHONENUMBER_MOBILE']")
    private WebElement mobile_textBox;
    
    @FindBy(xpath = "//label[@for='PLACE_OF_BIRTH']")
    private WebElement nextpage_lable;
    
    public RegPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 3000);
        PageFactory.initElements(driver, this);
    }

    
    
    
    
    public String CreateTestData(int len)
    {
    	String  text = "";
   	 String possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   	   for (int i = 0; i < len; i++)
   	     text += possible.charAt((int) Math.floor(Math.random() * possible.length()));
   	   return text;
    }
    
    

       

	public boolean verifyErrorMessageDisplayed(){
       
		 wait.until(ExpectedConditions.elementToBeClickable(Reg_Weiter_Button)).click();
		 String PageSource=driver.getPageSource();
		 int count=0;
				 
		 HashMap<String, String> map1_expected = new HashMap<>();
		 HashMap<String, String> map2_actual = new HashMap<>();
	       
		 map1_expected.put("salutation", "Bitte wählen Sie Ihre Anrede aus.");
		 map1_expected.put("first_name", "Bitte geben Sie Ihren Vornamen an.");
		 map1_expected.put("last_name", "Bitte geben Sie Ihren Nachnamen an.");
		 map1_expected.put("date_of_birth", "Bitte geben Sie Ihr Geburtsdatum an.");
		 map1_expected.put("mobile", "Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.");
		 
		String salutation= this.salutation_erro_Txt.getText();
		map2_actual.put("salutation", salutation);
		 if(PageSource.contains(map1_expected.get("salutation")))
		 {
			 System.out.println("salutation error message are correct");
			 count++;
		 }
		
		 String first_name= this.first_name_erro_Txt.getText();
		 map2_actual.put("first_name", first_name);
		 if(PageSource.contains(map1_expected.get("first_name")))
		 {
			 System.out.println("first name error message is correct ");
			 count++;
		 }
		 
		 String last_name= this.last_name_erro_Txt.getText();
		 map2_actual.put("last_name", last_name);
		 if(PageSource.contains(map1_expected.get("last_name")))
		 {
			 System.out.println("last name error message is  correct");
			 count++;
		 }
		
		 String date_of_birth= this.date_of_birth_erro_Txt.getText();
		 map2_actual.put("date_of_birth", date_of_birth);
		 if(PageSource.contains(map1_expected.get("date_of_birth")))
		 {
			 System.out.println("date of birth error message is correct");
			 count++;
		 }
		 
		 String mobile= this.mobile_erro_Txt.getText();
		 map2_actual.put("mobile", mobile);
		 if(PageSource.contains(map1_expected.get("mobile")))
		 {
			 System.out.println("mobile error message is correct");
			 count++;
		 }
		 
		 if(map2_actual.equals(map1_expected) && (count==5) ) {
			 System.out.println("All Error message are correct");
			 return true;
		 }
		 else
		 {
			 System.out.println("Error message are not correct");
			 return false;
		 }
		 
		 
		 
		 
		 
    }

      

	public void EnterValidValuesinRgAndClickonWeiter()
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(gender_Radio)).click();
		wait.until(ExpectedConditions.elementToBeClickable(first_name_textBox)).sendKeys(CreateTestData(5));
		wait.until(ExpectedConditions.elementToBeClickable(last_name_textBox)).sendKeys(CreateTestData(5));
		wait.until(ExpectedConditions.elementToBeClickable(DOB_textBox)).sendKeys("10111985");
		wait.until(ExpectedConditions.elementToBeClickable(mobile_textBox)).sendKeys("+4916030901820");
		
	}
	
	
    public boolean getResult(){
    	
    	wait.until(ExpectedConditions.elementToBeClickable(Reg_Weiter_Button)).click();
    	String PLACE_OF_BIRTH_Txt=wait.until(ExpectedConditions.elementToBeClickable(nextpage_lable)).getText();
    	
		if(PLACE_OF_BIRTH_Txt.contains("Geburtsort") )
		{
			return true;		
		}
		else
		{
			return false;
		}
        
    }

}