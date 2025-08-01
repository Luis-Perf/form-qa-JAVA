package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void preencherFormulario() {
        driver.get("https://demoqa.com/automation-practice-form");

        //Remove anúncios iniciais
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, .advertisement, #google_ads_iframe_').forEach(el => el.remove());"
        );

        driver.findElement(By.id("firstName")).sendKeys("Luis");
        driver.findElement(By.id("lastName")).sendKeys("Perfeito");
        driver.findElement(By.id("userEmail")).sendKeys("teste@email.com");

        //Clique protegido no radio "Male"
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, #google_ads_iframe_').forEach(el => el.remove());"
        );
        WebElement maleRadio = driver.findElement(By.xpath("//label[text()='Male']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", maleRadio);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", maleRadio);

        driver.findElement(By.id("userNumber")).sendKeys("11999999999");

        WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sports);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sports);

        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/teste.png");

        //Clique protegido no botão "Submit"
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, #google_ads_iframe_').forEach(el => el.remove());"
        );
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        //Espera explícita pelo modal aparecer
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        Assert.assertTrue(modal.isDisplayed(), "Modal não apareceu!");

        //Clique protegido no botão "Close"
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, #google_ads_iframe_').forEach(el => el.remove());"
        );
        WebElement closeButton = driver.findElement(By.id("closeLargeModal"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
