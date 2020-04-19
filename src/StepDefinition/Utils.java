package StepDefinition;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils {

	 //function to get the text for the calculated field
	//This functions is used because the <div> element of the html code contains other texts that we do not need
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
    
    //function that finds the numbers and type of operation to be calculated from the text of getTextNode() function
    public static String calculatedNumber(String s) {
    	int sum = 0;
    	
    	//Here we only keep the numbers from the text and store them in an Integer Array for later calculations
    	String str = s.replaceAll("[^-?0-9]+", " ");
    	int[] numbers = Arrays.stream(str.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
    	
    	//By adding the if statement we check which operation to perform
    	//The if statement can be extended to include subtraction, multiplication and division
    	if (s.indexOf("plus") != -1) {
    	sum = IntStream.of(numbers).sum();
    	}
    	//TODO add more checks in case there are other operations line minus, devide or multiply
    	return String.valueOf(sum);
    }
    
}
