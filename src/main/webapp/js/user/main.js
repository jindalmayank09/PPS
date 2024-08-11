'use strict';
var contextPath = getContextPath();
var list = new Array();
var pageList = new Array();
var currentPage = 1;
var numberPerPage = 10;
var numberOfPages = 0;
function getContextPath() {
	var contextPath = document.location.pathname;
	return contextPath.substring(0, contextPath.indexOf('/', 1));
}
var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document
		.querySelector('#singleFileUploadSuccess');

function uploadSingleFile(file) {
	var formData = new FormData();
	formData.append("file", file);

	var xhr = new XMLHttpRequest();

	xhr.open("POST", contextPath + '/uploadFile');

	xhr.onload = function() {
		// console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			singleFileUploadError.style.display = "none";
			singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>View Uploaded Data : <a href='"
					+ response.fileDownloadUri
					+ "' target='_blank'>"
					+ response.fileDownloadUri + "</a></p>";
			singleFileUploadSuccess.style.display = "block";
		} else {
			singleFileUploadSuccess.style.display = "none";
			singleFileUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
	}

	xhr.send(formData);
	document.getElementById("singleFileUploadInput").value = ""
	singleFileUploadError.style.display = "none"
	singleFileUploadSuccess.innerHTML = "";

}
var el = document.getElementById('singleUploadForm');
if (el) {

	singleUploadForm.addEventListener('submit', function(event) {
		var files = singleFileUploadInput.files;
		if (files.length === 0) {
			singleFileUploadError.innerHTML = "Please select a file";
			singleFileUploadError.style.display = "block";
		}
		uploadSingleFile(files[0]);
		event.preventDefault();
	}, true);
}

/*
 * multipleUploadForm.addEventListener('submit', function(event){ var files =
 * multipleFileUploadInput.files; if(files.length === 0) {
 * multipleFileUploadError.innerHTML = "Please select at least one file";
 * multipleFileUploadError.style.display = "block"; }
 * uploadMultipleFiles(files); event.preventDefault(); }, true);
 */

function printCard(name, phoneNo, place, dob, fromDate, toDate) {
	var model = {
		name : name,
		place : place,
		dob : dob,
		phoneNo : phoneNo,
		fromDate : fromDate,
		toDate : toDate
	};
	$.ajax({
		type : "POST",
		data : JSON.stringify(model),
		url : contextPath + '/printCard/',
		contentType : "application/json"
	}).done(function(res) {
		$("#SomeDivToShowTheResult").html(res);
	});
}

function load() {
	numberOfPages = getNumberOfPages();
}
function getNumberOfPages() {
	return Math.ceil(list.length / numberPerPage);
}
function nextPage() {
	currentPage += 1;
	loadList();
}
function previousPage() {
	currentPage -= 1;
	loadList();
}
function firstPage() {
	currentPage = 1;
	loadList();
}
function lastPage() {
	currentPage = numberOfPages;
	loadList();
}
function loadList() {
	var begin = ((currentPage - 1) * numberPerPage);
	var end = begin + numberPerPage;

	pageList = list.slice(begin, end);
	drawList(); // draws out our data
	check(); // determines the states of the pagination buttons
}
function drawList() {
	document.getElementById("list").innerHTML = "";

	for (var r = 0; r < pageList.length; r++) {
		document.getElementById("list").innerHTML += pageList[r] + "";
	}
}
function drawList() {
	document.getElementById("list").innerHTML = "";

	for (var r = 0; r < pageList.length; r++) {
		document.getElementById("list").innerHTML += pageList[r] + "";
	}
}
function check() {
	document.getElementById("next").disabled = currentPage == numberOfPages ? true
			: false;
	document.getElementById("previous").disabled = currentPage == 1 ? true
			: false;
	document.getElementById("first").disabled = currentPage == 1 ? true : false;
	document.getElementById("last").disabled = currentPage == numberOfPages ? true
			: false;
}

function searchUserData() {
	if ($("#searchUserBox").val() == null || $("#searchUserBox").val() == '') {
		$("#searchUserBox").focus();
		return false;
	} else {
		$('[name="searchUserForm"]').attr('action',
				contextPath + '/searchUserData');
		$('#searchUserForm').submit();
	}
}
function resetUserData(){
	$("#searchUserBox").val('');
	$('[name="resetUserForm"]').attr('action',
			contextPath + '/viewChildData');
	$('#resetUserForm').submit();

}
