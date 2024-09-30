package com.example.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class task1 {
	private WebDriver driver;
	private WebDriverWait wait;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		driver.manage().window().maximize(); // Maximize the window for better visibility

	}

	@Test(priority = 1)
	public void testScenario1() throws InterruptedException {

		driver.get("https://www.amazon.eg");
		// Scenario 1: Search for car accessories, add to cart, and verify in cart


		Thread.sleep(1000); // Wait for the page to load
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("car accessories");
		searchBox.submit();

		Thread.sleep(1000); // Wait for search results to load
		WebElement firstItem = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[1]/h2/a/span"));
		firstItem.click();

		// Add item to cart
		Thread.sleep(1000); // Wait for the item page to load
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();

		// Go to cart and verify item is added
		WebElement cartLink = driver.findElement(By.id("nav-cart"));
		cartLink.click();

		Thread.sleep(1000); // Wait for the cart page to load
		WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-item-content"));
		Assert.assertTrue(cartItem.isDisplayed(), "Item is not added to the cart");
	}

	@Test(priority = 2)
	public void testScenario2() throws InterruptedException {
		driver.get("https://www.amazon.com");
		// Scenario 2: Open today's deals, filter and add an item to the cart
		WebElement todaysDeals = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]"));
		todaysDeals.click();
		Thread.sleep(1000);
		// Choose "10% off or more" discount filter
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-a-input-name='percentOff' and @data-csa-c-element-id='filter-percentOff-10% off or more']/label"))).click();
		Thread.sleep(1000);
		// Wait for the "See More" button and click it
		WebElement hyperlink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See more")));
		hyperlink.click();	
		Thread.sleep(1000);

		//Select "Grocery and Gourmet Food" filter from the left side
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Grocery & Gourmet Food']"))).click();
		Thread.sleep(1000);

		// Wait for the page to load results
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'results for')]")));


		//Select the first item in the results
		WebElement firstItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[41]/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div[2]/div/div/div[3]/div/a/p/span/span/span[2]")));
		firstItem.click();

		// Add item to cart
		Thread.sleep(1000); // Wait for the item page to load
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();

		// Go to cart and verify item is added
		WebElement cartLink = driver.findElement(By.id("nav-cart"));
		cartLink.click();

		Thread.sleep(1000); // Wait for the cart page to load
		WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-item-content"));
		Assert.assertTrue(cartItem.isDisplayed(), "Item is not added to the cart");

	}
	@Test(priority = 3)
	public void testScenario3() throws InterruptedException {
		driver.get("https://www.amazon.com");
		// Scenario 2: Open today's deals, filter and add an item to the cart
		WebElement todaysDeals = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]"));
		todaysDeals.click();
		Thread.sleep(1000);
		//Choose "10% off or more" discount filter
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-a-input-name='percentOff' and @data-csa-c-element-id='filter-percentOff-10% off or more']/label"))).click();
		Thread.sleep(1000);
		// Wait for the "See More" button and click it
		WebElement hyperlink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("See more")));
		hyperlink.click();	
		Thread.sleep(1000);
		//Select the Electronics filter
		WebElement electronicsFilter = driver.findElement(By.xpath("//h4[contains(text(), 'Electronics')]//following-sibling::div//input[@type='checkbox']"));
		electronicsFilter.click();
		Thread.sleep(1000);
		// Select the Headphones filter
		WebElement headphonesFilter = driver.findElement(By.xpath("//h4[contains(text(), 'Headphones')]//following-sibling::div//input[@type='checkbox']"));
		headphonesFilter.click();

		// Wait for the page to load results
		Thread.sleep(1000);
		// Select the first item from the filtered results
		WebElement firstItem = driver.findElement(By.xpath("//div[@data-component-type='s-search-result'][1]//h2/a"));
		firstItem.click();

		// Wait for the item page to load
		Thread.sleep(1000);
		
		// Add item to cart
		Thread.sleep(1000); // Wait for the item page to load
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		addToCartButton.click();

		// Go to cart and verify item is added
		WebElement cartLink = driver.findElement(By.id("nav-cart"));
		cartLink.click();

		Thread.sleep(1000); // Wait for the cart page to load
		WebElement cartItem = driver.findElement(By.cssSelector(".sc-list-item-content"));
		Assert.assertTrue(cartItem.isDisplayed(), "Item is not added to the cart");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
