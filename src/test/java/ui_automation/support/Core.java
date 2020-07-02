package ui_automation.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Core {

    private WebDriver driver = null;

    protected void createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void killWebDriver(){
        driver.quit();
    }

    protected void navigate(String url){
        driver.get(url);
    }

    protected void send(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    protected void click(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
