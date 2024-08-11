<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
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
<link rel="stylesheet" href="css/excelmain.css" />
<!-- <link type="text/css" rel="stylesheet" href="css/simplePagination.css" /> -->

</head>
<body>
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>
	<div class="upload-container">
		<div class="upload-header">
			<h2>User Uploaded Data</h2>
			<h2 style="margin-top: -58px; margin-left: 350px;">
				<a href="${pageContext.request.contextPath}/"
					style="text-decoration: none">Create New User</a>
			</h2>

			<h2 style="margin-top: -58px; margin-left: 550px;">
				<a href="${pageContext.request.contextPath}/uploadExcelFile"
					style="text-decoration: none">Upload Data</a>
			</h2>
		</div>
		<div class="upload-content">&nbsp;&nbsp;&nbsp;</div>
		<div style="margin-left: 275px;">
			<form method="post" name="searchUserForm" id="searchUserForm"
				autocomplete="off">
				<input type="text" placeholder="Search by Name/Phone No"
					required="required" style="height: 40px" name="searchUserBox"
					id="searchUserBox" />
				<button class="primary submit-btn" id="searchUser" type="submit"
					onclick="searchUserData();">Search</button>
				<button class="primary submit-btn" id="searchUser" type="submit"
					onclick="resetUserData();" style="margin-left: 8px;">Reset</button>
			</form>
		</div>

		<div class="upload-content" style="margin-top: 25px;">&nbsp;&nbsp;&nbsp;</div>
		<div class="upload-content" id="viewData">
			<div>
				<c:choose>
					<c:when test="${childObj.size()>0}">
						<table border="1" style="margin-left: 10px; width: 700px;"
							class="pagination" data-pagecount="3" id="userData">
							<tbody>
								<tr style="color: #618E91">
									<td>Name</td>
									<td>Phone No</td>
									<td>Place</td>
									<td>Date of Birth</td>
									<td>From Date</td>
									<td>To Date</td>
									<td>Generate Card</td>
								</tr>
								<c:forEach var="child" items="${childObj}">
									<tr>
										<td width="15%" style="word-break: break-all;">${child.name}</td>
										<td width="25%" style="word-break: break-all;">${child.phoneNo}</td>
										<td width="20%" style="word-break: break-all;">${child.place}</td>
										<td width="15%" style="word-break: break-all;">${child.dob}</td>
										<td width="15%" style="word-break: break-all;">${child.fromDate}</td>
										<td width="15%" style="word-break: break-all;">${child.toDate}</td>
										<td width="10%"><button type="button"
												class="primary submit-btn"
												onclick="printCard('${child.name}','${child.phoneNo}','${child.place}','${child.dob}','${child.fromDate}','${child.toDate}')"
												style="margin-right: 10px;">Generate</button></td>
									</tr>

								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<h3 align="center">Sorry!! No Data Available</h3>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- 		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
		<div style="text-align: center;">
			<input type="button" id="first" onclick="firstPage()" value="first" />
			<input type="button" id="next" onclick="nextPage()" value="next" />
			<input type="button" id="previous" onclick="previousPage()"
				value="previous" /> <input type="button" id="last"
				onclick="lastPage()" value="last" />

			<div id="list"></div>
		</div>
 -->
	</div>

	<script>
		function makeList() {
			for (var i = 0; i < "${childObj.size()}"; i++) {
				var u = {
					name : '${childObj[i]}.username',
					phoneNo : '${childObj[i]}.phoneNo',
					place : '${childObj[i]}.phoneNo',
					dob : '${childObj[i]}.dob',
					from : '${childObj[i]}.from',
					to : '${childObj[i]}.to',
				};
				list.push(u);
			}
		}
	</script>
	<script type="text/javascript" src="vendor/jquery/jquery.js"></script>
	<!-- <script type="text/javascript" src="js/jquery.simplePagination.js"></script> -->

	<script src="js/user/main.js"></script>
</body>
</html>