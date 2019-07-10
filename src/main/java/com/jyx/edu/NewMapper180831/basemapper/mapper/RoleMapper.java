package com.jyx.edu.NewMapper180831.basemapper.mapper;

import com.jyx.edu.NewMapper180831.basemapper.BaseMapper;
import com.jyx.edu.NewMapper180831.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper extends BaseMapper<SysRole> {

    void addRole_Permssion(@Param("roleId") Long roleId , @Param("permissionId") Long  permissionId);

    List<Long> getpermissionIdByroleId(Long roleId);

    void deleteRole_PermissionByRoleId(Long roleId);
}
