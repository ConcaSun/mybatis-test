package com.usoft.suntg;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.UserMapper;
import com.usoft.suntg.service.UserService;
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
        userService.saveOrUpdate(user);
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
}
