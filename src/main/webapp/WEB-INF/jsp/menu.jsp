<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border:1 px solid red;">
<div>
		<a href="${pageContext.request.contextPath}/" style="cursor: pointer;">
			<img src="${pageContext.request.contextPath}/images/Add-User-icon.png"  alt="Add New User" title="Add New User"   style="width:70px;height: 58px;display:block;margin-top:-170px;margin-left:980px;"></img>
		</a>
		
		<a href="${pageContext.request.contextPath}/getUsersList" style="cursor: pointer;">
			<img src="${pageContext.request.contextPath}/images/View-User-icon.png"  alt="View Users List" title="View Users List"   style="width:70px;height: 70px;display:block;margin-top:-61px;margin-left:1050px;"></img>
		</a>
		
		<a href="#" id="${v.userId}" onclick="goBack()" style="cursor: pointer;">
			<img src="${pageContext.request.contextPath}/images/back-icon.png"  alt="Go Back" title="Go Back"   style="width:31px;height: 70px;display:block;margin-top:-66px;margin-left:1120px;"></img>
		</a>
</div>
</div>
<script>
function goBack() {
    window.history.back()
}
</script>