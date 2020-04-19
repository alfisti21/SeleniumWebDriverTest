package StepDefinition;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;	

public class Steps {
	String message, numbersInText;
	WebDriver driver;
	
	
    @Given("^Open the browser and launch the website$")				
    public void open_the_browser_and_launch_the_website() throws Throwable							
    {
    	//Comment out the browser you don't want to use. Don't forget to manage the imports section
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\alfis\\eclipse-workspace\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\alfis\\eclipse-workspace\\geckodriver.exe");	
        
    	//Comment out the browser you don't want to use. Don't forget to manage the imports section
    	driver= new ChromeDriver();
    	//driver= new FirefoxDriver();
    	
        driver.manage().window().maximize();			
        driver.get("https://www.solaredge.com/us/contact/qa_automation_test");					
    }		

    @When("^Fill in sample data and submit$")					
    public void fill_sample_data_and_submit() throws Throwable 							
    {
    	//Here below we fill the form with sample data
    	
    	driver.findElement(By.id("edit-name")).sendKeys("Angelos Ladopoulos");
    	driver.findElement(By.id("edit-mail")).sendKeys("ladopoulos@hotmail.com");
    	driver.findElement(By.id("edit-subject-0-value")).sendKeys("Roof Solar Panels");
    	driver.findElement(By.id("edit-message-0-value")).sendKeys("How much will it cost to cover 10 square meters of a roof with solar panes?");
    	//Select country from dropdown list
    	Select dropdown1 = new Select(driver.findElement(By.name("field_client_address[0][address][country_code]")));
    	dropdown1.selectByValue("US");
    	//Wait 1 second because when US is selected the remaining form is dynamically changed
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-given-name')]")).sendKeys("Angelos");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-family-name')]")).sendKeys("Ladopoulos");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-address-line1')]")).sendKeys("Street 1");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-locality')]")).sendKeys("City 1");
    	//Select state from dropdown list
    	Select dropdown2 = new Select(driver.findElement(By.name("field_client_address[0][address][administrative_area]")));
    	dropdown2.selectByValue("AL");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-postal-code')]")).sendKeys("35004");    	
    	driver.findElement(By.id("edit-field-number-0-value")).sendKeys(Utils.calculatedNumber(driver.findElement(By.id("edit-field-number-wrapper")).getText()));
    	driver.findElement(By.id("edit-field-phone-0-value")).sendKeys("0682956477");    	
    	
    	//Submit the form
    	driver.findElement(By.id("edit-submit")).click();
    	
    	//Wait 1 second so we are sure that the submission message appeared
    	Thread.sleep(1000);    	
    	
    	//Save message
    	message = Utils.getTextNode(driver.findElement(By.xpath("//div[contains(@class, 'alert alert')]")));
    	
    }		

    @Then("^Check for Success message$")					
    public void check_for_success_message() throws Throwable 							
    {
    	assertEquals("Successfully submitted", message);
    }	
    
    @And("^Close the browser$")
    public void close_the_browser() throws Throwable {
    	//Close the browser
        driver.quit();
    }
    
}