package com.loop.home_tasks.day6;
import com.loop.home_tasks.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.*;
import org.testng.annotations.Test;

import java.time.Duration;

    /*
    1. go to https://demoqa.com/nestedframes
    2. Validate "Child Iframe" text
    3. Validate "Parent Iframe" text
    4. Validate the "Sample Nested Iframe page.There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
     */



public class Task2 extends TestBase {

    @Test
    public void iframeTextTest () {
        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);

        //WebElement childIframe = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        //driver.switchTo().frame(childIframe);

        WebElement childIframeText = driver.findElement(By.xpath("//p[text() = 'Child Iframe']"));
        actual = childIframeText.getText();
        expected = "Child Iframe";
        //Assert.assertEquals(actual, expected, "Actual does not match the expected");


        driver.switchTo().parentFrame();
        WebElement parentIframeText = driver.findElement(By.xpath("//body[.='Parent frame']"));
        actual = parentIframeText.getText();
        expected = "Parent Iframe";
        //Assert.assertEquals(actual, expected, "Actual does not match the expected");

        driver.switchTo().defaultContent();
        WebElement sampleNestedIframePage = driver.findElement(By.xpath("//div[contains(text(),'Sample')]"));
        actual = sampleNestedIframePage.getText();
        expected = "Sample Nested Iframe page.There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        //Assert.assertEquals(actual, expected,"Actual does not match the expected");
        driver.quit();


    }

}



