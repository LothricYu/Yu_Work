package com.demo.springmessage.controller;

import com.demo.springmessage.pojo.Out;
import com.demo.springmessage.pojo.Permission;
import com.demo.springmessage.pojo.Permissionrole;
import com.demo.springmessage.pojo.User;
import com.demo.springmessage.service.BillService;
import com.demo.springmessage.service.PermissionService;
import com.demo.springmessage.service.PermissionroleService;
import com.demo.springmessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private PermissionroleService permissionroleService;
    @Autowired
    private BillService billService;

    @RequestMapping("/vis_per")
    public String permission_update(HttpServletRequest request, HttpServletResponse response){
        String p1=request.getParameter("Search_m");
        String p2=request.getParameter("Add_m");
        String p3=request.getParameter("Delete_m_person");
        String p4=request.getParameter("Update_m_person");
        String p5=request.getParameter("Update_m_group");
        String p6=request.getParameter("Delete_m_all");
        String p7=request.getParameter("Update_m_all");
        String p8=request.getParameter("Update_user_person");
        String p9=request.getParameter("Update_user_all");
        int c1,c2,c3,c4,c5,c6,c7,c8,c9;
        System.out.println(p1);
        if(p1==null) {  c1=0; }else{c1=1;}
        if(p2==null) {  c2=0; }else{c2=1;}
        if(p3==null) {  c3=0; }else{c3=1;}
        if(p4==null) {  c4=0; }else{c4=1;}
        if(p5==null) {  c5=0; }else{c5=1;}
        if(p6==null) {  c6=0; }else{c6=1;}
        if(p7==null) {  c7=0; }else{c7=1;}
        if(p8==null) {  c8=0; }else{c8=1;}
        if(p9==null) {  c9=0; }else{c9=1;}
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        permissionService.updatepermission(c1,c2,c3,c4,c5,c6,c7,c8,c9,4);
        return "redirect:/Show?page=1";
    }

    @RequestMapping("/role_permission")
    public String rolepermission(){
        return "TE";
    }

    @RequestMapping("/user_role")
    public String user_role(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("userid"));
        response.setContentType("text/html;charset=gb2312");
        PrintWriter out = response.getWriter();
        if(id==1)
        {
            return "redirect:/showalluser";
        }
        return "A_user_role";
    }

    @RequestMapping("/user_roleup")      //修改用户角色
    public String user_roleup(HttpServletRequest request,ServletResponse response) throws IOException {
        String n=request.getParameter("ur");
        Out out=new Out();
        int roleid= (int) request.getSession().getAttribute("roleid");
        int id= (int) request.getSession().getAttribute("userid");
        if(n.equals("ad")) roleid=2;
        if(n.equals("normal")) roleid=3;
        if(n.equals("vis")) roleid=4;
        if(userService.updateUserrole(id,roleid)){
            out.seprint(response);
        }
        return null;
    }

    @RequestMapping("/Login")
    public String toLoginPage(){
        return "LoginPage";
    }

    @RequestMapping("/message_reward")
    public String reward(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int rewardid= Integer.parseInt(request.getParameter("reward_id"));
        int userid= Integer.parseInt(request.getParameter("userid"));
        Double num= Double.valueOf(request.getParameter("number"));
        User user= (User) request.getSession().getAttribute("user");
        Double b=user.getBalance();
        if(userid==rewardid){
            Out out=new Out();
            out.dashang_print_fe_same(response);
            System.out.println("不可打赏自己");
            return null;
        }
        else if(num>b){
            Out out=new Out();
            out.dashang_print_fe(response);
            System.out.println("打赏金额超过余额");
            return null;
        }
        else if(userService.reward(userid,num,rewardid)){
            Out out=new Out();
            out.dashang_print_se(response);
            System.out.println("打赏成功");
            user.setBalance(b-num);
            billService.insertBill("消费",num,userid);
            request.getSession().setAttribute("user",user);
            return null;
        }
        else {
            Out out=new Out();
            out.dashang_print_fe(response);
            System.out.println("打赏失败");
            return null;
        }
    }

    @RequestMapping("/chongzhi")
    public String chongzhi(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Double a= Double.valueOf(request.getParameter("number"));
        User user= (User) request.getSession().getAttribute("user");
        Double b=0.0;
        if(user.getBalance()!=null)
        {
            b=user.getBalance();
        }
        Double c=a+b;
        int id=user.getId();
        userService.chongzhi(c,id);
        user.setBalance(c);
        billService.insertBill("充值",a,id);
        return "UpdateUser";
    }

    @RequestMapping("/Showbill")
    public String Billshow(HttpServletRequest request, HttpServletResponse response) throws IOException {
       int id= Integer.parseInt(request.getParameter("userid"));
       int page = Integer.parseInt(request.getParameter("page"));
//        List list=operationService.findfenyeOperation(page);
//        int count = operationService.pageNum();
//        request.setAttribute("count",count);
//        request.setAttribute("operationList",list);
//        request.setAttribute("page",page);
//        return "operationshow";
       List list=billService.findBillByuserid(page,id);
       int count=billService.pageNum(id);
       request.setAttribute("count",count);
       request.setAttribute("billList",list);
       request.setAttribute("page",page);
       request.setAttribute("userid",id);
       return "Billlist";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        userService.loginout();
        request.getSession().invalidate();
        return "LoginPage";
    }

    @RequestMapping("/checklogin")
    public String checkLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("")) {
            return "Kong";
        } else {
            try {
                User user = userService.findByUsername(username);
                if (user == null) {
                    return "Error";
                } else {
//                user = userService.findByUsername(username);
                    if (user.getPassword().equals(password)) {
                        request.getSession().setAttribute("user", user);
                        request.getSession().setAttribute("user_name", username);
                        Permission permission = permissionService.permissionByname(username);
                        request.getSession().setAttribute("permission", permission);
                        return "redirect:/Show?page=1";
                    }
                    return "Error";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping("/showalluser")
    public String showalluser(HttpServletRequest request){ ;
        List list = userService.findAll();
        request.setAttribute("userList",list);
        return "A_UserManage";
    }

    @RequestMapping("/useredit")
    public String tousereditPage(HttpServletRequest request){
            return "UpdateUser";
    }

    @RequestMapping("/alluseredit")
    public String alluseredit(HttpServletRequest request)
    {
        String name=request.getParameter("username");
        if(name.equals("admin"))
        {
            return "redirect:/showalluser";
        }
        User user=userService.findByUsername(name);
        request.getSession().setAttribute("A_user",user);
        return "A_UpdateUser";
    }

    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request){
        return "AddUser";
    }

    @RequestMapping("/user_new")
    public String insertMessage(HttpServletRequest request){
        String name=request.getParameter("add_username");
        String password=request.getParameter("add_password");
        String email=request.getParameter("add_email");
        String tel=request.getParameter("add_telnumber");
        User user=new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);
        if(userService.insertUser(user)){
            return "redirect:/showalluser";
        }
        return null;
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");
//        Message message = new Message();
//        message.setTitle(title);
//        message.setContent(content);
//        message.setUserId(user.getId());
//        if (messageService.insertMessage(message)){
//            return "redirect:/Show?page=1";
//        }
//        return null;
    }

    @RequestMapping("/user_updata")
    public String updataUser(HttpServletRequest request){
        User user = new User();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTel(tel);

        if (userService.updateUser(user)){
            request.getSession().invalidate();
            return "LoginPage";
        }
        return null;
    }

    @RequestMapping("/A_user_updata")             //管理员提交修改用户信息
    public String A_updataUser(HttpServletRequest request,ServletResponse response) throws IOException {
        User user=new User();
        Out out=new Out();
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String tel = request.getParameter("tel");
        int groupid= Integer.parseInt(request.getParameter("groupid"));
        if (userService.A_updateuser(name,password,email,tel,groupid,id)){
            out.seprint(response);
        }
        else{
            out.feprint(response);
        }
        return null;
    }

//    @RequestMapping("/")
//    public String vis_permission(HttpServletRequest request){
//
//    }

    @RequestMapping("/user_delete")
    public String userdelete(HttpServletRequest request){
        int userid=Integer.parseInt(request.getParameter("deleteid"));
        if(userid==1){
            return "redirect:/showalluser";
        }
        if(userService.deleteUser(userid)){
            return "redirect:/showalluser";
        }
        return "null";
    }

    @RequestMapping("/no")
    public String normal(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("roleid"));
        request.getSession().setAttribute("roleid",id);
        Permissionrole permissionrole=permissionroleService.permissionByroleid(id);
        request.getSession().setAttribute("normal_permission",permissionrole);
        return "normal_permission";
    }

    @RequestMapping("/vis")
    public String vis(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("roleid"));
        request.getSession().setAttribute("roleid",id);
        Permissionrole permissionrole=permissionroleService.permissionByroleid(id);
        request.getSession().setAttribute("vis_permission",permissionrole);
        return "vis_permission";
    }

    @RequestMapping("/ad")
    public String ad(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("roleid"));
        request.getSession().setAttribute("roleid",id);
        Permissionrole permissionrole=permissionroleService.permissionByroleid(id);
        request.getSession().setAttribute("ad_permission",permissionrole);
        return "ad_permission";
    }



    @RequestMapping("/normal_per")
    public String normal_per(HttpServletRequest request, HttpServletResponse response){
        String p1=request.getParameter("Search_m");
        String p2=request.getParameter("Add_m");
        String p3=request.getParameter("Delete_m_person");
        String p4=request.getParameter("Update_m_person");
        String p5=request.getParameter("Update_m_group");
        String p6=request.getParameter("Delete_m_all");
        String p7=request.getParameter("Update_m_all");
        String p8=request.getParameter("Update_user_person");
        String p9=request.getParameter("Update_user_all");
        int c1,c2,c3,c4,c5,c6,c7,c8,c9;
        System.out.println(p1);
        if(p1==null) {  c1=0; }else{c1=1;}
        if(p2==null) {  c2=0; }else{c2=1;}
        if(p3==null) {  c3=0; }else{c3=1;}
        if(p4==null) {  c4=0; }else{c4=1;}
        if(p5==null) {  c5=0; }else{c5=1;}
        if(p6==null) {  c6=0; }else{c6=1;}
        if(p7==null) {  c7=0; }else{c7=1;}
        if(p8==null) {  c8=0; }else{c8=1;}
        if(p9==null) {  c9=0; }else{c9=1;}
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        permissionService.updatepermission(c1,c2,c3,c4,c5,c6,c7,c8,c9,3);
        return "redirect:/Show?page=1";
    }

    @RequestMapping("/ad_per")
    public String ad_per(HttpServletRequest request, HttpServletResponse response){
        String p1=request.getParameter("Search_m");
        String p2=request.getParameter("Add_m");
        String p3=request.getParameter("Delete_m_person");
        String p4=request.getParameter("Update_m_person");
        String p5=request.getParameter("Update_m_group");
        String p6=request.getParameter("Delete_m_all");
        String p7=request.getParameter("Update_m_all");
        String p8=request.getParameter("Update_user_person");
        String p9=request.getParameter("Update_user_all");
        int c1,c2,c3,c4,c5,c6,c7,c8,c9;
        System.out.println(p1);
        if(p1==null) {  c1=0; }else{c1=1;}
        if(p2==null) {  c2=0; }else{c2=1;}
        if(p3==null) {  c3=0; }else{c3=1;}
        if(p4==null) {  c4=0; }else{c4=1;}
        if(p5==null) {  c5=0; }else{c5=1;}
        if(p6==null) {  c6=0; }else{c6=1;}
        if(p7==null) {  c7=0; }else{c7=1;}
        if(p8==null) {  c8=0; }else{c8=1;}
        if(p9==null) {  c9=0; }else{c9=1;}
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        permissionService.updatepermission(c1,c2,c3,c4,c5,c6,c7,c8,c9,2);
        return "redirect:/Show?page=1";
    }
}
