package com.loop.home_tasks.day3;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {
    /**
    1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
     */

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://google.com");
        Thread.sleep(3000);
        WebElement gmail = driver.findElement(By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(1) > a"));
        gmail.click();
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println(driver.getTitle());





    }

}
