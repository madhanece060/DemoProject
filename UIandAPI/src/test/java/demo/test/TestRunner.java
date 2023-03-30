package demo.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions 
(
		plugin = { "pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumberreport.html"},
		dryRun = false,
		features= {"src/main/java/Feature"},
		glue= {"StepDefinition"},
		publish = true,
		tags = "@Demo"
		
		)
 


public class TestRunner {

}
