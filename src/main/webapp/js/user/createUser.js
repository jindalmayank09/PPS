var contextPath = getContextPath();

function getContextPath(){
	  var contextPath = document.location.pathname;
	  return contextPath.substring(0,contextPath.indexOf('/', 1));
	}



		
(function ($) {
		    'use strict';		
	    try {
	 		var dates = $("#fromDate, #toDate").datepicker({
	 		    changeMonth: true,
	 		    changeYear: true,
	            //maxDate:new Date("02/15/2019"),
	 		    minDate: new Date(),
	 		    dateFormat: 'dd/mm/yy',
	 		    onSelect: function(selectedDate) {
	 		        var option = this.id == "fromDate" ? "minDate" : "maxDate",
	 		            instance = $(this).data("datepicker"),
	 		            date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
	 		        dates.not(this).datepicker("option", option, date);
	 		    }
	 		});
			}
	    catch(er) {console.log(er);}		
		})(jQuery);
