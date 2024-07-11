package gob.cpccs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends
     SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

     // @Autowired
     // private AuditService auditService;

     
     @Override
     public void onLogoutSuccess(
          HttpServletRequest request,
          HttpServletResponse response,
          Authentication authentication)
          throws IOException, ServletException {

         // String refererUrl = request.getHeader("Referer");
          
          setDefaultTargetUrl("/login?logout");
          
          if (authentication != null){
               new SecurityContextLogoutHandler().logout(request, response, authentication);
               new SecurityContextLogoutHandler().setClearAuthentication(true);
               new SecurityContextLogoutHandler().setInvalidateHttpSession(true);
               new SecurityContextLogoutHandler().isInvalidateHttpSession();
               SecurityContextHolder.getContext().setAuthentication(null);
           }
          
         
          HttpSession session= request.getSession(false);
          
          if(request.isRequestedSessionIdValid() && session != null) {
               session.invalidate();
          }
          
          Cookie[] cookies = request.getCookies();
          for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);
          }
          
          
          super.onLogoutSuccess(request, response, authentication);
     }
     
     

}
