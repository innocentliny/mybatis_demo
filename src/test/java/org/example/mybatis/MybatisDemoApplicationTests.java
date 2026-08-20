package org.example.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.injector.methods.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.example.mybatis.adapter.mapper.UserMapper;
import org.example.mybatis.domain.User;
import org.example.mybatis.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSelectAll() {
        List<User> users = userMapper.selectList(null);
        assertNotNull(users);
        assertEquals(5, users.size());
    }

    @Test
    void testMapperSelectById() {
        User user = userMapper.selectById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
    }

    @Test
    void testRepositorySelectById() {
        Optional<User> optUser = userRepository.getOptById(1);
        assertTrue(optUser.isPresent());
        assertEquals(1, optUser.get().getId());
    }

    @Test
    void testSelectByCondition() {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", 2));
        assertNotNull(user);
        assertEquals(2, user.getId());
    }

    @Test
    void testSimpleQuery() {
        Map<Long, User> userMap = SimpleQuery.keyMap(Wrappers.lambdaQuery(User.class).ge(User::getId, 3),
                User::getId,  // 這是 map key
                user -> IO.println(user.getName()));
        assertNotNull(userMap);
        assertEquals(3, userMap.size()); // User ID >= 3 的有 3 筆。
        assertTrue(userMap.containsKey(4L));
    }
}
