package com.usoft.suntg.mapper;

import com.usoft.suntg.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ConcaSun on 2019/4/15.
 */
public interface UserMapper {

    int insert(User user);

    int deleteByPrimaryKey(Integer id);

    int delete(User user);

    User selectByPrimaryKey(Integer id);

    List<User> selectPageInfo(@Param("startNumber") Integer startNumber, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(User user);

    int getCount();

}
