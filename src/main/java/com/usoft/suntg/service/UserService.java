package com.usoft.suntg.service;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;

/**
 * Created by ConcaSun on 2019/4/16.
 */
public interface UserService {

    User saveOrUpdate(User user);

    Page<User> getUsersByPage(PageParams pageParams);

}
