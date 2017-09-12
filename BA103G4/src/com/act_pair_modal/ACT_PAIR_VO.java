package com.act_pair_modal;

import java.io.Serializable;
import java.sql.Date;

public class ACT_PAIR_VO implements Serializable{
	private String ACT_NO;
	private String MEM_AC;
	private Date APPLY_DATE;
	private String PAY_STATE;
	private String CHK_STATE;
	public ACT_PAIR_VO() {
		super();
	}
	public String getACT_NO() {
		return ACT_NO;
	}
	public void setACT_NO(String aCT_NO) {
		ACT_NO = aCT_NO;
	}
	public String getMEM_AC() {
		return MEM_AC;
	}
	public void setMEM_AC(String mEM_AC) {
		MEM_AC = mEM_AC;
	}
	public Date getAPPLY_DATE() {
		return APPLY_DATE;
	}
	public void setAPPLY_DATE(Date aPPLY_DATE) {
		APPLY_DATE = aPPLY_DATE;
	}
	public String getPAY_STATE() {
		return PAY_STATE;
	}
	public void setPAY_STATE(String pAY_STATE) {
		PAY_STATE = pAY_STATE;
	}
	public String getCHK_STATE() {
		return CHK_STATE;
	}
	public void setCHK_STATE(String cHK_STATE) {
		CHK_STATE = cHK_STATE;
	}
	
	
	
	
}
