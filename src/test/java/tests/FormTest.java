package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FormTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void preencherFormulario() {
        driver.get("https://demoqa.com/automation-practice-form");

        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, .advertisement').forEach(el => el.remove());"
        );

        driver.findElement(By.id("firstName")).sendKeys("Luis");
        driver.findElement(By.id("lastName")).sendKeys("Perfeito");
        driver.findElement(By.id("userEmail")).sendKeys("teste@email.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("11999999999");

        WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sports);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sports);

        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/teste.png");

        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modal.isDisplayed(), "Modal não apareceu!");
        driver.findElement(By.id("closeLargeModal")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
