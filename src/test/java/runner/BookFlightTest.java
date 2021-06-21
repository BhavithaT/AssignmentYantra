package runner;

import org.testng.annotations.Test;
import Baseclass.TestBase;
import pageobjects.BookFlight;

public class BookFlightTest extends TestBase
{
	@Test(dataProvider="CitiesData")
	public void BookingTickets(String Dept,String Arrive) throws InterruptedException {

	BookFlight bf=new BookFlight();
	bf.TicketBook(Dept, Arrive);

	}
}
