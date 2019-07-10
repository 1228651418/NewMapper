package com.jyx.edu.NewMapper180831.service;

import com.jyx.edu.NewMapper180831.entity.SysUser;

public interface UserService extends BaseService<SysUser>{

    SysUser findByUsername(String username);

    Long[] getRoleIdsByUserId(Long userId);

    void addUser_Role(Long userId, Long[] roleIds);
}
