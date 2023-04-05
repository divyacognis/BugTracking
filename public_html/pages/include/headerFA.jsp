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
						<td class="heading" style="color:white;">Select Month :&nbsp;</td>						
						<td>
							<div class="input-append date" id="datepicker">
			  					<input type="text" class="span2" readonly="readonly" style="position: relative;top:-2px;"><span class="add-on" ><i class="fa fa-calendar fa-2x" aria-hidden="true" style="color:white;"></i></span>
							</div>
						</td>
						</tr>
					</table>
					
					<div class="title">Crew <span class="title">Payroll</span> of FA</div>                   
                    <ul>
                    	<li><a id="loginUser" style="color:black;"></a></li>             	                   	
                        <li><a href="#"><i class="fa fa-user-circle-o"></i></a></li>						
                        <li><a href="#"><i class="fa fa-power-off" onclick="logout()" title="Logout"></i></a></li>						 
                    </ul>
                </div>
            </div>
            <!--header menu end-->
            
            <!--sidebar start-->
            <div class="sidebar">
                <div class="sidebar-menu">
                                       
                    <li class="item" id="profile">
                        <a href="#profile" class="menu-btn">
                            <i class="fas fa-user-circle"></i><span>Bonded Store <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="#"><i class="fas fa-image"></i><span>Bonded Store1</span></a>
                            <a href="#"><i class="fas fa-address-card"></i><span>Bonded Store 2</span></a>
                        </div>
                    </li>
                    
                    <li class="item" id="messages">
                        <a href="#messages" class="menu-btn">
                            <i class="fas fa-envelope"></i><span>CA And VOC <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="#"><i class="fas fa-envelope"></i><span>CA And VOC 1</span></a>
                            <a href="#"><i class="fas fa-envelope-square"></i><span>CA And VOC 2</span></a>
                            <a href="#"><i class="fas fa-exclamation-circle"></i><span>CA And VOC 3</span></a>
                        </div>
                    </li>
                    
                    <li class="item" id="settings">
                        <a href="#settings" class="menu-btn">
                            <i class="fa fa-home"></i><span>Home Allotment <i class="fas fa-chevron-down drop-down"></i></span>
                        </a>
                        <div class="sub-menu">
                            <a href="#"><i class="fas fa-lock"></i><span>Verified </span>(<span id="verifiedCrew"></span>)</a>
                            <a href="#"><i class="fas fa-language"></i><span>Wait to Verify </span>(<span  id="waitToVerifyCrew"></span>)</a>
							<a href="#"><i class="fa fa-thumbs-o-down" aria-hidden="true" title="Rejected"></i><span>Rejected </span>(<span id="rejectedCrew"></span>)</a>
                        </div>
                    </li>
                     
                </div>
            </div>
 
<script type="text/javascript">

        $(document).ready(function(){
            $(".sidebar-btn").click(function(){
                $(".sidebar").toggleClass("collapse");
            });
        });
		function selectAll(){
		$(".all").attr("checked",!$(".all").attr("checked"));
	}
		
</script>
