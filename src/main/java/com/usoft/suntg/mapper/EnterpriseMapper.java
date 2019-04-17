package com.usoft.suntg.mapper;

import com.usoft.suntg.entity.Enterprise;
import com.usoft.suntg.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public interface EnterpriseMapper {

    int insert(Enterprise enterprise);

    int deleteByPrimaryKey(Integer id);

    int delete(Enterprise enterprise);

    Enterprise selectByPrimaryKey(Integer id);

    List<Enterprise> selectPageInfo(@Param("startNumber") Integer startNumber, @Param("pageSize") Integer pageSize);

    int updateByPrimaryKey(Enterprise enterprise);

    int getCount();

    void addUser(@Param("enterpriseId") Integer enterpriseId, @Param("userId") Integer userId);

    void removeUser(@Param("enterpriseId") Integer enterpriseId, @Param("userId") Integer userId);

}
