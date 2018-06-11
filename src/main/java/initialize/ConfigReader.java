package initialize;

import common.Capability;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;


public class ConfigReader {

	public static void PopulateSettings() throws IOException {
		ConfigReader reader = new ConfigReader();
		reader.ReadProperty();
	}
	
	private void ReadProperty() throws IOException {
		Properties p = new Properties();
//		p.load(getClass().getResourceAsStream("./src/main/resources/config/env_config.properties"));
		File f = new File("./src/main/resources/config/env_config.properties");
		if(f.exists()) {
			System.out.println("config file found");
			p.load(new FileInputStream(f));
		} else {
			System.out.println("config file not found");
		}

		
		Settings.env = p.getProperty("currentEnv");
		//Settings.host = p.getProperty(Settings.env+"_host");
		//Settings.port = p.getProperty(Settings.env+"_port");
		Settings.url = p.getProperty(Settings.env+"_host")+":"+p.getProperty(Settings.env+"_port");
		Settings.capabilities = (new Capability(Settings.env,p.getProperty("desiredCapabilityConfigFile"))).getDesiredCapabilities();
		
	}
}

/*

	currentEnv=local
	desiredCapability=./src/main/resources/config/desiredcapabilities/capability.xml

#--credentials
	sauce.username=himanshu-tech101
	sauce.accesskey=bdd8e6ef-c1bc-495a-abe6-59e9f853a4f4

#--local
			local_host=http://127.0.0.1
	local_port=4723/wd/hub

#--sauce
			sauce_host=https://himanshu-tech101:bdd8e6ef-c1bc-495a-abe6-59e9f853a4f4@ondemand.saucelabs.com
	sauce_port=443/wd/hub
*/
