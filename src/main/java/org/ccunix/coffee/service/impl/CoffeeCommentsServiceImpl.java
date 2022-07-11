package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.CoffeeCommentsDao;
import org.ccunix.coffee.domain.CoffeeCommentsResultMap;
import org.ccunix.coffee.service.ICoffeeCommentsService;
import org.ccunix.coffee.vo.CommentsCustomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeCommentsServiceImpl implements ICoffeeCommentsService {
    @Autowired
    CoffeeCommentsDao coffeeCommentsDao;

    @Override
    public List<CoffeeCommentsResultMap> selectAllCommentsByPage(CommentsCustomVO commentsCustomVO) {
        return coffeeCommentsDao.selectAllCommentsByPage(commentsCustomVO);
    }

    @Override
    public CoffeeCommentsResultMap selectAllCommentsById(Integer id) {
        return coffeeCommentsDao.selectAllCommentsById(id);
    }

    @Override
    public void deleteCommentsById(Integer id) {
        coffeeCommentsDao.deleteCommentsById(id);
    }

}
