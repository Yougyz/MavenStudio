<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>Creation personne</title></head>
<body>


                <form method="post" action="<c:url value="/createPersonne" />">
                    <h4>Creation d'une nouvelle catégorie de structure
                    <input type="text" size="100" name="name" value=""/>
                    <input type="submit" value="Valider"/>
                    </h4>
                </form>


</body>

</html>