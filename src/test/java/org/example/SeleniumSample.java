package org.example;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumSample {
    static WebDriver driver;
//    String username = System.getenv("LT_USERNAME") == null ? "LT_USERNAME": System.getenv("LT_USERNAME");
//    String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY": System.getenv("LT_ACCESS_KEY");
//    String gridURL = "@hub.lambdatest.com/wd/hub";
    @BeforeTest
    void setup() {
//        ChromeOptions chromeOptions=new ChromeOptions();
//        chromeOptions.setHeadless(true);
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disbale-dev-shm-usage");
//        chromeOptions.addArguments("--remote-allow-origins=*");
//       // chromeOptions.addArguments("--headless");
//        WebDriverManager.chromedriver().setup();

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

//options.addArguments("--headless");

        options.addArguments("--disable-notifications");

        options.addArguments("--disable-gpu");

        options.addArguments("--disable-extensions");

        options.addArguments("--no-sandbox");

        options.addArguments("--disable-dev-shm-usage");

        options.addArguments("--remote-allow-origins=*");  // this i added  this and it worked, Thanks a ton  xinchao zhang !!

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        options.merge(capabilities);

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
    @Test
    public void sampleTest() {
        // Set up the wWebDriverManager for chrome driver

//        WebDriverManager.chromedriver().setup();
        // Create the driver object

//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");
        String expectedTitle = "W3Schools Online Web Tutorials";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Title Validated");
        driver.findElement(By.cssSelector("#navbtn_tutorials")).click();
        driver.findElement(By.xpath("//a[@class='w3-bar-item ga-top-drop w3-button'][text()='Learn HTML']")).click();
    }
    @AfterTest
    void teardown() {
        // Close the driver
        driver.quit();
    }
}