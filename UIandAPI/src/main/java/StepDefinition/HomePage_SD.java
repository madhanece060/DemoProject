package StepDefinition;

import BaseClass.BrowserConfig;
import io.cucumber.java.en.Given;

public class HomePage_SD extends BrowserConfig {
	
	@Given("Launch the url")
	public void launchUrl() {
		System.out.println("Hello");
		startApp("chrome", "https://reqres.in");
	}
	
	

}
