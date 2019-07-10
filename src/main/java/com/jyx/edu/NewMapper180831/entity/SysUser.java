package com.jyx.edu.NewMapper180831.entity;

import com.jyx.edu.NewMapper180831.util.FormSearchCondition;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="sys_user")
public class SysUser extends BaseEntity implements Serializable {

    //登录用户名,所属表字段为water_user.username
    @javax.persistence.Column( name = "username")
    private String username;

    //登录密码,所属表字段为water_user.password
    @FormSearchCondition(like="password1")
    @javax.persistence.Column( name = "password")
    private String password;

    //姓名,所属表字段为water_user.name
    @javax.persistence.Column( name = "name")
    private String name;

    //性别：1男0女,所属表字段为water_user.gender
    @javax.persistence.Column( name = "gender")
    private Boolean gender;

    //是否管理员：1是0否,所属表字段为water_user.is_admin
    @javax.persistence.Column( name = "is_admin")
    private Boolean isAdmin;

    //外键，所属部门Id,所属表字段为water_user.department_id
    @javax.persistence.Column( name = "sys_department_id")
    private Long departmentId;

    //是否锁定：1是0否,所属表字段为water_user.is_lock
    @javax.persistence.Column( name = "is_lock")
    private Boolean isLock;

    //是否删除：1是0否,所属表字段为water_user.delete_flag
    @javax.persistence.Column( name = "delete_flag")
    private Boolean deleteFlag;

    @ManyToMany(fetch= FetchType.LAZY)
    private Set<SysRole> roles = new HashSet<SysRole>();


    private static final long serialVersionUID = 1L;


    /**  START 以下为自己编写的代码区域 一般是多表之间的联合查询  START  **/
    @Transient
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**  END 以下为自己编写的代码区域 一般是多表之间的联合查询  END      **/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(super.getId());
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", isLock=").append(isLock);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createPerson=").append(super.getCreatePerson());
        sb.append(", createTime=").append(super.getCreateTime());
        sb.append(", updatePerson=").append(super.getUpdatePerson());
        sb.append(", updateTime=").append(super.getUpdateTime());
        sb.append("]");
        return sb.toString();
    }

    public enum Column {
        id("id"),
        username("username"),
        password("password"),
        fullname("fullname"),
        gender("gender"),
        isAdmin("is_admin"),
        departmentId("department_id"),
        isLock("is_lock"),
        deleteFlag("delete_flag"),
        createPerson("create_person"),
        createTime("create_date"),
        updatePerson("update_person"),
        updateTime("update_date");

        private final String column;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        Column(String column) {
            this.column = column;
        }

        public String desc() {
            return this.column + " DESC";
        }

        public String asc() {
            return this.column + " ASC";
        }
    }
}
