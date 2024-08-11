var contextPath = getContextPath();

function getContextPath(){
	  var contextPath = document.location.pathname;
	  return contextPath.substring(0,contextPath.indexOf('/', 1));
	}

function getStateList(countryId) 
{
	$('#stateId').html("");
	$('#cityId').html("");
	$('#stateId').append($("<option></option>").attr("value","").text("State"));
	$('#cityId').append($("<option></option>").attr("value","").text("City"));
	if(countryId!=null && countryId!=-1){
	$.ajax({
		url : contextPath +'/getStatesByCountryId',
		global : false,
		type : "GET",
		data : {
			countryId : countryId
		},
		dataType : "json",
		success : function(data) {
			  $.each(data, function(i, item) {
				  addDynamicOptionsForStates(document.addUserForm.state, item.stateId, item.stateName);
  				});
		}
	}); 
	}
	}

function getCityList(stateId) {
	
	$('#cityId').html("");
	$('#cityId').append($("<option></option>").attr("value","").text("City"));
	$.ajax({
		url : contextPath +'/getCitiesByCountryIdandStateId',
		global : false,
		type : "GET",
		data : {
			stateId : stateId,
			countryId:$("#countryId option:selected" ).val()
		},
		dataType : "json",
		success : function(data) {
			
			  $.each(data, function(i, item) {
				  addDynamicOptionsForCities(document.addUserForm.city, item.cityId, item.cityName);
 				});
		}
	}); 
}

function addDynamicOptionsForStates(selectElement, optionval, name){
	var option = document.createElement("option");
	var selectedElement = document.getElementById("stateId");
    option.text = name;
    option.value = optionval;
    selectedElement.add(option);
}
function addDynamicOptionsForCities(selectElement, optionval, name){
	var option = document.createElement("option");
	var selectedElement = document.getElementById("cityId");
    option.text = name;
    option.value = optionval;
    selectedElement.add(option);
}
function calculateDiff() {
		if($("#startDate").val()!="" && $("#endDate").val()!=""){
		var accomValue = $("#accomodation option:selected").attr("data-param");
		var noOfPersons = $('#noOfMPrsns').val();
		if(accomValue!=null && noOfPersons!=null && noOfPersons>0){
				$('#totalFare').val(accomValue*($('#totalDays').val())*noOfPersons);
				
			}
		}else{
		    alert("Please select dates");
		    $("#accomType").val('');
		    return false;
		}
}

function editViewUser(userId,action) {
		$("#userId").val(userId);
		$("#action").val(action);
		$('[name="searchUserForm"]').attr('action',contextPath+'/editViewUserDetails');
		$('#searchUserForm').submit();
	
}

	function validateUserForm(){
 		if($("#isDixit option:selected" ).val()==null || $("#isDixit option:selected" ).val()==''){
 			alert('Please select Dixit From Swamiji field.');
 			$("#isDixit").focus();
 			return false;
 		}
 		if($("#isDixit option:selected" ).val()=='Y' || $("#isDixit option:selected" ).val()=='N'){
 			if($("#isMbrOfPps option:selected" ).val()==null || $("#isMbrOfPps option:selected" ).val()==''){
 			alert('Please select User Type field.');
 			$("#isMbrOfPps").focus();
 				return false;
 			}
 		}
 		if($("#gender option:selected" ).val()==null || $("#gender option:selected" ).val()==''){
 			alert('Please select Gender.');
 			$("#gender").focus();
 			return false;
 		}

/* 		if($("#startDate").val()!=null && $("#startDate").val()==''&& $("#endDate").val()!=null && $("#endDate").val()!=''){
 			var startDtArr = $("#startDate").val().split("/");
 			 var arrivalDt= startDtArr[1]+"/"+startDtArr[0]+;
 			compareDates()
 		}
*/ 		
 		if($('#noOfMPrsns').val()>16){
 			alert('Maximum 16 Persons allowed with one registration!!');
 			$('#noOfMPrsns').val('');
 			return false;
 		}
 		if($("#accomType option:selected" ).val()==null || $("#accomType option:selected" ).val()==''){
 			alert('Please select Accom Info.');
 			$("#accomType").focus();
 			return false;
 		}

 		$('[name="saveNewUser"]').attr('action', contextPath + '/saveNewUser');
 	}
	
	function compareDates(arrivalDate,departureDate){
	     if (arrivalDate>departureDate) {
	    	 alert ("Arrival Date can not be More than Departure Date");
	    	 return false;
	     }else if (arrivalDate==departureDate) {
		   alert ("Both Dates can not be same");
		   return false;
	     }else
	    	 return true;
	     
	  }
	
		$("#noOfMPrsns").keyup(function () {
 			var min = parseInt($(this).attr('min'));
 	        var max = parseInt($(this).attr('max'));
 	        var val = parseInt($(this).val());
 	      if(val < min){
 	    	  alert('Minimum ' +min+ ' Person is required for registration');
 	    	 $(this).val( min );
 	      }
 	      if(val > max){
 	    	 alert('Maximum ' +max+ ' Person is allowed for registration');
 	    	 $(this).val( max );
 	      }
 	     if($("#startDate").val()!="" && $("#endDate").val()!="" && $("#accomodation option:selected" ).val()!=null && $("#accomodation option:selected" ).val()!='-1'){
 	    	 $('#accomodation').trigger("change");
	    	 
	      }
 	    
 		  });
		
(function ($) {
		    'use strict';		
	    try {
	 		var dates = $("#startDate, #endDate").datepicker({
	 		    changeMonth: true,
	 		    changeYear: true,
	            maxDate:new Date("02/15/2019"),
	 		    minDate: new Date("12/01/2018"),
	 		    dateFormat: 'dd/mm/yy',
	 		    onSelect: function(selectedDate) {
	 		        var option = this.id == "startDate" ? "minDate" : "maxDate",
	 		            instance = $(this).data("datepicker"),
	 		            date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
	 		        dates.not(this).datepicker("option", option, date);
	 		       var diff = 0;
	 		        calculateDays();
	 		       $('#totalFare').val(0);
	 	            var accomValue = $("#accomodation option:selected").attr("data-param")!=null && $("#accomodation option:selected" ).val()!='-1'?$("#accomodation option:selected").attr("data-param"):0;
	 	            var noOfPersons = $('#noOfMPrsns').val()!=null?$('#noOfMPrsns').val():1;
	 	            diff = $('#totalDays').val();
	 	           $('#totalFare').val(accomValue*diff*noOfPersons);
	 		    }
	 		});
			}
	    catch(er) {console.log(er);}		
		})(jQuery);

function calculateDays(){
     var d1 = $('#startDate').datepicker('getDate');
      var d2 = $('#endDate').datepicker('getDate');
      var diff = 0;
      if (d1 && d2) {
          diff = Math.floor((d2.getTime() - d1.getTime()) / 86400000); // ms per day
      }
      $('#totalDays').val(diff);

}