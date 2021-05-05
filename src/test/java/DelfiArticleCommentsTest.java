import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiArticleCommentsTest {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");

    @Test
    public void titleAndCommentsCountCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://delfi.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE_BTN));

        driver.findElement(ACCEPT_COOKIE_BTN).click();

        List<WebElement> titles = driver.findElements(HOME_PAGE_TITLE);

        //----------------------FOR----------------------------------------------------------
        for (int i = 0; i < titles.size(); i++) {  //i = i + 1   ->  i++
            if (!titles.get(i).getText().isEmpty()) {  // !true = false   !false = true
                System.out.println(i + ": " + titles.get(i).getText());
            }
        }

        //-------------------FOREACH---------------------------------------------------------
        for (WebElement we : titles) {
//            if (!we.getText().isEmpty()) {
//                System.out.println(we.getText());
//            } else {
//                System.out.println("----------------------------------------");
//            }

            // условие ? true : false (else)
            System.out.println(we.getText().isEmpty() ? "---------" : we.getText());
        }
    }
}
