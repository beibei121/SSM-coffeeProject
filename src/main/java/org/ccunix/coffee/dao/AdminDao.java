package org.ccunix.coffee.dao;

import org.ccunix.coffee.domain.Admin;
import org.ccunix.coffee.pojo.AdminPOJO;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    Admin findAdminLoginUser(AdminPOJO adminPOJO);
}
