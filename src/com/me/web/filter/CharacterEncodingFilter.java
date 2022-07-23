package com.me.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class CharacterEncodingFilter
 */
@WebFilter(description = "处理中文乱码的过滤器", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8") })
public class CharacterEncodingFilter implements Filter {
	protected String encoding;

	/**
	 * Default constructor.
	 */
	public CharacterEncodingFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String servletPath = ((HttpServletRequest) request).getServletPath();
		if (!servletPath.contains(".css") && !servletPath.contains(".js")) {
			if (encoding != null) {
				// 设置request字符编码
				request.setCharacterEncoding(encoding);
				// 设置response字符编码
				response.setContentType("text/html;charset=" + encoding);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding = fConfig.getInitParameter("encoding");
	}

}
