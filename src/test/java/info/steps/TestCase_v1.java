package info.steps;

import info.pom.AbstractPage;
import info.pom.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class TestCase_v1 extends AbstractPage{

	MainPage mp;

	
	@Then("Page title should be {string}")
	public void page_title_should_be(String text) {

		
	}

	@And("Click on `MOBILE` menu")
	public void click_on_mobile_menu() {

		mp = new MainPage();


	}

	@And("User selects `SORT BY` dropdown as {string}")
	public void user_selects_sort_by_dropdown_as_name(String type) {
	}

	@Then("All products should be sorted by name")
	public void all_products_should_be_sorted_by_name() {
	}


	
}
