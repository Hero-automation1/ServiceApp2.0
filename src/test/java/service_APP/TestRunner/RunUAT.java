package service_APP.TestRunner;
//import org.junit.runner.RunWith;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {".//Features/ServiceAppSecurityGuard.feature"},
		glue="service_APP.StepDefinition",
		dryRun = false,				// if check test case method present or not as per feature file
		monochrome = true,
		tags = "@UAT",       //scenarios under @sanity tag will be executed "@AdminLogin or @Sanity", 
		plugin = {"summary",
				  "html:Reports/cucumber_reports.html",
		          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)


//plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
//		plugin = {"pretty","json:target/cucumber-reports/report_json.json"}

public class RunUAT extends AbstractTestNGCucumberTests{
	/*This class will be empty*/
}
