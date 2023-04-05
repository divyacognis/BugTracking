/*Copyright (c) 2020 RCL| All Rights Reserved  */
package com.rclgroup.dolphin.web.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rclgroup.dolphin.web.model.UserMod;

/* ------------------------- Change Log ---------------------------------------
##   DD/MM/YY       -User-              -TaskRef-            -ShortDescription-
1    14/03/20       chandu               Initial Version
-------------------------------------------------------------------------------
*/

/**
 * This class contain method to convert db code into respective String.
 * 
 * @author Cognis
 *
 */
public class Utils {

	private static final String USER_BEAN = "USER_INFO";

	public static boolean isCurrentMonth(String month) {
		
		Date date = new Date();
		String currentMonth = String.valueOf(date.getMonth()+1);
		if(currentMonth.equalsIgnoreCase(month)) {
			return true;
		}
		return false;
	}
	public static String getDBValue(String value) {
		if (value == null) {
			return "";
		}

		return value;

	}

	public static String getTimeTaken(long startTime, long endTime) {
		long diff = endTime - startTime;
		return diff / 1000 + " Seconds ";
	}

	public static void setUserInSession(HttpServletRequest request, UserMod userMod) {
		HttpSession session = request.getSession();
		session.setAttribute(USER_BEAN, userMod);

	}
	
	
	public static void removeFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(USER_BEAN);

	}

	public static UserMod getUserFromSession(HttpServletRequest request) {

		HttpSession session = request.getSession();
		UserMod userMod = (UserMod) session.getAttribute(USER_BEAN);
		return userMod;

	}
}
