package org.ccunix.coffee.controller;


import org.ccunix.coffee.domain.TestAccount;
import org.ccunix.coffee.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController_sad {

    @Autowired
    ITestService testService;

    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        System.out.println("测试成功");
        List<TestAccount> accountsList = testService.queryAll();
        model.addAttribute("accountList",accountsList);
        return "list";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(TestAccount testAccount){
        System.out.println("测试成功");
        testService.saveAccount(testAccount);
        return "redirect:/test/queryAll";
    }
}
