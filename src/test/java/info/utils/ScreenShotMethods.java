package info.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import info.pom.AbstractPage;

public class ScreenShotMethods extends AbstractPage {

	/**
	 * Method to take screen shot and save in ./screenShots folder
	 */
	public void takeScreenShot() throws IOException {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("MMMM-dd-yyyy-z-HH:mm:ss", Locale.ENGLISH);
		Calendar cal = Calendar.getInstance();
		FileUtils.copyFile(scrFile, new File("screenShots/" + dateFormat.format(cal.getTime()) + ".png"));
	}

}
