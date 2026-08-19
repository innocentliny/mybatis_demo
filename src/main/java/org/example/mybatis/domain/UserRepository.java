package org.example.mybatis.domain;

import com.baomidou.mybatisplus.extension.repository.IRepository;
import com.baomidou.mybatisplus.spring.repository.CrudRepository;
import org.example.mybatis.adapter.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends CrudRepository<UserMapper, User> implements IRepository<User> {
}
