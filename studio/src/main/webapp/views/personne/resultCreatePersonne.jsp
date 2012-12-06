<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>OK</title></head>
<body>

<a href="<c:url value="views/personne/createForm.jsp"/>">Retour create personne</a> 
</br>
Ajout de ${variable.name} réussie !
<c:choose>
<c:when test="${not empty listTypeOf}">
      <c:forEach items="${listTypeOf}" var="type">
        <li>
          <div class="search-result-details">
			${type.name}
          </div>
        </li>
      </c:forEach>
</c:when>
<c:otherwise>
    <h2>Pas de type</h2>
</c:otherwise>
</c:choose>
</body>

</html>