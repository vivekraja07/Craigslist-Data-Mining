package selenium;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CarPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        /*********************************************************************
         *Set Up
         *********************************************************************/
        System.setProperty("webdriver.chrome.driver",
         "/Users/vivekraja07/Desktop/Craigslist/CraigsListSelenium/chromedriver");
        WebDriver driver = new ChromeDriver();


        HomePage homepage = new HomePage(driver);
        ArrayList<String> carLinks = homepage.traverse();
        System.out.println(carLinks.size());
        //System.out.println(carLinks.toString());
        CarPage car = new CarPage(driver, carLinks.get(0));
        System.out.println(Arrays.toString(car.toExcel()));

        //homepage.sampleExcelWrite();

//
//        try {
//            Thread.sleep(5000);
//        }
//        catch(Exception e) {
//
//        }
//

        //CarPage car = new CarPage(driver, "https://atlanta.craigslist.org/atl/cto/d/1999-honda-accord/6315478906.html");
        //System.out.println(Arrays.toString(car.toExcel()));



        driver.quit();

    }
}
