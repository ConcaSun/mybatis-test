package com.usoft.suntg.entity;

import com.usoft.suntg.utils.BizCodeUtil;

/**
 * Created by ConcaSun on 2019/4/16.
 */
public class BankAccount {

    public static final String CODE_PREFIX = "CN";

    private Integer id;
    private String code;
    private Integer userId;
    private Double amount;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void genCode() {
        this.code = BizCodeUtil.genBizCode(CODE_PREFIX);
    }
}
