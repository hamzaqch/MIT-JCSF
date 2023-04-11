package info.steps;

import info.pom.AbstractPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Share extends AbstractPage{

	@Before
	public void test_setup() {


	}

	@Given("User navigate to URL")
	public void user_navigate_to_url() {
		getDriver().get("http://live.techpanda.org/index.php/");
	}

	@After
	public void tearDown() {
		getDriver().quit();
	}
	
}
