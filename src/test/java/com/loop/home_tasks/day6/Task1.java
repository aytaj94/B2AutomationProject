package com.loop.home_tasks.day6;

/*
 task1
=============
        1. go to https://demoqa.com/alerts
            2. click - click button to see alert
3. handle alert
4. click - On button click, alert will appear after 5 seconds
5. handle alert
6. click - On button click, confirm box will appear
7. click ok and validate - You selected Ok
8. after that do it again this time cancel and validate - You selected Cancel
9. click - On button click, prompt box will appear
10. enter "Loop Academy" and validate You entered Loop Academy
 */

import com.loop.home_tasks.base.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;



public class Task1 extends TestBase {

     String actual;
     String expected;

    @Test (priority = 1 )
    public void alert1() {
        driver.get("https://demoqa.com/alerts");
        WebElement clickButton = driver.findElement(By.xpath("//button[contains(text(),'Click me')]"));
        clickButton.click();
        driver.switchTo().alert().accept();

    }

    @Test (priority = 2)
    public void alert2() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement onButtonClick = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        onButtonClick.click();

        Thread.sleep(6000);
        driver.switchTo().alert().accept();

    }

    @Test (priority = 3)
    public void alert3() {
        driver.get("https://demoqa.com/alerts");
        WebElement confirmBoxClick = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmBoxClick.click();

        driver.switchTo().alert().accept();

        WebElement successMessageAlert = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        expected = "You selected Ok";
        actual = successMessageAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

        confirmBoxClick.click();
        driver.switchTo().alert().dismiss();
        expected = "You selected Cancel";
        actual = successMessageAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

    }

    @Test (priority = 4)
    public void alert4(){
        driver.get("https://demoqa.com/alerts");
        WebElement promptBoxButton = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptBoxButton.click();
        String text = "Loop Academy";
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Loop Academy");
        alert2.accept();

        WebElement successMessageAlert = driver.findElement(By.xpath("//span[@id='promptResult']"));
        expected = "You entered Loop Academy";
        actual = successMessageAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");


    }

}
