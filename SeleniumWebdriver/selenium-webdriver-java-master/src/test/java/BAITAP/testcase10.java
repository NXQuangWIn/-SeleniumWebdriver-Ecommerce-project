package BAITAP;

/*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.

*/

import Pom.BackendLogin;
import Pom.OrderMenuPage;
import Pom.RegisterPage;
import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

public class testcase10 {
    @Test
    public static void testTC10() {
        int scc = 0;
        StringBuffer verificationErrors = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/index.php/backendlogin
            driver.get("http://live.techpanda.org/index.php/backendlogin");
            RegisterPage registerPage = new RegisterPage(driver);
            BackendLogin loginPage = new BackendLogin(driver);
            OrderMenuPage o = new OrderMenuPage(driver);

            //2. Login the credentials provided
            driver.findElement(By.id("username")).sendKeys("user01");
            driver.findElement(By.id("login")).sendKeys("guru99com");

            driver.findElement(By.xpath("//input[@title='Login']")).click();
            Thread.sleep(2000);

            //3. Go to Sales-> Orders menu
            o.clickOrdersLinkLocator();

            // 4. Input OrderId and FromDate -> ToDate
            o.enterOrderId("100021247");
            o.enterFromDateInputLocator("11/7/2023");
            o.enterToDateInputLocator("11/10/2023");

            // 5. Click Search button
            o.clickSearchButtonLocator();
            Thread.sleep(2000);

            //6. Screenshot capture.
            scc = (scc + 1);
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String png = "D:\\NGUYENXUANQUANG\\2023.FFF\\SeleniumWebdriver\\selenium-webdriver-java-master\\TC10.png";
            FileUtils.copyFile(srcFile, new File(png));



        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
