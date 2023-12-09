package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Metodos4 {
    public static WebDriver driver;
    public static String UrlBase = "https://www.sugarcrm.com/au/request-demo/";
    public static void main(String[] args) throws InterruptedException {
        SetupWebDriver("chrome", UrlBase);
        fecharCoockies();

        //Criando WebElemento para poder ser manipulado pelo select é como se eu tivesse entrando dentro desse campo
        WebElement ddown = driver.findElement(By.name("employees_c"));
        //Criando o objeto select da classe select que maniupalará o objeto ddown que é do tipo WebElemento
        Select select = new Select(ddown);

        //Chamando os métodos da classe Select que manipulará o objeto ddown por meio do objeto select

        select.selectByValue("level1");
        Thread.sleep(2000);
        select.selectByVisibleText("51 - 100 employees");
        Thread.sleep(2000);
        select.selectByIndex(5);
        Thread.sleep(2000);

        driver.quit();
        Thread.sleep(5000);
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
    private static void fecharCoockies(){
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonCustomize']")).click();
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyButtonDecline']")).click();
    }

}
