package packMyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void main(String[] args)
    {

        // 1 Инициализацию веб драйвера лучше сделать в отдельном классе и создавать инсианс веб драйвера перед запуском тестов
        // есть аннотации которые помогут это сделать 
        
        // 2 в тестах должна быть только бизнес логика, они ничего не должны знать о реализации
        // пример 
        // public void testValidLogin() {
        //    loginPage.enterUserName(VALID_USER_NAME);
        //    loginPage.enterPassword(VALID_PASSWRD);
        //    loginPage.clickLoginButton();
        //    
        //    дальше ассерт
        //}
        //    
        // 3 значения не хардкодить в тестах - вынести в константы. Можно сделать отдельный класс который будет хранить эти константы
        // 
        // 4 Сделать loginPage - там будут локаторы к элементам (в константах) и методы которые используются для манипуляции с элементами на этой странице
        // 5 xpath лучше делать не абсолютные когда ты пишешь весь путь, а относительные  - https://www.guru99.com/xpath-selenium.html
        
        
         
        
        
        System.setProperty("webdriver.gecko.driver","C:/Users/Yan/Desktop/Temp/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebElement element;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.i.ua/");

        WebElement loginField = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/p[2]/input"));
        loginField.sendKeys("autoselenium");

        WebElement passwordField = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/input"));
        passwordField.sendKeys("supertesting");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input"));
        loginButton.click();

        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

        WebElement profileUser = driver.findElement(By.xpath("/html/body/div[1]/div[4]/ul/li[1]/span"));
        String mailUser = profileUser.getText();
        System.out.println(mailUser);
        Assert.assertEquals("autoselenium@i.ua", mailUser);

        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

        WebElement menuSettings = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/ul[3]/li[3]/span"));
        menuSettings.click();
        WebElement logout = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/ul/li[7]/a"));
        logout.click();
        driver.quit();




    }
}







