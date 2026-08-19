package org.example.mybatis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
//import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@TableName(value = "users")
public class User {
    @TableId(type = IdType.INPUT)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
