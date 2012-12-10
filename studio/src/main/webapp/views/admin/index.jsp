<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h3>Interface d'administration</h3>
   	<div>	
		<a href="<c:url value="/populate"/>">Installation du référentiel</a></br></br>
		<a href="<c:url value="/cleandb"/>">Clean DB</a></br></br>
	</div>
</div>