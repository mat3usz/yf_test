package yf.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class StockPage {
    private WebDriver driver;

    public StockPage() {
        System.setProperty("webdriver.gecko.driver", "/Users/mk/Downloads/gdriver/geckodriver");
        this.driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://finance.yahoo.com/quote/FFIV/history?p=FFIV&guccounter=2");
     }

    public void clickContinueButton() throws InterruptedException {
        sleep(1000);
    }

    public void assertUserIsOnCorrectPage() {
        if (!this.driver.getTitle().contains("F5")) {
            throw new IllegalStateException("This is not YF page, current page is: " + this.driver.getTitle());
        }
    }

    public double getMaxClosingPrice(int days){
        Double retValue = 0.0;
        for(int i=1; i<=days; i++){
            WebElement el = this.driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/section/div[2]/table/tbody/tr[" + i +"]/td[5]/span"));
            Double price = Double.valueOf(el.getText());
            if (price > retValue) {
                retValue = price;
            }
        }
        return retValue;
    }
}
