//Step Definition file for the first scenario. 

package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_Factory.Page_Elements_Filter_Functionality;


public class Filter_Functionality {
	
	static WebDriver driver = null;
	
	 Page_Elements_Filter_Functionality pe_filter_object;

	@Given("user is on ebay website page")
	public void user_is_on_ebay_website_page() {
		
		//Setting up the driver property and setting it to chrome driver.
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		driver.manage().window().maximize();
		
		//Object creation of the Page_Elements_Filter_Functionality class to call the various functions built in it.
		
		pe_filter_object =  new Page_Elements_Filter_Functionality(driver);

	}
	
	@When("user navigates to Search")
	public void user_navigates_to_search() {
		
		pe_filter_object.catergory_search_dropdown_click();
		pe_filter_object.cell_phone_accessories_click();

	}

	@And("user clicks on Cell Phones & Smartphones")
	public void user_clicks_on_cell_phones_smartphones() {
		
		pe_filter_object.cell_phone_smartphones_click();

	}

	@And("user clicks on All Filters")
	public void user_clicks_on_all_filters() throws InterruptedException {
		
		
		pe_filter_object.all_filters_click();
		//Thread.sleep(10000);

	}

	@And("user add three filters - Condition, Price and Item location")
	public void user_add_three_filters_condition_price_and_item_location() throws InterruptedException {
		
		pe_filter_object.condition_filter_click();
		Thread.sleep(5000);
		
		pe_filter_object.condition_selection_click();
		Thread.sleep(5000);
		
		pe_filter_object.price_filter_click();
		Thread.sleep(5000);
		
		pe_filter_object.price_lower_range_input();
		Thread.sleep(5000);
		
		pe_filter_object.price_upper_range_input();
		Thread.sleep(5000);
		
		pe_filter_object.location_filter_click();
		Thread.sleep(5000);
		
		pe_filter_object.location_selection_click();
		Thread.sleep(5000);
		
		pe_filter_object.apply_button_click();
		Thread.sleep(5000);
		
		

	}

	@Then("verify the filter tags are applied.")
	public void verify_the_filter_tags_are_applied() {
		
		
		pe_filter_object.selected_filter_dropdown_click();
		
		//Final assertion function
		pe_filter_object.selected_filters_check();
		
		driver.close();
		

	}
	



}
