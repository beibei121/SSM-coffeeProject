package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.Coffee;

import org.ccunix.coffee.domain.CoffeeResultMap;
import org.ccunix.coffee.domain.CoffeeTaste;
import org.ccunix.coffee.domain.Coffeetype;
import org.ccunix.coffee.pojo.CoffeePOJO;
import org.ccunix.coffee.pojo.CoffeeTastePOJO;
import org.ccunix.coffee.service.ICoffeeService;
import org.ccunix.coffee.service.ICoffeeTasteService;
import org.ccunix.coffee.service.ICoffeetypeService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.ccunix.coffee.utils.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/Coffee")
public class AdminCoffeeController {
    @Autowired
    ExportExcelUtil exportExcelUtil;
    @Autowired
    ICoffeeService coffeeService;
    @Autowired
    ICoffeetypeService coffeetypeService;
    @Autowired
    ICoffeeTasteService coffeeTasteService;

    @RequestMapping("/selectAllCoffeeBypage")
    public String selectAllCoffeeBy(Model model, Integer nowPage, String key, CoffeePOJO coffeePOJO){



        System.out.println("咖啡搜索："+coffeePOJO);
//        List<Coffee> coffeeList =  coffeeService.selectAllCoffee(coffeePOJO);
        //第二种实现方式
        List<CoffeeResultMap> coffeeList =  coffeeService.selectAllCoffeeResultMap(coffeePOJO);
        //获得咖啡类型的数据
        List<Coffeetype> coffeetypeList = coffeetypeService.selectAllCoffeetype(null);
        //获得咖啡口味类型数据
        List<CoffeeTaste> coffeeTasteList = coffeeTasteService.selectAllCoffeeTaste(null);

        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }
        CastPageUtil castPageUtil_coffee = new CastPageUtil(coffeeList,nowPage);
//        CastPageUtil castPageUtil_coffeetype = new CastPageUtil(coffeetypeList,nowPage);
//        CastPageUtil castPageUtil_Taste = new CastPageUtil(coffeeTasteList,nowPage);

        if (coffeePOJO.getName()!=null && !coffeePOJO.getName().trim().equals("")){
            model.addAttribute("name",coffeePOJO.getName().trim());
        }
        if(coffeePOJO.getCoffeetypeId()!=null && coffeePOJO.getCoffeetypeId()!=0){
            model.addAttribute("coffeetypeId",coffeePOJO.getCoffeetypeId());
        }
        if(coffeePOJO.getTasteId()!=null && coffeePOJO.getTasteId()!=0){
            model.addAttribute("tasteId",coffeePOJO.getTasteId());
        }
        //添加到作用域里面
        model.addAttribute("castPageUtil",castPageUtil_coffee);
//        model.addAttribute("castPageUtil",castPageUtil_coffeetype);
//        model.addAttribute("castPageUtil",castPageUtil_Taste);
        model.addAttribute("nowPage",nowPage);

        model.addAttribute("coffeeList",coffeeList);
        model.addAttribute("coffeetypeList",coffeetypeList);
        model.addAttribute("coffeeTasteList",coffeeTasteList);

        return "coffee/list";
    }

    @RequestMapping("/toAddCoffee")
    public String toAddCoffee(Model model){
        //获得咖啡类型的数据
        List<Coffeetype> coffeetypeList = coffeetypeService.selectAllCoffeetype(null);
        //获得咖啡口味类型数据
        List<CoffeeTaste> coffeeTasteList = coffeeTasteService.selectAllCoffeeTaste(null);
        model.addAttribute("coffeetypeList",coffeetypeList);
        model.addAttribute("coffeeTasteList",coffeeTasteList);

        return "coffee/add";
    }


    @RequestMapping("/addCoffee")
    public void addCoffee(HttpServletRequest request, HttpServletResponse response,
                          MultipartFile photo, CoffeePOJO coffeePOJO){
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
            coffeePOJO.setPicture(fileName);
            //对数据库进行添加操作
            coffeeService.addCoffee(coffeePOJO);
//            request.getRequestDispatcher("/admin/Coffee/selectAllCoffee").forward(request,response);
            //使用转发的话 session作用域里面的值会跟着转发一起传过去  为了使得作用域里面的值失效只能使用重定向
            response.sendRedirect(request.getContextPath()+"/admin/Coffee/selectAllCoffeeBypage");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @RequestMapping("/toUpdateCoffee")
    public String toUpdateCoffee(Model model,Integer id){
        //通过id获取单个商品
        CoffeeResultMap coffee =  coffeeService.selectCoffeeById(id);
        // 获得咖啡类型名称列表
        List<Coffeetype> coffeetypeList = coffeetypeService.selectAllCoffeetype(null);
        // 获得咖啡口味类型列表
        List<CoffeeTaste> coffeeTasteList = coffeeTasteService.selectAllCoffeeTaste(null);

        model.addAttribute("coffee",coffee);
        model.addAttribute("coffeetypeList",coffeetypeList);
        model.addAttribute("coffeeTasteList",coffeeTasteList);

        return "coffee/update";
    }

    @RequestMapping("/updateCoffee")
    public void updateCoffee(HttpServletRequest request, HttpServletResponse response,
                             MultipartFile picImage, CoffeePOJO coffeePOJO){
       try {
           //判断图片是否修改
           if (!"".equals(picImage.getOriginalFilename())){
               //把图片删除掉
               String realPath = request.getSession().getServletContext().getRealPath("/images/");
               File file = new File(realPath);
               if (!file.exists()){
                   file.mkdirs();
               }
               File deletefile = new File(file,coffeePOJO.getPicture());
               deletefile.delete();//删除
               //上传新的图片
               String uuid = UUID.randomUUID().toString().replace("-", "");
               String fileName = picImage.getOriginalFilename();
               int dian = fileName.lastIndexOf(".");
               fileName = uuid + fileName.substring(dian);
               picImage.transferTo(new File(file,fileName));
               //记录新图片的路径  赋值给CoffeePOJO中的picture
               coffeePOJO.setPicture(fileName);
           }
           //更新数据库
           coffeeService.updateCoffee(coffeePOJO);
           //重定向
           //使用转发的话 session作用域里面的值会跟着转发一起传过去  为了使得作用域里面的值失效只能使用重定向
           response.sendRedirect(request.getContextPath()+"/admin/Coffee/selectAllCoffeeBypage");

           return;
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @RequestMapping("/deleteCoffee")
    public void deleteCoffee(HttpServletRequest request,HttpServletResponse response,
                               Integer id){

        try{
            coffeeService.deleteCoffee(id);
            //  重定向
            response.sendRedirect(request.getContextPath()+"/admin/Coffee/selectAllCoffeeBypage");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/detailCoffee")
    public String detailCoffee(Model model, Integer id){
        //通过id获取单个商品
        CoffeeResultMap coffee =  coffeeService.selectCoffeeById(id);

        model.addAttribute("coffee",coffee);

        return "coffee/detail";
    }
}
