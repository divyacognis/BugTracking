<div class="wrapper">
            <!--header menu start-->
            <div class="header">
                <div class="header-menu">
                    <div class="sidebar-btn">
                        <i class="fas fa-bars"></i>
						&nbsp; &nbsp;<img src="../../img/rcl_logo.png" style="background-color:white;height:40px;"  />						
                    </div>&nbsp;
					
				<table>
					<tr>
						<td class="heading" style="color:white;">Select Month :&nbsp;</td>
						<td>			 
							<div class="input-append date" id="datepicker">
  								<input type="text" class="span2" readonly="readonly" style="position: relative;top:-2px;">
  								<span class="add-on" ><i class="fa fa-calendar fa-2x" aria-hidden="true" style="color:white;"></i></span>
							</div>
						</td>
				   </tr>
				</table>
				
					<div class="title">Crew <span class="title">Payroll</span> User Info</div>
                    
	                    <ul>
	                    	<li><a id="loginUser" style="color:white;"></a></li>
	                       				
	                        <li><a ><i class="fa fa-power-off" onclick="logout()" title="Logout"></i></a></li>					 
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
                            <a href="#"><i class="fas fa-lock"></i><span>Completed (<span class="Completed"></span>) Vessels</span></a>
                            <a href="#"><i class="fas fa-language"></i><span>Wait to Verify (<span class="WaittoVerify"></span>) Vessels</span></a>
							<a href="#"><i class="fas clock-o"></i><span>Wait for Submission (<span class="WaitforSubmition"></span>) Vessels</span></a>
							
                        </div>
                    </li>
                     
                </div>
            </div>