package org.ccunix.coffee.controller;


import org.ccunix.coffee.domain.CoffeeNews;
import org.ccunix.coffee.pojo.CoffeeNewsPOJO;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.ICoffeeNewsService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/coffeenews")
public class AdminCoffeeNewsController {
    @Autowired
    ICoffeeNewsService coffeeNewsService;

    @RequestMapping("/selectAllCoffeenewsByPage")
    public String selectAllCoffeenewsByPage(Model model, Integer nowPage, String key,
                                            CoffeeNewsPOJO coffeenewsPOJO){

        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }

        //第二种实现方式
        List<CoffeeNews> coffeeNewsList =  coffeeNewsService.selectAllCoffeeResultMap(coffeenewsPOJO);

        CastPageUtil castPageUtil = new CastPageUtil(coffeeNewsList,nowPage);

        if (coffeenewsPOJO.getTitle()!=null && !coffeenewsPOJO.getTitle().trim().equals("")){
            model.addAttribute("title",coffeenewsPOJO.getTitle().trim());
        }
        //添加到作用域里面
        model.addAttribute("castPageUtil",castPageUtil);
        model.addAttribute("nowPage",nowPage);

        return "coffeenews/list";
    }

    @RequestMapping("/toAddCoffeenews")
    public String toAddCoffeenews(){

        return "coffeenews/add";
    }
    @RequestMapping("/addCoffeenews")
    @ResponseBody
    public Result<Boolean> addCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO, MultipartFile photo,
                                         HttpServletRequest request, HttpServletResponse response)
    throws Exception{
            //文件上传
            String realPath = request.getSession().getServletContext().getRealPath("/images/");
            File file = new File(realPath);
            if (!file.exists()) {
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
            //把文件名称封装到CoffeePOJO当中
            coffeeNewsPOJO.setPicture(fileName);
            //对数据库进行添加操作
            coffeeNewsService.addCoffeenews(coffeeNewsPOJO);
            //写出上传文件到指定的文件夹当中
            photo.transferTo(new File(file, fileName));
            return Result.success(true);
    }

    @RequestMapping("/toUpdateCoffeenews")
    public String toUpdateCoffeenews(Integer id,Model model){
        CoffeeNews coffeenews = coffeeNewsService.selectAllCoffeeNewsById(id);
        model.addAttribute("coffeenews",coffeenews);
        return "coffeenews/update";
    }
    @RequestMapping("/updateCoffeenews")
    @ResponseBody
    public Result<Boolean> updateCoffeenews(CoffeeNewsPOJO coffeeNewsPOJO ,MultipartFile photo,
                                            HttpServletRequest request, HttpServletResponse response)
    throws  Exception{
        //判断图片是否修改
        if (!"".equals(photo.getOriginalFilename())){
            //把图片删除掉
            String realPath = request.getSession().getServletContext().getRealPath("/images/");
            File file = new File(realPath);
            if (!file.exists()){
                file.mkdirs();
            }
            File deletefile = new File(file,coffeeNewsPOJO.getPicture());
//                deletefile.delete();//删除
            //上传新的图片
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = photo.getOriginalFilename();
            int dian = fileName.lastIndexOf(".");
            fileName = uuid + fileName.substring(dian);
            //记录新图片的路径  赋值给CoffeePOJO中的picture
            coffeeNewsPOJO.setPicture(fileName);
            //更新数据库
            coffeeNewsService.updateCoffeenews(coffeeNewsPOJO);
            deletefile.delete();//删除
            photo.transferTo(new File(file,fileName));
        }
        else {
            //更新数据库
            coffeeNewsService.updateCoffeenews(coffeeNewsPOJO);
        }
        return Result.success(true);
    }

    @RequestMapping("/detailCoffeenews")
    public String detailCoffeenews(Model model,Integer id){
        CoffeeNews coffeenews = coffeeNewsService.selectAllCoffeeNewsById(id);
        model.addAttribute("coffeenews",coffeenews);
        return "coffeenews/detail";
    }
    @RequestMapping("/deleteCoffeenewsById")
    @ResponseBody
    public Result<Boolean> deleteCoffeenewsById(Integer id){
        coffeeNewsService.deleteCoffeenewsById(id);
        return Result.success(true);
    }
}
