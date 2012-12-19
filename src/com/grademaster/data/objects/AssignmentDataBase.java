package com.grademaster.data.objects;

import com.grademaster.Globals;
import com.grademaster.logging.ErrorLevel;

public class AssignmentDataBase extends DataBase {
	public int getMaxIntId() {
		int maxid = 0;
		for (Object obj : Objects) {
			Assignment a = (Assignment) obj;
			String aid = a.getAid();
			int iaid = 0;
			try {
				iaid=Integer.parseInt(aid);
			} catch (Exception e) {
				Globals.getLogger().log("Found assignment with non-int id", ErrorLevel.WARNING);
			}
			if (iaid > maxid) {
				maxid=iaid;
			}
		}
		return maxid;
	}
}
