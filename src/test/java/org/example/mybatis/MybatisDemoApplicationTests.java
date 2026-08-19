package org.example.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mybatis.adapter.mapper.UserMapper;
import org.example.mybatis.domain.User;
import org.example.mybatis.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
        users.forEach(IO::println);
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
}
