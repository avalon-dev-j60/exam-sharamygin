<%-- 
    Document   : registrationForm
    Created on : Jun 28, 2019, 8:02:14 PM
    Author     : sera
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.servletContext.contextPath}/calc"
      method="POST"
      class ="pull-left one thirds padded  bounceInDown animated" style="min-width: 200">

<div class ="row gap-bottom">
    <label>z1: </label>        
    <input class="param"
               style ="background-color: oldlace"
               type="number" 
               name="teeth1" 
               min="17"
               value="<%= request.getParameter("teeth1") %>"
               required>
</div>
       
    <div class="row gap-bottom">
        <label>z2: </label>
        <input class="param"
               style ="background-color: oldlace"
               type="number" 
               name="teeth2" 
               min="17"
               value="<%= request.getParameter("teeth2") %>"
               required>
    </div>
    
    <div class="row gap-bottom ">
        <label>m: </label>
        <input class ="param" 
               type="number"
               step="0.25"
               name="module" 
               min ="1"
               max ="60"
               style ="background-color: oldlace"
               value="<%= request.getParameter("module") %>"
               placeholder="mm"
               required>
    </div>
        
        <div  class="row gap-bottom">
            <br>
        <button style="width: inherit;
                text-align: left">
            Calculate
        </button>
        </div>
               
               <div class="row gap-bottom"
                    style = "font-size: x-small">
                   Legend:<br>
                   z1 = number of teeth for gear 1;<br>
                   z2 = number of teeth for gear 2;<br>
                   m = module<br>
               </div>
               
    <div class="row gap-bottom"
         style="font-size: small">
        <common:error/>
    </div>

    </form>

        
<form class ="pull-right two third padded border-left bounceInDown animated" style="min-width: 200">
    <div class="row gap-bottom ">
        <label>Reference diameter of gear 1: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("ref1") + ", mm" %>"
               placeholder=""
               readonly>
    </div>  

    <div class="row gap-bottom ">
        <label>Reference diameter of gear 2: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("ref2") + ", mm" %>"
               placeholder=""
               readonly>
    </div>                 
               
               
    <div class="row gap-bottom ">
        <label>Tip diameter of gear 1: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("tip1") + ", mm" %>"
               readonly>
    </div>   
               
    <div class="row gap-bottom ">
        <label>Tip diameter of gear 2: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("tip2") + ", mm" %>"
               placeholder=""
               readonly>
    </div>                 
    
               
    <div class="row gap bottom ">
        <label>Root diameter of gear 1: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("root1") + ", mm"%>"
               placeholder=""
               readonly>
    </div>   
               
    <div class="row gap-bottom ">
        <label>Root diameter of gear 2: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("root2") + ", mm"%>"
               placeholder=""
               readonly>
    </div>                  
               

    <div class="row gap-bottom ">
        <label>Center distance: </label> 
        <input type="text" 
               style ="background-color: #5faee3"
               value="<%= request.getAttribute("centre") + ", mm"%>"
               placeholder=" "
               readonly>
    </div>   
               
    <div class="row gap-bottom ">
        <label>Gear ratio: </label> 
        <input type="text" 
               style ="background-color: #1abc9c"
               value="<%= request.getAttribute("ratio") + ", mm"%>"
               placeholder=" "
               readonly>
    </div>
           
</form>
               
<form action="${pageContext.servletContext.contextPath}/"
          method="POST"
          class ="pull-right padded bounceInDown animated">
    <div class="row gap-bottom">   
    <button style="width: inherit;
            text-align: left">
                    Save 
    </button>
    </div>
</form>
          

<form class ="pull-left padded  bounceInright animated">
    <div class="row gap-bottom">   
        <text>

        
        </text>
    </div>
</form>