package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

/**
 * Created by vivekraja07 on 10/4/17.
 */
public class CarPage {
    private WebDriver driver;
    /*********************************************************************
     *Set Up
     *********************************************************************/
    public CarPage(WebDriver driver, String url) {
        this.driver = driver;
        driver.get(url);
        PageFactory.initElements(driver, this);
    }

    /*********************************************************************
     *Locators
     **********************************************************************/

    @FindBy(className = "price")
    WebElement price;

    @FindBy(id = "postingbody")
    WebElement postingBody;

    @FindBy(xpath = "/html/body/section/section/section/div[1]/p[1]/span/b")
    WebElement title;

    @FindAll({
        @FindBy(xpath = "/html/body/section/section/section/div[1]/p[2]/span")
    })
    List<WebElement> labels;

    /*********************************************************************
     *Methods
     **********************************************************************/
    @SuppressWarnings("Since15")
    public String[] toExcel() {
        String[] ret = new String[14];
        HashMap<String, String> map = getMap(labels);

        ret[0] = price.getText();
        ret[1] = title.getText();

        ret[2] = map.getOrDefault("condition: ", "");
        ret[3] = map.getOrDefault("cylinders: ", "");
        ret[4] = map.getOrDefault("drive: ", "");
        ret[5] = map.getOrDefault("fuel: ", "");
        ret[6] = map.getOrDefault("odometer: ", "");
        ret[7] = map.getOrDefault("paint color: ", "");
        ret[8] = map.getOrDefault("size: ", "");
        ret[9] = map.getOrDefault("title status: ", "");
        ret[10] = map.getOrDefault("transmission: ", "");
        ret[11] = map.getOrDefault("type: ", "");

        ret[12] = driver.getCurrentUrl();

        ret[13] = postingBody.getText();

        return ret;
    }

    /*********************************************************************
     *Private Methods
     **********************************************************************/
    private HashMap<String, String> getMap(List<WebElement> labels) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (WebElement label:labels) {
            String text = label.getText();
            int colon = text.indexOf(':');
            String key = text.substring(0, colon + 2);
            String value = text.substring(colon + 2);

            map.put(key, value);
            //System.out.println(key + " : " + value);
        }
        return map;
    }

}
