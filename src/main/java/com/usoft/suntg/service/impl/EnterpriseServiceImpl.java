package com.usoft.suntg.service.impl;

import com.usoft.suntg.entity.Enterprise;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.EnterpriseMapper;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;
import com.usoft.suntg.service.EnterpriseService;
import com.usoft.suntg.utils.MyBatisTestRuntimeException;
import com.usoft.suntg.utils.VerifyParamsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService{

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public Enterprise saveOrUpdate(Enterprise enterprise) {
        VerifyParamsUtil.notNull(enterprise, "用户信息不可为空");
        if (enterprise.getId() == null) {
            return save(enterprise);
        } else {
            Enterprise existEnterprise = enterpriseMapper.selectByPrimaryKey(enterprise.getId());
            if (existEnterprise == null) {
                throw new MyBatisTestRuntimeException("要修改的企业不存在，id：" + enterprise.getId());
            }
            return update(enterprise);
        }
    }

    private Enterprise save(Enterprise enterprise) {
        Integer id = enterpriseMapper.insert(enterprise);
        enterprise.setId(id);
        return enterprise;
    }

    private Enterprise update(Enterprise enterprise) {
        enterpriseMapper.updateByPrimaryKey(enterprise);
        return enterprise;
    }

    @Override
    public Page<Enterprise> getUsersByPage(PageParams pageParams) {
        int totalCount = enterpriseMapper.getCount();
        List<Enterprise> enterprises = enterpriseMapper.selectPageInfo(pageParams.getStartNumber(), pageParams.getPageSize());
        Page<Enterprise> page = new Page<>(pageParams, totalCount, enterprises);
        return page;
    }

    @Override
    public void addUserToEnterprise(Enterprise enterprise, User user) {
        enterpriseMapper.addUser(enterprise.getId(), user.getId());
    }

    @Override
    public void removeUserFromEnterprise(Enterprise enterprise, User user) {
        enterpriseMapper.removeUser(enterprise.getId(), user.getId());
    }
}
