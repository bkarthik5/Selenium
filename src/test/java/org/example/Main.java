package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com");
        String expectedTitle = "W3Schools Online Web Tutorials";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("Title Validated");
        driver.findElement(By.cssSelector("#navbtn_tutorials")).click();
        driver.findElement(By.xpath("//a[@class='w3-bar-item ga-top-drop w3-button'][text()='Learn HTML']")).click();

        driver.quit();
    }
}