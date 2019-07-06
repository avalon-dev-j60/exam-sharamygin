<%-- 
    Document   : login
    Created on : Jun 14, 2019, 8:34:13 PM
    Author     : sera
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<fmt:setBundle basename="edu.blog.resources.labels"/>

<form action="${pageContext.servletContext.contextPath}/login"
      method="POST"
      class="centered"
      style="max-width: 300px">  
    
    <common:error/>
    
    <div class="row gap-bottom">
        <label>
            <fmt:message key="form.login.label"/>
        </label>
        <input type="text" 
               name="login" 
               value="${param.login}"
               placeholder="<fmt:message key="form.login.placeholder"/>">
    </div>
    
        <div class="row gap-bottom">
        <label>Password:</label>
        <input type="password" 
               name="password" 
               placeholder="Your password ...">
    </div>

    <div class="row">
        <a href="${pageContext.servletContext.contextPath}/registration">
        Registration
        </a>
        
        <button class="pull-right">
            Sign in
        </button>
        
    </div>
    
    
</form>
