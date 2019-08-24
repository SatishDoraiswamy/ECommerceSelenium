package com.ecommerce.project.ecommerce.utils;

public class DateAndTimeUtil {

	public static void sleep(int timeInSecond) {
		try {
			Thread.sleep(timeInSecond);
		}catch (InterruptedException e) {
			// TODO: handle exception
		}catch(Exception e) {
			
		}
	}
}
