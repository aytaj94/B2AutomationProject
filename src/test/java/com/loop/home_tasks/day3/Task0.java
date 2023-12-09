package com.loop.home_tasks.day3;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 1. go to https://loopcamp.vercel.app/forgot-password.html
 * 2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
 * 3. use css
 * 4. verify those elements are displayed
 */
public class Task0 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println(forgotPassword.isDisplayed());

        WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println(email.isDisplayed());

        WebElement emailInput = driver.findElement((By.cssSelector("input[name='email']")));
        System.out.println(emailInput.isDisplayed());

        WebElement retrievePassword = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        System.out.println(retrievePassword.isDisplayed());

        WebElement poweredByLOOPCAMP = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println(poweredByLOOPCAMP.isDisplayed());



    }
}