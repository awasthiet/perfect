package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class login {
	public String baseUrl = "https://www.flipkart.com/";
	String driverPath ="/home/harshit/Downloads/geckodriver";
	
	public WebDriver driver;
	
	
  @Test
  public void openurl() {
	  System.setProperty("webdriver.firefox.marionette", driverPath);
	  driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.manage().window().maximize();
  } 
  
  @Test (dependsOnMethods={"openurl"})
  
  public void verifyname(){
	  
	 String name= driver.findElement(By.xpath("//A[@class='_2k0gmP'][text()='Sell on Flipkart']")).getText();
	 if (name.equalsIgnoreCase("sell on Flipkart")==true)
	 {
		 System.out.println("We are on the corrrect webpage");
	 }
  }
      @Test (dependsOnMethods={"openurl","verifyname"})
      public void iphone()
      {
      driver.findElement(By.xpath("//INPUT[@type='text']")).sendKeys("Iphone");
      driver.findElement(By.xpath("//BUTTON[@class='vh79eN']")).click();
      }
      
      
      @Test (dependsOnMethods={"openurl","iphone","verifyname"})
      public void iphone6(){
    	driver.findElement(By.xpath("//DIV[@class='_3wU53n'][text()='Apple iPhone 6 (Space Grey, 32 GB)']")).click();
    String s=	driver.findElement(By.xpath("//H1[@class='_3eAQiD']")).getText();
    System.out.println("Selected Iphne is "+ s);
    	
      }

//      @AfterMethod (dependsOnMethods={"openurl","iphone","verifyname","iphone6"})
//      public void tearDown()
//      {
//          driver.quit();
//      }
} 
  

