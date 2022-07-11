package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.Coffeetype;
import org.ccunix.coffee.pojo.CoffeetypePOJO;
import org.ccunix.coffee.result.CodeMsg;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.ICoffeetypeService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.ccunix.coffee.utils.ExportExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin/Coffeetype")
public class AdminCoffeeTypeController {

    @Autowired
    ICoffeetypeService coffeetypeService;
    @Autowired
    ExportExcelUtil exportExcelUtil;

    //导出Excel表格  导出所有数据
    @RequestMapping("/exportAllData")
    public void exportAllData(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("导出所有数据");
            String export = "编号#id,名称#name";
            String []excelHeader = export.split(",");
            List<Coffeetype> dataList = coffeetypeService.selectAllCoffeetype(null);
            exportExcelUtil.export(response,"咖啡分类表",excelHeader,dataList);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //导出Excel表格  导出当前页数据
    @RequestMapping("/exportCurrData")
    public void exportCurrData(HttpServletRequest request, HttpServletResponse response,
                               Integer nowPage ,  CoffeetypePOJO coffeetypePOJO){
        try {
            System.out.println("导出当前页数据");
            System.out.println("nowPage = "+nowPage);
            System.out.println("CoffeetypePOJO = "+coffeetypePOJO);
            String export = "编号#id,名称#name";
            String []excelHeader = export.split(",");
            List<Coffeetype> CoffeetypeList = coffeetypeService.selectAllCoffeetype(coffeetypePOJO);
            if (nowPage==null){
                nowPage=1;
            }
            CastPageUtil castPagePO = new CastPageUtil(CoffeetypeList,nowPage);
            exportExcelUtil.export(response,"咖啡分页"+nowPage+"页数据表",
                                   excelHeader,castPagePO.getCurrentDataList());
            return;

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @RequestMapping("/selectAllCoffeetypeByPage")
    public String selectAllCoffeetypeByPage(Model model,Integer nowPage,String key,
                                            CoffeetypePOJO coffeetypePOJO ){

        System.out.println("搜索："+coffeetypePOJO);
        List<Coffeetype> coffeetypeList =  coffeetypeService.selectAllCoffeetypeByPag(coffeetypePOJO);
        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }
        CastPageUtil castPageUtil = new CastPageUtil(coffeetypeList,nowPage);
//        System.out.println(coffeetypeList.size());

        if (coffeetypePOJO.getName()!=null && !"".equals(coffeetypePOJO.getName())){
            model.addAttribute("name",coffeetypePOJO.getName());
        }
        //添加到作用域里面
        model.addAttribute("castPageUtil",castPageUtil);
        model.addAttribute("nowPage",nowPage);

        return "coffeetype/list";
    }

    @RequestMapping("/toAddCoffeetype")
    public String toAddCoffeetype(){

        return "coffeetype/add";
    }

    @RequestMapping("/addCoffeetype")
    @ResponseBody
    public Result<Boolean> addCoffeetype(CoffeetypePOJO coffeetypePOJO){
        System.out.println("控制器2"+coffeetypePOJO);
        Boolean b = coffeetypeService.addCoffeetype(coffeetypePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_ADD_ERROR);
        }
    }

    @RequestMapping("/toUpdateCoffeetype")
    public String toUpdateCoffeetype(Integer id, Model model){

        Coffeetype coffeetype = coffeetypeService.selectAllCoffeetypeById(id);
        model.addAttribute("coffeetype",coffeetype);
        return "coffeetype/update";
    }

    @RequestMapping("/updateCoffeetype")
    @ResponseBody
    public Result<Boolean> updateCoffeetype(CoffeetypePOJO coffeetypePOJO){
        System.out.println("控制器3"+coffeetypePOJO);
        Boolean b = coffeetypeService.updateCoffeetype(coffeetypePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_UPDATE_ERROR);
        }
    }

    @RequestMapping("/deleteCoffeetypeById")
    @ResponseBody
    public Result<Boolean> deleteCoffeetypeById(CoffeetypePOJO coffeetypePOJO){
        System.out.println("控制器4"+coffeetypePOJO);
        Boolean b = coffeetypeService.deleteCoffeetypeById(coffeetypePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_DELETE_ERROR);
        }
    }

    @RequestMapping("/detailCoffee")
    public String detailCoffee(Integer id, Model model){

        Coffeetype coffeetype = coffeetypeService.selectAllCoffeetypeById(id);
        model.addAttribute("coffeetype",coffeetype);
        return "coffeetype/detail";
    }

}
