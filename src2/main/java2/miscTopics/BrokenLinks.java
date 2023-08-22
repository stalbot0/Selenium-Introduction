package miscTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        get one link using css selector
        WebElement soapUIURL = driver.findElement(By.cssSelector("a[href*='soapui']"));
//        we don't have to actually click the link to see if it is broken or not
//        we can get the status codes for navigation, if status code >= 400, the link is broken
//        this link will work
        int respCode = connectionMethod(soapUIURL);
        System.out.printf("Response code for soapUI link: %d\n", respCode);

//        this link should be broken
        WebElement brokenLink = driver.findElement(By.cssSelector("a[href*='brokenlink']"));
        int respCode2 = connectionMethod(brokenLink);
        System.out.printf("Response code for broken link: %d\n", respCode2);

        SoftAssert softAssert = new SoftAssert();
//        write a script that will go through all links in the footer and scan to see which are broken
        List<WebElement> footerLinks = driver.findElements(By.cssSelector("li.gf-li a"));
        for (WebElement w : footerLinks) {
            String msg = String.format("Broken link: %s, Response Code: %d\n", w.getText(), connectionMethod(w));
//                soft assertion so that we can continue to run through all of them and check (see top)
            softAssert.assertFalse(connectionMethod(w) >= 400, msg);
        }
//        when we assert all, we get beautiful messages in the output
        softAssert.assertAll();
    }

    public static int connectionMethod(WebElement w) throws IOException {
        String url = w.getAttribute("href");
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("HEAD");
        connection.connect();
        return connection.getResponseCode();
    }
}
