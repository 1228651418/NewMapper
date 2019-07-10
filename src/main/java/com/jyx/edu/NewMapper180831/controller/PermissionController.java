package com.jyx.edu.NewMapper180831.controller;

import com.jyx.edu.NewMapper180831.entity.SysPermission;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.MessageInfo;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import com.jyx.edu.NewMapper180831.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping(value = "/permissions")
    public MessageInfo add(SysPermission permission, HttpSession session){
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            permissionService.insertSelective(permission,operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("资源添加异常");
        }
        return result;
    }
    @PutMapping(value = "/permissions")
    public MessageInfo update(SysPermission permission,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            permissionService.updateByPrimaryKeySelective(permission, operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("资源更新异常");
        }
        return result;
    }

    @DeleteMapping(value = "/permissions")
    public MessageInfo delete(Integer id,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            //此处log记录
            permissionService.deleteByPrimaryKey(id);
        }catch (Exception e){
            result.setResult(false);
            result.setMsg("资源删除异常");
        }
        return result;
    }

    @GetMapping("/permissions")
    public List<PageTree> getAllTree() {//加载所有节点
        return permissionService.getAllTree(SysPermission.class);
    }

    @GetMapping(value = "/permissions/getAllChildrensByParent")
    public List<PageTree> getAllChildrensByParent(Integer parentId) {//获取某个根节点下所有子节点
        if (StringUtils.isEmpty(parentId))
            return permissionService.getRootNode(SysPermission.class);
        return permissionService.getAllChildrens(SysPermission.class, parentId);
    }

    @GetMapping(value = "/permissions/getAuthorizPermissions")
    public List<PageTree> getAuthorizPermissions(Long parentId) {
        Subject subject = SecurityUtils.getSubject();
        if (StringUtils.isEmpty(parentId))
            return permissionService.getRootNode(SysPermission.class)
                    .stream().filter(p->subject.isPermitted(p.getTitle())).collect(Collectors.toList());;
        return permissionService.getAllAuthorizChildrens(parentId,subject);
    }



}
