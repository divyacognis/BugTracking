<%-- --------------------------------------------------------------------------------------------------------
QtnSearchScn.jsp
-------------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2007
-------------------------------------------------------------------------------------------------------------
Author Sarawut Anuckwattana 02/07/2019
- Change Log ------------------------------------------------------------------------------------------------
##  DD/MM/YY       -User-              -TaskRef-            -ShortDescription-
-------------------------------------------------------------------------------------------------------- --%>
<meta http-equiv="X-UA-Compatible" content="IE=11" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="true" autoFlush="true"
	errorPage="/pages/error/RcmErrorPage.jsp"%>
<%@ taglib prefix="rcl" uri="/WEB-INF/custom.tld"%>


 <jsp:include page="../../include/commonInclude.jsp"></jsp:include>
<script type="text/javascript">
	//window.location.replace("http://"+sessionStorage.getItem("urlchildExpire")+"/SealinerRCL/childExpire.jsp");
	var userData = JSON.parse(sessionStorage.getItem("userData"));
	 var currentUrl =location.host
	 var seaLinerUrl=location.host;
	if(currentUrl.indexOf('-ce9') > 0){
		clUrl = "cl9";
	}else if(currentUrl.indexOf('-ce.') > 0){
		clUrl = "cl";
	}
	
	if(currentUrl.indexOf('marlin') >=0){
		seaLinerUrl = "marlin-"+clUrl+".rclgroup.com/SealinerRCL/login.jsp";
	}else if(currentUrl.indexOf('zebra') >= 0){
		seaLinerUrl = "zebra-"+clUrl+".rclgroup.com/SealinerRCL/login.jsp";
	}else if(currentUrl.indexOf('dolphin') >=0){
		seaLinerUrl = "dolphin-"+clUrl+".rclgroup.com/SealinerRCL/login.jsp";
	} 
	
	window.location.replace(location.protocol+"//"
			+ seaLinerUrl
			);
</script>
