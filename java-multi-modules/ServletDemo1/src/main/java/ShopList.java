import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//添加商品和显示商品列表

public class ShopList extends HttpServlet {
    ArrayList<String> places = new ArrayList<String>();
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String so= request.getParameter("goods");
        if(so!=""){
            places.add(so);
            RequestDispatcher ch=request.getRequestDispatcher("Shop.jsp");
            ch.forward(request,response);
        }
        else{
            response.getWriter().write("<script>alert('商品名为空！');window.location.href='Shop.jsp';</script>");
        }
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list",places);
        RequestDispatcher qr=request.getRequestDispatcher("Shopdetail.jsp");
        qr.forward(request,response);
    }
}
