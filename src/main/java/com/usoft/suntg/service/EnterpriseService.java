package com.usoft.suntg.service;

import com.usoft.suntg.entity.Enterprise;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;

/**
 * @author suntg
 * @date ${date}
 */
public interface EnterpriseService {

    Enterprise saveOrUpdate(Enterprise enterprise);

    Page<Enterprise> getUsersByPage(PageParams pageParams);

    void addUserToEnterprise(Enterprise enterprise, User user);

    void removeUserFromEnterprise(Enterprise enterprise, User user);
}
