package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FormTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void preencherFormulario() {
        // Acessa a página
        driver.get("https://demoqa.com/automation-practice-form");

        // Remove anúncios (iframes) que atrapalham cliques
        ((JavascriptExecutor) driver).executeScript(
            "document.querySelectorAll('iframe, .advertisement').forEach(el => el.remove());"
        );

        // Preenche Nome e Sobrenome
        driver.findElement(By.id("firstName")).sendKeys("Luis");
        driver.findElement(By.id("lastName")).sendKeys("Perfeito");

        // Preenche Email
        driver.findElement(By.id("userEmail")).sendKeys("teste@email.com");

        // Seleciona Gênero (Male)
        driver.findElement(By.xpath("//label[text()='Male']")).click();

        // Preenche Telefone
        driver.findElement(By.id("userNumber")).sendKeys("11999999999");

        // Seleciona Hobby (Sports) usando scroll + JS
        WebElement sports = driver.findElement(By.xpath("//label[text()='Sports']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sports);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sports);

        // Upload de arquivo
        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/teste.png");

        // Clica em Submit (usando JS)
        WebElement submitButton = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);

        // Valida se o modal de sucesso apareceu
        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modal.isDisplayed(), "Modal não apareceu!");

        // Fecha modal
        driver.findElement(By.id("closeLargeModal")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
