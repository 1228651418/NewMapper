package com.jyx.edu.NewMapper180831.basemapper.mapper;

import com.jyx.edu.NewMapper180831.basemapper.BaseMapper;
import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends BaseMapper<SysPermission> {

    List<Long> findPermissionIdByRoleId(Long id);


}
