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
                <!-- <div class="card-heading"></div> -->
                
                <div class="card-body"><div class="logo-heading"></div><div class="logo2-heading"></div>
                    <h2 class="title">Prabhu Premi Sangh Registration Form</h2><br/>
                    <h4 align="center">9th Jan 2019 to 15th Feb 2019</h4><br/>
                    <h4 align="center">Sector 14, Annapurna Marg, Jhusi, Prayagraj-211019</h4><br/>
                    <h4 align="center">9810650437 -- 9437052071 -- 9350245283</h4><br/>
                    
                    <form:form action="${pageContext.request.contextPath}/saveNewUser" method="post" modelAttribute="user" name="addUserForm"  id="addUserForm" autocomplete="off">
                    <form:hidden path="action"/>
                    <form:hidden path="userId"/>
                    <form:hidden path="regNo"/>
                    <h4 align="center">Reg No.# : <font color="red">${user.regNo}</font></h4><br/>
                        <%-- <div class="row row-space">
	                         <div class="col-2">                        
		                         <div class="input-group">
		                             <div class="rs-select2 js-select-simple select--no-search">
		                                 <form:select path="isDixit" required="required">
		                                     <form:option disabled="disabled"  selected="selected" value="">Dixit from Swamiji</form:option>
		                                     <form:option value="Y">Yes</form:option>
		                                     <form:option value="N">No</form:option>
		                                 </form:select>
		                                 <div class="select-dropdown"></div>
		                             </div>
		                         </div>
	                         </div> 
	                                             
	                         <div class="col-2" id="userTypeDiv">                        
		                         <div class="input-group">
		                             <div class="rs-select2 js-select-simple select--no-search">
		                                 <form:select path="isMbrOfPps" required="required">
		                                     <form:option disabled="disabled" value="">User Type</form:option>
		                                     <form:option value="Y">Yes</form:option>
		                                     <form:option value="N">No</form:option>
		                                 </form:select>
		                                 <div class="select-dropdown"></div>
		                             </div>
		                         </div>
	                         </div>                      
                        </div> --%>
                        <font color="red" size="4">Note:All fields are required!!</font><br/><br/>
                        
                        <div class="row row-space">
                            <div class="col-2">
		                        <div class="input-group">
        		                    <form:input path="enrollNo" class="input--style-2" type="text" placeholder="Enrollment No" required="true"/>
                		        </div>
                             </div>
							<div class="col-2">                             
		                        <div class="input-group">
		                            <form:input path="userName" class="input--style-2" type="text" placeholder="Name" required="true"/>
		                        </div>
		 					</div>
                    </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
 									<form:input path="contactNo" class="input--style-2" type="text" placeholder="Contact No" required="true" maxlength="10" onkeydown='return isNumber(event)'
									title="Please enter numeric values"/>                                
 								</div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                               	 <form:input path="aadharNo" class="input--style-2" type="text" placeholder="Aadhar No" required="true" maxlength="15" onkeydown='return isNumber(event)'
									title="Please enter numeric values"/>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
	                         <div class="col-2">
	                         	<div class="input-group">
									<form:input path="age" class="input--style-2" type="text" placeholder="Age" required="true" maxlength="2" onkeydown='return isNumber(event)'
									title="Please enter numeric values"/>  
	                             </div>
	                         </div>
	                         <div class="col-2">                        
		                         <div class="input-group">
		                             <div class="rs-select2 js-select-simple select--no-search">
		                                 <form:select path="gender" required="required">
		                                     <form:option disabled="disabled" selected="selected" value="">Gender</form:option>
		                                     <form:option value="Male">Male</form:option>
		                                     <form:option value="Female">Female</form:option>
		                                 </form:select>
		                                 <div class="select-dropdown"></div>
		                             </div>
		                         </div>
	                         </div>                      
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
 									<form:input path="userAddress" class="input--style-2" type="text" placeholder="Address" required="true"/>                               
 								</div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                               	 <form:input path="state" class="input--style-2" type="text" placeholder="State" required="true"/>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input path="city" class="input--style-2" type="text" placeholder="City" required="true"/>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input path="userPinCode" class="input--style-2" type="text" placeholder="Pin Code" required="true"/>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
	                         <div class="col-2">                        
		                         <div class="input-group">
 									<form:input path="referredBy" class="input--style-2" type="text" placeholder="Referred By" required="true"/>                                
		                         </div>
	                         </div>                      
	                         <div class="col-2">                        
                                <div class="input-group">
 									<form:input path="noOfMPrsns" class="input--style-2" type="text" placeholder="Total No  of Persons(between 1 to 15)" required="true" onkeydown='return isNumber(event)' maxlength="2" min="1" max="15"/>                                
 								</div>

	                         </div>                      
                        </div>

                              <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        <form:select path="accomodation"  required="required">
                                            <form:option disabled="disabled" selected="selected" value="">Accom Info-Fare/Day</form:option>
	                                            <form:option value="Ganga" data-param="3000">Ganga:3 Beded(Ply Cottage Attached Toilet & wash basin with Geyser)-3000</form:option>
	                                            <form:option value="Yamuna" data-param="1800">Yamuna:6 Beded(Ply Cottage Attached Toilet & wash basin with Geyser)-1800</form:option>
	                                            <form:option value="Saraswati" data-param="1200">Saraswati:12 Beded(Ply Cottage Attached Toilet & wash basin with Geyser)-1200</form:option>
	                                            <form:option value="Prayag" data-param="400">Prayag:20 Beded(Common Toilet)-400</form:option>
	                                            <form:option value="Triveni" data-param="200">Triveni:100 Beded(Common Toilet)-200</form:option>
	                                            
                                        </form:select>
                                        <div class="select-dropdown"></div>
                                    </div>
 								</div>
                        
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input class="input--style-2 datepicker" type="text" placeholder="Arrival Date" path="startDate" id="startDate" required="true" readonly="true"/>
                                    <!-- <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar-startdate"></i> -->
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input  type="text" placeholder="Arrival Time" path="arrTime" id="arrTime"  required="true" class="input--style-2"/>
                                </div>
                            </div>
                        </div>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input class="input--style-2 datepicker" type="text" placeholder="Departure Date" path="endDate" id="endDate" required="true" readonly="true"/>
                                    <!-- <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar-enddate"></i> -->
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                                    <form:input  type="text" placeholder="Departure Time" path="deptTime" id="deptTime" required="true" class="input--style-2"/>
                                </div>
                            </div>
                        </div>
                        <!-- <div class="row row-space"> -->
                            <!-- <div class="col-2"> -->
