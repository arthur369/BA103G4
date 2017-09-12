package com.act_comm_modal;

import java.sql.Date;

public class ACT_COMM_VO {
	private String COMM_NO;
	private String ACT_NO;
	private String MEM_AC;
	private String COMM_CONT;
	private Date COMM_DATE;
	private String COMM_REPLY_CONT;
	private Date COMM_REPLY_DATE;
	public ACT_COMM_VO() {
		super();
	}
	public String getCOMM_NO() {
		
		return COMM_NO;
	}
	public void setCOMM_NO(String cOMM_NO) {
		COMM_NO = cOMM_NO;
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
	public String getCOMM_CONT() {
		return COMM_CONT;
	}
	public void setCOMM_CONT(String cOMM_CONT) {
		COMM_CONT = cOMM_CONT;
	}
	public Date getCOMM_DATE() {
		return COMM_DATE;
	}
	public void setCOMM_DATE(Date cOMM_DATE) {
		COMM_DATE = cOMM_DATE;
	}
	public String getCOMM_REPLY_CONT() {
		return COMM_REPLY_CONT;
	}
	public void setCOMM_REPLY_CONT(String cOMM_REPLY_CONT) {
		COMM_REPLY_CONT = cOMM_REPLY_CONT;
	}
	public Date getCOMM_REPLY_DATE() {
		return COMM_REPLY_DATE;
	}
	public void setCOMM_REPLY_DATE(Date cOMM_REPLY_DATE) {
		COMM_REPLY_DATE = cOMM_REPLY_DATE;
	}
	
	
	
	
	
}
