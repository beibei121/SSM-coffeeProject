package org.ccunix.coffee.service;

import org.ccunix.coffee.domain.Admin;
import org.ccunix.coffee.pojo.AdminPOJO;

public interface IAdminSerivice {
    /**
     * 用户登录
     */
    Admin findAdminLoginUser(AdminPOJO adminPOJO);
}
