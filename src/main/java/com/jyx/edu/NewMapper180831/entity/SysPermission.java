package com.jyx.edu.NewMapper180831.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_permission")
public class SysPermission extends BaseEntity {
    @Column(length=50,name = "name")
    private String name;    // 名称
    @Column(length=50,name = "code")
    private String code;    //
    @Column(length=50,name = "url")
    private String url;     // 菜单路径
    @Column(length=50,name = "icon_cls")
    private String iconCls;    // 图标
    @Column(length=50,name = "type")
    private Integer type;   // 资源类型, 0菜单 1功能
    @Column(length=50,name = "sort")
    private Integer sort;   // 排序号
  /*  @ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @OrderBy("sort")
    private SysPermission parent; // 父级*/
    @Column(name = "parent_id")
    private Long parentId;
    @ManyToMany(fetch=FetchType.LAZY,mappedBy = "permissions")
    private Set<SysRole> roles = new HashSet<SysRole>();
    public SysPermission(){}
    public SysPermission(Long id){
        super(id);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getIconCls() {
        return iconCls;
    }
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    /*public SysPermission getParent() {
        return parent;
    }
    public void setParent(SysPermission parent) {
        this.parent = parent;
    }*/
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
