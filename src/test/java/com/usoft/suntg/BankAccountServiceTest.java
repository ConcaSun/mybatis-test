package com.usoft.suntg;

import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.service.BankAccountService;
import com.usoft.suntg.utils.FastJsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ConcaSun on 2019/4/17.
 */
public class BankAccountServiceTest extends MybatisTestApplicationTests{

    @Autowired
    private BankAccountService bankAccountService;

    @Test
    public void testCreateWithUser() {
        User user = new User();
        user.setId(1);
        bankAccountService.createWithUser(user);
        List<BankAccount> accounts = bankAccountService.findByUserId(1);
        System.out.println(FastJsonUtil.toJson(accounts));
        assertEquals(1, accounts.size());
    }

}
