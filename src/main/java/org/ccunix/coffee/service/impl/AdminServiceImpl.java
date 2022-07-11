package org.ccunix.coffee.service.impl;

import org.ccunix.coffee.dao.AdminDao;
import org.ccunix.coffee.domain.Admin;
import org.ccunix.coffee.pojo.AdminPOJO;
import org.ccunix.coffee.service.IAdminSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminSerivice {
    @Autowired
    AdminDao adminDao;

    @Override
    public Admin findAdminLoginUser(AdminPOJO adminPOJO) {
        return adminDao.findAdminLoginUser(adminPOJO);
    }
}
