package gob.cpccs.utilidades;

/**
 * Controlador ReCaptchaAuthenticationFilter
 *
 * Este archivo contiene métodos para el controlador ReCaptchaAuthenticationFilter
 *
 * @property CPCCS
 * @author Carlos Anchundia
 * @email e.du.ingcharles@hotmail.com
 * @date 2019-01-15
 * @uses ReCaptchaAuthenticationFilter
 * @package gob.cpccs.utilidades
 * @subpackage
 * 
 */

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ReCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

     @Override
     protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
          throws IOException, ServletException {
          super.successfulAuthentication(request, response, chain, authResult);
     }

     @Override
     protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
          throws IOException, ServletException {
          super.unsuccessfulAuthentication(request, response, failed);
     }

     @Override
     public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
          String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

          boolean verificarRecaptcha = false;
          try{

               if (!StringUtils.isEmpty(gRecaptchaResponse)){
                    verificarRecaptcha = VerificarRecaptcha.verify(gRecaptchaResponse);

                    if (!verificarRecaptcha){
                         this.reCaptchaError(request, response, "2");
                         return null;
                    } else{
                         return super.attemptAuthentication(request, response);
                    }


               } else{
                    this.reCaptchaError(request, response, "3");
                    return null;
               }

          } catch (IOException e){
               e.printStackTrace();
          }
          return null;

     }

     public void reCaptchaError(HttpServletRequest request, HttpServletResponse response, String errorMsg) {

          try{
               RequestDispatcher dispatcher = request.getRequestDispatcher("/loginn?error=" + errorMsg);
               dispatcher.forward(request, response);
          } catch (ServletException e){
               throw new AuthenticationServiceException("ReCaptcha Falló---> : " + errorMsg);
          } catch (IOException e){
               throw new AuthenticationServiceException("ReCaptcha Falló---> : " + errorMsg);
          }

     }



}

