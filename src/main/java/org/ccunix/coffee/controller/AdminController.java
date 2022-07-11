package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.Admin;
import org.ccunix.coffee.pojo.AdminPOJO;
import org.ccunix.coffee.result.CodeMsg;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.IAdminSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
    @Autowired
    IAdminSerivice adminSerivice;

    @RequestMapping("/toAdminLogin")
    public String toLogin(){
        return "admin/adminLogin";
    }

    @RequestMapping("/adminLogin")
    @ResponseBody
    public Result<Admin> adminLogin(AdminPOJO adminPOJO, HttpServletRequest request, HttpServletResponse response){
        System.out.println("控制器1"+adminPOJO);
        //此处返回了null值  那么返回到前端 json会转换失败   那么就跳转到error
        Admin adminLoginUser = adminSerivice.findAdminLoginUser(adminPOJO);

        if (adminLoginUser==null){
            //用户名或密码错误
            return Result.error(CodeMsg.LOGIN_ERROR);
        }else {
            //登录成功
            //封装数据在session上
            request.getSession().setAttribute("adminLoginUser",adminLoginUser);
            return Result.success(adminLoginUser);

        }
    }

    @RequestMapping("/admin/adminIndex")
    public String adminIndex(){
        return "admin/adminIndex";
    }

    @RequestMapping("/admin/adminHeader")
    public String adminHeader(){
        return "admin/adminHeader";
    }

    @RequestMapping("/admin/adminMenu")
    public String adminMenu(){
        return "admin/adminMenu";
    }

    @RequestMapping("/admin/adminMain")
    public String adminMain(){
        return "admin/adminMain";
    }

    @RequestMapping("/admin/pageNotFound")
    public String PageNotFound(){
        return "error";
    }

}
