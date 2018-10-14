package packMyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:/Users/Yan/Desktop/Temp/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        WebElement element;
        //= null;
        element = driver.findElement(By.id("lst-ib"));
        //element = driver.findElement(By.name("passwd"));
        //element = driver.findElement(By.xpath("//input[@id='passwd-id']"));
        element.sendKeys("Приветствую изюмского Фунтика!");
    }

    }
