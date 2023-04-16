package info.steps;

import info.config.TestCaseFailed;
import info.pom.AbstractPage;

public class AssertionSteps extends AbstractPage {

	public void check_title(String present, String title) throws TestCaseFailed {
		assertion_Obj.checkTitle(title, present.isEmpty());
	}
	
}
