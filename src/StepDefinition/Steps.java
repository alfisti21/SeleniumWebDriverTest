package StepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;	

public class Steps {
	String message, numbersInText;
	WebDriver driver;

     
    @Given("^Open the FireFox and launch the website$")				
    public void open_the_Firefox_and_launch_the_website() throws Throwable							
    {
    	//Comment out the browser you don't want to use
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\alfis\\eclipse-workspace\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver", "C:\\Users\\alfis\\eclipse-workspace\\geckodriver.exe");	
        
    	//Comment out the browser you don't want to use
    	driver= new ChromeDriver();
    	//driver= new FirefoxDriver();
    	
        driver.manage().window().maximize();			
        driver.get("https://www.solaredge.com/us/contact/qa_automation_test");					
    }		

    @When("^Fill in sample data and submit$")					
    public void fill_sample_data_and_submit() throws Throwable 							
    {		
    	driver.findElement(By.id("edit-name")).sendKeys("Angelos Ladopoulos");
    	driver.findElement(By.id("edit-mail")).sendKeys("ladopoulos@hotmail.com");
    	driver.findElement(By.id("edit-subject-0-value")).sendKeys("Roof Solar Panels");
    	driver.findElement(By.id("edit-message-0-value")).sendKeys("How much will it cost to cover 10 square meters of a roof with solar panes?");
    	Select dropdown1 = new Select(driver.findElement(By.id("edit-field-client-address-0-address-country-code--2")));
    	dropdown1.selectByValue("US");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-given-name')]")).sendKeys("Angelos");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-family-name')]")).sendKeys("Ladopoulos");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-address-line1')]")).sendKeys("Street 1");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-locality')]")).sendKeys("City 1");
    	Select dropdown2 = new Select(driver.findElement(By.name("field_client_address[0][address][administrative_area]")));
    	dropdown2.selectByValue("AL");
    	driver.findElement(By.xpath("//input[contains(@id, 'edit-field-client-address-0-address-postal-code')]")).sendKeys("35004");    	
    	driver.findElement(By.id("edit-field-number-0-value")).sendKeys(calculatedNumber(driver.findElement(By.id("edit-field-number-wrapper")).getText()));
    	driver.findElement(By.id("edit-field-phone-0-value")).sendKeys("0682956477");    	
    	
    	driver.findElement(By.id("edit-submit")).click();
    	
    	Thread.sleep(2000);    	
    	
    	message = getTextNode(driver.findElement(By.xpath("//div[contains(@class, 'alert alert')]")));
    	
    }		

    @Then("^Check for Success message$")					
    public void check_for_success_message() throws Throwable 							
    {
    	System.out.println(message);
    	assertEquals("Successfully submitted", message);
    }	
    
    //function to get the text for the calculated field
    public static String getTextNode(WebElement e)
    {
        String text = e.getText().trim();
        List<WebElement> children = e.findElements(By.xpath("./*"));
        for (WebElement child : children)
        {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }
    
    //function that finds the numbers and type of operation to be calculated
    public static String calculatedNumber(String s) {
    	int sum = 0;
    	
    	//By adding the if statement we check which operation to perform
    	//The if statement can be extended to include subtraction, multiplication and division
    	if (s.indexOf("plus") != -1) {
    	String str = s.replaceAll("[^-?0-9]+", " ");
    	int[] numbers = Arrays.stream(str.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    	sum = IntStream.of(numbers).sum();
    	}
    	return String.valueOf(sum);
    }

}