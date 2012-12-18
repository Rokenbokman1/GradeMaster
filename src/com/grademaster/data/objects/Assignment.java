package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;

public class Assignment implements IDataObject {
	private final String aid;
	private final String sid;
	private String name;
	private String multi;
	private String pts;
	private String assigned;
	private String due;
	private String desc;
	public Assignment(String aid, String sid, String name, String multi, String pts, String assigned, String due, String desc) {
		this.aid=aid;
		this.sid=sid;
		this.name=name;
		this.multi=multi;
		this.pts=pts;
		this.assigned=assigned;
		this.due=due;
		this.desc=desc;
	}
	public String getAid() {
		return aid;
	}
	public String getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMulti() {
		return multi;
	}
	public void setMulti(String multi) {
		this.multi = multi;
	}
	public String getPts() {
		return pts;
	}
	public void setPts(String pts) {
		this.pts = pts;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	
}
