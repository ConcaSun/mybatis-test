package com.usoft.suntg.service;


import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.User;

import java.util.List;

/**
 * Created by ConcaSun on 2019/4/17.
 */
public interface BankAccountService {

    BankAccount createWithUser(User user);

    List<BankAccount> findByUserId(Integer userId);

    BankAccount income(BankAccount bankAccount, double inAmount);

    BankAccount outlay(BankAccount bankAccount, double outAmount);

    BankAccount transfer(BankAccount fromBankAccount, BankAccount toBankAccount, double amount);

}
