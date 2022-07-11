package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.CoffeeTaste;
import org.ccunix.coffee.pojo.CoffeeTastePOJO;

import org.ccunix.coffee.result.CodeMsg;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.ICoffeeTasteService;
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
@RequestMapping("/admin/Taste")
public class AdminCoffeeTasteController {

    @Autowired
    ICoffeeTasteService coffeeTasteService;
    @Autowired
    ExportExcelUtil exportExcelUtil;


    //导出Excel表格  导出所有数据
    @RequestMapping("/exportAllData")
    public void exportAllData(HttpServletRequest request, HttpServletResponse response){
        try {
            System.out.println("导出所有数据");
            String export = "编号#id,名称#name";
            String []excelHeader = export.split(",");
            List<CoffeeTaste> dataList = coffeeTasteService.selectAllCoffeeTaste(null);
            exportExcelUtil.export(response,"咖啡口味分类表",excelHeader,dataList);
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //导出Excel表格  导出当前页数据
    @RequestMapping("/exportCurrData")
    public void exportCurrData(HttpServletRequest request, HttpServletResponse response,
                               Integer nowPage , CoffeeTastePOJO coffeeTastePOJO){
        try {
            System.out.println("导出当前页数据");
            System.out.println("nowPage = "+nowPage);
            System.out.println("CoffeetypePOJO = "+coffeeTastePOJO);
            String export = "编号#id,名称#name";
            String []excelHeader = export.split(",");
            List<CoffeeTaste> CoffeeTasteList = coffeeTasteService.selectAllCoffeeTaste(coffeeTastePOJO);
            if (nowPage==null){
                nowPage=1;
            }
            CastPageUtil castPagePO = new CastPageUtil(CoffeeTasteList,nowPage);
            exportExcelUtil.export(response,"咖啡口味分页"+nowPage+"页数据表",
                    excelHeader,castPagePO.getCurrentDataList());
            return;

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping("/selectAllTasteByPage")
    public String selectAllTasteByPage(Model model, Integer nowPage,String key ,
                                       CoffeeTastePOJO coffeeTastePOJO){
        List<CoffeeTaste> coffeeTastesList =  coffeeTasteService.selectAllTasteByPage(coffeeTastePOJO);
        if (nowPage==null){
            nowPage = 1;
        }
//        判断key是否是跳转  如果不是跳转  就把nowPage置为1
        if(!"jump".equals(key)){
            nowPage = 1;
        }
        CastPageUtil castPageUtil = new CastPageUtil(coffeeTastesList,nowPage);

        if (coffeeTastePOJO.getName()!=null && !("".equals(coffeeTastePOJO.getName()))){
            model.addAttribute("name",coffeeTastePOJO.getName());
        }
        //添加到作用域里面
        model.addAttribute("castPageUtil",castPageUtil);
        model.addAttribute("nowPage",nowPage);

        return "taste/list";
    }

    @RequestMapping("/toAddCoffeeTaste")
    public String toAddCoffeeTaste(){

        return "taste/add";
    }

    @RequestMapping("/addCoffeeTaste")
    @ResponseBody
    public Result<Boolean> addCoffeeTaste(CoffeeTastePOJO coffeeTastePOJO){
        System.out.println("口味控制器2"+coffeeTastePOJO);
        Boolean b = coffeeTasteService.addCoffeeTaste(coffeeTastePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_ADD_ERROR);
        }
    }

    @RequestMapping("/toUpdateCoffeeTaste")
    public String toUpdateCoffeeTaste(Integer id, Model model){

        CoffeeTaste coffeeTaste = coffeeTasteService.selectAllCoffeeTasteById(id);
        model.addAttribute("coffeeTaste",coffeeTaste);
        return "taste/update";
    }

    @RequestMapping("/updateCoffeeTaste")
    @ResponseBody
    public Result<Boolean> updateCoffeetype(CoffeeTastePOJO coffeeTastePOJO){
        System.out.println("控制器3"+coffeeTastePOJO);
        Boolean b = coffeeTasteService.updateCoffeeTaste(coffeeTastePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_UPDATE_ERROR);
        }
    }

    @RequestMapping("/deleteCoffeeTasteById")
    @ResponseBody
    public Result<Boolean> deleteCoffeeTasteById(CoffeeTastePOJO coffeeTastePOJO){
        System.out.println("控制器4"+coffeeTastePOJO);
        Boolean b = coffeeTasteService.deleteCoffeeTasteById(coffeeTastePOJO);
        if (b){
            return Result.success(b);
        }else {
            return Result.error(CodeMsg.COFFEETYPE_DELETE_ERROR);
        }
    }

    @RequestMapping("/detailCoffeeTaste")
    public String detailCoffeeTaste(Integer id, Model model){

        CoffeeTaste coffeeTaste = coffeeTasteService.selectAllCoffeeTasteById(id);
        model.addAttribute("coffeeTaste",coffeeTaste);

        return "taste/detail";
    }

}
