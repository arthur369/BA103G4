package com.ad_modal;

import java.sql.Date;
import java.util.List;

public class AD_Service {
	private AD_DAO_interface dao;
	public AD_Service(){
		dao=new AD_JNDIDAO();
	}
	
	
	public AD_VO addAd(String ad_no,String prod_no,String ad_title,byte[] ad_img,Date ad_op_date,Date ad_ed_date){
		AD_VO ad_VO=new AD_VO();
		ad_VO.setAD_NO(ad_no);
		ad_VO.setPROD_NO(prod_no);
		ad_VO.setAD_TITLE(ad_title);
		ad_VO.setAD_IMG(ad_img);
		ad_VO.setAD_OP_DATE(ad_op_date);
		ad_VO.setAD_ED_DATE(ad_ed_date);
		dao.insert(ad_VO);
		return ad_VO;
	}
	public AD_VO updateAd(String ad_no,String prod_no,String ad_title,byte[] ad_img,Date ad_op_date,Date ad_ed_date){
		AD_VO ad_VO=new AD_VO();
		ad_VO.setAD_NO(ad_no);
		ad_VO.setPROD_NO(prod_no);
		ad_VO.setAD_TITLE(ad_title);
		ad_VO.setAD_IMG(ad_img);
		ad_VO.setAD_OP_DATE(ad_op_date);
		ad_VO.setAD_ED_DATE(ad_ed_date);
		dao.update(ad_VO);
		return ad_VO;
		
	}
	public void deleteAd(String ad_no){
		dao.delete(ad_no);
	}
	
	public AD_VO getOneAd(String ad_no){
		return dao.findByPrimaryKey(ad_no);
	}
	
	public List<AD_VO>getAll(){
		return dao.getAll();
	}
	
}
