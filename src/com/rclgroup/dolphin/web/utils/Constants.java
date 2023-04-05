/*Copyright (c) 2020 RCL| All Rights Reserved  */
package com.rclgroup.dolphin.web.utils;


/* ------------------------- Change Log ---------------------------------------
##   DD/MM/YY       -User-              -TaskRef-            -ShortDescription-
1    13/03/20       Chandu               Initial Version
-------------------------------------------------------------------------------
*/
public interface Constants {
	 
	
	 public String HQ_ROLE="1";
	 public String FA_ROLE="2";
	 public String SHIPT_MASTER_ROLE="3";
	
	 
	 public int HQ_STATUS=1;
	 public int FA_STATUS=2;
	 public int SHIPT_MASTER_STATUS=3;
	 
	 
	 public int STATUS_NEW=1;
	 public int STATUS_WAIT_TO_VERIFY=2;
	 public int STATUS_COMPLETED=3;
	 
	 public int STATUS_VERIFFED=7;
	 public int STATUS_REJECTED=4;
	 public int STATUS_CANCEL=5;
	 public int STATUS_WAIT_TO_SUMBIT=6;
	
	 public int STATUS_EXISTING=8;
	 public int STATUS_APPROVED=9; 
	/**
	 * This For Http Status Code
	 */
	public static final int SC_SERVER_ERROR = 500;
	public static final int SC_OK = 200;
	public static final String FAILED = "FAILED";
	public static String LOGIN_USER ="Login page";
	
	public static String RCL_WEB_ROOT="VesselPayrollWSWebApp";
}
