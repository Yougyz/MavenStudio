<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h3>Bienvenu sur le proto MDM</h3>
   	<div>	
		<a href="<c:url value="/populate"/>">Installation du référentiel</a></br></br>
		<a href="<c:url value="/initCreateFormPersonne"/>">Creation de categorie de personne</a></br></br>
		<a href="<c:url value="views/structure/createForm.jsp"/>">Creation de categorie de structure</a></br></br>
    </div>
</div>
