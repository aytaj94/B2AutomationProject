package com.loop.test.day10_upload_download;

import com.loop.test.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T3_drag_drop {

    @Test
    public void drag_drop_test() {
        Driver.getDriver().get(ConfigurationReader.getProperty("guru.drag"));

        Actions action = new Actions(Driver.getDriver());

        WebElement bank = Driver.getDriver().findElement(By.xpath("//a[.=' BANK ']"));
        WebElement debitAccount = Driver.getDriver().findElement(By.id("bank"));
        action.dragAndDrop(bank, debitAccount).perform();

        WebElement fiveK = Driver.getDriver().findElement(By.xpath("//a[.=' 5000 ']"));
        WebElement debitAmount = Driver.getDriver().findElement(By.id("amt7"));
        action.dragAndDrop(fiveK, debitAmount).perform();

        WebElement sales = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'SALES')]"));
        WebElement creditAccount = Driver.getDriver().findElement(By.xpath("//*[@id='loan']/li"));
        action.dragAndDrop(sales, creditAccount).perform();

        WebElement creditAmount = Driver.getDriver().findElement(By.id("amt8"));
        action.dragAndDrop(fiveK, creditAmount).perform();

        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//a[contains(.,'Perfect!')]"));

        String expectedMessage = "Perfect!";
        String actual = successMessage.getText();

        assertEquals(actual, expectedMessage, "Actual does not match expected");
        //assertEquals(successMessage.getText(), expectedMessage);

        Driver.closeDriver();
    }
}
