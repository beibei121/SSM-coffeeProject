package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.CoffeeCommentsResultMap;
import org.ccunix.coffee.vo.CommentsCustomVO;

import java.util.List;

public interface CoffeeCommentsDao {
    /**
     * 根据条件查询评论信息
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
     * 根据id进行逻辑删除评价
     * @param id
     */
    void deleteCommentsById(Integer id);

}
