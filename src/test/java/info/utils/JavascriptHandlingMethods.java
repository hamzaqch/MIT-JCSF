package info.utils;

import info.pom.AbstractPage;

public class JavascriptHandlingMethods extends AbstractPage{

	/**
	 * Method to handle alert
	 * 
	 * @param decision : String : pass (accept) to accept the alert or somthing else to dismiss
	 */
	public void handleAlert(String decision) {
		if (decision.equalsIgnoreCase("accept")) {
			getDriver().switchTo().alert().accept();
		}
		else {
			getDriver().switchTo().alert().dismiss();
		}
	}
	
}
