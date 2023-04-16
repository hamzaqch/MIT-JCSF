package info.config;

import info.utils.*;

public interface Base {

	SelectElementByType selectElementByType = new SelectElementByType(); 
	AssertionMethods assertion_Obj = new AssertionMethods();
	ClickElementsMethods click_Obj = new ClickElementsMethods();
	ConfigurationMethods config_Obj = new ConfigurationMethods();
	InputMethods input_Obj = new InputMethods();
	JavascriptHandlingMethods javaScriptHandling_Obj = new JavascriptHandlingMethods();
	MiscMethods misc_Obj = new MiscMethods();
	NavigateMethods navigate_Obj= new NavigateMethods();
	ProgressMethods progress_Obj = new ProgressMethods();
	ScreenShotMethods screenShot_Obj = new ScreenShotMethods();
}
