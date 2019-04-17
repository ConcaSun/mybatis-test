package com.usoft.suntg.mapper;

import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.Enterprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public interface BankAccountMapper {

    int insert(BankAccount bankAccount);

    int deleteByPrimaryKey(Integer id);

    int delete(BankAccount bankAccount);

    BankAccount selectByPrimaryKey(Integer id);

    List<BankAccount> selectPageInfo(@Param("startNumber") Integer startNumber, @Param("pageSize") Integer pageSize);

    List<BankAccount> findByUserId(Integer userId);

    int updateAmount(BankAccount bankAccount);

    int getCount();
}
