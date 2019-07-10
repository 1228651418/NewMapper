package com.jyx.edu.NewMapper180831.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * 公共实体对象
 * @author Administrator
 *
 */
@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	//private String available = "1";
	@Column(length=20,name="create_person")
	private String createPerson;
	@Column(length=25,name="create_time")
	private Date createTime;
	@Column(length=20,name="update_person")
	private String updatePerson;
	@Column(length=25,name="update_time")
	private Date updateTime;

	public BaseEntity(){};

	public  BaseEntity(Long id){ this.id = id; }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/*@Column(length=2)
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}*/
	public Date getCreateTime() {
		return createTime;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
