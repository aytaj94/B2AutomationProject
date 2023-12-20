package com.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {
    /**
     * logins to the docuport application
     * param driver, which initialized in test base
     * @param role, comes from docuport constance
     * @author nadir
     */

    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()){
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT1);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR1);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR1);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE1);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default: throw new InputMismatchException("There us not such a role: " + role);
        }

        login.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
        }
    }


    /**
     * logs out from the application
     * @param driver
     * @author nadir
     */
    public static void logOut(WebDriver driver){
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
