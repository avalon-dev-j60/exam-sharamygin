<%-- 
    Document   : layout
    Created on : Jun 14, 2019, 7:48:30 PM
    Author     : sera
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%--Заголовок страницы--%>
<%@attribute name="title" required ="true"%>

<!DOCTYE html>
<html>
    <head>
        <title>
            ${title}
        </title>
        
            <link href="${pageContext.servletContext.contextPath}/css/groundwork-setup.css"
                  type="text/css"
                  rel="stylesheet">
        
    </head>
    <body>
        
        <header class="three fourths centered padded">
            <a href="${pageContext.servletContext.contextPath}/">
               Home
            </a>

            <c:choose>
                
                <c:when test="${not empty sessionScope.auth}">
            <a href="${pageContext.servletContext.contextPath}/logout"
               class="inline-block pull-right">
                Sign out
            </a>
                </c:when>
                
                <c:otherwise>
            <a href="${pageContext.servletContext.contextPath}/login"
               class="inline-block pull-right">
                Sign in
            </a>                    
                </c:otherwise>
                
            </c:choose>
     
        </header>
               
        <header class="three fourths centered padded">
            <a href="${pageContext.servletContext.contextPath}/choose">
               To projects list
            </a>
        </header>
        
        <section class="two fourths centered padded bounceInDown animated">        
            <jsp:doBody/>           
        </section>
    </body>
</html>