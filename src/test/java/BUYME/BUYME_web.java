package BUYME;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class BUYME_web extends commonOps
{
    @Test(description = "Full Gift Card Balance")
    @Description("Check the Balance of a Full Gift Card")
    public void test01_FullGiftCardBalance()
    {
        webFlows.checkBalance("73600-67086-66223", "08/10/2023");
        verifications.textInElement(giftCardBalance_BUYME.balance_lbl,"20");
    }

    @Test(description = "Used Gift Card Balance")
    @Description("Check the Balance of a Partially Used Gift Card")
    public void test02_UsedGiftCardBalance()
    {
        webFlows.checkBalance("39100-67086-84904", "08/10/2023");
        verifications.textInElement(giftCardBalance_BUYME.balance_lbl,"8");
    }

    @Test(description = "Empty Gift Card Balance")
    @Description("Check the Balance of a Empty Gift Card")
    public void test03_EmptyGiftCardBalance()
    {
        webFlows.checkBalance("18800-67086-87822", "08/10/2023");
        verifications.textInElement(giftCardBalance_BUYME.emptyGiftCardResult_lbl,"ה-Gift Card מומש במלואו, מקווים שנהנית!");
    }

    @Test(description = "Cancelled Gift Card Balance")
    @Description("Check the Balance of a Cancelled Gift Card")
    public void test04_CancelledGiftCardBalance()
    {
        webFlows.checkBalance("27800-67087-06360", "08/10/2023");
        verifications.textInElement(giftCardBalance_BUYME.cancelledGiftCardResult_lbl,"לבדיקת יתרת ה-Gift Card↵אנא צרו קשר עם שירות הלקוחות שלנו↵בטלפון 03-3737117↵או במייל support@buyme.co.il");
    }
}
