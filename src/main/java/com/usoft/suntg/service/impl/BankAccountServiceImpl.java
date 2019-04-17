package com.usoft.suntg.service.impl;

import com.usoft.suntg.entity.BankAccount;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.BankAccountMapper;
import com.usoft.suntg.service.BankAccountService;
import com.usoft.suntg.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ConcaSun on 2019/4/17.
 */
@Service
public class BankAccountServiceImpl implements BankAccountService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public BankAccount createWithUser(User user) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.genCode();
        bankAccount.setUserId(user.getId());
        int id = bankAccountMapper.insert(bankAccount);
        bankAccount.setId(id);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findByUserId(Integer userId) {
        return bankAccountMapper.findByUserId(userId);
    }

    @Override
    public BankAccount income(BankAccount bankAccount, double inAmount) {
        bankAccount.setAmount(NumberUtil.add(bankAccount.getAmount(), inAmount));
        bankAccountMapper.updateAmount(bankAccount);
        return bankAccount;
    }

    @Override
    public BankAccount outlay(BankAccount bankAccount, double outAmount) {
        bankAccount.setAmount(NumberUtil.minus(bankAccount.getAmount(), outAmount));
        bankAccountMapper.updateAmount(bankAccount);
        return bankAccount;
    }

    @Override
    public BankAccount transfer(BankAccount fromBankAccount, BankAccount toBankAccount, double amount) {
        fromBankAccount = outlay(fromBankAccount, amount);
        income(toBankAccount, amount);
        return fromBankAccount;
    }
}
