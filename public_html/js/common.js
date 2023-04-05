
function getUserDataFromHeader(){
	var referrer = document.referrer;
	 
	return rptGetDataFromSingleArea("h3-hidden");
}

(function ($) {
	$.fn.serializeFormJSON = function () {

		var o = {};
		var a = this.serializeArray();
		$.each(a, function () {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [o[this.name]];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
})(jQuery);

function getMonth(){
	var d=$('#datepicker').datepicker('getDate');
	  var month =d.getMonth()+1;
	  if(month<=9){
		  month = "0"+month;
	  }
	 
	  return month+"/"+d.getFullYear();
}


function getMonthForFile(){
	var d=$('#datepicker').datepicker('getDate');
	  var month =d.getMonth()+1;
	  if(month<=9){
		  month = "0"+month;
	  }
	 
	  return month+"_"+d.getFullYear();
}
function getFullMonth(){
	
	var d=$('#datepicker').datepicker('getDate');
	  var month =d.getMonth()+1;
	  if(month<=9){
		  month = "0"+month;
	  }
	  return month+"/"+d.getFullYear();
}

/**
	Note this method is used to send ajax post request
	paramter : url menas url where user want to send request
	data     : data which user want to send to server 
*/


function sendPostRequest(url, data, sucessFunction, errorFunction) {
	
	url="/VesselPayrollWSWebApp/rclws"+url;
	if(!data["byPass"]){
		var session = sessionStorage.getItem("userLogin");
		if(session){
		  let user =JSON.parse(session);
		  data["userId"]=user["userId"];
		  data["role"]=user["role"];
		  data["loginUserEmailId"]=user["emailId"];
		  data["vesselCode"]= user["vesselCode"];
		}	 
	}
	
	$( "body" ).append('<div class="loading"></div>');
	$("body").find('.loading').remove();
	$( "body" ).append('<div class="loading"></div>');
	//data["browserData"]=getUserDataFromHeader();
	
	$.ajax({
		method: "POST",		
		async: true,
		cache: false,
		url: url,
		data: JSON.stringify(data),
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		
		success: function (dataResponse) {
			$("body").find('.loading').remove();
			if(dataResponse["statusId"]){
				data["statusId"] =dataResponse["statusId"];
			}
			if(dataResponse["statusAsString"]){
				data["statusAsString"] =dataResponse["statusAsString"];
			}
			
				sucessFunction.apply(this, [dataResponse.data]);		
			
		},
		error: function (error, textStatus, jqXHR) {
			//process error msg
			$("body").find('.loading').remove();
			
			if(sucessFunction){
				errorFunction.apply(this, [error])
			}
			else{
				handleAjaxError(error)
			}
			//errorFunction.apply(this, [data]);
		},
	});

}
/**
	Note this method is used to send ajax get request
	paramter : url menas url where user want to send request
	data     : data which user want to send to server 
*/

function sendGetRequest(url, data, sucessFunction, errorFunction) {
	url="/VesselPayrollWSWebApp/"+url;
	//data["browserData"]=getUserDataFromHeader();
	$( "body" ).append('<div class="loading"></div>');
	$("body").find('.loading').remove();
	$( "body" ).append('<div class="loading"></div>');
	$.ajax({
		method: "GET",
		url: url,
		data: data,
		contentType: "application/json;",
		traditional: true,
		dataType: 'json',
		success: function (data) {
			$("body").find('.loading').remove();
			sucessFunction.apply(this, data);
		},
		error: function (error, textStatus, jqXHR) {
			 
			$("body").find('.loading').remove();
			handleAjaxError(error)
			//errorFunction.apply(this, [data]);
		}
	});

}

function GetURLParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for (var i = 0; i < sURLVariables.length;i++) {
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam) {
			return decodeURIComponent(sParameterName[1]);
		}
	}
}
  
function closeWindow(){
	logout();
}
 
function dialogFadeout(msg){
	alert("error occur "+JSON.stringify(msg))
}

function formateNumber(grandTotal){
	if(grandTotal){
	return (grandTotal).toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&,');
	}else {
	return "";
	}
	}
	
	function handleAjaxError(error){
		console.log()
		if(error.statusText =="Internal Server Error"){
			dialogFadeout("Internal Server Error");
		}
		else
		{
			if(error.responseText){
				dialogFadeout(error.responseText);
			}
		}
	    return { $_success: false };
	}
	
	 function onClickClose(){
		// alert("close");
		 window.close();
		}
      
	 function removeEmtryOptions(elementId) {
			var x = document.getElementById(elementId);
			x.remove(0);
		}   	 
	 
	 $(document).ready(function(){
		 $( "body" ).append('<div class="loading"></div>'); 
		
		 $("body").find('.loading').remove();
	 
	 });
      
	 
	function getTableCSS(status){
		var css="table-light";
		switch(status){
			case "8":
				css="table-primary"
				break;
			case "7":
				css="table-info"
				break;
			case "4":
				css ="table-danger";
				break;
			case "1":
				css ="table-warning";
				break;
			case "2":
				css ="table-success";
				break;
		}
		return css;
	}
	
	
		function formatNumber(num) {
    var p = num.toFixed(2).split(".");
	 
    return p[0].split("").reverse().reduce(function(acc, num, i, orig) {
        return num + (num != "-" && i && !(i % 3) ? "," : "") + acc;
    }, "") + (p[1]==00?"": "." + p[1]);
}