package info.steps;

import info.pom.AbstractPage;
import info.config.TestCaseFailed;
import info.pom.*;
import io.cucumber.java.en.Then;

public class MainPage extends AbstractPage {

	private MainPageObjects mp = new MainPageObjects();
	
	@Then("I should see all products sorted by name")
	public void i_should_see_all_products_sorted_by_name() throws TestCaseFailed {
		mp.allProductAreSortedByName(true);
	}

	@Then("I should be able to see page title as {string}")
	public void i_should_be_able_to_see_page_title_as(String title) throws InterruptedException {
		mp.pageTitleShouldBe(title);
	}

}
