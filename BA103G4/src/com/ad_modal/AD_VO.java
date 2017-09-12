package com.ad_modal;

import java.io.Serializable;
import java.sql.Date;

public class AD_VO implements Serializable{

	private String AD_NO;
	private String PROD_NO;
	private String AD_TITLE;
	 private	byte[] AD_IMG;
	 private Date AD_OP_DATE;
	 private Date AD_ED_DATE;
	public AD_VO() {
		super();
	}
	public String getAD_NO() {
		return AD_NO;
	}
	public void setAD_NO(String aD_NO) {
		AD_NO = aD_NO;
	}
	public String getPROD_NO() {
		return PROD_NO;
	}
	public void setPROD_NO(String pROD_NO) {
		PROD_NO = pROD_NO;
	}
	public String getAD_TITLE() {
		return AD_TITLE;
	}
	public void setAD_TITLE(String aD_TITLE) {
		AD_TITLE = aD_TITLE;
	}
	public byte[] getAD_IMG() {
		return AD_IMG;
	}
	public void setAD_IMG(byte[] aD_IMG) {
		AD_IMG = aD_IMG;
	}
	public Date getAD_OP_DATE() {
		return AD_OP_DATE;
	}
	public void setAD_OP_DATE(Date aD_OP_DATE) {
		AD_OP_DATE = aD_OP_DATE;
	}
	public Date getAD_ED_DATE() {
		return AD_ED_DATE;
	}
	public void setAD_ED_DATE(Date aD_ED_DATE) {
		AD_ED_DATE = aD_ED_DATE;
	}
	
	
	
	
	
}
