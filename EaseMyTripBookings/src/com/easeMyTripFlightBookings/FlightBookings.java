/*Automate the Following Test Scenario using Locators as ID,Xpath,Name
 *1.Use TestNg/Junit Framework to Open
 *URL "https://www.easemytrip.com/flights.html"
 * 		a.Chrome Browser
 *      b.Edge Browser
 * 2.Click on "Holiday" link and then click on "Hotels"
 * 3.Verify Message in
 *         "Holidays" = 'Turn your Dream Holiday into A Reality'
 *         "Hotels" = 'Same hotel,Cheapest price.Gurenteed!'
 * 4.Count the number of links and & verify home page title name
 * 5.Run and validate
 * 6.Run and validate in Jenkins
 * 7.push code from eclipse to GIThub
 */
package com.easeMyTripFlightBookings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.Helper;

public class FlightBookings {
	WebDriver driver;
	
	@Parameters({ "browser" })
	@BeforeClass
	void setUp(String browser) {
		System.out.println("The Test is Running in Browser: "+browser);
		
		String url = "https://www.easemytrip.com/flights.html";
		//1.Launching browser and navigating to the given URL
		driver = Helper.launchBrowser(browser, url);
	}
	
	@Test
	public void bookings() {
		try {
			String actualHomePageTitl = driver.getTitle();
			
			//2.Clicking on "Holiday" links "Hotels"
			driver.findElement(By.xpath("(//div[@id='myTopnav']//following::li/a[contains(text(),'Holidays')])[1]")).click();			
			String expectedHolidayMessage = "Turn Your Dream Holiday Into A Reality";
			String actualHolidayMessage = driver.findElement(By.xpath("//div[@class='serch-box-inp']/h1")).getText();
 						
			driver.findElement(By.xpath("(//div[@id='myTopnav']//following::li/a[contains(text(),'Hotels')])[1]")).click();
			String expectedHotelsMessage = "Same hotel, Cheapest price. Guaranteed!";
			String actualHotelsMessage = driver.findElement(By.xpath("//div[@class='mid_sec_hp']/h1[@class='hp_title']")).getText();
			
			//3.Verifying Message in Hotels and Holiday
			Assert.assertEquals(expectedHolidayMessage, actualHolidayMessage);
			Assert.assertEquals(expectedHotelsMessage, actualHotelsMessage);
			
			//4.Count the number of links and printing it in console
			int linksCount = driver.findElements(By.xpath("//a")).size();
			System.out.println("Total number of Links Present are :" +linksCount);
			
			
			//5.Verifying Home page title name 
			String expectedHomePageTitle = "Flight Booking, Cheap Flights, Air tickets at Lowest Airfare Online";			
			Assert.assertEquals(expectedHomePageTitle, actualHomePageTitl);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@AfterClass
	void tearDown() {
		Helper.closeBrowser(driver);
	}

}
