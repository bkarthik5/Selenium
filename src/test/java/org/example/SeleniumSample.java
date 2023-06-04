package org.example;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumSample {
//    static WebDriver driver;
    private RemoteWebDriver driver;
//    String username = System.getenv("LT_USERNAME") == null ? "LT_USERNAME": System.getenv("LT_USERNAME");
//    String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY": System.getenv("LT_ACCESS_KEY");
//    String gridURL = "@hub.lambdatest.com/wd/hub";
    @BeforeTest
    void setup() {

        // Chrome flag for headless using chrome options
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");// headless flag for chrome
        options.addArguments("--start-maximized");
        options.addArguments("disable-gpu");;
        driver = new ChromeDriver(options);
       WebDriverManager.chromedriver().setup();


    }
    @Test
    public void sampleTest() {
//         Set up the WebDriverManager for chrome driver

       // WebDriverManager.chromedriver().setup();
//         Create the driver object



        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");
        String expectedTitle = "W3Schools Online Web Tutorials";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Title Validated");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        driver.findElement(By.cssSelector("#navbtn_tutorials")).click();
//        driver.findElement(By.xpath("//a[@class='w3-bar-item ga-top-drop w3-button'][text()='Learn HTML']")).click();
    }
    @AfterTest
    void teardown() {
        // Close the driver
        driver.quit();
    }
}