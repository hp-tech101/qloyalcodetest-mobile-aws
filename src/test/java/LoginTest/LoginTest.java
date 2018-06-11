package LoginTest;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.DashboardScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.LogoutScreen;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {

    String emulator="Nexus_5X_API_25_MTI";
    String host="0.0.0.0";
    int port=4723;
    String fitusername="himanshu.tech101@gmail.com";
    String fitpassword="Eminence17$$18";

    @Test
    public void appLoginTest() throws MalformedURLException {

   //     File f = new File("src");
   //     File fs = new File(f,"fitbit_v2.6.0.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
   /*     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,emulator);
        capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());

        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "com.fitbit.*");
*/
        AndroidDriver driver =
                new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        System.out.println("DRIVER SET SUCCESSFULLY");
        HomeScreen homeScreen = new HomeScreen(driver);
        LoginScreen loginScreen= homeScreen.goToLoginPage();
        DashboardScreen dashboardScreen= loginScreen.login(fitusername,fitpassword);
        LogoutScreen logoutScreen= dashboardScreen.goToLogoutPage();
        HomeScreen homeScreen2= logoutScreen.logout();

        Assert.assertTrue(homeScreen2.isPageLoaded(),"Login Functionality Works as Expected");


    }
}
