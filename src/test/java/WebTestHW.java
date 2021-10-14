import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTestHW {

    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers_Testing\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

   @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public void navigatingToPage(){
        driver.get("https://amazon.com");

        System.out.println("Current Page Tytle is " + driver.getTitle());
        System.out.println("Currnet Page Url is " + driver.getCurrentUrl());
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
        signIn.click();
        WebElement newacct = driver.findElement(By.id("createAccountSubmit"));
        newacct.click();
        System.out.println("Current Page Tytle is " + driver.getTitle());
        System.out.println("Currnet Page Url is " + driver.getCurrentUrl());
    }

    @Test
    public void testAlert() {



        navigatingToPage();

        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Doctor");
        WebElement contact = driver.findElement(By.id("ap_email"));
        contact.sendKeys("doctor@yahoo.com");
        WebElement button = driver.findElement(By.id("continue"));
        button.click();
        WebElement alert = driver.findElement(By.id("auth-password-missing-alert"));
        Assert.assertEquals(alert.getText(), "Minimum 6 characters required");

    }
    @Test
    public void testMatchAlert(){

        navigatingToPage();


        WebElement name = driver.findElement(By.id("ap_customer_name"));
        name.sendKeys("Doctor");
        WebElement contact = driver.findElement(By.id("ap_email"));
        contact.sendKeys("doctor@yahoo.com");
       WebElement password =driver.findElement(By.id("ap_password"));
       password.sendKeys("3213213");
       WebElement passwordCheck = driver.findElement(By.id("ap_password_check"));
       passwordCheck.sendKeys("1231231");
       WebElement alert= driver.findElement(By.xpath("//*[@id=\"auth-password-mismatch-alert\"]"));
       Assert.assertEquals(alert.getText(),"Passwords must match"
               );


    }
}