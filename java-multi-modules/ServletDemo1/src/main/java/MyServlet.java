import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//登陆功能
public class MyServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("user");

        if(name.equals("")){
            //如果用户名为空，则跳转到Deng页面
            response.getWriter().write("<script>alert('用户名为空！');window.location.href='Deng.jsp';</script>");
        }
        else{//用户名不为空则跳转Shop页面
            HttpSession session = request.getSession();
            session.setAttribute("user",name);
            response.sendRedirect("Shop.jsp");     //请求重定向
//            RequestDispatcher ch=request.getRequestDispatcher("Shop.jsp");    原先请求转发
//            ch.forward(request,response);
        }
    }
}
