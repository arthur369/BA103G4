package com.fo_act_modal;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class FO_ACT_VO implements Serializable{
	private String MEM_AC;
	private String ACT_NO;
	private Date FO_ACT_DATE;
//	private Timestamp FO_ACT_DATE;
	public FO_ACT_VO() {
		super();
	}
	public String getMEM_AC() {
		return MEM_AC;
	}
	public void setMEM_AC(String mEM_AC) {
		MEM_AC = mEM_AC;
		
	}
	public String getACT_NO() {
		return ACT_NO;
	}
	public void setACT_NO(String aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public Date getFO_ACT_DATE() {
		return FO_ACT_DATE;
	}
//	public Timestamp getFO_ACT_DATE() {
//		return FO_ACT_DATE;
//	}
	public void setFO_ACT_DATE(Date fO_ACT_DATE) {
		FO_ACT_DATE = fO_ACT_DATE;
	}
//	public void setFO_ACT_DATE(Timestamp fO_ACT_DATE) {
//		FO_ACT_DATE = fO_ACT_DATE;
//	}
	
}
