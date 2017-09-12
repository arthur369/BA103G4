package com.convert_gift_modal;

import java.io.Serializable;
import java.sql.Date;

public class CONVERT_GIFT_VO implements Serializable{
	private String APPLY_NO;
	private String MEM_AC;
	private String APPLY_NAME;
	private String APPLY_PHONE;
	private String GIFT_NO;
	private Date APPLY_DATE;
	private String APPLY_STAT;
	private String APPLY_ADD;
	private Date SEND_DATE;
	private String SEND_NO;
	public CONVERT_GIFT_VO() {
		
		super();
	}
	public String getAPPLY_NO() {
		return APPLY_NO;
	}
	public void setAPPLY_NO(String aPPLY_NO) {
		APPLY_NO = aPPLY_NO;
	}
	public String getMEM_AC() {
		return MEM_AC;
	}
	public void setMEM_AC(String mEM_AC) {
		MEM_AC = mEM_AC;
	}
	public String getAPPLY_NAME() {
		return APPLY_NAME;
	}
	public void setAPPLY_NAME(String aPPLY_NAME) {
		APPLY_NAME = aPPLY_NAME;
	}
	public String getAPPLY_PHONE() {
		return APPLY_PHONE;
	}
	public void setAPPLY_PHONE(String aPPLY_PHONE) {
		APPLY_PHONE = aPPLY_PHONE;
	}
	public String getGIFT_NO() {
		return GIFT_NO;
	}
	public void setGIFT_NO(String gIFT_NO) {
		GIFT_NO = gIFT_NO;
	}
	public Date getAPPLY_DATE() {
		return APPLY_DATE;
	}
	public void setAPPLY_DATE(Date aPPLY_DATE) {
		APPLY_DATE = aPPLY_DATE;
	}
	public String getAPPLY_STAT() {
		return APPLY_STAT;
	}
	public void setAPPLY_STAT(String aPPLY_STAT) {
		APPLY_STAT = aPPLY_STAT;
	}
	public String getAPPLY_ADD() {
		return APPLY_ADD;
	}
	public void setAPPLY_ADD(String aPPLY_ADD) {
		APPLY_ADD = aPPLY_ADD;
	}
	public Date getSEND_DATE() {
		return SEND_DATE;
	}
	public void setSEND_DATE(Date sEND_DATE) {
		SEND_DATE = sEND_DATE;
	}
	public String getSEND_NO() {
		return SEND_NO;
	}
	public void setSEND_NO(String sEND_NO) {
		SEND_NO = sEND_NO;
	}
	
	
	
}
