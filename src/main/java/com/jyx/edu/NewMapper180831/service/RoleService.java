package com.jyx.edu.NewMapper180831.service;

import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysRole;
import com.jyx.edu.NewMapper180831.pojo.PageTree;

import java.util.List;

public interface RoleService extends BaseService<SysRole>{

    void addRole_Permssion(Long roleId,Long[] permissionIds);
}
