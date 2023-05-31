package org.example;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumSample {
    static WebDriver driver;
//    String username = System.getenv("LT_USERNAME") == null ? "LT_USERNAME": System.getenv("LT_USERNAME");
//    String accesskey = System.getenv("LT_ACCESS_KEY") == null ? "LT_ACCESS_KEY": System.getenv("LT_ACCESS_KEY");
//    String gridURL = "@hub.lambdatest.com/wd/hub";
    @BeforeTest
    void setup() {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disbale-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--remote-debugging-port=9222");
        chromeOptions.addArguments("windows-size=1200*600");
       // chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
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
        driver.findElement(By.cssSelector("#navbtn_tutorials")).click();
        driver.findElement(By.xpath("//a[@class='w3-bar-item ga-top-drop w3-button'][text()='Learn HTML']")).click();
    }
    @AfterTest
    void teardown() {
        // Close the driver
        driver.quit();
    }
}