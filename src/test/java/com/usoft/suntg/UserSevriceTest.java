package com.usoft.suntg;

import com.usoft.suntg.entity.User;
import com.usoft.suntg.mapper.UserMapper;
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
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> users = userMapper.selectPageInfo(0, 10);
        assertTrue(CollectionUtils.isEmpty(users));
    }
}
