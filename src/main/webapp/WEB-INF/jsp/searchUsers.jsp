<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
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
	<link href="css/jquery.dataTables.min.css" rel="stylesheet" media="all">
	<link href="css/datatables.css" rel="stylesheet" media="all">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="all">
    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
</head>
<body>

    <div class="page-wrapper bg-red p-t-180 p-b-100 font-robo">
    <%-- <jsp:include page="menu.jsp" /> --%>
        <div class="wrapper wrapper--w960">
            <div class="card card-2">
                <!-- <div class="card-heading"></div> -->
                <div class="card-body"><div class="logo-heading"></div><div class="logo2-heading"></div>
                    <h2 class="title">Prabhu Premi Sangh Registration Form</h2><br/>
                    <h4 align="center">9th Jan 2019 to 15th Feb 2019</h4><br/>
                    <h4 align="center">Sector 14, Annapurna Marg, Jhusi, Prayagraj-211019</h4><br/>
                    <h4 align="center">9810650437 -- 9437052071 -- 9350245283</h4><br/>
                    <h2 class="title">Search Users</h2>
                    <form:form action="${pageContext.request.contextPath}/getUsersList" method="post" modelAttribute="user" name="searchUserForm"  id="searchUserForm" autocomplete="off">
                       <form:hidden path="userId" />
                       <form:hidden path="action" />
                       <form:hidden path="pageNumber" id="pageNumberId"/>
                        <div class="row row-space">
                            <!-- <div class="col-2"> -->
                                <div class="input-group">
                               	 <form:input path="regNo" class="input--style-2" type="text" placeholder="Registration No"/>
                                </div>
                            <!-- </div> -->
	                        <%-- <div class="col-2">
		                        <div class="input-group">
		                            <form:input path="userName" class="input--style-2" type="text" placeholder="Name"/>
		                        </div>
	                        </div> --%>
                        </div>
                        <%-- <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
 									<form:input path="contactNo" class="input--style-2" type="text" placeholder="Contact No"/>                                
 								</div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                               	 <form:input path="aadharNo" class="input--style-2" type="text" placeholder="Aadhaar No"/>
                                </div>
                            </div>
                        </div> --%>

                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Search</button>
                            <!-- <button class="btn btn--radius btn--green" type="submit">Reset</button> -->
                        </div>
               <c:if test="${searchResult eq 'true'}">         
				<c:choose>
					<c:when test="${not empty searchUserList}">
						<div id="air_tb" class="">
							<!-- <input type="button" class="download_button" value="Download Audit Trail" /> -->
							<table border="2"  id="DataTables_Table_0"  style="margin-top: 15px;">
								<!--  class="dataTable no-footer" role="grid" aria-describedby="DataTables_Table_0_info"> -->
								<thead>
									<tr>
										<th style="display: none;"></th>
										<th width="10%">Reg No</th>
										<th width="8%">Name</th>
										<th width="8%">Contact No</th>
										<!-- <th>Aadhaar No</th> -->
										<th width="15%">Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${searchUserList}" var="v">
										<tr>
											<td style="display: none;">${v.creationTime}</td>
											<c:set var = "regNos" value = "${fn:split(v.regNo, '/')}"/>
											<td width="10%">${regNos[1]}</td>
											<td width="8%">${v.userName}</td>
											<td width="8%">${v.contactNo}</td>
											<%-- <td>${v.aadharNo}</td> --%>
											<td width="15%">
												<%-- <a  href="#" id="${v.userId}" onclick="editViewUser(${v.userId},'view');" style="cursor: pointer;text-decoration:none;">View &nbsp;&nbsp;
										      		<img src="${pageContext.request.contextPath}/images/viewuser.jpg"  alt="View User Details" title="View User Details"   style="display:block;margin-left:9px;"></img>
											  	</a> --%>
											  	<c:if test="${v.noOfMPrsns>1}">
				    								<a href="${pageContext.request.contextPath}/addSubUsers?userObj=${v.userId}_create&${v.creationTime}" style="cursor: pointer;text-decoration:none;">Add More Users</a>
				    							</c:if>
												<a href="#" id="${v.userId}" onclick="editViewUser(${v.userId},'edit');" style="cursor: pointer;text-decoration:none;margin-left: 10px;">Edit
										      		<%-- <img src="${pageContext.request.contextPath}/images/edit-image.png"  alt="Edit User Details" title="Edit User Details"   style="display:block;margin-top:-32px;margin-left:48px;width: 15px;"></img> --%>
											  	</a>
												<a href="${pageContext.request.contextPath}/printPdf/${v.userId}" id="${v.userId}" style="cursor: pointer;text-decoration:none;margin-left: 10px;">Print I-Card
										      		<%-- <img src="${pageContext.request.contextPath}/images/edit-image.png"  alt="Edit User Details" title="Edit User Details"   style="display:block;margin-top:-32px;margin-left:48px;width: 15px;"></img> --%>
											  	</a>
											  	
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<%-- <jsp:include page="paginationbar.jsp"></jsp:include> --%>
						</div>
						 <div class="p-t-30">
                            <!-- <button class="btn btn--radius btn--green"  id="exportBtn" data-toggle="modal" data-target="#myModal">Export</button> -->
                            <!-- <button class="btn btn--radius btn--green" type="submit">Reset</button> -->
                        </div>
                                     
                         <!-- Trigger the modal with a button -->
							<button type="button" class="btn btn--radius btn--green" name="${pageContext.request.contextPath}/selectUserFieldsToExportData" id="exportBtn">Export</button>
					</c:when>
					<c:otherwise>
						<div id="msg" align="center">
							<span style="color: red">No Data Found</span>
						</div>
					</c:otherwise>
				</c:choose>
       </c:if>                 
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/jquery/jquery.dataTables.min.js"></script>
    <%-- <script src="vendor/jquery/bootstrap.js"></script>--%>
    <script src="vendor/jquery/bootstrap.min.js"></script> 
    <%-- <script src="vendor/jquery/modal.js"></script> --%>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>
	<script src="js/user/user.js"></script>
	<script type="text/javascript">
 	$(document).ready(function(){
 		var
 		w       = 470,
 		h       = 400,
 		l       = (screen.availWidth - w) / 2,
 		t       = (screen.availHeight - h) / 2,
 		popPage = '#exportBtn',
 		popPagePdf = '#exportBtn';
 		$(popPage).on('click',function(event){
 			window.open(this.name,"window","width= "+ w + ",height=" + h + ",left=" + l + ",top=" + t + ", scrollbars = yes, location = no, toolbar = no, menubar = no, status = no");
 			 return false;
 		});
 		$(popPagePdf).on('click',function(event){
 			window.open(this.href,"window","width= "+ w + ",height=" + h + ",left=" + l + ",top=" + t + ", scrollbars = yes, location = no, toolbar = no, menubar = no, status = no");
 			 return false;
 		});
 	
 	});
 	function submitPageForPagination(pageNumber){		
 		$("#pageNumberId").val(pageNumber);
 		$("#searchUserForm").submit();
 	}
 	
 	function Download(url) {
 	    
 	}
 	</script>
 	
 	
</body>
</html>
<!-- end document-->