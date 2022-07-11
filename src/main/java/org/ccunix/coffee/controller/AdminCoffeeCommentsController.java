package org.ccunix.coffee.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.ccunix.coffee.domain.CoffeeCommentsResultMap;
import org.ccunix.coffee.result.Result;
import org.ccunix.coffee.service.ICoffeeCommentsService;
import org.ccunix.coffee.utils.CastPageUtil;
import org.ccunix.coffee.vo.CommentsCustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/comments")
public class AdminCoffeeCommentsController {
    @Autowired
    ICoffeeCommentsService coffeeCommentsService;

    @RequestMapping("/selectAllCommentsByPage")
    public String selectAllCommentsByPage(Model model, Integer nowPage, String key,
                                          CommentsCustomVO commentsCustomVO){
        List<CoffeeCommentsResultMap> commentsList = coffeeCommentsService.selectAllCommentsByPage(commentsCustomVO);

        if (nowPage==null){
            nowPage = 1;
        }
        //判断key是否为跳转 如果不跳转 就把当前页设为1
        if (!"jump".equals(key)){
            nowPage = 1;
        }

        CastPageUtil castPageUtil = new CastPageUtil(commentsList,nowPage);

        if (commentsCustomVO.getUserName()!=null && !commentsCustomVO.getUserName().trim().equals("")){
            model.addAttribute("userName",commentsCustomVO.getUserName().trim());
        }
        if (commentsCustomVO.getCoffeeName()!=null && !commentsCustomVO.getCoffeeName().trim().equals("")){
            model.addAttribute("coffeeName",commentsCustomVO.getCoffeeName().trim());
        }
        if (commentsCustomVO.getContent()!=null && !commentsCustomVO.getContent().trim().equals("")){
            model.addAttribute("content",commentsCustomVO.getContent().trim());
        }
        if (commentsCustomVO.getStartTime()!=null && !commentsCustomVO.getStartTime().trim().equals("")){
            model.addAttribute("startTime",commentsCustomVO.getStartTime().trim());
        }
        if (commentsCustomVO.getEndsTime()!=null && !commentsCustomVO.getEndsTime().trim().equals("")){
            model.addAttribute("endsTime",commentsCustomVO.getEndsTime().trim());
        }
        //添加到作用域里面
        model.addAttribute("castPageUtil",castPageUtil);
        model.addAttribute("nowPage",nowPage);


        return "comments/list";
    }


    @RequestMapping("/detailComments")
    public String detailComments(Model model,Integer id){

        CoffeeCommentsResultMap commentsResultMap = coffeeCommentsService.selectAllCommentsById(id);
        model.addAttribute("comments",commentsResultMap);
        return "comments/detail";
    }

    @RequestMapping("/deleteCommentsById")
    @ResponseBody
    public Result<Boolean> deleteCommentsById(Integer id){
        coffeeCommentsService.deleteCommentsById(id);
        return Result.success(true);
    }

}
