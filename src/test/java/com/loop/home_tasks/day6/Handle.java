package com.loop.home_tasks.day6;


import com.loop.home_tasks.base.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Handle extends TestBase {

    @Test
    public void alertButton() {

        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void timerAlertButton() throws InterruptedException {

        driver.get("https://demoqa.com/alerts");
        WebElement timerAlertButton = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        timerAlertButton.click();

        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmButton() {

        driver.get("https://demoqa.com/alerts");
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        confirmButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String expected = "You selected Ok";
        WebElement validateMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String actual = validateMessage.getText();
        System.out.println(actual);
        assertEquals(actual, expected, "Actual result does not match the Expected");

        WebElement dismissButton = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        dismissButton.click();
        driver.switchTo().alert().dismiss();

        String expectedDisButMsg = "You selected Cancel";
        WebElement validateDisButMsg = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String actualDisButMsg = validateDisButMsg.getText();
        System.out.println(actualDisButMsg);
        assertEquals(actualDisButMsg, expectedDisButMsg, "Actual result does not match the Expected");}

    @Test
    public void promptBut (){
        driver.get("https://demoqa.com/alerts");

        WebElement promptBut = driver.findElement(By.xpath("//button[@id='promtButton']"));
        promptBut.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Loop Academy");
        alert.accept();

        WebElement validateMsgPrompt = driver.findElement(By.xpath("//span[@id='promptResult']"));
        String actual = validateMsgPrompt.getText();
        System.out.println(actual);
        String expected = "You entered Loop Academy";
        Assert.assertEquals(actual,expected);

    }
}
