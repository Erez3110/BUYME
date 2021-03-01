package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import Utilities.helperMethods;
import io.qameta.allure.Step;

public class webFlows extends commonOps
{
    @Step("")
    public static void checkBalance(String code, String expiration)
    {
        uiActions.click(homePage_BUYME.giftCardBalance_btn);
        uiActions.updateText(giftCardBalance_BUYME.codeNumber_txt, code);
        helperMethods.datePicker(expiration);
        uiActions.click(giftCardBalance_BUYME.codeNumber_txt);
        uiActions.click(giftCardBalance_BUYME.checkBalance_btn);
    }
}
