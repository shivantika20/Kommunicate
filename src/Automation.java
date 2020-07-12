import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Automation {

    public static WebDriver driver = null;

    public static void main(String args[]) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\roya2\\3D Objects\\Softwares\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//disabling the warnings
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//open chrome app
        driver.get("https://test.kommunicate.io/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String stepsFailed = "";
        try {
            driver.switchTo().frame("kommunicate-widget-iframe");
            driver.findElement(By.xpath("//div[@id='launcher-svg-container']")).click();
        } catch (Exception e) {
            stepsFailed += " 1";
        }
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//button[@id='km-faq']")).click();
        } catch (Exception e) {
            stepsFailed += " 2";
        }
        Thread.sleep(2000);
        int num = -1;
        try {
            List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='km-faqimage']"));
            num = allOptions.size();
        } catch (Exception e) {
            stepsFailed += " 3";
        }
        if (stepsFailed.equals(" 1 2"))
            stepsFailed += " 3";
        if (!stepsFailed.equals("") || num < 20) {
            driver.get("https://mail.google.com/");


            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement userElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
            userElement.sendKeys("abc@abc.com");
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/span")).click();

            Thread.sleep(1000);

            WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"));
            passwordElement.sendKeys("test123");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/span")).click();

            Thread.sleep(1000);
            Thread.sleep(10000);

            WebElement composeElement = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div"));
            composeElement.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement to = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea"));
            to.sendKeys("abcd@gmail.com");
            WebElement sub = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/div/input"));
            // emailSubject and emailbody.
            String emailSubject = "Testing";
            String emailBody = "";
            if (num >= 20)
                emailBody = "Errors in Steps " + stepsFailed;
            else {
                emailBody = "No. of FAQs = " + Integer.toString(num);
                if (!stepsFailed.equals(""))
                    emailBody = emailBody + "\n" + "Errors in Steps " + stepsFailed;
            }
            sub.sendKeys(emailSubject);

            WebElement body = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div"));
            body.sendKeys(emailBody);


            WebElement send = driver.findElement(By.xpath("/html/body/div[22]/div/div/div/div[1]/div[3]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]"));
            send.click();
        }
    }
}
