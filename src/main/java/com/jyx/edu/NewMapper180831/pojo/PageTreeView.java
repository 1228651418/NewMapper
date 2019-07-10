package com.jyx.edu.NewMapper180831.pojo;

import java.util.ArrayList;
import java.util.List;


public class PageTreeView {
	private Long nodeId;
	private String text;    // 名称
	private String code;    //
	private String url;     // 菜单路径
	private String iconCls;    // 图标
	private Integer type;   // 资源类型, 0菜单 1功能
	private String state;
	private boolean checked = false;
	private Integer sort;   // 排序号
	private Long pid; // 父级
	private String parentName; // 父级
	private String available;      //1有效，0删除
	private String createDate;
	private String modifyDate;
	private String description; // 描述
	private List<PageTreeView> nodes = new ArrayList<PageTreeView>();

	public Long getNodeId() {
		return nodeId;
	}

	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<PageTreeView> getNodes() {
		return nodes;
	}

	public void setNodes(List<PageTreeView> nodes) {
		this.nodes = nodes;
	}
}
