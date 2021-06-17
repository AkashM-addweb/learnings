package Learnings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Implicit_wait {

    public static WebDriver driver;
    public static Logger logger=null;
    public static Properties siteData=null;
    public static FileInputStream fis;

    @Test
    public void Waits() throws FileNotFoundException {

    //Load the Browser

        System.setProperty("webdriver.chrome.driver","./src/main/resources/Drivers/chromedriver");
        driver=new ChromeDriver();

//        siteData=new Properties();
//        fis=new FileInputStream("./src/main/java/Properties/siteData.properties");
//        fis.;
//
        driver.get("http://demo.guru99.com/V4/");

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Explicit Wait
        WebElement username= driver.findElement(By.name("uid"));
        WebDriverWait wait= new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
//      wait.until(ExpectedConditions.elementToBeClickable(By.name("uid")));
        driver.findElement(By.name("uid")).sendKeys("test Automation");


    }
}