package org.example.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mybatis.adapter.mapper.UserMapper;
import org.example.mybatis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelectAll() {
        List<User> users = userMapper.selectList(null);
        assertNotNull(users);
        assertEquals(5, users.size());
        users.forEach(IO::println);
    }

    @Test
    void testSelectById() {
        User user = userMapper.selectById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        user = userMapper.selectOne(new QueryWrapper<User>().eq("id", 1));
        IO.println(user);
    }

    @Test
    void testSelectByCondition() {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", 2));
        assertNotNull(user);
        assertEquals(2, user.getId());
    }
}
