package com.loop.home_tasks.day4;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {

    /*
    task 1
=============
1. go to docuport app
2. validate that Home, Received docs, My uploads, Invitations are displayed
3. press three lines
4. Home, Received docs, My uploads, Invitations will disappear
5. Validate the buttons are not displayed

     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/");
        WebElement username =driver.findElement(By.id("input-14"));
        username.sendKeys(DocuportConstants.USERNAME_CLIENT);
        username.click();
        WebElement password= driver.findElement(By.id("input-15"));
        password.sendKeys(DocuportConstants.PASSWORD_CLIENT);
        password.click();
        WebElement loginButton=driver.findElement(By.className("v-btn__content"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement continueButton= driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(300);
        WebElement home = driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
        if(home.isDisplayed()){
            System.out.println("TEST FAILED => Home button is NOT displayed");
        }else {
            System.out.println("TEST PASS => Home button is displayed");
        }

        Thread.sleep(300);
        WebElement receivedDocs = driver.findElement(By.xpath("//a[@href='/received-docs']"));
        if(receivedDocs.isDisplayed()){
            System.out.println("TEST FAILED => Received docs button is NOT displayed");
        }else {
            System.out.println("TEST PASS => Received docs button is displayed");
        }

        Thread.sleep(500);
        WebElement myUploads = driver.findElement(By.xpath("//a[@href='/my-uploads']"));
        if(myUploads.isDisplayed()){
            System.out.println("TEST FAILED => My Uploads button is NOT displayed");
        }else {
            System.out.println("TEST PASS => My Uplouds button is displayed");
        }

        Thread.sleep(500);
        WebElement invitations = driver.findElement(By.xpath("//a[@href='/invitations']"));
        if(invitations.isDisplayed()){
            System.out.println("TEST FAILED => Invitation button is NOT displayed");
        }else {
            System.out.println("TEST PASS => Invitations button is displayed");
        }

        Thread.sleep(500);
        WebElement pressThreeLines = driver.findElement(By.xpath("//button[@class='v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default']"));
        pressThreeLines.click();

        Thread.sleep(300);
        if(!home.isDisplayed()){
            System.out.println("TEST PASS => Home button is displayed");
        }else {
            System.out.println("TEST FAILED => Home button is NOT displayed");
        }

        Thread.sleep(300);
        if(!receivedDocs.isDisplayed()){
            System.out.println("TEST PASS => Received docs button is displayed");
        }else {
            System.out.println("TEST FAILED => Received docs button is NOT displayed");
        }

        Thread.sleep(500);
        if(!myUploads.isDisplayed()){
            System.out.println("TEST PASS => My uploads button is displayed");
        }else {
            System.out.println("TEST FAILED => My uploads button is NOT displayed");
        }
        Thread.sleep(300);
        if(!invitations.isDisplayed()){
            System.out.println("TEST PASS => Invitations button is displayed");
        }else {
            System.out.println("TEST FAILED => Invitation button is NOT displayed");
        }

        driver.close();





    }
}
