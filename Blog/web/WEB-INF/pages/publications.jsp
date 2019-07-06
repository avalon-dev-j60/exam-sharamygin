<%-- 
    Document   : publications
    Created on : Jul 5, 2019, 9:00:09 PM
    Author     : sera
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="pubs" tagdir="/WEB-INF/tags/publications/"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>


<common:layout title = "Publications">
    
    <pubs:publicationList publications = "${publications}"/>
    
</common:layout>