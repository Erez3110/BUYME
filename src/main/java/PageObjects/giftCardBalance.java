package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class giftCardBalance
{
    @FindBy(xpath = "//input[@class='textField ember-view ember-text-field']")
    public WebElement codeNumber_txt;

    @FindBy(xpath = "//input[@class='dp-input datepicker ember-view ember-text-field picker__input']")
    public WebElement expiration_txt;

    @FindBy(xpath = "//span[@class='btn orange spaceTop ']")
    public WebElement checkBalance_btn;

    @FindBy(xpath = "//span[@class='value']")
    public WebElement balance_lbl;

    @FindBy(xpath = "//div[@class='box split']/div[2]/p[2]")
    public WebElement emptyGiftCardResult_lbl;

    @FindBy(xpath = "//div[@class='text']/p")
    public WebElement cancelledGiftCardResult_lbl;
}
