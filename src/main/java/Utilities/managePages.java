package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        homePage_BUYME = PageFactory.initElements(driver, PageObjects.homePage.class);
        giftCardBalance_BUYME = PageFactory.initElements(driver, PageObjects.giftCardBalance.class);
        datePicker_BUYME = PageFactory.initElements(driver, PageObjects.datePicker.class);
    }
}
