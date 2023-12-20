package com.loop.home_tasks.day7;
import com.loop.home_tasks.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends TestBase {
    /*
    task1
=============
    1. go to https://loopcamp.vercel.app/nested-frames.html
    2. validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */

    @Test (priority = 1)
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        actual = left.getText();
        expected = "LEFT";
        Assert.assertEquals(actual,expected,"Actual does not match the expected");
    }

    @Test (priority = 2)
    public void middle(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        actual = middle.getText();
        expected = "MIDDLE";
        Assert.assertEquals(actual,expected,"Actual does not match the expected");


    }

    @Test (priority = 3)
    public void right(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        actual = right.getText();
        expected = "RIGHT";
        Assert.assertEquals(actual,expected,"Actual does not match the expected");

    }

    @Test (priority = 4)
    public void bottom() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        actual = bottom.getText();
        expected = "BOTTOM";
        Assert.assertEquals(actual,expected, "Actual does not match the expected");

        driver.close();

    }
}
