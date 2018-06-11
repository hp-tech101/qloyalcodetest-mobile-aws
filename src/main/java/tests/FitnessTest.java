package tests;

import base.TestInit;
import initialize.Settings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import screens.DashboardScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.LogoutScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class FitnessTest extends TestInit {
    String fitusername="himanshu.tech101@gmail.com";
    String fitpassword="Eminence17$$18";

   // @Test
    public void launchApp() {
    if(androidDriver!=null) {
        System.out.println("DRIVER SET SUCCESSFULLY");
        HomeScreen homeScreen = new HomeScreen(androidDriver);
        LoginScreen loginScreen= homeScreen.goToLoginPage();
        DashboardScreen dashboardScreen= loginScreen.login(fitusername,fitpassword);
        LogoutScreen logoutScreen= dashboardScreen.goToLogoutPage();
        HomeScreen homeScreen2= logoutScreen.logout();

//        Assert.assertTrue(homeScreen2.isPageLoaded(),"Login Functionality Works as Expected");

    } else {
        System.out.println("DRIVER SET FAILED");
    }

    }
}
