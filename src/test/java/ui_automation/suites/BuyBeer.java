package ui_automation.suites;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ui_automation.support.Core;

import static ui_automation.objects.UiEnvironment.*;

public class BuyBeer extends Core {

    @Before
    public void befores()
    {
        createWebDriver();
    }

    @After
    public void after()
    {
        killWebDriver();
    }

    @Test
    public void buyBeerNavigation() {
        navigate(url);
        click(ageButton);
        click(signInButton);
        click(loginWithEmail);
        send(emailInput, "Your email");
        send(passwordInput, "Your Password");
        click(loginButton);
        click(beerClass);
        click(chooseBecksBeers);
        click(chooseBecks275ml);
        click(chooseSixUnities);
        click(addBeers);
        click(finishOrderButton);
        click(paymentFormButton);
        click(creditOrDebit);
        //click(finishPurchaseButton);
        sleep(10000);
    }
}
