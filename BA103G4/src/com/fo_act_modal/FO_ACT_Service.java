package com.fo_act_modal;

import java.sql.Date;
import java.util.List;

public class FO_ACT_Service {
	private FO_ACT_DAO_interface dao;
	
	public FO_ACT_Service(){
		dao=new FO_ACT_JNDIDAO();
	}
	public FO_ACT_VO addFo_act(String mem_ac,String act_no,Date fo_act_date){
		FO_ACT_VO fo_act_VO =new FO_ACT_VO();
		fo_act_VO.setMEM_AC(mem_ac);
		fo_act_VO.setACT_NO(act_no);
		fo_act_VO.setFO_ACT_DATE(fo_act_date);
		
		
		dao.insert(fo_act_VO);
		return fo_act_VO;
		
	}
	public FO_ACT_VO updateFo_act(String mem_ac,String act_no,Date fo_act_date){
		FO_ACT_VO fo_act_VO =new FO_ACT_VO();
		fo_act_VO.setMEM_AC(mem_ac);
		fo_act_VO.setACT_NO(act_no);
		fo_act_VO.setFO_ACT_DATE(fo_act_date);
		
		dao.update(fo_act_VO);
		return fo_act_VO;
		
	}
	
	public void deleteFo_act(String mem_ac,String act_no){
		dao.delete(mem_ac, act_no);
	}
	public FO_ACT_VO getFo_act(String mem_ac,String act_no){
		return dao.findByPrimaryKey(mem_ac,act_no);
	}
	
	public List<FO_ACT_VO>getAll(){
		return dao.getAll();
	}
	
	
}
