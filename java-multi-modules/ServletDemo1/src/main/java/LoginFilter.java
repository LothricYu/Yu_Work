import java.io.IOException;

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

//过滤判断是否已登录

@WebFilter(filterName="TestFilter",urlPatterns= {"/Shop.jsp","/Shopdetail.jsp" })
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        try{
            HttpServletRequest req = (HttpServletRequest) request;
            String path = req.getRequestURI();
            if (path.contains("Deng.jsp")) {
                chain.doFilter(request, response);//若是登陆界面就放行
            }
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession();
            String x = (String) session.getAttribute("user");
            if (x == null) {
                response.getWriter().write("<script>alert('请先登录！');window.location.href='Deng.jsp';</script>");
            } else {
                chain.doFilter(request, response); // 放行
            }
        }catch (Exception e){
            e.printStackTrace();
    }
}

    @Override
    public void destroy() {
    }
}
