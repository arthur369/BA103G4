package com.convert_gift_modal;

import java.sql.Date;
import java.util.List;

public class CONVERT_GIFT_Service {

	private CONVERT_GIFT_DAO_interface dao;
	
	public CONVERT_GIFT_Service(){
		dao=new CONVERT_GIFTJNDIDAO();
		
		
		
	}
	
	public CONVERT_GIFT_VO addConvert_gift(String apply_no,String mem_ac,String apply_name,String apply_phone,String gift_no,Date apply_date,String apply_stat,String apply_add,Date send_date,String send_no){
		
		CONVERT_GIFT_VO convert_gift_VO=new CONVERT_GIFT_VO();
		convert_gift_VO.setAPPLY_NO(apply_no);
		convert_gift_VO.setMEM_AC(mem_ac);
		convert_gift_VO.setAPPLY_NAME(apply_name);
		convert_gift_VO.setAPPLY_PHONE(apply_phone);
		convert_gift_VO.setGIFT_NO(gift_no);
		convert_gift_VO.setAPPLY_DATE(apply_date);
		convert_gift_VO.setAPPLY_STAT(apply_stat);
		convert_gift_VO.setAPPLY_ADD(apply_add);
		convert_gift_VO.setSEND_DATE(send_date);
		convert_gift_VO.setSEND_NO(send_no);
		dao.insert(convert_gift_VO);
		return convert_gift_VO;
	}
	public CONVERT_GIFT_VO updateConvert_gift(String apply_no,String mem_ac,String apply_name,String apply_phone,String gift_no,Date apply_date,String apply_stat,String apply_add,Date send_date,String send_no){
		
		CONVERT_GIFT_VO convert_gift_VO=new CONVERT_GIFT_VO();
		convert_gift_VO.setAPPLY_NO(apply_no);
		convert_gift_VO.setMEM_AC(mem_ac);
		convert_gift_VO.setAPPLY_NAME(apply_name);
		convert_gift_VO.setAPPLY_PHONE(apply_phone);
		convert_gift_VO.setGIFT_NO(gift_no);
		convert_gift_VO.setAPPLY_DATE(apply_date);
		convert_gift_VO.setAPPLY_STAT(apply_stat);
		convert_gift_VO.setAPPLY_ADD(apply_add);
		convert_gift_VO.setSEND_DATE(send_date);
		convert_gift_VO.setSEND_NO(send_no);
		dao.update(convert_gift_VO);
		return convert_gift_VO;
	}
	
	public void deleteConvert_gift(String apply_no){
		dao.delete(apply_no);
	}
	public CONVERT_GIFT_VO getOneConvert_gift(String apply_no){
		return dao.findByPrimaryKey(apply_no);
	}
	
	public List<CONVERT_GIFT_VO> getAll(){
		return dao.getAll();
	}
	
	
}
