package D11_seleniumWaitsCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.testBase;

import java.sql.Driver;
import java.util.Set;

public class C02_Cookies extends testBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        Set<Cookie> cookiesSet = driver.manage().getCookies();

        int no=1;

        for (Cookie eachCookie:cookiesSet) {
            System.out.println(no + ": " + eachCookie);
            no++;
        }

        int cookiesNumber = 5;

        Assert.assertTrue(cookiesSet.size()>cookiesNumber);

        String expData = "USD";
        String actData = "";
        for (Cookie eachCookie: cookiesSet) {
            if (eachCookie.getName().equals("i18n-prefs")){
                actData = eachCookie.getValue();
            }
        }

        Assert.assertEquals(expData,actData);


        Cookie myCookie = new Cookie("myCookie","chocolate");

        driver.manage().addCookie(myCookie);

        cookiesSet = driver.manage().getCookies();

        no=1;

        for (Cookie eachCookie:cookiesSet) {
            System.out.println(no + ": " + eachCookie);
            no++;
        }

        expData = "chocolate";
        actData = "";
        for (Cookie eachCookie: cookiesSet) {
            if (eachCookie.getName().equals("myCookie")){
                actData = eachCookie.getValue();
            }
        }

        Assert.assertEquals(expData,actData);

        driver.manage().deleteCookieNamed("skin");
        cookiesSet = driver.manage().getCookies();

        int skinCookie = 0;
        for (Cookie eachCookie: cookiesSet) {
            if (eachCookie.getName().equals("skin")) {
                skinCookie++;
            }
        }
        System.out.println(skinCookie);
        Assert.assertEquals(0,skinCookie);

        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();

        Assert.assertEquals(0,cookiesSet.size());

    }
}
