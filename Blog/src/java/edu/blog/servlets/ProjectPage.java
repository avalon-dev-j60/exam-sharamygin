
package edu.blog.servlets;

import edu.blog.beans.AuthService;
//import edu.blog.models.data.Data;
import edu.blog.models.models.User;
import edu.blog.models.services.UserService;
import edu.blog.models.services.UserServiceLocal;
import static edu.blog.util.RedirectHelper.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/choose")
public class ProjectPage extends HttpServlet{
    
    private static final String JSP = "WEB-INF/pages/projectPage.jsp";
    
    @Inject AuthService authService;
    @EJB UserServiceLocal userService; 
    
LoginServlet log;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if(!authService.isAuth()){
            redirectLocaly(request, response, "/login");
        } else { 

        RequestDispatcher dispatcher = request.getRequestDispatcher(JSP);
        dispatcher.forward(request, response);
        
                }
    }

   /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
            String login = request.getParameter("login");
            login =  authService.getLogin();
            String z1 = request.getParameter("z1");
            String z2 = request.getParameter("z2");
            String m = request.getParameter("m");
        
        try{
           // Data data = new Data(z1, z2, m);
            User user = new User(login, z1, z2, m, data);
            userService.update(user);
            redirect(request, response, request.getContextPath()+"/calc");
            
        } catch (IllegalStateException e){
            request.setAttribute("exception", e);
            doGet(request, response);
        }
      
    }
    
    
    
 */   
}
  