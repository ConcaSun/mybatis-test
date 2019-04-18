package com.usoft.suntg;

import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;
import com.usoft.suntg.service.BankAccountService;
import com.usoft.suntg.utils.FastJsonUtil;
import com.usoft.suntg.utils.MyBatisTestRuntimeException;
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
        user.setId(2);
        bankAccountService.createWithUser(user);
        List<BankAccount> accounts = bankAccountService.findByUserId(1);
        System.out.println(FastJsonUtil.toJson(accounts));
        assertEquals(1, accounts.size());
    }

    @Test
    public void testGetPage() {
        PageParams pageParams = new PageParams();
        pageParams.setPageNumber(1);
        pageParams.setPageSize(10);
        Page<BankAccount> page = bankAccountService.getUsersByPage(pageParams);
        System.out.println(FastJsonUtil.toJson(page));
        assertEquals(2, page.getTotalElement());
    }

    @Test
    public void testIncome() {
        List<BankAccount> accounts = bankAccountService.findByUserId(1);
        bankAccountService.income(accounts.get(0), 400);
        List<BankAccount> accounts1 = bankAccountService.findByUserId(1);
        assertEquals(new Double(2500), accounts1.get(0).getAmount());
    }

    @Test
    public void testOutlayThrowException() {
        List<BankAccount> accounts = bankAccountService.findByUserId(1);
        thrown.expect(MyBatisTestRuntimeException.class);
        thrown.expectMessage("账户余额不足，无法支出");
        bankAccountService.outlay(accounts.get(0), 1000);
    }

    @Test
    public void testOutlay() {
        List<BankAccount> accounts = bankAccountService.findByUserId(1);
        bankAccountService.outlay(accounts.get(0), 200);
        List<BankAccount> accounts1 = bankAccountService.findByUserId(1);
        assertEquals(new Double(2300), accounts1.get(0).getAmount());
    }

    @Test
    public void testTransfer() {
        BankAccount accountSuntg = bankAccountService.findByUserId(1).get(0);
        BankAccount accountWangyc = bankAccountService.findByUserId(2).get(0);
        bankAccountService.transfer(accountSuntg, accountWangyc, 200);
    }



}
