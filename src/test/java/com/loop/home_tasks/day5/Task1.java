package com.loop.home_tasks.day5;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task1 {

        /*
        1. go to http://the-internet.herokuapp.com/dropdown
        2. validate "Please select an option" is selected by default
        3. Choose option 1 and validate that it is selected
        4. Choose option 2 and validate that it is selected
        5. Validate dropdown name is
         */

    WebDriver driver;
    String expected1 = "Please select an option";
    String expceted2 = "Option 1";
    String expceted3 = "Option 2";
    String expceted4 = "Dropdown List";
    String actual;


    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().minimize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.close();
    }

    @Test (priority = 1)
    public void dropdownTest1() throws InterruptedException {
        Thread.sleep(3000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected1, "Actual does not match expected");

    }

    @Test (priority = 2)
    public void dropdownTest2() throws InterruptedException {
        Thread.sleep(3000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(1);
        actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expceted2, "Actual does not match expected");
    }

    @Test (priority = 3)
    public void dropdownTest3() throws InterruptedException {
        Thread.sleep(3000);
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(2);
        actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expceted3, "Actual does not match expected");

    }

    @Test (priority = 4)
    public void dropdownName() throws InterruptedException {
        Thread.sleep(3000);
        actual = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        Assert.assertEquals(actual,expceted4,"Actual does not match expected");
    }

}
