<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="PPS">
    <meta name="author" content="PPS">
    <meta name="keywords" content="PPS">

    <!-- Title Page-->
    <title>Prabhu Premi Sangh</title>
	<link rel="icon" type="image/ico" href="images/swamiji_icon_latest.jpg" />
    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
</head>
<body>
    <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <!-- <div class="card-heading"></div> -->
                <div class="card-body"><div class="logo-heading"></div><div class="logo2-heading"></div>
                    <h2 class="title">Prabhu Premi Sangh Registration Form</h2><br/>
                    <h4 align="center">9th Jan 2019 to 15th Feb 2019</h4><br/>
                    <h4 align="center">Sector 14, Annapurna Marg, Jhusi, Prayagraj-211019</h4><br/>
                    <h4 align="center">9810650437 -- 9437052071 -- 9350245283</h4><br/>
                    <h2 class="title">User Registration</h2>
                    
                        <div class="input-group">
                            <h4>${responseMsg}</h4>
                            <h4>Your Registration No. is </h4><br/>
                            <h3><font color="red">${userObj.regNo}</font></h3><br/>
                            <h4>Please keep this for further communication.</h4>
                        </div>
				    <h3><%-- <a href="${pageContext.request.contextPath}/">Add New User</a> --%>
				    <c:if test="${userObj.noOfMPrsns>1}">
				    	<a href="${pageContext.request.contextPath}/addSubUsers?userObj=${userObj.userId}_create&${userObj.creationTime}" style=" margin-right: 151px; ">Add More Users</a>
				    </c:if>
				    </h3>
                </div>
            </div>
        </div>
    </div>

 <%--    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>
 --%>
    <!-- Main JS-->
    <%-- <script src="js/global.js"></script> --%>
</body>
</html>
<!-- end document-->