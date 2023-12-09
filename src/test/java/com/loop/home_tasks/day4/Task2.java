package com.loop.home_tasks.day4;

import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    /*
    1. go to docuport
    2. sign as adviser
    3. store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
    4. iterate and print out href values

    optional step:
    5. Validate that expected matching to actual

    Home, Received docs, My uploads, Clients, Invitations, Users, Leads, Bookkeeping, 1099 form, Reconciliation

     */

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.id("input-14"));
        username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        username.click();
        WebElement password = driver.findElement(By.id("input-15"));
        password.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
        password.click();
        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();
        Thread.sleep(2000);


        //store left navigate items to (Home, Received docs, My uploads, Invitations etc) to the List
        List<WebElement> navigateItems = driver.findElements(By.xpath("//a[contains(@class,'py-x-2')]"));
        System.out.println(navigateItems.size());

        //iterate and print out href values
        for (int i = 0; i < navigateItems.size(); i++) {
            if (!navigateItems.get(i).getText().equals("")) {
                System.out.println("Box item: " + navigateItems.get(i).getText());
                System.out.println("Box items link: " + navigateItems.get(i).getAttribute("href"));
            }
        }


        //Validate that expected matching to actual
        ArrayList<String> actualNavigateItems = new ArrayList<>(Arrays.asList("Home", "Received docs", "My uploads",
                "Clients", "Invitations", "Users", "Leads", "Bookkeeping", "1099 Form", "Reconciliation"));
        for (int i = 0; i < navigateItems.size(); i++) {
            if (actualNavigateItems.get(i).equals(navigateItems.get(i).getText())) {
                System.out.println("TEST PASSED - expected result " + "(" + navigateItems.get(i).getText() + ")  matches the actual result");
            } else {
                System.out.println("TEST FAILED - expected result " + "(" + navigateItems.get(i).getText() + ") doesn't match the actual result");
            }
        }

        driver.quit();


        //List<WebElement> navigateItems = driver.findElements(By.xpath("//a[contains(@class,'py-x-2')]"));
        //for (WebElement each : navigateItems) {
        //    System.out.print(each.getAttribute("href") + " ") ;
        //    System.out.print(each.getText());
        //}
        //ArrayList<String> list = new ArrayList<>();
        //list.add("Home");
        //list.add("Received");
        //list.add("My uploads);
        //list.add("Clients");
        //list.add("Invitations");
        //list.add("Users");
        //list.add("Leads");
        //list.add("Bookkeeping");
        //list.add("1099 form);
        //list.add("Reconciliation);

        //for ( int i = 0; i < list.size(): i++){
        //  if ( list.get(i).equals(navigateItems.get(i).getText())) {
        //     System.out.println("TEST PASSED");
        //  }else{
        //      System.out.println("TEST FAILED , the expected result did not match the actual result.");
        //  }

        //}



    }
}
