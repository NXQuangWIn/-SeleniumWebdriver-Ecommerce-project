package BAITAP;
/*  Verify Discount Coupon works correctly

Test Case Description:

1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated

TestData:  Coupon Code: GURU50

Expected result:

1) Price is discounted by 5%

*/

import Pom.CartPage;
import Pom.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class testcase09 {
    @Test
    public static void testTC09() {
        int scc = 0;
        StringBuffer verificationErrors = new StringBuffer();
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");
            RegisterPage registerPage = new RegisterPage(driver);
            CartPage cartPage = new CartPage(driver);


            //2. Go to Mobile and add IPHONE to cart
            driver.findElement(By.linkText("MOBILE")).click();
            //add Iphone to cart
            driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]")).click();

            Thread.sleep(2000);
            //3. Enter Coupon Code
            double oldGrand = Double.parseDouble(cartPage.getInitGrandTotal());
            driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
            //click apply
            driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
            Thread.sleep(1000);

            //4. Verify the discount generated
            System.out.println(cartPage.discountGenerated());
            AssertJUnit.assertNotSame("",cartPage.discountGenerated());
            Thread.sleep(1000);
            cartPage.verifyDiscount(oldGrand);
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
