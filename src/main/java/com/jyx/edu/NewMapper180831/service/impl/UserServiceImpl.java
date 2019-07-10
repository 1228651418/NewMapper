package com.jyx.edu.NewMapper180831.service.impl;

import com.jyx.edu.NewMapper180831.basemapper.mapper.UserMapper;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.EasyUIResult;
import com.jyx.edu.NewMapper180831.pojo.QueryInfo;
import com.jyx.edu.NewMapper180831.service.UserService;
import com.jyx.edu.NewMapper180831.util.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public  class UserServiceImpl extends BaseServiceImpl<SysUser> implements UserService {

    @Autowired
    private UserMapper mapper;

    /**
     * 一般只需多表操作代码
     */

    @Override
    public SysUser findByUsername(String username) {
        return mapper.findByUsername(username);
    }

    @Override
    public Long[] getRoleIdsByUserId(Long userId){
        return mapper.getRoleIdsByUserId(userId);
    }

    @Override
    public void addUser_Role(Long userId,Long[] roleIds){
        mapper.deleteUser_RoleByUserId(userId);
        for(Long roleId : roleIds){
            mapper.addUser_Roles(userId,roleId);
        }
    }
}
