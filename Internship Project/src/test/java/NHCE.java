import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NHCE {
    public static WebDriver driver;
    @BeforeMethod
    void browserStarter(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Opening Chrome");
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void NHCE_Test(){
        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
        System.out.println("Entering in google");
        searchBox.sendKeys("NHCE Bangalore"+ Keys.ENTER);
        System.out.println("Finding New Horizon College from search results");
        driver.findElement(By.cssSelector("[href='https://newhorizonindia.edu/nhengineering/'] > .TbwUpd")).click();
        String pageTitle = driver.getTitle();
        System.out.println("Currently in "+pageTitle+" page");
        Assert.assertEquals(pageTitle,"Top Engineering Colleges in Bangalore | NHCE Bangalore");
        System.out.println("Closing Browser");



    }
    @AfterMethod
    void close(){
        driver.close();
    }
}