<%--                             </div>
                            <div class="col-2">
                                <div class="input-group">
                               	 <form:input path="noOfFPrsns" class="input--style-2" type="text" placeholder="No Of Female" required="true"/>
                                </div>
                            </div>
                         </div>--%>
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
 									<form:input path="totalFare" class="input--style-2" type="text" placeholder="Total Fare" readonly="true"/>                               
 								</div>
                            </div>
                            <div class="col-2">
                                <div class="input-group">
                               	 <input id="totalDays" class="input--style-2" type="text" placeholder="Total Days" readonly="readonly"/> 
                                </div>
                            </div>
                        </div>
                        <div class="p-t-30">
                            <button class="btn btn--radius btn--green" type="submit">Update</button>
                           <!--  <button class="btn btn--radius btn--green" type="submit">Reset</button> -->
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <!-- Main JS-->
    <script src="js/global.js"></script>
	<script src="js/user/user.js"></script>
	<script type="text/javascript">
		var option = '';
		var usersTypeArray = [
	        { name: 'Shivirrathi', val: 'SHIV' },
	        { name: 'Trustee', val: 'TRUST' },			       
	        { name: 'VishishthAtithi', val: 'VIATI' },
	        { name: 'Atithi', val: 'ATI' },
	        { name: 'Archak', val: 'ARCK' },
	        { name: 'Camp Sewak', val: 'CAMSWK' },
	        { name: 'Karyakarta', val: 'KAR' } ,
        	{ name: 'Pujari', val: 'PUJ' }
	    ];
 	$(document).ready(function(){
 		//$('#isMbrOfPps').html("");
 		$('#userTypeDiv').hide();
 		calculateDays();
 		<c:if test="${user.action=='view'}">
 			$('#addUserForm input').attr('readonly', 'readonly');
 			$('#accomodation,#gender').prop('disabled', true);
 			document.getElementsByClassName("datepicker")[0].disabled = true;
 			//document.getElementsByClassName("js-datepicker-enddate")[0].disabled = true;
 			$('.btn--green').hide();
 		</c:if>
 		/*   		<c:if test="${user.action=='edit'}">
 		$('#isMbrOfPps,#isDixit').prop('disabled', true);
 		</c:if>
 		
		<c:if test="${user.isDixit=='Y' || user.isDixit=='N'}">
 			$('#userTypeDiv').show();
 			<c:if test="${user.isDixit=='N'}">
 				option += '<option value="'+ usersTypeArray[0].val + '">' + usersTypeArray[0].name + '</option>';
 			</c:if>
 			<c:if test="${user.isDixit=='Y'}">
				for (var i=1;i<usersTypeArray.length;i++){
	 					$('#isMbrOfPps').html("");
	 					$('#isMbrOfPps').append($("<option></option>").attr("value","").text("User Type"));
	 				   option += '<option value="'+ usersTypeArray[i].val + '">' + usersTypeArray[i].name + '</option>';
	 				}
			</c:if>
			$('#isMbrOfPps').append(option);
			$('#isMbrOfPps option[value=${user.isMbrOfPps}]').attr('selected','selected');
 		</c:if> */
 		$('select[name=accomodation]').on("change", function(e){
 			calculateDiff();
 		});
 		$('#totalFareDiv').hide();
/*  		$('select[name=isDixit]').on("change", function(e){
				$('#isMbrOfPps').html("");
 				$('#isMbrOfPps').val("");
 				$('#userTypeDiv').hide();
			if($("#isDixit option:selected" ).val()=='Y' || $("#isDixit option:selected" ).val()=='N'){
 				$('#userTypeDiv').show();
 				$('#isMbrOfPps').html("");
 				$('#isMbrOfPps').append($("<option></option>").attr("value","").text("User Type"));
 				if($("#isDixit option:selected" ).val()=='N'){
 					option='';
 	 				   option += '<option value="'+ usersTypeArray[0].val + '">' + usersTypeArray[0].name + '</option>';
				}else if($("#isDixit option:selected" ).val()=='Y'){
					option='';
 	 				for (var i=1;i<usersTypeArray.length;i++){
 	 					$('#isMbrOfPps').html("");
 	 					$('#isMbrOfPps').append($("<option></option>").attr("value","").text("User Type"));
  	 				   option += '<option value="'+ usersTypeArray[i].val + '">' + usersTypeArray[i].name + '</option>';
  	 				}
				}
 				$('#isMbrOfPps').append(option);
 			}else if($("#isDixit option:selected" ).val()=='-1'){
 				$('#userTypeDiv').hide();
 				$('#isMbrOfPps').html("");
 				$('#isMbrOfPps').val("");
 			}
 				
 		}); */ 		
 	});
 	</script>
</body>
</html>
<!-- end document-->