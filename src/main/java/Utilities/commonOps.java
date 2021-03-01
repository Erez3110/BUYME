package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("Configuration\\dataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
            catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
            doc.getDocumentElement().normalize();
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid platform name stated");
        driver.manage().window().maximize();
        driver.get(getData("url"));
        wait = new WebDriverWait(driver,Long.parseLong(getData("timeout")));
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    @BeforeClass
    public void startSession()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            initBrowser(getData("browser"));
        else
            throw new RuntimeException("Invalid platform name stated");
        managePages.init();
        try
        {
            helperMethods.closePopup();
        }
        catch(Exception e)
        {
            System.out.println("There was no Pop Up");
        }
    }

    @AfterMethod
    public void afterMethod()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession()
    {
        if(getData("platformType").equalsIgnoreCase("web"))
            driver.quit();
    }
}
