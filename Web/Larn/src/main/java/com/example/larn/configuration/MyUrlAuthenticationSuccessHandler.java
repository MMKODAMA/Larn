package com.example.larn.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.repository.StudentRepository;
import com.example.larn.repository.TeacherRepository;

public class MyUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Autowired
    private StudentRepository studentyRep;
    
    @Autowired
    private TeacherRepository teacherRep;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);	
	}
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		
		if (response.isCommitted()) {
            logger.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }
		
		System.out.println("GET NAME: " + SecurityContextHolder.getContext().getAuthentication().getName());
		
		User user = null;
		
		Collection<? extends GrantedAuthority> authorities
        = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			switch (grantedAuthority.getAuthority()) {
			case "STUDENT_USER":
				user = studentyRep.findByEmail(authentication.getName());
				break;
			case "TEACHER_USER":
				user = teacherRep.findByEmail(authentication.getName());
				break;
			default:
				user = teacherRep.findByEmail(authentication.getName());
				break;
			}
			if(user != null) {
				setSessionUserAttributes(user, request.getSession());
				;
			}
		}
		
		
		
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		boolean student = false;
		boolean teachear = false;
		boolean admin = false;
		
		Collection<? extends GrantedAuthority> authorities
        = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			switch (grantedAuthority.getAuthority()) {
			case "STUDENT_USER":
				student = true;
				break;
			case "TEACHER_USER":
				teachear = true;
				break;
			case "ADMIN_USER":
				admin = true;
				break;
			case "SUPER_USER":
				admin = true;
				break;
			default:
				break;
			}
			
		}
		
		if(admin) {
			return "/";
		}
		if(teachear) {
			return "/teacher/home";
		} else {
			return "/student/profile";
		}
		
	}
	
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    
    private void setSessionUserAttributes(User user, HttpSession session) {
    	session.setAttribute("id", user.getId());
    	session.setAttribute("role", user.getRoles());
    	session.setAttribute("user", user);
    }
     
}
