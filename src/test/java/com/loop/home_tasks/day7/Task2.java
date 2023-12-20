package com.loop.home_tasks.day7;
import com.loop.home_tasks.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.Set;
import static org.testng.Assert.assertEquals;

/*
    task2
=============
    1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title
     */
public class Task2 extends TestBase {

    @Test
    public void multipleWindows(){
        driver.get("https://loopcamp.vercel.app/");
        WebElement multipleWindows = driver.findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindows.click();

        WebElement poweredByLoopcamp = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if (poweredByLoopcamp.isDisplayed()) {
            System.out.println("Powered by Loopcamp is displayed");
        }else {
            System.out.println("Powered by Loopcamp is NOT displayed");
        }


        assertEquals(driver.getTitle(), "Windows", "Results aren't matching!");

        WebElement clickHere = driver.findElement(By.xpath("//a[@href='windows/new.html']"));
        clickHere.click();


        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            System.out.println("each window's handle = " + each);
            driver.switchTo().window(each);
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());


        driver.close();

    }

}
