package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class datePicker
{
    @FindBy(className = "picker__select--year")
    public WebElement year_dropDown;

    @FindBy(className = "picker__select--month")
    public WebElement month_dropDown;

    @FindBy(xpath = "//table[@class='picker__table']/tbody/tr/td")
    public List<WebElement> day_list;
}
