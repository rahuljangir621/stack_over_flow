package demo;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import dev.failsafe.internal.util.Assert;

public class TestCases {
  ChromeDriver driver;
  wrapper action;

  public TestCases() {
    System.out.println("Constructor: TestCases");

    WebDriverManager.chromedriver().timeout(30).setup();
    ChromeOptions options = new ChromeOptions();
    LoggingPreferences logs = new LoggingPreferences();

    // Set log level and type
    logs.enable(LogType.BROWSER, Level.ALL);
    logs.enable(LogType.DRIVER, Level.ALL);
    options.setCapability("goog:loggingPrefs", logs);

    // Set path for log file
    System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

    driver = new ChromeDriver(options);
    action = new wrapper(driver);

    // Set browser to maximize and wait
    driver.manage().window().maximize();

  }

  public void endTest() {
    System.out.println("End Test: TestCases");
    driver.close();
    driver.quit();

  }

  // TODO: Write Test Cases Here

  public void testCase01() {
    System.out.println("Start Test case: testCase01");
    driver.get("https:www.google.com");
    System.out.println("end Test case: testCase01");

  }

  // verifying to match url with expected result
  public void testcase02() throws InterruptedException {
    System.out.println("Start Test case: testCase02");
    String url = "https://stackoverflow.com/";
    action.navigate_to_url(url);
    Thread.sleep(2000);

    Assert.isTrue(driver.getCurrentUrl().contains("stackoverflow"), "Current URL does not match expected condition");

    System.out.println("completed Test case: testCase02");
  }

  // verifying "Python list comprehension" in the search bar after
  public void testcase03() throws InterruptedException {
    boolean status = false;

    System.out.println("start Test case: testCase03");
    action.type(By.xpath("//input[@placeholder=\"Search…\"]"), "Python list comprehension");

    // filling catcha manually

    action.waitfor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("s-post-summary--content-excerpt")));

    List<WebElement> verifying_results = driver.findElements(By.className("s-post-summary--content-excerpt"));

    for (WebElement element : verifying_results) {
      String gettext = element.getText();

      if (!gettext.contains("python") || !gettext.contains("list comprehension")) {
        status = false;
        break;
      }
      Assert.isTrue(status, "FAIL: Text does not contain expected keywords");
      System.out.println("completed Test case: testCase03");
      Thread.sleep(2000);

    }
  }

  public void testcase04() throws InterruptedException {
     System.out.println("start Test case: testCase04");
    boolean status = false;
    int counter = 0 ;
     String url = "https://stackoverflow.com/";
    action.navigate_to_url(url);
    Thread.sleep(2000);
  

    action.waitfor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(@class, '-link--channel-name pl8') and contains(text(), 'Tags')]")));


    action.click(By.xpath("//span[contains(@class, '-link--channel-name pl8') and contains(text(), 'Tags')]"));
    Thread.sleep(5000);

    action.waitfor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[text() = 'javascript']")));

   
    action.click(By.xpath("//a[text() = 'javascript']"));
    Thread.sleep(4000);

    action.waitfor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class = 'ml0 list-ls-none js-post-tag-list-wrapper d-inline']")));

    List<WebElement> verifying_results = driver.findElements(By.xpath("//ul[@class = 'ml0 list-ls-none js-post-tag-list-wrapper d-inline']"));

    for (WebElement element : verifying_results) {
      String gettext = element.getText();

      if (gettext.contains("javascript")) {
        counter = counter + 1 ;
      }
    }
    if ((counter >= 10)) {
      status = true;
    }
    Assert.isTrue(status, "FAIL: Text does not contain expected keywords");
    System.out.println("completed Test case: testCase04");
    Thread.sleep(2000);

    }
  

  public void testcase05() throws InterruptedException {
     System.out.println("start Test case: testCase04");

    boolean status = false;

    String url = "https://stackoverflow.com/";
    action.navigate_to_url(url);
    Thread.sleep(2000);

    action.click(By.xpath("//button[@aria-controls='uql-more-popover']"));

    WebElement verifying_soure = driver.findElement(By.cssSelector("a.s-block-link.s-block-link__left.js-gps-track[href='/questions?tab=Votes']"));
   
    Assert.isTrue(verifying_soure.getText().equalsIgnoreCase("Score"),  "button score is not contains in more button");
   
    action.click(By.xpath(" //a[@aria-current='page']"));

    action.waitfor(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@aria-current='page']")));
    

     System.out.println("complete Test case: testCase05");

  

    


    }

  }


