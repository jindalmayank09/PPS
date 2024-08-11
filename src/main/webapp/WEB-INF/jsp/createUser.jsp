<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="PPS">
<meta name="author" content="PPS">
<meta name="keywords" content="PPS">

<!-- Title Page-->
<title>Prabhu Premi Sangh</title>
<link rel="icon" type="image/ico" href="images/swamiji_icon_latest.jpg" />
<!-- Icons font CSS-->
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">
<!-- Vendor CSS-->
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="vendor/jquery/jquery-1.12.4.js"></script>
<script src="vendor/jquery/jquery-ui.js"></script>
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">

</head>
<body>
	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960">
			<div class="card card-2">
				<div class="card-body">
					<div class="logo-heading"></div>
					<div class="logo2-heading"></div>
					<h2 class="title">User Registration Form</h2>
					<h2 style="margin-top: -74px; margin-left: 610px;">
						<a href="${pageContext.request.contextPath}/uploadExcelFile"
							style="text-decoration: none">Upload Data</a>
					</h2>
					<form:form method="post" modelAttribute="user"
						action="${pageContext.request.contextPath}/saveNewUser"
						name="addUserForm" id="addUserForm" autocomplete="off">
						<br />
						<br />
						<font color="red" size="4">Note:All fields are required!!</font>
						<br />
						<br />
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<form:input path="name" class="input--style-2" type="text"
										placeholder="Name" required="true" />
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<form:input path="phoneNo" class="input--style-2" type="text"
										placeholder="Phone No" required="true" maxlength="10"
										onkeydown='return isNumber(event)'
										title="Please enter numeric values" />
								</div>
							</div>

						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<form:select path="gender" required="required">
											<form:option disabled="disabled" selected="selected" value="">Gender</form:option>
											<form:option value="Male">Male</form:option>
											<form:option value="Female">Female</form:option>
										</form:select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<form:input path="place" class="input--style-2" type="text"
										placeholder="Address" required="true" />
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2" style="width: 700px;">
								<form:input class="input--style-2 datepicker" type="text"
									placeholder="From Date" path="fromDate" id="fromDate"
									required="true" readonly="true" />
								<!-- <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar-startdate"></i> -->
							</div>
							<div class="col-2" style="margin-left: 420px; margin-top: -31px;">
								<form:input class="input--style-2 datepicker" type="text"
									placeholder="To Date" path="toDate" id="toDate" required="true"
									readonly="true" />
								<!-- <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar-enddate"></i> -->
							</div>
						</div>
						<div class="p-t-30">
							<button class="btn btn--radius btn--green" type="submit">Save</button>
							<!-- <button class="btn btn--radius btn--green" type="submit">Reset</button> -->
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<!-- Main JS-->
	<script src="js/global.js"></script>
	<script src="js/user/createUser.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			/* $('#addUserForm').on('submit', function(event) {
				//event.preventDefault();
			})

			$('input[type="text"]').keyup(function(event) {
				if (event.keyCode === 13) {
					$(this).next().focus();
				}
			}); */
		});
	</script>
</body>
</html>
<!-- end document-->