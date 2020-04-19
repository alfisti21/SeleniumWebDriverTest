package TestRunner;		

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;		

@RunWith(Cucumber.class)				
@CucumberOptions(features="Features",glue={"StepDefinition"})						
public class Runner 				
{		
//Runner file to initiate the test case following the steps from the .feature file
}
