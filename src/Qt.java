import okhttp3.internal.http2.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Qt {

    public enum Header {
        WhatisQT, Portfolio, Process, Platforms,
        ArticlesAboutQT, HireUS
    }

    public enum AllArticles {
        first, second, third, fourth, fifth, sixth,
        seventh, eight, ninth, tenth, eleventh
    }


    public void testQT() throws InterruptedException {


        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.get("https://qt.milosolutions.com");
        String newWindow = driver.getWindowHandle();
        driver.manage().window().maximize();

        WebElement elementQT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@id=\"main-header\"]/nav/ul/li[6]/a")));

        wait.until(ExpectedConditions.elementToBeClickable(elementQT));
        driver.findElement(By.xpath("//*[@id=\"blog\"]/a")).click();


        List<WebElement> colNumQt = driver.findElements(By.className("menu-element"));
        List<WebElement> portfolioIcons = driver.findElements(By.className("portfolio-elem-button"));

        System.out.println(colNumQt.size());
        //for(Header header : Header.values())
        for (int i = 0; i <= colNumQt.size(); i++) {
            colNumQt.get(i).click();
            Thread.sleep(1000);
            if (i == Header.Portfolio.ordinal()) {
                for (int k = 0; k < portfolioIcons.size(); k++) {
                    if (k % 4 == 0) {
                        js.executeScript("window.scrollBy(0,320)");
                    }
                    portfolioIcons.get(k).click();
                    Thread.sleep(2000);
                    portfolioIcons.get(k).click();
                    Thread.sleep(1000);
                }
            }
            if (i == Header.ArticlesAboutQT.ordinal()) {
                for (int l = 1; l <= 11; l++) {
                    driver.findElement(By.xpath("//*[@id=\"blog-section\"]/div[2]/div[" + l + "]/a")).click();
                    Thread.sleep(2000);
                    if (l == AllArticles.second.ordinal()) {
                        driver.findElement(By.xpath("//*[@id=\"body\"]/div[4]/div[3]/a[1]")).click();
                        driver.findElement(By.xpath("//*[@id=\"body\"]/div[3]/div[3]/a[1]")).click();
                    }
                    js.executeScript("window.scrollBy(0,500)");
                    Thread.sleep(5000);
                    driver.navigate().back();
                }
            }
        }
        driver.close();


        // Kod słuzący do kliknięciaa na znaczek QT, ale z racji tego, że nie mogę obsłużyć (nie wiem czemu)
        // strony milo po powrocie nie nią jak narazie zostaje zakomentowany, później bedzie trzeba do tego
        // wrocic
        /*
        driver.findElement(By.xpath("//*[@id=\"qt-link\"]")).click();
        Thread.sleep(1000);
        driver.switchTo().window(newWindow);
        */

    }
}

