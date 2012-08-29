<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${files}" begin="0" step="1" var="file">
    ${file.customName}
</c:forEach>