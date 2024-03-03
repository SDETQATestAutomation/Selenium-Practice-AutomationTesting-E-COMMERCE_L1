package com.iiht.evaluation.automation;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubActivities {
    public static void check_page_load_complete(WebDriver driver) {
        Duration timeout = Duration.ofSeconds(60); // Timeout in seconds
        int interval = 10; // Retry interval in seconds
        long startTime = System.currentTimeMillis();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        while (true) {
            if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")) {
                break;
            }

            if ((System.currentTimeMillis() - startTime) >= timeout.getSeconds() * 1000) {
                // Timeout reached
                break;
            }

            try {
                TimeUnit.SECONDS.sleep(interval);
            } catch (Exception ex) {
                System.out.println("ex " + ex);
            }
        }

        // Check if the page has loaded completely
        boolean isPageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        if (isPageLoaded) {
            System.out.println("Webpage loaded completely");
        } else {
            System.out.println("Webpage not loaded completely");
        }
    }

    public static WebElement find_element_use_xpath(WebDriver driver, String xpath) {
        WebElement requiredElement = null;
        Duration timeout = Duration.ofSeconds(15);
        try {
            requiredElement = new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            return requiredElement;
        }
    }

    public static List<WebElement> find_elements_use_xpath(WebDriver driver, String xpath) {
        List<WebElement> requiredElementList = null;
        Duration timeout = Duration.ofSeconds(15);
        try {
            requiredElementList = driver.findElements(By.xpath(xpath));
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            return requiredElementList;
        }
    }

    public static boolean wait_for_element_not_present(WebDriver driver, String xpath) {
        boolean elementNotPresent = false;
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        double waitTimeout = 60.0; // Convert to floating-point number
        int retryTimeout = 5;
        int countNeeded = (int) Math.floor(waitTimeout / retryTimeout);
        try {
            for (int i = 0; i < countNeeded; i++) {
                List<WebElement> elements = driver.findElements(By.xpath(xpath));
                int allElementsLength = elements.size();
                System.out.println("all_elements_length " + allElementsLength);
                if (allElementsLength == 0) {
                    elementNotPresent = true;
                    break;
                } else {
                    Thread.sleep(retryTimeout * 1000);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return elementNotPresent;
        }
    }

    public static boolean wait_for_element_present(WebDriver driver, String xpath) {
        boolean elementPresent = false;
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        double waitTimeout = 60.0; // Convert to floating-point number
        int retryTimeout = 5;
        int countNeeded = (int) Math.floor(waitTimeout / retryTimeout);
        try {
            for (int i = 0; i < countNeeded; i++) {
                List<WebElement> allElements = driver.findElements(By.xpath(xpath));
                int allElementsLength = allElements.size();
                if (allElementsLength > 0) {
                    elementPresent = true;
                    break;
                } else {
                    Thread.sleep(retryTimeout * 1000);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return elementPresent;
        }
    }

    public static boolean wait_for_element_visible(WebDriver driver, String xpath) {
        boolean elementVisible = false;
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        double waitTimeout = 60.0; // Convert to floating-point number
        int retryTimeout = 5;
        int countNeeded = (int) Math.floor(waitTimeout / retryTimeout);
        try {
            for (int i = 0; i < countNeeded; i++) {
                List<WebElement> allElements = driver.findElements(By.xpath(xpath));
                int allElementsLength = allElements.size();
                if (allElementsLength > 0) {
                    WebElement requiredElement = allElements.get(0);
                    boolean requiredElementDisplay = requiredElement.isDisplayed();
                    System.out.println("required_element_display " + requiredElementDisplay);
                    if (requiredElementDisplay) {
                        elementVisible = true;
                        break;
                    }
                } else {
                    Thread.sleep(retryTimeout * 1000);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return elementVisible;
        }
    }

    public static boolean wait_for_element_not_visible(WebDriver driver, String xpath) {
        boolean elementNotVisible = false;
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        double waitTimeout = 60.0; // Convert to floating-point number
        int retryTimeout = 5;
        int countNeeded = (int) Math.floor(waitTimeout / retryTimeout);

        try {
            for (int i = 0; i < countNeeded; i++) {
                List<WebElement> allElements = driver.findElements(By.xpath(xpath));
                int allElementsLength = allElements.size();

                if (allElementsLength > 0) {
                    WebElement requiredElement = allElements.get(0);
                    boolean requiredElementDisplay = requiredElement.isDisplayed();
                    System.out.println("requiredElementDisplay " + requiredElementDisplay);

                    if (!requiredElementDisplay) {
                        elementNotVisible = true;
                        break;
                    }
                } else {
                    Thread.sleep(retryTimeout * 1000);
                }
            }
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            return elementNotVisible;
        }
    }

    public static void do_javascript_click(WebDriver driver, WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static void close_adds(WebDriver driver) {
        try {
            System.out.println("Closing adds");
            WebElement element = driver.findElement(By.cssSelector("#gutter > div:nth-child(1) > div > a:nth-child(1)"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Closing adds finish");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        }
    }

    public static void close_banner(WebDriver driver) {
        try {
            System.out.println("Closing banner");
            WebElement iframeElement = driver.findElement(By.xpath("//iframe[contains(@id,'google_ads')]"));
            driver.switchTo().frame(iframeElement);
            WebElement element = driver.findElement(By.cssSelector("#closeInit"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            System.out.println("Closing banner succeed");
        } catch (Exception ex) {
            System.out.println("ex " + ex);
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
	

