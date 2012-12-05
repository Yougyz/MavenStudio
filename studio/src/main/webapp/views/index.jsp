<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>menu</title></head>
<body>
Bienvenu !!
<a href="<c:url value="/populate"/>">Installation du référentiel</a></br>
<a href="<c:url value="/personne/createForm"/>">Creation de catergorie de personne</a></br>
<a href="<c:url value="/structure/createForm"/>">Creation de catergorie de structure</a></br>
</body>

</html>
