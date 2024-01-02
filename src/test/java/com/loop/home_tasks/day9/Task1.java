package com.loop.home_tasks.day9;
import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;

/*
task1
============
1. go to url: https://loopcamp.vercel.app/registration_form.html
2. fill the form
3. use faker
 */

public class Task1 {

    @Test
    public void registrationForm(){
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form"));
        Faker faker = new Faker();
        WebElement registrationForm = Driver.getDriver().findElement(By.xpath("//a[@href='registration_form.html']"));
        registrationForm.click();
        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        System.out.println("Faker First Name = " + faker.name().firstName());
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        System.out.println("Faker Last Name = " + faker.name().lastName());
        lastName.sendKeys(faker.name().lastName());
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@name='usernam']"));
        System.out.println("Faker Username = " + faker.name().username().replace(".", ""));
        username.sendKeys(faker.name().username().replace(".", ""));
        WebElement emailAddress = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        System.out.println("Faker Email Address = " + faker.internet().emailAddress() );
        emailAddress.sendKeys(faker.internet().emailAddress());
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        System.out.println("Faker Password = " + faker.internet().password());
        password.sendKeys(faker.internet().password());
        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        System.out.println("Faker Phone Number = " + faker.numerify("617-###-####"));
        phoneNumber.sendKeys(faker.numerify("617-###-####"));
        WebElement genderSelect = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderSelect.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        SimpleDateFormat date = new SimpleDateFormat("MM/dd/yyyy");
        String actual = date.format(faker.date().birthday());
        dateOfBirth.sendKeys(actual);

        Select dropdown1 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        dropdown1.selectByVisibleText("Department of Engineering");
        Select dropdown2 = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        dropdown2.selectByVisibleText("Developer");

        WebElement selectProgramLanguage = Driver.getDriver().findElement(By.xpath("//div[@class='form-check form-check-inline'][3]"));
        selectProgramLanguage.click();

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();
    }
}
