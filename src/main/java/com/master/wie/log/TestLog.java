package com.master.wie.log;

import org.apache.log4j.Logger;

public class TestLog {
	
	private static final Logger logger = LoggerFactory.getLogger();
	
	public static void main(String[] args) {
		logger.info("test");
	}

}