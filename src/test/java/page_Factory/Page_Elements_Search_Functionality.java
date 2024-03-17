package page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Elements_Search_Functionality {
	
	//Initialization of the different web elements to be used in the Step Definition file.
	
	@FindBy(xpath = "//*[@id=\"gh-ac\"]")
	WebElement search_textbox;
	
	@FindBy(id="gh-cat")
	WebElement category_dropdown;
	
	@FindBy(xpath="//*[@id=\"gh-cat\"]/option[12]")
	WebElement category_selection;
	
	@FindBy(id="gh-btn")
	WebElement search_button;
	
	@FindBy(xpath="//*[@id=\"item4d8cbf0397\"]/div/div[2]/a/div/span/span")
	WebElement first_item;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[1]/div/div[1]/div[1]/div[1]/h1")
	WebElement result_search;
	
	WebDriver driver = null;
	
	
	//Below are the various functions used to perform different actions used in the Step Definition file.
	
	//Constructor for the class.
	public Page_Elements_Search_Functionality (WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver,  this);
	}
	

	public void searchProduct()
	{
		search_textbox.sendKeys("Macbook");
	}
	
	public void clickCategoryDropdown()
	{
		category_dropdown.click();
	}
	
	public void selectCategory()
	{
		category_selection.click();
	}
	public void clickSearchButton()
	{
		search_button.click();
	}
	public String getFirstItem()
	{
		return first_item.getText();
		
	}
	public void pageLoadCheck()
	{
		String result_text = result_search.getText();
		if(result_text.contains("results for Macbook")) {
			System.out.println("Results page has loaded successfully for Macbook");
		}
		
		
	}
	
	
	// Assertion to check whether the first element in the search result has 'Macbook' present in it or not.
	
	public void checkTextOfFirstElement(String text)
	{

		if (text.contains("Macbook")) {
			System.out.println("Test Passed - The first result name matches with the search string.");
		} else {
			System.out.println("Test Failed - The first result name doesnot match with the search string.");
		}
		
	}

}
