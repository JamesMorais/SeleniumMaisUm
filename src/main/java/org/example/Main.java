package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static WebDriver driver;
    public static String UrlBase = "https://www.saucedemo.com";
    public static void main(String[] args) {
        SetupWebDriver("chrome", UrlBase);
        login("standard_user", "secret_sauce");
        String nome = driver.getWindowHandle();
        System.out.println(nome);
        driver.quit();
    }

    private static void SetupWebDriver(String browser, String url){
        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    private static void login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@class='submit-button btn_action']")).click();
    }

    private static void addItemToCart(String itemId){
        String itemXPath = String.format("//*[@id='%s']", itemId);
        driver.findElement(By.xpath(itemXPath)).click();
    }
}