package com.usoft.suntg;

import com.usoft.suntg.entity.Enterprise;
import com.usoft.suntg.entity.User;
import com.usoft.suntg.service.EnterpriseService;
import com.usoft.suntg.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author suntg
 * @date ${date}
 */
public class EnterpriseServiceTest extends MybatisTestApplicationTests {

    @Autowired
    private EnterpriseService enterpriseService;

    @Test
    public void testSaveEnterprise() {
        Enterprise enterprise = new Enterprise();
        enterprise.setName("深圳市英唐智能控制有限公司");
        enterprise.setAddress("深圳市南山区科技南五路英唐大厦5楼");
        enterprise.setLogo("");
        enterprise = enterpriseService.saveOrUpdate(enterprise);
    }

    @Test
    public void testUpdateEnterprise() {
        Enterprise enterprise = new Enterprise();
        enterprise.setId(3);
        enterprise.setName("深圳市英唐智能控制有限公司");
        enterprise.setAddress("深圳市南山区科技南五路英唐大厦5楼");
        enterprise.setLogo("https://zhengxin-pub.bj.bcebos.com/logopic/a249359c1b5124ae36b6c681aab1a335_fullsize.jpg");
        enterprise = enterpriseService.saveOrUpdate(enterprise);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId(1);
        Enterprise enterprise = new Enterprise();
        enterprise.setId(2);
        enterpriseService.addUserToEnterprise(enterprise, user);
    }

    @Test
    public void testRemoveUser() {
        User user = new User();
        user.setId(1);
        Enterprise enterprise = new Enterprise();
        enterprise.setId(2);
        enterpriseService.removeUserFromEnterprise(enterprise, user);
    }
}
