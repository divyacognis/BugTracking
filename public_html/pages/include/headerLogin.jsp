<!--
---------------------------------------------------------------------------------------------------------
header.jsp
---------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2009
---------------------------------------------------------------------------------------------------------
Author Thanapong Tienniem 08/10/2018
- Change Log---------------------------------------------------------------------------------------------
## 		DD/MM/YY 		-User- 		-TaskRef-       -ShortDescription
01		04/12/2018		Pichit						Restructure header file
---------------------------------------------------------------------------------------------------------
-->
<%@ taglib prefix="rcl" uri="/WEB-INF/custom.tld"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
   <!--wrapper start-->
        <div class="wrapper">
            <!--header menu start-->
            <div class="header">
                <div class="header-menu">
                    <div class="sidebar-btn">
                        <i class="fas fa-bars"></i>
						&nbsp; &nbsp;<img src="/VesselPayrollWSWebApp/img/rcl_logo.png" style="background-color:white;height:40px;"  />						
                    </div>&nbsp;
					 
					 <table>
						<tr>
						<td class="heading" style="color:white;"></td>
						<td></td>
						</tr>
					 </table>
					 
					<div class="title">Crew <span class="title">Payroll</span> </div>
                    
                    <ul>                       
                        <li><a href="#"><i class="fas fa-user-circle"></i></a></li>						
                        <li><a href="#"><i class="fas fa-power-off"></i></a></li>						 
                    </ul>
					
                </div>
            </div>
            <!--header menu end-->
      <!--sidebar start-->
            