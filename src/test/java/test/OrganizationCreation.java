package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestBase;

import java.util.Set;


public class OrganizationCreation extends TestBase {

    @Test
    public void organizationRegistration() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 70);

        String uniqueBusinessName = "Vincent" + TestBase.generateUnique().substring(0,5) +"org";
        String uniqueFirstName = "Vincent" + TestBase.generateUnique().substring(0,5) +"first";
        String uniqueLastName = "Vincent" + TestBase.generateUnique().substring(0,5) +"last";
        String uniqueWorkEmail = "vincent" + TestBase.generateUnique().substring(0,5) +"@yopmail.com";
        String uniquePassword = "Vincent" + TestBase.generateUnique().substring(0,5) +"password9@";


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/text()[normalize-space(.)='CREATE ONE']/parent::*")));
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//*/text()[normalize-space(.)='CREATE ONE']/parent::*")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Thread.sleep(500);
        getDriver().findElement(By.id("name")).sendKeys(uniqueBusinessName);
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first")));
        Thread.sleep(500);
        getDriver().findElement(By.id("first")).sendKeys(uniqueFirstName);
        getDriver().findElement(By.id("last")).sendKeys(uniqueLastName);
        getDriver().findElement(By.id("email")).sendKeys(uniqueWorkEmail);
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//form/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        Thread.sleep(500);
        getDriver().findElement(By.id("password")).sendKeys(uniquePassword);
        getDriver().findElement(By.id("confirm")).sendKeys(uniquePassword);
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//form/div/button")).click();

    }

    @Test
    public void successfulSignInConfirmation() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getDriver(), 100);

        String expectedDashboardMessage = "What would you like to start?";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.OnboardingChoice-title")));
        Thread.sleep(1000);
        String actualDashboardMessage = getDriver().findElement(By.cssSelector("div.OnboardingChoice-title")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(expectedDashboardMessage, actualDashboardMessage); //to confirm the message displayed upon test
    }
}
