package com.jyx.edu.NewMapper180831.service.impl;

import com.jyx.edu.NewMapper180831.basemapper.mapper.RoleMapper;
import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysRole;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import com.jyx.edu.NewMapper180831.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Service
public  class RoleServiceImpl extends BaseServiceImpl<SysRole> implements RoleService {

    @Autowired
    private RoleMapper mapper;


    /**
     * 一般只需多表操作代码
     */

    @Override
    public void addRole_Permssion(Long roleId, Long[] permissionIds) {
                mapper.deleteRole_PermissionByRoleId(roleId);
            for(Long permissionId : permissionIds) {
                mapper.addRole_Permssion(roleId, permissionId);
            }
    }


}
