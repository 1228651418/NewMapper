package com.jyx.edu.NewMapper180831.entity;

import javax.persistence.*;
/**
 * 组织架构
 * @author Administrator
 *
 */
@Entity
@Table(name="sys_department")
public class SysDepartment extends BaseEntity{
	@Column(length=50,name="name")
	private String name;
	@Column(length=50,name="icon_cls")
	private String iconCls;    // 图标
	private Integer sort;   // 排序号
	/*@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	@OrderBy("sort")
	private SysDepartment parent; // 父级*/
	@Column(name="parent_id")
	private Long parentId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

/*	public SysDepartment getParent() {
		return parent;
	}
	public void setParent(SysDepartment parent) {
		this.parent = parent;
	}*/

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}
