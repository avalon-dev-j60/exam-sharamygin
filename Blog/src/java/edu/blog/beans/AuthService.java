package edu.blog.beans;

import edu.blog.servlets.LoginServlet;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;


@Stateless
public class AuthService {
    
    
    @Inject HttpSession session;
    
    public boolean isAuth(){
        Boolean auth = (Boolean) session.getAttribute("auth");
        return auth != null && auth; 
    }
    
    public void setAuth(boolean isAuth){
        if (isAuth){
        session.setAttribute("auth", isAuth);
    } else {
            session.invalidate();
        }
}
    
}
