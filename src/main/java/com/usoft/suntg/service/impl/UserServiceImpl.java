package com.usoft.suntg.service.impl;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.UserMapper;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;
import com.usoft.suntg.service.UserService;
import com.usoft.suntg.utils.MyBatisTestRuntimeException;
import com.usoft.suntg.utils.VerifyParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            if (existUser == null) {
                throw new MyBatisTestRuntimeException("要修改的用户不存在，id：" + user.getId());
            }
            return update(user);
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
        int totalCount = userMapper.getCount();
        List<User> users = userMapper.selectPageInfo(pageParams.getStartNumber(), pageParams.getPageSize());
        Page<User> page = new Page<>(pageParams, totalCount, users);
        return page;
    }
}
