
package edu.blog.filters;

import edu.blog.beans.AuthService;
import java.io.IOException;
import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



@WebFilter("/*")
public class LocaleController implements Filter {

    @Inject AuthService authService;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        chain.doFilter(request, response);
    }


    
}
