package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.CoffeeCommentsResultMap;
import org.ccunix.coffee.vo.CommentsCustomVO;

import java.util.List;

public interface ICoffeeCommentsService {
    /**
     * 查询评价信息
     * @param commentsCustomVO
     * @return
     */
    List<CoffeeCommentsResultMap> selectAllCommentsByPage(CommentsCustomVO commentsCustomVO);

    /**
     * 根据id查询评价详情
     * @param id
     * @return
     */
    CoffeeCommentsResultMap selectAllCommentsById(Integer id);

    /**
     * 按id对评价进行逻辑删除
     * @param id
     */
    void deleteCommentsById(Integer id);


}
