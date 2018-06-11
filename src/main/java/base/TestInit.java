package base;

import initialize.ConfigReader;
import initialize.Settings;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestInit {
    protected WebDriver androidDriver;
   // @BeforeClass
    public void beforeTests() {

        try {
            ConfigReader.PopulateSettings();
        } catch (IOException e) {
            System.out.println("Problem reading env_config.properties");
        }

        DesiredCapabilities capabilities = Settings.capabilities;

        try {
            androidDriver =
                    new AndroidDriver(new URL(Settings.url),capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Problem with initializing androidDriver");
        }

    }
}
