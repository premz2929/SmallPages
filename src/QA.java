import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class QA  {

    public void TestQA() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);


        // Testowanie strony https://qa.milosolutions.com/#
        driver.get("https://qa.milosolutions.com/");
        driver.manage().window().maximize();

        WebElement elementQA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"projects\"]/a")));
        wait.until(ExpectedConditions.elementToBeClickable(elementQA));


        List<WebElement> colNumQa = driver.findElements(By.className("menu-element"));
        System.out.println(colNumQa.size());

        // Pętla przechodząca przez wszystkie linki w headerze
        for (int i = 0; i < colNumQa.size(); i++) {
            colNumQa.get(i).click();
            Thread.sleep(1000);
        }
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("//*[@id=\"years-button\"]")).click();


    }

}
