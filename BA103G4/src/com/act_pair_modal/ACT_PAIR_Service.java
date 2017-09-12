package com.act_pair_modal;

import java.util.List;

public class ACT_PAIR_Service {
	private ACT_PAIR_DAO_interface dao;
	public ACT_PAIR_Service(){
		dao=new ACT_PAIRJNDIDAO();
	}
	
	public ACT_PAIR_VO addAct_pair(String act_no,String mem_ac,java.sql.Date apply_date,String pay_state,String chk_state){
		
		ACT_PAIR_VO act_pair_VO=new ACT_PAIR_VO();
		
		act_pair_VO.setACT_NO(act_no);
		act_pair_VO.setMEM_AC(mem_ac);
		act_pair_VO.setAPPLY_DATE(apply_date);
		act_pair_VO.setPAY_STATE(pay_state);
		act_pair_VO.setCHK_STATE(chk_state);
		dao.insert(act_pair_VO);
		return act_pair_VO;
	}
	
	public ACT_PAIR_VO updateAct_pair(String act_no,String mem_ac,java.sql.Date apply_date,String pay_state,String chk_state){
		ACT_PAIR_VO act_pair_VO=new ACT_PAIR_VO();
		act_pair_VO.setACT_NO(act_no);
		act_pair_VO.setMEM_AC(mem_ac);
		act_pair_VO.setAPPLY_DATE(apply_date);
		act_pair_VO.setPAY_STATE(pay_state);
		act_pair_VO.setCHK_STATE(chk_state);
		dao.update(act_pair_VO);
		return act_pair_VO;
	}
	public void deleteAct_pair(String act_no,String mem_ac){
		dao.delete(act_no,mem_ac);
	}
	public ACT_PAIR_VO getOneAct_pair(String act_no,String mem_ac){
	
	return dao.findByPrimaryKey(act_no,mem_ac);
}
	public List<ACT_PAIR_VO>getAll(){
		return dao.getAll();
	}


}
