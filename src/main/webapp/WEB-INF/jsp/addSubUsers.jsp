<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<%--     
    <h3 align="right"><a href="${pageContext.request.contextPath}/" style=" margin-right: 206px; ">Add New User</a></h3>
    <c:if test="${userObj.noOfMPrsns>1}">
    	<h3 align="right"><a href="${pageContext.request.contextPath}/addSubUsers?userObj=${userObj.userId}&${userObj.creationTime}" style=" margin-right: 206px; ">Add More Users</a></h3>
    </c:if>
 --%>        
 		<div class="wrapper wrapper--w960">
            <div class="card card-2">
                <!-- <div class="card-heading"></div> -->
                <!-- <div class="card-body"><div class="logo-heading"></div><div class="logo2-heading"></div> -->
<!--                     <h2 class="title">Prabhu Premi Sangh Registration Form</h2><br/>
                    <h4 align="center">9th Jan 2019 to 15th Feb 2019</h4><br/>
                    <h4 align="center">Sector 14,Annapurna Marg,Jhunsi,Prayagraj-211019</h4><br/>
                    <h4 align="center">9810650437 -- 9437052071 -- 9350245283</h4><br/>
 -->                    <img src = "${pageContext.request.contextPath}/images/icon.png" style=" width: 100px; height: 100px; margin-left: 5px;"></img><h2 class="title">Sub User Registration</h2><img src = "${pageContext.request.contextPath}/images/kumbh.jpg" style="width:100px;height: 100px;margin-top: -174px;margin-left: 850px;"></img>
 						<form:form action="${pageContext.request.contextPath}/saveSubUsersDetails" method="post" modelAttribute="user" name="addUserForm"  id="addUserForm" autocomplete="off">
                        <form:hidden path="action"/>
                        <form:hidden path="userId"/>
                        <div class="input-group">
                            <h5><font color="red" style="margin-left: 7px;font-size:medium;">Reg. No #:${user.regNo} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Accommodation Type:${user.accomodation} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Period From :<fmt:formatDate pattern = "dd-MM-yyyy" value = "${user.startDate}" />&nbsp;To&nbsp;<fmt:formatDate pattern = "dd-MM-yyyy" value = "${user.endDate}" /></font></h5><br/>
                        </div>
						<table border="1" style="margin-left: 10px;"> 
						<font color="red" style="margin-left: 10px;font-size:medium;">Total Fare : Rs.  ${user.totalFare}</font><br/><br/>
						  <tbody>
						  <tr>
						  <td width="2%">1.</td>
						  <td width="8%"><div class="input--style-2">${user.userName}</div></td>
						  <td width="7%"><div class="input--style-2">${user.contactNo}</div></td>
						  <td width="10%"><div class="input--style-2">${user.userAddress}</div></td>
						  <td width="6%"><div class="input--style-2">${user.gender}</div></td>
						  <td width="8%"><div class="input--style-2">${user.age}</div></td>
						  <td width="8%"><div class="input--style-2">${user.aadharNo}</div></td>
						  </tr>
						  <c:forEach var = "i" begin = "0" end = "${user.noOfMPrsns-2}">
						       <tr>
						         <td width="2%">${i+2}.</td>
						         <td width="8%"><form:input path="subUsersList[${i}].userName" class="input--style-2" type="text" placeholder="Name" required="true"/></td>
						         <td width="7%"><form:input path="subUsersList[${i}].contactNo" class="input--style-2" type="text" placeholder="Contact No" maxlength="10" required="true" onkeydown="return isNumber(event)" title="Please enter numeric values"/></td>
						         <td width="10%"><form:input path="subUsersList[${i}].userAddress" class="input--style-2" type="text" placeholder="Place"  required="true"/></td>
						         <td width="6%">
						         
						         <c:choose>
						       		<c:when test="${user.action=='view'}">
						         		<form:input path="subUsersList[${i}].gender" class="input--style-2" type="text"/>
						         	</c:when>
						         <c:otherwise>
							         <div class="rs-select2 js-select-simple select--no-search">
			                                 <form:select path="subUsersList[${i}].gender" required="required">
			                                     <form:option disabled="disabled" selected="selected" value="-1">Gender</form:option>
			                                     <form:option value="Male" >Male</form:option>
			                                     <form:option value="Female">Female</form:option>
			                                 </form:select>
			                                 <div class="select-dropdown"></div>
		                         </div>
						         </c:otherwise>
						         </c:choose>
						         </td>
								 <td width="8%"><form:input path="subUsersList[${i}].age" class="input--style-2" type="text" placeholder="Age" required="true" maxlength="2" onkeydown="return isNumber(event)" title="Please enter numeric values"/></td>						         
						         <td width="8%"><form:input path="subUsersList[${i}].aadharNo" class="input--style-2" type="text" placeholder="Aadhar No" required="true" maxlength="12" onkeydown="return isNumber(event)" title="Please enter numeric values"/></td>
