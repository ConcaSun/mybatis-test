package com.usoft.suntg;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.UserMapper;
import com.usoft.suntg.model.Page;
import com.usoft.suntg.model.PageParams;
import com.usoft.suntg.service.UserService;
import com.usoft.suntg.utils.FastJsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public class UserSevriceTest extends MybatisTestApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("孙土桂");
        user.setTel("13266703535");
        user.setEmail("suntg@usoftchina.com");
        user.setPassword("");
        user.setSalt("");
        user = userService.saveOrUpdate(user);
        assertEquals(new Integer(1), user.getId());
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1);
        user.setName("孙土桂");
        user.setTel("13266703535");
        user.setEmail("suntg@usoftchina.com");
        user.setPassword("");
        user.setSalt("");
        userService.saveOrUpdate(user);
    }

    @Test
    public void testGetPage() {
        PageParams pageParams = new PageParams();
        pageParams.setPageNumber(1);
        pageParams.setPageSize(10);
        Page<User> page = userService.getUsersByPage(pageParams);
        System.out.println(FastJsonUtil.toJson(page));
    }

    @Test
    public void testGetUserWithEnterprises() {
        User user = userService.getUserWithEnterprises(1);
        System.out.println(FastJsonUtil.toJson(user));
        assertEquals(2, user.getEnterprises().size());
    }
}
