<!--
---------------------------------------------------------------------------------------------------------
footer.jsp
---------------------------------------------------------------------------------------------------------
Copyright RCL Public Co., Ltd. 2009
---------------------------------------------------------------------------------------------------------
Author Thanapong Tienniem 08/10/2018
- Change Log---------------------------------------------------------------------------------------------
## 		DD/MM/YY 		-User- 		-TaskRef-       -ShortDescription
---------------------------------------------------------------------------------------------------------
-->

<div id="f0-footerpage" class="rcl-standard-page-footer"></div>
	 
<div class="modal" id="notification">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title" id="notificationTitle">Message</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					onclick="closeNotification(this);"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body" id="notificationConent">Modal body..</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal"
					onclick="closeNotification(this);">Close</button>
			</div>

		</div>
	</div>
</div>


	 
<div class="modal" id="ConfirmNotification">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title" id="confirmNotificationTitle">Confirmation</h4>
				 
			</div>

			<!-- Modal body -->
			
			<div class="modal-body" >
				<i class="fa fa-check-circle-o fa-2x" style="color: green;" aria-hidden="true"></i> <span id="confirmNotificationConent" style="position: relative;top:-5px;left:15px;font-weight: 700;"></span>
			</div>

			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-bs-dismiss="modal"
					onclick="yesConfirmationNotification(this);">Yes</button>
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal"
					onclick="closeConfirmationNotification(this);">No</button>
			</div>
			

		</div>
	</div>
</div>

<script>

function openConfirmationNotification(mesage,callBack,args){
	$("#confirmNotificationConent").html(mesage);
	//$("#confirmNotificationTitle").html(mesage);
	$('#ConfirmNotification').modal('show');	 
	callBackFunction=callBack;
	yesConfirmArgs =args;
}

function yesConfirmationNotification(){
	debugger;
	$('#ConfirmNotification').modal('hide');
	if(callBackFunction!= null){
		callBackFunction.apply(this, [yesConfirmArgs]);
		callBackFunction = null;
		yesConfirmArgs =null;
	}
	 
}

function closeConfirmationNotification(){
	 
	$('#ConfirmNotification').modal('hide');
	 
	 
}


	var parentDoc;
	var yesConfirmArgs=null
	var callBackFunction=null;
	function openNotification(title, mesage,obj,callBack){
		$("#notificationTitle").html(title);
		$("#notificationConent").html(mesage);
		$("#notification").show();
		parentDoc = obj;
		callBackFunction=callBack;
	}
	
	function closeNotification(){
		debugger;
		$("#notification").hide();
		if(callBackFunction!= null){
			callBackFunction.apply(this, []);
			callBackFunction = null;
		}
		 
	}
	
	function showErrorMsg(msg){
		debugger;
		openNotification("Error",msg.responseJSON.errorMessage)
	}
	
	function noRecordFoundMsg(){
		openNotification("Info","No Records Found");
	}
</script>
