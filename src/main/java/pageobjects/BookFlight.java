package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Baseclass.TestBase;

public class BookFlight extends TestBase {

public BookFlight() {

PageFactory.initElements(driver, this);
}

@FindBy(id="BE_flight_origin_city")
WebElement originCity;

@FindBy(id="BE_flight_arrival_city")
WebElement ArrivalCity;

@FindBy(id="BE_flight_origin_date")
WebElement Date;

@FindBy(xpath="//td[@data-date='28/06/2021']")
WebElement DateSelected;

@FindBy(id="BE_flight_flsearch_btn")
WebElement SearchFlights;



public void TicketBook(String Dept,String Arrive) throws InterruptedException {

originCity.click();
Thread.sleep(2000);
originCity.sendKeys(Dept);
Thread.sleep(2000);
originCity.sendKeys(Keys.ENTER);
Thread.sleep(2000);
ArrivalCity.sendKeys(Arrive);
Thread.sleep(2000);
ArrivalCity.sendKeys(Keys.ENTER);
Thread.sleep(2000);
Date.click();
Thread.sleep(2000);
DateSelected.click();
Thread.sleep(2000);
SearchFlights.click();
Thread.sleep(2000);
}
  
}
