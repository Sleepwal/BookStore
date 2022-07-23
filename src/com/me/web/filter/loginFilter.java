package com.me.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/*")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//System.out.println("销毁loginFilter……");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		/*System.out.println("开始loginFilter……");*/
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        HttpSession session = httpRequest.getSession();

        if(httpRequest.getRequestURI().contains("client/login") ||
				httpRequest.getRequestURI().contains("ClientFindNoticeById") ||
				httpRequest.getRequestURI().contains("ShowCart") ||
				httpRequest.getRequestURI().contains("MenuSearchServlet") ){
        	if(session.getAttribute("username") == null){
        		httpResponse.sendRedirect(httpRequest.getContextPath()+"/LoginUI");
        		return;
        	}
        	else{
        		chain.doFilter(request, response);
        	}
        }
        else{
        	chain.doFilter(request, response);
        }
       //System.out.println("结束loginFilter……");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("初始化loginFilter……");
	}

}
