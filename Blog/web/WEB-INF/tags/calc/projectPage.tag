<%-- 
    Document   : registrationForm
    Created on : Jun 28, 2019, 8:02:14 PM
    Author     : sera
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.servletContext.contextPath}/choose"
      method="POST">

    <div class ="padded one fifth bounceInDown animated pull-left" ">
        <label>Your login: </label>        
        <input     type="text" 
                   name="login" 
                   value="<%= request.getAttribute("login") %>"
                   readonly>
  
    </div>
                   
    <div class = "row padded one fifth bounceInDown animated pull-left "> 
        <a href="${pageContext.servletContext.contextPath}/calc">
        Create new project
        </a>
    </div>  
          
               
<div class="row gap-bottom">
<common:error/>
</div>

</form>