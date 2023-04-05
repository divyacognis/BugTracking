<%@page import="com.rclgroup.dolphin.web.servlet.ConfigServlet"%>
<%@page import="java.util.Date"%>
<%
	Date index = new Date();
%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"
	charset="utf-8"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.1/chart.min.js"
	integrity="sha512-QSkVNOCYLtj73J4hbmVoOV6KVZuMluZlioC+trLpewV8qMjsWqlIQvkn1KGX2StWvPMdWGBqim1xlC8krl1EKQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="/VesselPayrollWSWebApp/css/loader.css">
<script
	src="/VesselPayrollWSWebApp/bootstrapDatePicker/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="/VesselPayrollWSWebApp/bootstrapDatePicker/css/bootstrap-datepicker.css">

<!-- To generate excel through js  -->

<!-- <script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
 -->
<!-- use version 0.19.1 -->
<script lang="javascript"
	src="https://cdn.sheetjs.com/xlsx-0.19.1/package/dist/xlsx.full.min.js"></script>
<!-- Cognis JS and CSS -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/exceljs/4.3.0/exceljs.min.js"
	integrity="sha512-UnrKxsCMN9hFk7M56t4I4ckB4N/2HHi0w/7+B/1JsXIX3DmyBcsGpT3/BsuZMZf+6mAr0vP81syWtfynHJ69JA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="/VesselPayrollWSWebApp/js/common.js?id=<%=index%>"></script>
<script src="/VesselPayrollWSWebApp/js/moment.min.js?id=<%=index%>"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
	function logout() {
		var url = "/login/logout";
		sendPostRequest(url, {
			"id" : 1
		}, function(dataResponse) {
			window.location.href = "../"
		});
	}

	$(document).ready(function() {
		var session = sessionStorage.getItem("userLogin");
		if (session) {
			let user = JSON.parse(session);
			var firstName = user["firstName"];
			var lastName = user["lastName"];
			$("#loginUser").html(firstName);
		}

		$(".sidebar-btn").click(function() {
			$(".sidebar").toggleClass("collapse");
		});

		var etdDate = new Date();
		 

		var maxDate = new Date();
		maxDate.setMonth(maxDate.getMonth()-1)
		maxDate.set
		$('#datepicker').datepicker({
			format: "mm/yyyy",
		    viewMode: "months", 
		    minViewMode: "months",
			inline : true,
			defaultDate : etdDate
			}).on('dp.change', function(e) {
 

			$('#monthShow').html(getFullMonth());
		});

		$('#datepicker').datepicker('setDate', new Date());
		$('#datepicker').datepicker('setStartDate', maxDate);
		$('#datepicker').datepicker('setEndDate', new Date());
		$('#monthShow').html(getFullMonth());

		hideToolBar();
	});

	function hideToolBar() {

		var cutOffDate =
<%=ConfigServlet.getConfigValue("CUT_OFF_TIME")%>
	var todayDate = new Date();
		var isCrossCutOffDate = false;
		// $(".actionToolbar").hide();
		if (todayDate.getDate() <= cutOffDate) {
			isCrossCutOffDate = true;
			$(".actionToolbar").show();
		}
	}
</script>

<style>

#totalNumberOfRecord{
	font-size: 15px;
}
.crew_title{
color: blue;font-size:24px;font-weight: 500;
}
.sub-menu a {
	text-decoration: none;
}

#monthShow {
	color: blue;
}

.readonly {
	background-color: #c2c2c2;
}

.form-select:disabled {
	background-color: #c2c2c2;
}

.content {
	top: 40px;
	margin: 30px;
	position: relative;
}

.boarder {
	border: .5px solid #c2c2c2;
	padding: 10px;
}

.heading {
	font-size: 15px;
	font-weight: 600;
	text-align: right;
}

.datepicker-orient-bottom {
	top: 55px !important;
	width: 200px;
	padding: 10px;
}
</style>