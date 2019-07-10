package com.jyx.edu.NewMapper180831.basemapper.mapper;

import com.jyx.edu.NewMapper180831.basemapper.BaseMapper;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary   //@Primary 为解决mapper冲突问题，设置有限调取
public interface UserMapper extends BaseMapper<SysUser> {

    /**
     * 一般只需多表操作
     */

    SysUser findByUsername(String username);

    void addUser_Roles(@Param("userId") Long userId,@Param("roleId") Long roleId);

    Long[] getRoleIdsByUserId(Long userId);

    void deleteUser_RoleByUserId(Long userId);
}
