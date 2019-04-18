package com.usoft.suntg;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTestApplicationTests extends TestCase {

	@Rule
	public ExpectedException thrown= ExpectedException.none();

	@Test
	public void contextLoads() {
	}

}
