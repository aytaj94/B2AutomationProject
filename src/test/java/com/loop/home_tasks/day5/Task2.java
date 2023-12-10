package com.loop.home_tasks.day5;

import com.loop.test.utilities.WebDriverFactory;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.StringJoiner;

public class Task2 {



        /*
        1. go to https://www.etsy.com/
        2. search for rings
        3. validate that Estimated Arrival shows any time
        3. click Estimated Arrival dropdown
        4. click Select custom date
        5. choose may 30 from dropdown
        6. validate Estimated Arrival shows may 30
         */

    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDownMethod(){
        //driver.close();
    }

    @Test
    public void ringSearchTest() throws InterruptedException {
        WebElement placeSearch = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        String textToSearch = "rings";
        Thread.sleep(3000);
        placeSearch.sendKeys(textToSearch + Keys.ENTER);
        //WebElement estimatedArrivalAnyTime = driver.findElement(By.xpath("//body[@class='ui-toolkit transitional-wide is-responsive no-touch en-US USD US etsy-has-it-design wt-focus-visible']"));
        //estimatedArrivalAnyTime.click();
        WebElement estimatedArrivalAnyTime = driver.findElement(By.xpath("((//span[@class='wt-text-reader-caption'])[1]"));
        estimatedArrivalAnyTime.click();
        //WebElement selectCustomDate = driver.findElement(By.xpath("//select[@id='locale-overlay-select-region_code']"));
        //selectCustomDate.click();
        //WebElement chooseDec15 = driver.findElement(By.xpath("//div['data-above-header']"));
        //chooseDec15.click();
        //WebElement estimatedArrivalByDec15 = driver.findElement(By.xpath("//div['data-above-header']"));
        //estimatedArrivalByDec15.click();


        driver.quit();






    }


}
