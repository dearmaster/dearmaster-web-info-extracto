package com.master.wie.log;

import org.apache.log4j.Logger;
import sun.reflect.Reflection;

@SuppressWarnings("restriction")
public class LoggerFactory {
	
	public static final Logger getLogger() {
		return Logger.getLogger(Reflection.getCallerClass(0));
	}

}