import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class InnerFinalProjectTest {

    private WebDriver driver;

    @BeforeTest
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void destroy() {
        driver.quit();
    }

    @Test
    public void testOne() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(Helper.TPLANURL);
        Thread.sleep(2000);
    }

    @Test
    public void testTwo() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(Helper.TPLANURL);
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.navigate().to(Helper.TPLANURL);
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
    }

    @Test
    public void testThree() throws InterruptedException {
        Thread.sleep(2000);
        driver.get(Helper.TPLANURL);
        Thread.sleep(2000);

        WebElement fullNameField = driver.findElement(By.id(Helper.FULLNAMEID));
        WebElement emailField = driver.findElement(By.id(Helper.EMAILID));
        WebElement companyField = driver.findElement(By.id(Helper.COMPANYID));
        WebElement phoneNumberField = driver.findElement(By.id(Helper.PHONENUMBERID));

        fullNameField.sendKeys(Helper.FULLNAME);
        Thread.sleep(2000);
        emailField.sendKeys(Helper.EMAIL);
        Thread.sleep(2000);
        companyField.sendKeys(Helper.COMPANY);
        Thread.sleep(2000);
        phoneNumberField.sendKeys(Helper.PHONENUMBER);
        Thread.sleep(2000);
    }

    @Test
    public void testFour() throws IOException, InterruptedException {
        driver.get(Helper.TPLANURL);

        WebElement fullNameField = driver.findElement(By.id(Helper.FULLNAMEID));
        WebElement emailField = driver.findElement(By.id(Helper.EMAILID));
        WebElement companyField = driver.findElement(By.id(Helper.COMPANYID));
        WebElement phoneNumberField = driver.findElement(By.id(Helper.PHONENUMBERID));

        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file , new File(Helper.TIKIAHADASHA + "Screenshot1" + Helper.JPG));

        fullNameField.sendKeys(Helper.FULLNAME);
        Thread.sleep(2000);
        emailField.sendKeys(Helper.EMAIL);
        Thread.sleep(2000);
        companyField.sendKeys(Helper.COMPANY);
        Thread.sleep(2000);
        phoneNumberField.sendKeys(Helper.PHONENUMBER);

        File file2 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2, new File(Helper.TIKIAHADASHA + "Screenshot2" + Helper.JPG));
    }

    @Test
    public void testFive() throws InterruptedException, IOException {
        driver.get(Helper.TPLANURL);

        for (int i = 0; i <Helper.FULLNAMES.length ; i++) {
            WebElement fullNameField = driver.findElement(By.id(Helper.FULLNAMEID));
            WebElement emailField = driver.findElement(By.id(Helper.EMAILID));
            WebElement companyField = driver.findElement(By.id(Helper.COMPANYID));
            WebElement phoneNumberField = driver.findElement(By.id(Helper.PHONENUMBERID));

            fullNameField.sendKeys(Helper.FULLNAMES[i]);
            Thread.sleep(2000);
            emailField.sendKeys(Helper.EMAIL);
            Thread.sleep(2000);
            companyField.sendKeys(Helper.COMPANY);
            Thread.sleep(2000);
            phoneNumberField.sendKeys(Helper.PHONENUMBER);

            File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(Helper.TIKIAHADASHA + "screenshot" + i + Helper.JPG));
            driver.navigate().to(Helper.TPLANURL);
        }
    }
}




