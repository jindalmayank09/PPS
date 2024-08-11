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
       
 		<div class="wrapper wrapper--w960">
            <div class="card3 card-4" style="margin-top:-100px;">
                    <img src = "${pageContext.request.contextPath}/images/icon.png" style=" width: 100px; height: 100px; margin-left: 5px;"></img><h2 class="title">User Details Export</h2><img src = "${pageContext.request.contextPath}/images/kumbh.jpg" style="width:100px;height: 100px;margin-top: -174px;margin-left: 550px;"></img>
 						<form:form action="${pageContext.request.contextPath}/writeExcel" method="post" modelAttribute="user" name="addUserForm"  id="addUserForm" autocomplete="off">
                        <form:hidden path="action"/>
                        <form:hidden path="userId"/>
                        <form:hidden path="userSelectedFields"/>
                        <div class="input-group">
                            <h5><font color="red" style="margin-left:50px;font-size:medium;">Select the fields to Export Data</font></h5><br/>
                        </div>
						<table border="1" style="margin-left: 20px;margin-top:-30px;margin-right:20px;"> 
						  <tbody>
						  <tr>
						  <td width="10%"><input type="checkbox"  value="-1" class="checkall"></td>
						  <td width="20%" style="padding-left: 36px;">Select All</td>
						  </tr>
						<c:forEach items="${userFieldsList}" var ="field" >
								<tr>
									<td width="10%"><input type="checkbox" name="selectedUserFields" value="${field.key}" class="userfield"></input></td>
									<td width="20%" style="padding-left: 36px;"><c:out value="${field.value}"/></td>
								</tr>
							
						</c:forEach>
						  </tbody>
						</table> 
                     <div class="p-t-30" style="margin-left: 10px;margin-bottom: 20px;">
                            <button class="btn btn--radius btn--green" type="submit" id="proceedExport">Proceed to Export</button>
                      </div>
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

 	var clicked = false;
 	$(".checkall").on("click", function() {
 	  $(".userfield").prop("checked", !clicked);
 	  clicked = !clicked;
 	});
 	$(".close").on("click", function() {
 	 	  $(".userfield").prop("checked", !clicked);
 	 	  clicked = !clicked;
 	 	$(".checkall").prop("checked", false);
 	 	});
 	
 	$('#proceedExport').on('click', function(ev) {
 		var arr = [];
 		$('input.userfield:checkbox:checked').each(function () {
 		    arr.push($(this).val());
 		});
 		if(arr.length==0){
 			alert('Please select atleast one field for export');
 			return false;
 		}else{
 			$('#userSelectedFields').val(arr);
 			 $(".userfield").prop("checked", !clicked);
 	 	 	  clicked = !clicked;
 	 	 	$(".checkall").prop("checked", false);
 		}
	 });
 	});

</script>
</html>
<!-- end document-->