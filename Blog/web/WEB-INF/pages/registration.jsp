<%-- 
    Document   : registration
    Created on : Jun 28, 2019, 8:24:31 PM
    Author     : sera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/"%>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/"%>


<common:layout title="Registration">
    
    <div class="one half centered">
    <h2>Registration</h2>
    <auth:registrationForm/>
    </div>
    
</common:layout>