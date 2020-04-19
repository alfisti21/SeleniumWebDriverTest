package StepDefinition;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utils {

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
