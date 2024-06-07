package utils;

import managers.FileReaderManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public WebDriver driver;
    public List<Dimension> screenDimensionsList;
    public long implicitWait;
    public long pageLoadTimeout;

    public WebDriver initializeDriver() {
        if (driver == null) {
            if (FileReaderManager.getInstance().getConfigReader().getBrowser().equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (FileReaderManager.getInstance().getConfigReader().getBrowser().equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (FileReaderManager.getInstance().getConfigReader().getBrowser().equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            } else if (FileReaderManager.getInstance().getConfigReader().getBrowser().equalsIgnoreCase("Headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-pop-blocking");
                options.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (FileReaderManager.getInstance().getConfigReader().getBrowser().equalsIgnoreCase("Iphone")) {
                screenDimensionsList = new ArrayList<Dimension>();
                screenDimensionsList.add(new Dimension(375, 667));
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                driver = new ChromeDriver();
                for (Dimension d : screenDimensionsList) {
                    driver.manage().window().setSize(d);
                }
            }
        }
        implicitWait = FileReaderManager.getInstance().getConfigReader().getImplicitWait();
        pageLoadTimeout = FileReaderManager.getInstance().getConfigReader().getPageLoadTimeout();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().deleteAllCookies();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

        return driver;
    }
}
