package com.grademaster.data.objects;

import java.util.ArrayList;

import com.grademaster.data.IDataObject;

public class MyClass implements IDataObject {
	private final String cid;
	private String uid;
	private String name;
	private String loc;
	private String desc;
	private ArrayList<ClassSection> sections;
	public MyClass(String cid, String uid, String name, String loc, String desc, ArrayList<ClassSection> sections) {
		this.cid=cid;
		this.setUid(uid);
		this.setName(name);
		this.setLoc(loc);
		this.setDesc(desc);
		this.setSections(sections);
	}
	public MyClass(String cid, String uid, String name, String loc, String desc) {
		this(cid,uid,name,loc,desc,new ArrayList<ClassSection>());
	}
	public String getCid() {
		return cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ArrayList<ClassSection> getSections() {
		return sections;
	}
	public void setSections(ArrayList<ClassSection> sections) {
		this.sections = sections;
	}
	public void addClassSection(ClassSection section) {
		sections.add(section);
	}
}
