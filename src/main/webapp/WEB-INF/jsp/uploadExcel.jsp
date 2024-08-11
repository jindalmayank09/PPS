<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<meta charset="UTF-8">
<meta name="description" content="PPS">
<meta name="author" content="PPS">
<meta name="keywords" content="PPS">

<!-- Title Page-->
<title>Prabhu Premi Sangh</title>
<link rel="icon" type="image/ico" href="images/swamiji_icon_latest.jpg" />
<link rel="stylesheet" href="css/excelmain.css" media="all" />
</head>
<body>
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>
	<div class="upload-container">
		<div class="upload-header">
			<h2>Upload Excel File</h2>
			<h2 style="margin-top: -58px; margin-left: 280px;">
				<a href="${pageContext.request.contextPath}/"
					style="text-decoration: none">Create New User</a>
			</h2>
			<c:if test="${childSize>0 }">
				<h2 style="margin-top: -58px; margin-left: 480px;">
					<a href="${pageContext.request.contextPath}/viewChildData"
						style="text-decoration: none">View Added Data</a>
				</h2>
			</c:if>
		</div>
		<div class="upload-content">
			<div class="single-upload">
				<h3>Upload File</h3>
				<form id="singleUploadForm" name="singleUploadForm">
					<input id="singleFileUploadInput" type="file" name="file"
						class="file-input" required />
					<button type="submit" class="primary submit-btn">Submit</button>
				</form>
				<div class="upload-response">
					<div id="singleFileUploadError"></div>
					<div id="singleFileUploadSuccess"></div>
				</div>
			</div>
			<!--                 <div class="multiple-upload">
                    <h3>Upload Multiple Files</h3>
                    <form id="multipleUploadForm" name="multipleUploadForm">
                        <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required />
                        <button type="submit" class="primary submit-btn">Submit</button>
                    </form>
                    <div class="upload-response">
                        <div id="multipleFileUploadError"></div>
                        <div id="multipleFileUploadSuccess"></div>
                    </div>
                </div>
 -->
		</div>
	</div>
	<script src="js/user/main.js"></script>
</body>
</html>