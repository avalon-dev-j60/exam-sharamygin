
package edu.blog.servlets;

import edu.blog.beans.AuthService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/calc")
public class Calc extends HttpServlet{

    @Inject AuthService authService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/gearCalc.jsp");
        dispatcher.forward(request, response);  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String teeth1 = request.getParameter("teeth1");
        String teeth2 = request.getParameter("teeth2");
        String module = request.getParameter("module");
        float d1 = 0;
        float da1 = 0;
        float df1 = 0;
        
        float d2 = 0;
        float da2 = 0;
        float df2 = 0;
        
        float aw = 0;
        
        float u = 0;
        
        
        
        try {
            float z1 = Float.valueOf(teeth1);
            float z2 = Float.valueOf(teeth2);
            float m = Float.valueOf(module);
            d1 = m * z1;
            d2 = m * z2;
            
            da1 = d1 + 2 * m;
            da2 = d2 + 2 * m;
            
            df1 = (float) (d1 - 2 * (0.25 + m));
            df2 = (float) (d2 - 2 * (0.25 + m));
            
            aw = ((z1 + z2) * m) / 2;
            
            u = (z2 / z1);
            
            request.setAttribute("ref1", d1);
            request.setAttribute("tip1", da1);
            request.setAttribute("root1", df1);
            
            request.setAttribute("ref2", d2);
            request.setAttribute("tip2", da2);
            request.setAttribute("root2", df2);
            
            request.setAttribute("centre", aw);
            request.setAttribute("ratio", u);
            
        } catch (NullPointerException | NumberFormatException e){
            response.getWriter().print("Wrong data format!");
        }
        doGet(request, response);
    }

        
    
}
