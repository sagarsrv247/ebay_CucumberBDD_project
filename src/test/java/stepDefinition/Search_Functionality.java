//Step Definition file for the second scenario. 

package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_Factory.Page_Elements_Search_Functionality;

public class Search_Functionality {

	WebDriver driver = null;
	String text;

	Page_Elements_Search_Functionality pf_search_object;

	@Given("user is on ebay website")
	public void user_is_on_ebay_website() {

		//Setting up the driver property and setting it to chrome driver. D:\\chromedriver.exe 
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
		
		//Object creation of the Page_Elements_Search_Functionality class to call the various functions built in it.

		pf_search_object = new Page_Elements_Search_Functionality(driver);

	}

	@When("user enters Macbook in Search Bar")
	public void user_enters_macbook_in_search_bar() {

		pf_search_object.searchProduct();

	}

	@And("user changes the category and click on Search")
	public void user_changes_the_category_and_click_on_search() {

		pf_search_object.clickCategoryDropdown();
		pf_search_object.selectCategory();
		pf_search_object.clickSearchButton();

	}

	@And("user verifies that the page is loaded completely.")
	public void user_verifies_that_the_page_is_loaded_completely() throws InterruptedException {

		//Waiting for the page to load completely.
		Thread.sleep(5000);
		
		//Assertion to check whether the page is loaded completely or not.
		pf_search_object.pageLoadCheck();

	}

	@Then("user first result name matches with the search string.")
	public void user_first_result_name_matches_with_the_search_string() {

		String text = pf_search_object.getFirstItem();
		
		//Final assertion function to check the text of the first searched element
		
		pf_search_object.checkTextOfFirstElement(text);
		
		driver.quit();
	}

}
