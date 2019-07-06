<%-- 
    Document   : error
    Created on : Jun 28, 2019, 8:03:28 PM
    Author     : sera
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<fmt:setBundle basename="edu.blog.resources.errors"/>
    
<%@attribute name="exception"%>
<c:if test="${not empty exception}">
    <p class="box error">
        <fmt:message key="${exception.message}"/>
    </p>
</c:if>
    