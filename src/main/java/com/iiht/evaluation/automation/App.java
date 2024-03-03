package com.iiht.evaluation.automation;


import com.iiht.evaluation.automation.testutils.xls.Xls_Reader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class App {
    public static WebDriver driver = null;
    public static Xls_Reader test_data_xls=null;


    @BeforeClass
    public static void setup() {
        System.out.println("\nBefore method setup");
        test_data_xls=new Xls_Reader(System.getProperty("user.dir")+"/src/test/java/com/iiht/evaluation/automation/testdata/TestSuite.xlsx");
        String req_chrome_driver_path = System.getProperty("user.dir") + "/binaries/chromedriver.exe";
        System.out.println(req_chrome_driver_path);
        String base_url = "http://practice.automationtesting.in/";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-cross-origin-auth-prompt");
        options.addArguments("--allow-control-allow-origin");
        options.addArguments("-–allow-file-access-from-files");
        options.addArguments("--test-type");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--lang=en");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9223");

        Map<String, Object> loggingPrefs = new HashMap<>();
        loggingPrefs.put("driver", "INFO");
        loggingPrefs.put("server", "OFF");
        loggingPrefs.put("browser", "INFO");
        options.setCapability("goog:loggingPrefs", loggingPrefs);
        options.setCapability("acceptInsecureCerts", true);

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(req_chrome_driver_path)).build();
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get(base_url);
        SubActivities.check_page_load_complete(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
