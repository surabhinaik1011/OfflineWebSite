package com.pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class BasePage {
	//Logger logger = Logger.getLogger(this.getClass());
	public Logger pageLogger(){
	Logger logger1 = Logger.getLogger(this.getClass());
    String path = (System.getProperty("user.dir")+"/log4jPage.properties");
	    PropertyConfigurator.configure(path);
	    return logger1;
}
}
