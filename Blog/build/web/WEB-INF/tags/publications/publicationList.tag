<%-- 
    Document   : publicationList
    Created on : Jul 5, 2019, 8:48:24 PM
    Author     : sera
--%>

<%@tag import="edu.blog.models.models.Publication"%>
<%@tag import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="publications" required = "true" type="List<Publication>"%>

<c:choose>

    <c:when test="${not empty publications and !publications.isEmpty()}">               
        <c:forEach items = "${publications}" var = "item">

            <p class="row gap-bottom">
            <h3>
                <a href="${pageContext.servletContext.contextPath}/publication?id=${item.id}">
                    ${item.title}
                </a>
            </h3>
            ${item.content.substring(0, 256)} ...    
        </p>


    </c:forEach>
</c:when>
            <c:otherwise>
        <p>
            There is no publications yet!
        </p>
    </c:otherwise>
</c:choose>