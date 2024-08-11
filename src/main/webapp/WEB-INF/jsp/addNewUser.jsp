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
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="css/main.css" rel="stylesheet" media="all">

</head>
<body>

	<div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">

		<div class="wrapper wrapper--w960">
			<div class="card card-2">


				<form:form method="post" modelAttribute="user"
					action="${pageContext.request.contextPath}/saveNewUser"
					name="addUserForm" id="addUserForm" autocomplete="off">
					<table border="2">
						<div>
							<form:input path="userName" class="input--style-2" type="text"
								placeholder="User Name" required="true" />
						</div>
						<div>
							<form:input path="contactNo" class="input--style-2" type="text"
								placeholder="Contact No" required="true" />
						</div>
						<div>
							<form:input path="email" class="input--style-2" type="text"
								placeholder="Email" required="true" />
						</div>
						<div>
							<form:input path="usersAddressList[0].address"
								class="input--style-2" type="text"
								placeholder="Communication Address" required="true" />
						</div>
						<div>
							<form:input path="usersAddressList[1].address"
								class="input--style-2" type="text"
								placeholder="Permanent Address" required="true" />
						</div>
						<div class="p-t-30">
							<button class="btn btn--radius btn--green" type="submit">Save</button>
							<button class="btn btn--radius btn--green" type="submit">Reset</button>
						</div>
					</table>
				</form:form>

			</div>
		</div>
	</div>
	<!-- Jquery JS-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="vendor/select2/select2.min.js"></script>
	<script src="vendor/datepicker/moment.min.js"></script>
	<script src="vendor/datepicker/daterangepicker.js"></script>

	<!-- Main JS-->
	<script src="js/global.js"></script>
</body>
</html>
<!-- end document-->