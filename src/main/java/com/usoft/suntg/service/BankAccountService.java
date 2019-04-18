package com.usoft.suntg.service;

import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;

import java.util.List;

/**
 * Created by ConcaSun on 2019/4/17.
 */
public interface BankAccountService {

    BankAccount createWithUser(User user);

    List<BankAccount> findByUserId(Integer userId);

    Page<BankAccount> getUsersByPage(PageParams pageParams);

    BankAccount income(BankAccount bankAccount, double inAmount);

    BankAccount outlay(BankAccount bankAccount, double outAmount);

    BankAccount transfer(BankAccount fromBankAccount, BankAccount toBankAccount, double amount);

}