<%-- 						         <td width="10%"><form:input class="input--style-2 js-datepicker-stayperiod-arrival_${i}" type="text" placeholder="Arrival Date" path="subUsersList[${i}].startDate" id="arrivalDate_${i}" required="true"/>
                                    <i class="zmdi zmdi-calendar-note input-icon-new js-btn-calendar-stayperiod-arrival_${i}" id="button_arrivalDate_${i}"></i></td>
						         <td width="10%"><form:input class="input--style-2 js-datepicker-stayperiod-departure_${i}" type="text" placeholder="Departure Date" path="subUsersList[${i}].endDate" id="departureDate_${i}" required="true"/>
                                    <i class="zmdi zmdi-calendar-note input-icon-new js-btn-calendar-stayperiod-departure_${i}" id="button_departureDate_${i}"></i></td>
 --%>						       
 								</tr>
						     </c:forEach>
						  </tbody>
						</table> 
                     <div class="p-t-30" style="margin-left: 10px;">
                            <button class="btn btn--radius btn--green" type="submit" id="save">Save</button>
                            <button class="btn btn--radius btn--green" type="submit" id="print" onclick="window.print();">Print</button>
                        </div><br/>
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
<script type="text/javascript">
$(document).ready(function(){
		<c:if test="${user.action=='view'}">
			$('#addUserForm input').attr('readonly', 'readonly');
			$('#save').hide();
		</c:if>
		<c:if test="${user.action=='create'}">
		$('#print').hide();
	</c:if>

});
/* <c:if test="${user.noOfMPrsns>0}">
	<c:forEach var = "i" begin = "0" end = "${user.noOfMPrsns-1}">
    $('#arrivalDate_${i}').daterangepicker({
    	"singleDatePicker": true,
        "showDropdowns": true,
        "autoUpdateInput": false,
        "minDate":new Date("12/01/2018"),
        "maxDate":new Date("02/15/2019"),
        locale: {
            format: 'DD/MM/YYYY'
        },
    });

    var myCalendarEndDate = $('#arrivalDate_${i}');
    var isClick = 0;

    $(window).on('click',function(){
        isClick = 0;
    });

    $(myCalendarEndDate).on('apply.daterangepicker',function(ev, picker){
        isClick = 0;
        $(this).val(picker.startDate.format('DD/MM/YYYY'));

    });

    $('#button_arrivalDate_${i}').on('click',function(e){
        e.stopPropagation();

        if(isClick === 1) isClick = 0;
        else if(isClick === 0) isClick = 1;

        if (isClick === 1) {
        	myCalendarEndDate.focus();
        }
    });

    $(myCalendarEndDate).on('click',function(e){
        e.stopPropagation();
        isClick = 1;
    });

    $('.daterangepicker').on('click',function(e){
        e.stopPropagation();
    });

    $('#departureDate_${i}').daterangepicker({
    	"singleDatePicker": true,
        "showDropdowns": true,
        "autoUpdateInput": false,
        "minDate":new Date("12/01/2018"),
        "maxDate":new Date("02/15/2019"),
        locale: {
            format: 'DD/MM/YYYY'
        },
    });

    var myCalendarEndDate = $('#departureDate_${i}');
    var isClick = 0;

    $(window).on('click',function(){
        isClick = 0;
    });

    $(myCalendarEndDate).on('apply.daterangepicker',function(ev, picker){
        isClick = 0;
        $(this).val(picker.startDate.format('DD/MM/YYYY'));

    });

    $('#button_departureDate_${i}').on('click',function(e){
        e.stopPropagation();

        if(isClick === 1) isClick = 0;
        else if(isClick === 0) isClick = 1;

        if (isClick === 1) {
        	myCalendarEndDate.focus();
        }
    });

    $(myCalendarEndDate).on('click',function(e){
        e.stopPropagation();
        isClick = 1;
    });

    $('.daterangepicker').on('click',function(e){
        e.stopPropagation();
    });
	</c:forEach>
</c:if> */
</script>
</html>
<!-- end document-->