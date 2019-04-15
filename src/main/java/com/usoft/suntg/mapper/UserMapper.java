package com.usoft.suntg.mapper;

import com.usoft.suntg.entity.User;

/**
 * Created by ConcaSun on 2019/4/15.
 */
public interface UserMapper {

    public int insert(User user);

    public int deleteByPrimaryKey(Integer id);

    public int delete(User user);

    public User selectByPrimaryKey(Integer id);

    public int updateByPrimaryKey(User user);

}
