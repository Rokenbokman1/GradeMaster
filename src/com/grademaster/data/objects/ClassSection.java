package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;

public class ClassSection implements IDataObject {
		private final String sid;
		private final String cid;
		private int value;
		private String desc;
		private String name;
		public ClassSection(String sid,String name, String cid, int value, String desc) {
			this.sid=sid;
			this.name=name;
			this.cid=cid;
			this.setValue(value);
			this.setDesc(desc);
		}
		public String getSid() {
			return sid;
		}
		public String getCid() {
			return cid;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
}
