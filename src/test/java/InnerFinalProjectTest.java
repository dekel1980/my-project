import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class InnerFinalProjectTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void testOne(){
        WebDriver driver = new ChromeDriver();

    }

    @Test
    public void testTwo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.get(Helper.TPLANURL);
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testThree() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.get(Helper.TPLANURL);
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.navigate().to(Helper.TPLANURL);
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testFour() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
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
        driver.quit();

    }

    @Test
    public void testFive() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
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

        driver.quit();

    }

    @Test
    public void testSix() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
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




