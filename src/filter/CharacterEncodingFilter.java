//package filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import java.io.IOException;
//
//@WebFilter(
//        urlPatterns = { "/*" },
//        initParams = {
//                @WebInitParam(name = "encoding", value="UTF-8")
//        }
//)
//public class CharacterEncodingFilter implements Filter {
//    protected String encoding;
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        if(encoding != null){
//            request.setCharacterEncoding(encoding);
//            response.setCharacterEncoding(encoding);
//            response.setContentType("text/html;charset=UTF-8");
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        this.encoding = fConfig.getInitParameter("encoding");
//    }
//
//}
