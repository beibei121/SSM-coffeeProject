package org.ccunix.coffee.controller;

import org.ccunix.coffee.domain.CoffeeOrdersResultMap;
import org.ccunix.coffee.service.ICoffeeOrdersService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.ccunix.coffee.vo.OrdersCustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class AdminCoffeeOrdersController {
    @Autowired
    ICoffeeOrdersService coffeeOrdersService;

    @RequestMapping("/selectAllOrdersByPage")
    public String selectAllOrdersByPage(Model model, Integer nowPage, String key,
                                        OrdersCustomVO ordersCustomVO){
        List<CoffeeOrdersResultMap> coffeeOrdersList = coffeeOrdersService.selectAllOrdersByPage(ordersCustomVO);

        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }

        CastPageUtil castPageUtil = new CastPageUtil(coffeeOrdersList,nowPage);

        if (ordersCustomVO.getLinkman()!=null && !ordersCustomVO.getLinkman().trim().equals("")){
            model.addAttribute("linkman",ordersCustomVO.getLinkman().trim());
        }
        if (ordersCustomVO.getUserName()!=null && !ordersCustomVO.getUserName().trim().equals("")){
            model.addAttribute("userName",ordersCustomVO.getUserName().trim());
        }
        if (ordersCustomVO.getPhone()!=null && !ordersCustomVO.getPhone().trim().equals("")){
            model.addAttribute("phone",ordersCustomVO.getPhone().trim());
        }
        if (ordersCustomVO.getStatus()!=null && !ordersCustomVO.getStatus().trim().equals("")){
            model.addAttribute("status",ordersCustomVO.getStatus().trim());
        }
        model.addAttribute("castPageUtil",castPageUtil);
        model.addAttribute("nowPage",nowPage);

        return "orders/list";
    }

    @RequestMapping("/toDeliver")
    public void toDeliver(HttpServletRequest request, HttpServletResponse response ,Integer id){
        //发货
        try {
            coffeeOrdersService.toDeliver(id);
            response.sendRedirect(request.getContextPath()+"/admin/orders/selectAllOrdersByPage");
            return;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/detailOrders")
    public String detailOrders(Integer id,Model model){

        CoffeeOrdersResultMap orders = coffeeOrdersService.selectOrdersDetailListById(id);
        model.addAttribute("orders",orders);
        return "orders/detail";
    }
}
