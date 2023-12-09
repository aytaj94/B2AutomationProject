package com.loop.home_tasks.day3;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.StringJoiner;

/**
 * task 2
 * =============
 * 1. Navigate to docuport application.
 * 2. Validate placeholders for username and password.
 * 3. Without sending username and password click login button.
 * 4. Validate username and password error messages.
 */

public class Task2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app/login");

        WebElement placeholder = driver.findElement(By.cssSelector("label[for='input-14']"));
        String actualPlaceholder = placeholder.getText();
        System.out.println(actualPlaceholder);



        Thread.sleep(3000);
        if (actualPlaceholder.equals(DocuportConstants.USERNAME_PLACEHOLDER)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        WebElement placeholderPassword = driver.findElement(By.cssSelector("label[for='input-14']"));
        String actualPlaceholderPassword = placeholderPassword.getText();
        System.out.println(actualPlaceholderPassword);

        if (actualPlaceholderPassword.equals(DocuportConstants.PASSWORD_PLACEHOLDER)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        driver.quit();
    }
}