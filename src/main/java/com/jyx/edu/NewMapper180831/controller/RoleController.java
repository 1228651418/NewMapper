package com.jyx.edu.NewMapper180831.controller;

import com.jyx.edu.NewMapper180831.entity.SysDepartment;
import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysRole;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.EasyUIResult;
import com.jyx.edu.NewMapper180831.pojo.MessageInfo;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import com.jyx.edu.NewMapper180831.pojo.QueryInfo;
import com.jyx.edu.NewMapper180831.service.DepartmentService;
import com.jyx.edu.NewMapper180831.service.PermissionService;
import com.jyx.edu.NewMapper180831.service.RoleService;
import com.jyx.edu.NewMapper180831.util.TkExampleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.acl.Permission;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/roles")
    public MessageInfo add(SysRole role, HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            roleService.insertSelective(role,operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("账户添加异常");
        }
        return result;
    }

    @PutMapping(value = "/roles")
    public MessageInfo update(SysRole role,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            roleService.updateByPrimaryKeySelective(role, operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("账户更新异常");
        }
        return result;
    }

    @DeleteMapping(value = "/roles")
    public MessageInfo delete(Integer id,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            //此处log记录
            roleService.deleteByPrimaryKey(id);
        }catch (Exception e){
            result.setResult(false);
            result.setMsg("资源删除异常");
        }
        return result;
    }

    @GetMapping("/roles")
    public EasyUIResult querySysRoleList(QueryInfo queryInfo, HttpServletRequest request) {
       return roleService.queryListPage(queryInfo, TkExampleUtil.setExample(request,SysRole.class));
    }
    @GetMapping("/roles/findAll")
   public List<SysRole> querySysRoleList(){
       return roleService.selectAll();
    }

    @GetMapping("/roles/{id}/permissions")
    public List<PageTree> getPermissionsById(@PathVariable Long id){
        return  permissionService.getAllTreeCheckByRole(id);
    }


    @PostMapping("/roles/role_permission")
    public MessageInfo addRole_Permission(Long roleId,Long[] permissionIds){
        MessageInfo result = MessageInfo.getInstance();
        try {
            roleService.addRole_Permssion(roleId,permissionIds);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("授权失败");
        }
        return result;
    }



}
