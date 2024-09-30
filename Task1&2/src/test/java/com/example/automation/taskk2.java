package com.example.automation;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class taskk2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize the window
        driver.manage().window().maximize();
    }

    @Test
    public void testBusBooking() {
        // Step 1: Open KSRTC website
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");

        // Step 2: Choose from "CHIKKAMAGALURU" to "BENGALURU"
        wait.until(ExpectedConditions.elementToBeClickable(By.id("fromPlaceName"))).sendKeys("CHIKKAMAGALURU");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Chikkamagaluru')]"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("toPlaceName"))).sendKeys("BENGALURU");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Bengaluru')]"))).click();

        // Step 3: Choose the arrival date
        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtJourneyDate"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(@class, 'ui-datepicker-current-day')]"))).click();

        // Step 4: Click "Search for bus"
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchBtn"))).click();

        // Step 5: Select a seat
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'seat')]"))).click();

        // Step 6: Choose boarding and dropping points
        wait.until(ExpectedConditions.elementToBeClickable(By.id("boardingPoint"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Select Boarding Point')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("droppingPoint"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), 'Select Dropping Point')]"))).click();

        // Step 7: Fill the "Customer" and "Passenger" details
        wait.until(ExpectedConditions.elementToBeClickable(By.id("customerMobileNumber"))).sendKeys("6789125987");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("customerName"))).sendKeys("John Doe");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("customerEmail"))).sendKeys("johndoe@example.com");

        // Step 8: Click on "make payment" (not submitting payment)
        wait.until(ExpectedConditions.elementToBeClickable(By.id("makePaymentBtn"))).click();

        // Fill payment fields without submitting
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentCardNumber"))).sendKeys("4111111111111111");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentExpiryDate"))).sendKeys("12/25");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("paymentCVC"))).sendKeys("123");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
