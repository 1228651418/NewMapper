package com.jyx.edu.NewMapper180831.controller;

import com.jyx.edu.NewMapper180831.entity.SysDepartment;
import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.EasyUIResult;
import com.jyx.edu.NewMapper180831.pojo.MessageInfo;
import com.jyx.edu.NewMapper180831.pojo.QueryInfo;
import com.jyx.edu.NewMapper180831.service.DepartmentService;
import com.jyx.edu.NewMapper180831.service.UserService;
import com.jyx.edu.NewMapper180831.util.TkExampleUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/users")
    public MessageInfo add(SysUser user, HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            userService.insertSelective(user,operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("账户添加异常");
        }
        return result;
    }

    @PutMapping(value = "/users")
    public MessageInfo update(SysUser user,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            userService.updateByPrimaryKeySelective(user, operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("账户更新异常");
        }
        return result;
    }

    @DeleteMapping(value = "/users")
    public MessageInfo delete(Integer id,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            //此处log记录
            userService.deleteByPrimaryKey(id);
        }catch (Exception e){
            result.setResult(false);
            result.setMsg("资源删除异常");
        }
        return result;
    }

    @GetMapping("/users")
    @ResponseBody
    public EasyUIResult querySysUserList(QueryInfo queryInfo, HttpServletRequest request) {
        List<SysDepartment> departments = departmentService.selectAll();
        EasyUIResult result = userService.queryListPage(queryInfo, TkExampleUtil.setExample(request,SysUser.class));
        List<SysUser> users = (List<SysUser>) result.getRows();
        departments.forEach(d->{
            users.forEach(u->{
                if (d.getId().equals(u.getDepartmentId())) u.setDepartmentName(d.getName());
            });
        });
        result.setRows(users);
        return result;
    }

    @PostMapping("users/user_roles")
    public MessageInfo addUser_Role(Long userId,Long[] roleIds){
        MessageInfo result = MessageInfo.getInstance();
        try {
            userService.addUser_Role(userId,roleIds);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("角色授予失败");
        }
        return result;

    }

    @GetMapping("/users/{userId}/roleIds")
    public Long[] getRoleIdsByUserId(@PathVariable Long userId){
        return userService.getRoleIdsByUserId(userId);
    }


}
