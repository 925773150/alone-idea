package com.gjsm.springboot_shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Date on 2020/09/26  下午 06:06
 */
@Data
@Accessors
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;
    private String name;
}
