<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>Creation personne</title></head>
<body>
                <form method="post" action="<c:url value="/createPersonne" />">
                    <h4>Nom de la catégorie de personne
                    <input type="text" size="30" name="name" value=""/>  					
				<select name="typeOf" id="Select1" size="1">	                    
                    <c:choose>
						<c:when test="${not empty listTypeOf}">
						      <c:forEach items="${listTypeOf}" var="type">
								 <option value="${type.id}">${type.name}</option>																							
						      </c:forEach>
						</c:when>
						<c:otherwise>
						    <h2>Pas de type</h2>
						</c:otherwise>
						</c:choose>
					</select>               									   				                                       
                    <center><input type="submit" value="Valider"/></center>
                    </h4>
                </form>
</body>

</html>