
package edu.blog.servlets;

import edu.blog.models.services.PublicationService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/publications")
public class IndexServlet extends HttpServlet{
    
    
   private static final String JSP = "/WEB-INF/pages/publications.jsp"; 

   @EJB PublicationService publicationService;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("publications", publicationService.list());
        request.getRequestDispatcher(JSP).forward(request, response);
    }
   
   
   
}
