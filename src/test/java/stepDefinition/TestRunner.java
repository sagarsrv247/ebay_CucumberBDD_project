//Test Runner file for orchestration of the complete project.

package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Scenarios.feature", glue= {"stepDefinition"}, monochrome = true,

//To generate the final reports in Pretty, JSON and HTML format.

plugin={"pretty","junit:target/JunitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HTMLReports/report.html"})
public class TestRunner {
	
	//Dummy Class created for java application execution(if needed).

}