
package edu.blog.servlets;

import com.sun.net.httpserver.HttpServer;
import edu.blog.beans.AuthService;
import edu.blog.models.models.Credentials;
import edu.blog.models.models.User;
import edu.blog.models.services.UserServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration") // позволяет найти этот класс и сконфигурировать 
public class RegistrationServlet extends HttpServlet{

    static final String JSP = "/WEB-INF/pages/registration.jsp";
    
    @Inject AuthService authService;
    
    @EJB UserServiceLocal userService;
    
    private void redirect(HttpServletRequest request, HttpServletResponse response, String location) 
                                throws ServletException, IOException{
        response.setHeader("Location",location);
        response.setStatus(302);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                                    throws ServletException, IOException {
        
        if(authService.isAuth()){
            String referer = request.getHeader("Referer");
            if (referer == null){
                referer = request.getContextPath();
            }
            redirect(request, response, referer);
        }else{
     request.getRequestDispatcher(JSP).forward(request, response);
     
    }
    
    }

    private void validateParameters(String login, String password, String confirmation){
        if (login == null || login.trim().isEmpty()){
            throw new IllegalStateException("error.login.required");
        }    
        if (password == null || password.trim().isEmpty()){
            throw new IllegalStateException("error.password.required");
        }    
        if (confirmation == null || confirmation.trim().isEmpty()){
            throw new IllegalStateException("error.password.confirmation.required");
        }   
        
        
        if (!password.equals(confirmation)){
            throw new IllegalStateException("error.password.confirmation.incorrect");
        }
        }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmation = request.getParameter("confirmation");
       
        try{
            validateParameters(login, password, confirmation);
            Credentials credentials = new Credentials(login, password);
            User user = new User(login, credentials);
            userService.create(user);
            redirect(request, response, request.getContextPath()+ "/login");
            
        } catch (IllegalStateException e){
            request.setAttribute("exception", e);
            doGet(request, response);
        }
    }
    
    
    
}
