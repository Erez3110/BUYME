package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage
{
    @FindBy(xpath = "//ul[@class=\"nav-bar buttons\"]/li[2]/a")
    public WebElement giftCardBalance_btn;

    @FindBy(xpath = "//div[@class=\"adoric_element element-shape closeLightboxButton editing\"]")
    public WebElement closePopup_btn;
}
