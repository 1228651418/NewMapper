package com.jyx.edu.NewMapper180831.controller;

import com.jyx.edu.NewMapper180831.entity.SysDepartment;
import com.jyx.edu.NewMapper180831.entity.SysUser;
import com.jyx.edu.NewMapper180831.pojo.MessageInfo;
import com.jyx.edu.NewMapper180831.pojo.PageTree;
import com.jyx.edu.NewMapper180831.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/departments")
    public MessageInfo add(SysDepartment department, HttpSession session){
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            departmentService.insertSelective(department,operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("部门添加异常");
        }
        return result;
    }
    @PutMapping(value = "/departments")
    public MessageInfo update(SysDepartment department,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            departmentService.updateByPrimaryKeySelective(department, operator);
        }catch (Exception e){
            e.printStackTrace();
            result.setResult(false);
            result.setMsg("部门更新异常");
        }
        return result;
    }

    @DeleteMapping(value = "/departments")
    public MessageInfo delete(Integer id,HttpSession session) {
        MessageInfo result = MessageInfo.getInstance();
        SysUser operator = (SysUser) session.getAttribute("user");
        try{
            //此处log记录
            departmentService.deleteByPrimaryKey(id);
        }catch (Exception e){
            result.setResult(false);
            result.setMsg("部门删除异常");
        }
        return result;
    }

    @GetMapping("/departments")
    public List<PageTree> getAllTree() {//加载所有节点
        return departmentService.getAllTree(SysDepartment.class);
    }

    @GetMapping(value = "/departments/getAllChildrensByParent")
    public List<PageTree> getAllChildrensByParent(Integer parentId) {//获取某个根节点下所有子节点
        if (StringUtils.isEmpty(parentId))
            return departmentService.getRootNode(SysDepartment.class);
        return departmentService.getAllChildrens(SysDepartment.class, parentId);
    }



}
