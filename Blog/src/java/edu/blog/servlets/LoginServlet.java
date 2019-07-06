
package edu.blog.servlets;

import edu.blog.beans.AuthService;
import edu.blog.exceptions.ValidationException;
import edu.blog.models.models.Credentials;
import edu.blog.models.models.User;
import edu.blog.models.services.UserServiceLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static edu.blog.util.RedirectHelper.*;
import static edu.blog.util.ValidationHelper.*;
import javax.inject.Inject;
import javax.security.enterprise.credential.Credential;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final String JSP = "/WEB-INF/pages/login.jsp";
    
    public String login;
    
    @Inject AuthService authService;
  
    
    @EJB UserServiceLocal userService;
    
    @Override
    protected void doGet(   HttpServletRequest request, 
                            HttpServletResponse response) 
                        throws ServletException, IOException {
        if(authService.isAuth()){
            redirectBack(request, response);
        } else {
        RequestDispatcher dispatcher = request.getRequestDispatcher(JSP);
        dispatcher.forward(request, response);     
    } 
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        login = request.getParameter("login");
        String password = request.getParameter("password");
        try{
            requireNonEmpty(login, "error.login.required");
            requireNonEmpty(password, "error.password.required");
            
            User user = userService.find(login);
            requireNonNull(user, "error.user.unknown");
            Credentials credentials = new Credentials(login, password);
            requireEquals(credentials, user.getCredentials(), "error.password.incorrect!");
            authService.setAuth(true);
            redirectLocaly(request, response, "/choose");
            
        } catch (ValidationException e){
            request.setAttribute("exception", e);
            doGet(request, response);
        }
     
    }
    
    
    
    
}
