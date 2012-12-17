package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;

public class ClassSection implements IDataObject {
		private final String sid;
		private final String cid;
		private String value;
		private String desc;
		private String name;
		public ClassSection(String sid,String name, String cid, String string, String desc) {
			this.sid=sid;
			this.setName(name);
			this.cid=cid;
			this.setValue(string);
			this.setDesc(desc);
		}
		public String getSid() {
			return sid;
		}
		public String getCid() {
			return cid;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
