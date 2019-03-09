package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Excel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vivekraja07 on 7/16/17.
 */
public class HomePage {
    //instance variables
    private WebDriver driver;
    private String url = "https://atlanta.craigslist.org/search/cto";

    /*********************************************************************
     *Set Up
     *********************************************************************/
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    /*********************************************************************
     *Locators
     **********************************************************************/

    @FindAll({
            @FindBy(xpath = "//*[@id=\"sortable-results\"]/ul/li/a")
    })
    private List<WebElement> cars;



    /*********************************************************************
    *Methods
    **********************************************************************/
    public ArrayList<String> traverse() {
        ArrayList<String> carLinks = new ArrayList<String>();
        for (WebElement car:cars) {
            carLinks.add(car.getAttribute("href"));
        }
        return carLinks;
    }

    public void sampleExcelWrite() {
        String[] valueToWrite = {"Toyota", "New", "4", "Automatic", "Fuel",
                "3.65", "White", "332", "New", "Manual", "kjj", "asdfasdf", "not here"};

        Excel excel = new Excel();
        String filePath = "/Users/vivekraja07/Desktop/Craigslist/";

        try {
            excel.writeExcel(filePath, "craig.xlsx", "Sheet1", valueToWrite);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }



}
