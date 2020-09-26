package com.gjsm.springboot_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Date on 2020/09/26  下午 02:57
 */

@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String uid;
    private String username;
    private String password;
    private String salt;

//    定义角色集合
    private List<Role> roleList;

}
