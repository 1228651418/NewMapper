package com.jyx.edu.NewMapper180831.service;

import com.jyx.edu.NewMapper180831.basemapper.mapper.PermissionMapper;
import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PermissionService extends BaseService<SysPermission>{

    List<PageTree> getAllTreeCheckByRole(Long id);

    List<PageTree> getAuthorizPermission();

    List<PageTree> getAllAuthorizChildrens(Object parentId,Subject subject);
}
