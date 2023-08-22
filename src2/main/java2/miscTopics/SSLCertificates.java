package miscTopics;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificates {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        we can also set proxy (this won't work for obvious reasons)
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipAddress:4444");
        options.setCapability("proxy", proxy);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
