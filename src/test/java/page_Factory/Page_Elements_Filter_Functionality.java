package page_Factory;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Elements_Filter_Functionality {

	// Initialization of the different web elements to be used in the Step
	// Definition file.

	@FindBy(id = "gh-shop-ei")
	WebElement category_search;

	@FindBy(linkText = "Cell phones & accessories")
	WebElement cell_phones_accessories;

	@FindBy(linkText = "Cell Phones & Smartphones")
	WebElement cell_phones_smartphones;

	@FindBy(xpath = "//*[@id=\"s0-28_2-9-0-1[0]-0-0\"]/section/ul[1]/li[9]/button")
	WebElement all_filters_button;

	@FindBy(xpath = "//*[@id=\"c3-mainPanel-condition\"]")
	WebElement condition_filter;

	@FindBy(xpath = "//*[@id=\"c3-subPanel-LH_ItemCondition_New\"]/span/label/span")
	WebElement condition_selection;

	@FindBy(xpath = "//*[@id=\"c3-mainPanel-price\"]")
	WebElement price_filter;

	@FindBy(xpath = "//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[1]/div/input")
	WebElement price_filter_lower_range;

	@FindBy(xpath = "//*[@id=\"c3-subPanel-_x-price-textrange\"]/div/div[2]/div/input")
	WebElement price_filter_upper_range;

	@FindBy(xpath = "//*[@id=\"c3-mainPanel-location\"]")
	WebElement location_filter;

	@FindBy(xpath = "//*[@id=\"c3-subPanel-location_Worldwide\"]/span/span/input")
	WebElement location_selection;

	@FindBy(xpath = "//*[@id=\"x-overlay__form\"]/div[3]/div[2]/button")
	WebElement apply_button;

	@FindBy(xpath = "//*[@id=\"s0-28_1-9-0-1[0]-0-0-6-8-4[0]-flyout\"]/button")
	WebElement selected_filter_dropdown;

	@FindBy(xpath = "//*[@id=\"s0-28_1-9-0-1[0]-0-0-6-8-4[0]-flyout\"]/div/ul/li[1]/a/span[1]")
	WebElement selected_filter_condition;

	@FindBy(xpath = "//*[@id=\"s0-28_1-9-0-1[0]-0-0-6-8-4[0]-flyout\"]/div/ul/li[2]/a/span[1]")
	WebElement selected_filter_price;

	@FindBy(xpath = "//*[@id=\"s0-28_1-9-0-1[0]-0-0-6-8-4[0]-flyout\"]/div/ul/li[3]/a/span[1]")
	WebElement selected_filter_location;

	WebDriver driver = null;

	// Constructor for the class.

	public Page_Elements_Filter_Functionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Below are the various functions used to perform different actions used in the Step Definition file.

	public void catergory_search_dropdown_click() {
		category_search.click();
	}

	public void cell_phone_accessories_click() {
		cell_phones_accessories.click();
	}

	public void cell_phone_smartphones_click() {
		cell_phones_smartphones.click();
	}

	public void all_filters_click() {
		all_filters_button.click();
	}

	public void condition_filter_click() {
		
		//Explicit wait used for the all filter panel as the time to open varies every time.
		explicit_wait(driver, condition_filter, Duration.ofSeconds(10)); 
		condition_filter.click();

	}

	public void condition_selection_click() {

		condition_selection.click();
	}

	public void price_filter_click() {
		price_filter.click();
	}

	public void price_lower_range_input() {
		price_filter_lower_range.sendKeys("100");
	}

	public void price_upper_range_input() {
		price_filter_upper_range.sendKeys("300");
	}

	public void location_filter_click() {

		location_filter.click();
	}

	public void location_selection_click() {
		location_selection.click();
	}

	public void apply_button_click() {
		apply_button.click();
	}

	public void selected_filter_dropdown_click() {
		selected_filter_dropdown.click();
	}
	
	//Assertion to check whether the filters are selected and working or not.

	public void selected_filters_check() {

		String filter1 = selected_filter_condition.getText();
		String filter2 = selected_filter_price.getText();
		String filter3 = selected_filter_location.getText();

		if (filter1.contains("Condition: New") && filter2.contains("Price: $100.00 to $300.00")
				&& filter3.contains("Item Location: Worldwide")) {
			System.out.println("Filters are working");
		}

	}
	
	//Explicit wait function.

	public static void explicit_wait(WebDriver driver, WebElement locator, Duration i) {
		new WebDriverWait(driver, i).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

}
