package Baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import Excelutil.BookFlightExcelUtil;
import utility.TestUtility;

public class TestBase extends TestUtility
{
	public static  WebDriver driver;
	public static Properties prop;

	public TestBase(){

	try {
	prop = new Properties();
	FileInputStream ip=new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\YatraAssign\\src\\main\\java\\Config\\config.properties");
	prop.load(ip);
	}catch(FileNotFoundException e){
	e.printStackTrace();
	}catch(IOException e) {
	e.printStackTrace();
	}
}
    @BeforeClass
	public static void initalization() throws InterruptedException {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");

	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	driver=new ChromeDriver(options);
	}else if(browserName.equals("FF")){
	System.setProperty("webdriver.gecko.driver", "F:\\ChromeDriver\\geckodriver.exe");
	driver=new FirefoxDriver();
	}

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);

	driver.get(prop.getProperty("url"));
	Thread.sleep(2000);
	//driver.findElement(By.xpath("(//button[text()='Get Started'])[2]")).click();

	}

	@DataProvider
	public Iterator<Object[]> CitiesData()
	    {
	ArrayList<Object[]> testdata=BookFlightExcelUtil.getDataFromExcel();
	return testdata.iterator();
	}
}
