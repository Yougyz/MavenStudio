<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>OK</title></head>
<body>

<a href="<c:url value="views/personne/createForm.jsp"/>">Retour create personne</a> 
</br>
Ajout de ${personne.name} r�ussie !
</body>

</html>