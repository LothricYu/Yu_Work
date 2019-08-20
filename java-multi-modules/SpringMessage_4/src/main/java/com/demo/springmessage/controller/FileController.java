package com.demo.springmessage.controller;

import com.demo.springmessage.pojo.User;
import com.demo.springmessage.pojo.photo;
import com.demo.springmessage.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController{
    @Autowired
    PhotoService photoService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }



//    @RequestMapping("/addphoto")       二进制流
//    public Object searchMember(MultipartFile file){
//        try {
//            InputStream ins = file.getInputStream();
//            byte[] buffer=new byte[1024];
//            int len=0;
//            ByteArrayOutputStream bos=new ByteArrayOutputStream();
//            while((len=ins.read(buffer))!=-1){
//                bos.write(buffer,0,len);
//            }
//            bos.flush();
//            byte data[] = bos.toByteArray();
//            photo photo=new photo();
//            photo.setPhoto_path(data);
//            photoService.insertphoto(photo);
//            photoService.inserttest(photo);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }

    @RequestMapping("choosePhoto")
    public String choosePhoto(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("userid"));
        List photolist=photoService.photoall();
        request.getSession().setAttribute("photolist",photolist);
        return "Photoall";
    }

//    @RequestMapping("updatephoto")
//    public String updatephoto(HttpServletRequest request){
//        int id=Integer.parseInt(request.getParameter("userid"));
//        String n=request.getParameter("ph");
//        User user= (User) request.getSession().getAttribute("user");
//        user.setPhoto_path(n);
//        request.getSession().setAttribute("user",user);
//        photoService.updatePhoto(n,id);
//        return "UpdateUser";
//    }

    @RequestMapping("updatephoto")
    public String updatephoto(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("userid"));
        String n=request.getParameter("path");
        User user= (User) request.getSession().getAttribute("user");
        user.setPhoto_path(n);
        request.getSession().setAttribute("user",user);
        photoService.updatePhoto(n,id);
        return "UpdateUser";
    }

    @RequestMapping("deletephoto")
    public String deletephoto(HttpServletRequest request){
        int id= Integer.parseInt(request.getParameter("photo_id"));
        photoService.DeletePhoto(id);
        return "UpdateUser";
    }

    @RequestMapping("/se")
    public String se(){
        return "Photo";
    }

    //上传头像
        @RequestMapping(value = "/fileUpload")
        public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
            if (file.isEmpty()) {
                System.out.println("文件为空空");
            }
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "C://img//"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = "/img/" + fileName;
            photo photo=new photo();
            photo.setPhoto_path(filename);
            photoService.insertphoto(photo);
            request.getSession().setAttribute("filename",filename);
            User user= (User) request.getSession().getAttribute("user");
            user.setPhoto_path(filename);
            request.getSession().setAttribute("user",user);
            model.addAttribute("filename", filename);
            return "UpdateUser";
        }
    }


