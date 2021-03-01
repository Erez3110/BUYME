package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class uiActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.click();
    }

    @Step("Send Text to TextBox")
    public static void updateText(WebElement elem, String value)
    {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//        elem.clear();
        elem.sendKeys(value);
    }

    @Step("Update DropDown")
    public static void updateDropDown(WebElement elem, String value)
    {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue = new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("Hover to Element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
}
