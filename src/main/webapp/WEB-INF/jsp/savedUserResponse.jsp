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
					<h2 class="title">User Details</h2>
					<h2 style="margin-top: -74px; margin-left: 555px;">
						<a href="${pageContext.request.contextPath}/"
							style="text-decoration: none">Create New User</a>
					</h2>
					<br/><br/>
					<font color="red" size="4"
						style="text-align: center; margin-left: 200px;">"${responseMsg}"</font>
					<br /> <br /><br/><br/>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<input name="name" class="input--style-2" type="text"
									placeholder="Name" readonly="readonly" value="${userObj.name}" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<input name="phoneNo" class="input--style-2" type="text"
									value="${userObj.phoneNo}" />
							</div>
						</div>

					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">
									<select name="gender" disabled="disabled">
										<option disabled="disabled" value="${userObj.gender}">Gender</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
									<div class="select-dropdown"></div>
								</div>
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<input name="place" class="input--style-2" readonly="readonly"
									value="${userObj.place}" />
							</div>
						</div>
					</div>
					<div class="row row-space">
						<div class="col-2">
							<div class="input-group">
								<input value="${userObj.fromDate}" readonly="readonly" />
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<input value="${userObj.toDate}" readonly="readonly" />
								<!-- <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar-enddate"></i> -->
							</div>
						</div>
					</div>
					<div class="p-t-30">
						<button class="btn btn--radius btn--green" type="submit"
							onclick="printCard('${userObj.name}','${userObj.phoneNo}','${userObj.place}','${userObj.dob}','${userObj.fromDate}','${userObj.toDate}')">Print
							Card</button>
						<div id="SomeDivToShowTheResult" class="btn btn--radius btn--green" style="margin-left: 50px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="vendor/select2/select2.min.js"></script>
	<script src="js/global.js"></script>
	<script src="js/user/createUser.js"></script>
	<script src="js/user/main.js"></script>
</body>
</html>
<!-- end document-->