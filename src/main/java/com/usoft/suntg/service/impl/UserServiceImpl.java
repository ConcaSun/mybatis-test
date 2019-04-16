package com.usoft.suntg.service.impl;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.UserMapper;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;
import com.usoft.suntg.service.UserService;
import com.usoft.suntg.utils.VerifyParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ConcaSun on 2019/4/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Override
    public User saveOrUpdate(User user) {
        VerifyParamsUtil.notNull(user, "用户信息不可为空");
        if (user.getId() == null) {
            return save(user);
        } else {
            User existUser = userMapper.selectByPrimaryKey(user.getId());
            if (existUser != null) {
                return update(user);
            } else {
                return save(user);
            }
        }
    }

    private User save(User user) {
        int id = userMapper.insert(user);
        user.setId(id);
        return user;
    }

    private User update(User user) {
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public Page<User> getUsersByPage(PageParams pageParams) {
        return null;
    }
}