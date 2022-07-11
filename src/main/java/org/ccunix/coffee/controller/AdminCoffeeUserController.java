package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.CoffeeUser;
import org.ccunix.coffee.pojo.CoffeeUserPOJO;
import org.ccunix.coffee.result.CodeMsg;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.ICoffeeUserService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.chrono.MinguoChronology;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/user")
public class AdminCoffeeUserController {

    @Autowired
    ICoffeeUserService coffeeUserService;

    @RequestMapping("/selectAllUserByPage")
    public String selectAllUserByPage(Model model, Integer nowPage, String key,
                                      CoffeeUserPOJO coffeeUserPOJO){
        //绑定信息

        //会员列表
        List<CoffeeUser> userList = coffeeUserService.selectAllUserByPage(coffeeUserPOJO);
        //分页

        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }
        CastPageUtil castPageUtil = new CastPageUtil(userList,nowPage);

        //绑定搜索框的内容
        if (coffeeUserPOJO.getUsername()!=null && !coffeeUserPOJO.getUsername().trim().equals("")){
            model.addAttribute("username",coffeeUserPOJO.getUsername().trim());
        }
        if (coffeeUserPOJO.getSex()!=null && !coffeeUserPOJO.getSex().trim().equals("")){
            model.addAttribute("sex",coffeeUserPOJO.getSex().trim());
        }

        model.addAttribute("castPageUtil",castPageUtil);
        return "user/list";
    }


    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "user/add";
    }

    @RequestMapping("/addUser")
    public void addUser(CoffeeUserPOJO coffeeUserPOJO, MultipartFile photo,
                        HttpServletRequest request, HttpServletResponse response){
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("---------添加新用户--------");
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        try {
            //文件上传
            String realPath = request.getSession().getServletContext().getRealPath("/images/");
            File file = new File(realPath);
            if (!file.exists()){
                file.mkdirs();
            }
            //确定文件名称
            //把文件的名称记录下来    文件名称不建议使用中文   为了保证不会和你的上传的路径名称有任何关系
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //获取原来的名字
            String fileName = photo.getOriginalFilename();
            //获取文件的后缀名 来进行对文件上传的限制 限制指定类文件可以上传
            int dian = fileName.lastIndexOf(".");
            fileName = uuid + fileName.substring(dian);
            //写出上传文件到指定的文件夹当中
            photo.transferTo(new File(file,fileName));
            //把文件名称封装到CoffeePOJO当中
            coffeeUserPOJO.setPicture(fileName);
//            //写出上传文件到指定的文件夹当中
//            photo.transferTo(new File(file,fileName));
            //对数据库进行添加操作
            coffeeUserService.addCoffeeUser(coffeeUserPOJO);
//            request.getRequestDispatcher("/admin/Coffee/selectAllCoffee").forward(request,response);
            //使用转发的话 session作用域里面的值会跟着转发一起传过去  为了使得作用域里面的值失效只能使用重定向
            response.sendRedirect(request.getContextPath()+"/admin/user/selectAllUserByPage");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/isRegister")
    @ResponseBody
    public Result<Boolean> isRegister(String username){
        CoffeeUser coffeeUser = coffeeUserService.isExistSameUsername(username);

        if (coffeeUser==null){
            return Result.success(null);
        }else{
            return Result.error(CodeMsg.NIKENAME_EXIST);
        }
    }

    @RequestMapping("/toUpdateUser")
    public String toUpdateUser(Integer id,Model model){
        CoffeeUser coffeeUser = coffeeUserService.selectAllUserById(id);
        model.addAttribute("user",coffeeUser);
        return "user/update";
    }
    @RequestMapping("/updateUser")
    public void updateUser(CoffeeUserPOJO coffeeUserPOJO, MultipartFile photo,
                           HttpServletRequest request, HttpServletResponse response){
        try {
            //判断图片是否修改
            if (!"".equals(photo.getOriginalFilename())){
                //把图片删除掉
                String realPath = request.getSession().getServletContext().getRealPath("/images/");
                File file = new File(realPath);
                if (!file.exists()){
                    file.mkdirs();
                }
                File deletefile = new File(file,coffeeUserPOJO.getPicture());
//                deletefile.delete();//删除
                //上传新的图片
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String fileName = photo.getOriginalFilename();
                int dian = fileName.lastIndexOf(".");
                fileName = uuid + fileName.substring(dian);
                //记录新图片的路径  赋值给CoffeePOJO中的picture
                coffeeUserPOJO.setPicture(fileName);
                //更新数据库
                coffeeUserService.updateCoffee(coffeeUserPOJO);
                deletefile.delete();//删除
                photo.transferTo(new File(file,fileName));
                }
            else {
                //更新数据库
                coffeeUserService.updateCoffee(coffeeUserPOJO);
            }
            //重定向
            //使用转发的话 session作用域里面的值会跟着转发一起传过去  为了使得作用域里面的值失效只能使用重定向
            response.sendRedirect(request.getContextPath()+"/admin/user/selectAllUserByPage");

            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/detailUser")
    public String detailUser(Integer id,Model model){
        CoffeeUser coffeeUser = coffeeUserService.selectAllUserById(id);
        model.addAttribute("user",coffeeUser);
        return "user/detail";
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request,HttpServletResponse response,Integer id){

        try {
            coffeeUserService.deleteUserById(id);
            //重定向
            //使用转发的话 session作用域里面的值会跟着转发一起传过去  为了使得作用域里面的值失效只能使用重定向
            response.sendRedirect(request.getContextPath()+"/admin/user/selectAllUserByPage");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
