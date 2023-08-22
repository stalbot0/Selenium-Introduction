package miscTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BrokenLinks {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        get one link using css selector
        String soapUIURL = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
//        we don't have to actually click the link to see if it is broken or not
//        write a script that will go through all links in the footer and scan to see which are broken
//        we can get the status codes for navigation, if status code >= 400, the links are broken
        HttpURLConnection connecktshun = (HttpURLConnection) new URL(soapUIURL).openConnection();
        connecktshun.setRequestMethod("HEAD");
        connecktshun.connect();
        int respCode = connecktshun.getResponseCode();
        System.out.printf("Response code for soapUI link: %d\n", respCode);

        String brokenLinkURL = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        HttpURLConnection connecktshun2 = (HttpURLConnection) new URL(brokenLinkURL).openConnection();
        connecktshun2.setRequestMethod("HEAD");
        connecktshun2.connect();
        int respCode2 = connecktshun2.getResponseCode();
        System.out.printf("Response code for broken link: %d\n", respCode2);
    }
}
