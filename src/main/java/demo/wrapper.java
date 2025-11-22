package demo;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wrapper {
    ChromeDriver driver;
    WebDriverWait wait;
     

    public wrapper(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigate_to_url(String url) {
        try {
            if (!(driver.getCurrentUrl().equals(url))) {
                driver.get(url);
            }
        } catch (Exception e) {
            System.out.println("Error occurred during navigation to URL: " + e);
        }
    }

    public void click(By locator) {
        try {
            driver.findElement(locator).click();

        } catch (Exception e) {
            System.out.println("error occers during click on element " + e);
            // TODO: handle exception
        }
    }

    public String getText(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getText();

        } catch (Exception e) {
            System.out.println("error occers during geting text of element " + e);

        }
        return null;

    }

    public void type(By locator,String value) {
                try {
          WebElement element =  driver.findElement(locator);
          element.clear();
          element.sendKeys(value);
          element.submit();

        } catch (Exception e) {
            System.out.println("error occers during click on element " + e);
            // TODO: handle exception
        }
        
    }
    public void waitfor(ExpectedCondition<?> conditions){
     try {
           wait.until(conditions);

        } catch (Exception e) {
            System.out.println("error occers during click on element " + e);
      
        }
    }
}