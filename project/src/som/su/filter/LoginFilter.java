package som.su.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.su.vo.Emp;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	List<String> list=new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r=(HttpServletRequest)request;
		String l=r.getServletPath();
		System.out.println(l);
		if(list.contains(l)) {
			chain.doFilter(request, response);
		}else {
			HttpSession session=r.getSession();
			Emp emp=(Emp) session.getAttribute("user");
			if(emp!=null) {
				chain.doFilter(request, response);
			}else {
				HttpServletResponse res=(HttpServletResponse)response;
				
				res.sendRedirect(r.getContextPath()+"/login.jsp");
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		list.add("/login.jsp");
		list.add("/login");
		list.add("/pass");
		list.add("/yzmpass");
		
		list.add("/images/logo.jpg");
		list.add("/images/b3.png");
		list.add("/images/login_box_logo.png");
		list.add("/images/b1.png");
		list.add("/images/b2.png");
		list.add("/js/jquery-1.9.1.min.js");
		list.add("/css/login.css");
		list.add("/images/logo.jpg");
		list.add("/images/b3.png");
		list.add("/images/login_pass.png");
		
		list.add("/images/body_bg.jpg");
		list.add("/images/login_user.png");
		list.add("/images/login_box.png");
	}

}
