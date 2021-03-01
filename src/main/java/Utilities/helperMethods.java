package Utilities;

import Extensions.uiActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElem, String imageName)
    {
        imageScreenShot = new AShot().coordsProvider((new WebDriverCoordsProvider())).takeScreenshot(driver,imageElem); //win 10
        //imageScreenShot = new AShot().takeScreenshot(driver,imageElem); //win 7
        try
        {
            ImageIO.write(imageScreenShot.getImage(),"png", new File(getData("imageRepo") + imageName + ".png"));

        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details: " + e);
        }
    }

    public static void closePopup()
    {
        wait.until(ExpectedConditions.visibilityOf(homePage_BUYME.closePopup_btn));
        uiActions.click(homePage_BUYME.closePopup_btn);
    }

    public static void datePicker(String date) // Date Format: dd/mm/yyyy
    {
        String[] dateParts = date.split("/");
        if(Integer.parseInt(dateParts[0]) < 10)
        {
            dateParts[0] = String.valueOf(dateParts[0].charAt(1));
        }
        uiActions.click(giftCardBalance_BUYME.expiration_txt);
        Select month = new Select(datePicker_BUYME.month_dropDown);
        month.selectByValue(String.valueOf((Integer.parseInt(dateParts[1])-1)));
        Select year = new Select(datePicker_BUYME.year_dropDown);
        year.selectByVisibleText(dateParts[2]);
        for (WebElement day:datePicker_BUYME.day_list)
        {
            if(day.getText().equalsIgnoreCase(dateParts[0]))
            {
                action.moveToElement(day).click().build().perform();
                break;
            }
        }
    }
}
