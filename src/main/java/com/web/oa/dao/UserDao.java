package com.web.oa.dao;

import com.web.oa.bean.User;
import com.web.oa.utils.PageModel;

import java.util.List;

public interface UserDao {
    boolean save(User user);

    boolean delete(Long id);

    boolean update(User user);

    User getById(Long id);

    User getByUserNameAndUserPassword(String userName, String userPssword);

    List<User> findByUserName(String userName);

    List<User> findAll();

    Long countByUserName(String userName);

    List<User> findByUserName(String userName,int page,int size);
}
