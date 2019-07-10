package com.jyx.edu.NewMapper180831.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色
 * @author Administrator
 *
 */
@Entity
@Table(name="sys_role")
public class SysRole extends BaseEntity{
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String code;
	@ManyToMany(fetch=FetchType.LAZY,mappedBy = "roles")
	private Set<SysUser> users = new HashSet<SysUser>();
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<SysPermission>  permissions = new HashSet<SysPermission>();
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
	public Set<SysUser> getUsers() {
		return users;
	}
	public void setUsers(Set<SysUser> users) {
		this.users = users;
	}
	public Set<SysPermission> getPermissions() {
		return  permissions;
	}
	public void setPermissions(Set<SysPermission>  permissions) {
		this. permissions =  permissions;
	}
}
